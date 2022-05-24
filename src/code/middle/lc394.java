package code.middle;

import java.util.LinkedList;
import java.util.List;

public class lc394 {
    public static void main(String[] args) {
        String res = decodeString("3[a]2[bc]");
        System.out.println(res);
    }
    public static String decodeString(String s) {
        List<String> stack = new LinkedList<>();
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ']') {
                stack.add(idx++, String.valueOf(c));
            } else {
                StringBuilder sb = new StringBuilder();
                while (idx >= 0) {
                    String str = stack.get(--idx);
                    if (str.equals("[")) {
                        int n = Integer.parseInt(stack.get(--idx));
                        String newS = sb.reverse().toString();
                        sb.delete(0, sb.length());
                        for (int j = 0; j < n; j++) {
                            sb.append(newS);
                        }
                        stack.add(idx++, sb.toString());
                        break;
                    } else {
                        sb.append(str);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < idx; i++) {
            sb.append(stack.get(i));
        }
        return sb.toString();
    }
}
