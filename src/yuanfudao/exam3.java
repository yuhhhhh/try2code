package yuanfudao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class exam3 {
    static Deque<Integer> stack = new LinkedList<>();
    static int cnt = 0;
    static int zero = 0;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input.split(" ")[0]);
        k = Integer.parseInt(input.split(" ")[1]);
        int[] arr = new int[n];
        String[] arrInput = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(arrInput[i]);
        }
        dfs(arr, 0);
        System.out.println(cnt);
    }

    public static void dfs(int[] arr, int idx) {
        if (stack.size() > (arr.length - idx)) return ;
        if (idx == arr.length) {
            if (stack.isEmpty()) {
                cnt += Math.pow(k, zero);
                cnt = cnt % 10001;
            }
            return;
        }
        if (arr[idx] == 0) {
            if (!stack.isEmpty()) {
                int tmp = stack.removeLast();
                dfs(arr, idx + 1);
                stack.addLast(tmp);
            }
            zero++;
            stack.addLast(0);
            dfs(arr, idx + 1);
            stack.removeLast();
            zero--;
        } else {
            stack.addLast(arr[idx]);
            dfs(arr, idx + 1);
            stack.removeLast();
        }
    }
}
