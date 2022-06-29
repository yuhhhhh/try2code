import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CPByLock {
    private static  int cnt;
    private static final int full = 10;
    private Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public static void main(String[] args) {
        CPByLock cpByLock = new CPByLock();
        new Thread(cpByLock.new Product()).start();
        new Thread(cpByLock.new Consumer()).start();
        new Thread(cpByLock.new Product()).start();
        new Thread(cpByLock.new Consumer()).start();
        new Thread(cpByLock.new Product()).start();
        new Thread(cpByLock.new Consumer()).start();
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                try {
                    if (cnt > 0) {
                        cnt--;
                        System.out.println(Thread.currentThread().getName() + "消费了一个产品，目前数量：" + cnt);
                        notFull.signal();
                    } else {
                        notEmpty.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class Product implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                try {
                    if (cnt < full) {
                        cnt++;
                        System.out.println(Thread.currentThread().getName() + "生产了一个产品，目前数量：" + cnt);
                        notEmpty.signal();
                    } else {
                        notFull.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
