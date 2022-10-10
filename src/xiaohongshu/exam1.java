package xiaohongshu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Objects;
import java.util.PriorityQueue;

public class exam1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]), id = Integer.parseInt(input[2]);
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> {
            if (Objects.equals(map.get(n1), map.get(n2))) {
                return n1- n2;
            } else {
                return map.get(n2) - map.get(n1);
            }
        });
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += Integer.parseInt(input[j]);
            }
            map.put(i + 1, sum);
            queue.add(i + 1);
        }
        int res = 1;
        while (queue.remove() != id) {
            res++;
        }
        System.out.println(res);
    }
}
