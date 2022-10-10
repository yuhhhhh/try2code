package wanmei;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class exam2 {

    static class sortRun implements Runnable {
        static volatile AtomicInteger x = new AtomicInteger(0);
        static final String lock = "lock";
        Runnable source;
        int idx;

        sortRun(Runnable r, int i) {
            source = r;
            idx = i;
        }

        @Override
        public void run() {
            synchronized (lock) {
                while (x.intValue() != idx) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                source.run();
                x.getAndIncrement();
                lock.notifyAll();
            }
        }
    }

    public static Collection<Runnable> makeTasks(List<Runnable> tasks) {
        //TODO
        List<Runnable> res = new ArrayList<>();
        for (int i = 0; i < tasks.size(); i++) {
            res.add(new sortRun(tasks.get(i), i));
        }
        return res;
    }

}
