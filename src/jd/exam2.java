package jd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class exam2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        String[] input = br.readLine().split(" ");
        Map<Integer, Integer> oddDict = new HashMap<>();
        Map<Integer, Integer> evenDict = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
            if (i % 2 == 0) {
                evenDict.put(nums[i], evenDict.getOrDefault(nums[i], 0) + 1);
            } else {
                oddDict.put(nums[i], oddDict.getOrDefault(nums[i], 0) + 1);
            }
        }
        ArrayList<Integer> oddIdxNum = new ArrayList<>(oddDict.keySet());
        ArrayList<Integer> evenIdxNum = new ArrayList<>(evenDict.keySet());
        oddIdxNum.sort((n1, n2) -> oddDict.get(n2) - oddDict.get(n1));
        evenIdxNum.sort((n1, n2) -> evenDict.get(n2) - evenDict.get(n1));
        int res = 0;
        int n1 = oddIdxNum.get(0), n2 = evenIdxNum.get(0);
        if (n1 == n2) {
            if (oddIdxNum.size() <= 1 && evenIdxNum.size() <= 1) {
                res = n - Math.max(oddDict.get(oddIdxNum.get(0)), evenDict.get(evenIdxNum.get(0)));
            } else if (oddIdxNum.size() <= 1) {
                res = n - oddDict.get(oddIdxNum.get(0)) - evenDict.get(evenIdxNum.get(1));
            } else if (evenIdxNum.size() <= 1) {
                res = n - oddDict.get(oddIdxNum.get(1)) - evenDict.get(evenIdxNum.get(0));
            } else {
                res = n - Math.max(oddDict.get(oddIdxNum.get(1)) + evenDict.get(evenIdxNum.get(0)),
                        oddDict.get(oddIdxNum.get(0)) + evenDict.get(evenIdxNum.get(1)));
            }

        } else {
            res = n - (oddDict.get(oddIdxNum.get(0)) + evenDict.get(evenIdxNum.get(0)));
        }
        System.out.println(res);
    }
}
