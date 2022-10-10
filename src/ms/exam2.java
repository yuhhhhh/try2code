package ms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class exam2 {
    public int solution(int[] X, int[] Y, int W) {
        // write your code in Java 8 (Java SE 8)
        PriorityQueue<Integer> set = new PriorityQueue<>();
        for (int n : X) {
            set.add(n);
        }
        int res = 0, begin = 0, end = 0;
        while (!set.isEmpty()) {
            res++;
            begin = set.peek();
            end = begin + W;
            while (!set.isEmpty() && set.peek() < end) {
                set.poll();
            }
        }
        return res;
    }
}
