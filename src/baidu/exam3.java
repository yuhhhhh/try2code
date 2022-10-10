package baidu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class exam3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cur = 0, res = 0;
        boolean flag = false, ifFlag = false;
        Deque<Integer> stack = new LinkedList<>();
        while (true) {
            String s = br.readLine();
            if (s.length() > 0 && s.charAt(0) == '}') break;
            s = s.trim();
            if (s.startsWith("for")) {
                flag = true;
                cur++;
                res = Math.max(cur, res);
                stack.addLast(0);
            } else if (s.startsWith("if")) {
                ifFlag = true;
                stack.addLast(1);
            } else if (s.startsWith("}")) {
                if (!stack.isEmpty()) {
                    int val = stack.removeLast();
                    if (val == 0) {
                        cur--;
                    }
                }
            }

        }

        System.out.println(res);
    }
}
