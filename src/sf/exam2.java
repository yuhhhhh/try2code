package sf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class exam2 {
    static HashMap<Integer, Set<Integer>> kids = new HashMap<>();
    static int[] values;
    static long process = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        values = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            int p = Integer.parseInt(input[i]);
            Set<Integer> set = kids.getOrDefault(p, new HashSet<>());
            set.add(i + 2);
            kids.put(p, set);
        }
        input = br.readLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            values[i] = Integer.parseInt(input[i]);
        }
        dfs(1);
        System.out.println(process);
    }

    public static int dfs(int i) {
        int val = 0;
        if (kids.containsKey(i)) {
            Set<Integer> set = kids.get(i);
            for (int k : set) {
                val += dfs(k);
            }
        }
        process += Math.abs(values[i - 1] + val);
        int newVal = values[i - 1] + val;
        val = -newVal + val;
        return val;
    }
}
