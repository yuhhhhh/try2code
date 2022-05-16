package offer;

import java.util.Deque;
import java.util.LinkedList;

public class of59 {
    public static void main(String[] args) {
        Deque<Integer> q1 = new LinkedList<>();
        Deque<Integer> q2 = new LinkedList<>();
        q1.addLast(1);
        q1.addLast(2);
        q2.addLast(1);
        q2.addLast(3);
        System.out.println(q1.peekFirst() == q2.peekFirst());
        StringBuilder builder = new StringBuilder();
        String str = " ";
    }

}
