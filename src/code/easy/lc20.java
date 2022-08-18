package code.easy;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class lc20 {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        Map<Character, Character> dict = new HashMap<>(){
            {
                put('[',']');
                put('(', ')');
                put('{', '}');
            }
        };
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (dict.containsKey(c)) {
                stack.addLast(dict.get(c));
            } else {
                if (!stack.isEmpty() && stack.peekLast() == c) {
                    stack.removeLast();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
