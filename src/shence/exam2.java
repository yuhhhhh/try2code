package shence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class exam2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        int[] timeTable = new int[n];
        for (int i = 0; i < n; i++) {
            String[] time = inputs[i].split(":");
            timeTable[i] = Integer.parseInt(time[0]) * 3600
                    + Integer.parseInt(time[1]) * 60
                    + Integer.parseInt(time[2]);
            map.put(inputs[i], timeTable[i]);
        }
        Arrays.sort(inputs, Comparator.comparingInt(map::get));
        Arrays.sort(timeTable);
        int max = 0, idx = 0;
        for (int i = 0; i < n - 1; i++) {
            if (timeTable[i + 1] - timeTable[i] > max) {
                max = timeTable[i + 1] - timeTable[i];
                idx = i;
            }
        }
        if (24 * 3600 - timeTable[n - 1] + timeTable[0] > max) {
            idx = n - 1;
        }
        System.out.println(inputs[idx]);
    }
}
