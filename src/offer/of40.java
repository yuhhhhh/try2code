package offer;

import java.util.HashMap;
import java.util.Map;

public class of40 {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        int x = 0, y = 0;
        int[] array1 = new int[]{3, 2, 1};
        int k = 2;
        int[] res = getLeastNumbers(array1, k);
        for (int re : res) {
            System.out.println(re);
        }
    }
    public static int[] getLeastNumbers(int[] arr, int k) {
        int[] cnt = new int[10010];
        int[] res = new int[k];
        int idx = 0;
        int j = 0;
        for(int i = 0; i < arr.length; i++) {
            cnt[arr[i]]++;
        }
        while(j != k) {
            if(cnt[idx] != 0) {
                res[j++] = idx;
                cnt[idx]--;
            }
            else {
                idx++;
            }
        }
        return res;
    }
}
