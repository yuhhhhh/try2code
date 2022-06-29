public class ConsumerProduct {

    private static  int cnt;
    private static final int full = 10;
    private static String lock = "Lock";

    public static void main(String[] args) {
        ConsumerProduct consumerProduct = new ConsumerProduct();
        new Thread(consumerProduct.new Product()).start();
        new Thread(consumerProduct.new Consumer()).start();
        new Thread(consumerProduct.new Product()).start();
        new Thread(consumerProduct.new Consumer()).start();
        new Thread(consumerProduct.new Product()).start();
        new Thread(consumerProduct.new Consumer()).start();
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
                synchronized (lock) {
                    if (cnt < full) {
                        cnt++;
                        System.out.println(Thread.currentThread().getName() + "生产了一个产品，目前数量：" + cnt);
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    lock.notifyAll();
                }
            }

        }
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
                synchronized (lock) {
                    if (cnt > 0) {
                        cnt--;
                        System.out.println(Thread.currentThread().getName() + "消费了一个产品，目前数量：" + cnt);
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    lock.notifyAll();
                }
            }
        }
    }
}
