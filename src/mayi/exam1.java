package mayi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class exam1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        Deque<Character> stack = new LinkedList<>();
        stack.addLast('a');
        for (int i = 1; i < x; i++) {
            char c = 'a';
            while (!stack.isEmpty() && stack.peekLast() == c) {
                stack.removeLast();
                c = (char) (c + 1);
            }
            stack.addLast(c);
        }
        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()) {
            sb.append(stack.removeFirst());
        }
        System.out.println(sb);
    }
}
