package nc.middle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class nc41 {
    public int maxLength (int[] arr) {
        // write code here
        Set<Integer> dict = new HashSet<>();
        int maxLen = 0, l = 0;
        for (int r = 0; r < arr.length; r++) {
            while (dict.contains(arr[r])) {
                dict.remove(arr[l++]);
            }
            dict.add(arr[r]);
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}
