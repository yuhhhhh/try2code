package youka;

import java.util.ArrayList;
import java.util.List;

public class exam3 {
    public ArrayList<Integer> findConsecutiveSubArr2 (ArrayList<Integer> binaries) {
        // write code here
        int[] num = new int[binaries.size()];
        for (int i = 0; i < num.length; i++) {
            int n = binaries.get(i);
            if (n == 0) num[i] = -1;
            else num[i] = n;
        }
        int[] preSum = new int[num.length];
        preSum[0] = num[0];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i-1] + num[i];
        }
        int maxLen = 0, begin = 0;
        for (int i = 0; i < preSum.length; i++) {
            for (int j = 2; i + j - 1 < preSum.length; j += 2) {
                int sum;
                if (i == 0) {
                    sum = preSum[j - 1];
                } else {
                    sum = preSum[i + j - 1] - preSum[i - 1];
                }
                if (sum == 0) {
                    if (maxLen <= j) {
                        maxLen = j;
                        begin = i;
                    }
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = begin; i < begin + maxLen; i++) {
            res.add(binaries.get(i));
        }
        return res;
    }
}
