package zgxitong;

import java.util.Deque;
import java.util.LinkedList;

public class exam2 {

    public int longestValidParentheses (String s) {
        // write code here
        Deque<Character> stack = new LinkedList<>();
        int res = 0, cur = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                    cur += 2;
                    res = Math.max(cur, res);
                } else {
                    cur = 0;
                }
            } else {
                stack.addLast(c);
            }
        }
        return res;
    }


}
