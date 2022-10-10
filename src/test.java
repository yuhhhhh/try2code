import java.io.*;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

class MyThread extends Thread {
    long i;
    long end;
    long n;
    long[] arr;
    public MyThread(long i, long n, long end, long[] arr) {
        this.i = i;
        this.n = n;
        this.end = end;
        this.arr = arr;
    }
    @Override
    public void run() {
        long start = i / n * end + 1;
        for (long j = start; j <= (i + 1) / n * end; j++) {
            arr[(int) i] += j;
        }
    }
}

public class test {
    public static void main(String[] args) throws IOException, InterruptedException {
        long n = 1000, end = 1000000000, sum = 0;
        long[] sumArr = new long[(int) n];
        List<Thread> list = new ArrayList<>();
        Date startTime = new Date(System.currentTimeMillis());
        for (int i = 0; i < n; i++) {
            Thread t = new MyThread(i, n, end, sumArr);
            t.start();
            list.add(t);
        }
        for (int i = 0; i < n; i++) {
            list.get(i).join();
            sum += sumArr[i];
        }
        System.out.println(sum);
        Date endTime = new Date(System.currentTimeMillis());
        System.out.println(endTime.getTime() - startTime.getTime());
        startTime = new Date(System.currentTimeMillis());
        sum = 0;
        for (long i = 1; i <= end; i++) {
            sum += i;
        }
        System.out.println(sum);
        endTime = new Date(System.currentTimeMillis());
        System.out.println(endTime.getTime() - startTime.getTime());
    }
}