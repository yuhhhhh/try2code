package code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumCount {
    static Map<Integer, Integer> dic = new HashMap<>();

    public static void main(String[] args) {
        String str = "10 20 20 30 40 10";
        numCount(str);
        int[] arr = new int[dic.keySet().size()];
        int idx = 0;
        for (Integer key : dic.keySet()) {
            System.out.println(key + ":" + dic.get(key));
            arr[idx++] = key;
        }
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void numCount(String s) {
        s.trim();
        int num = 0;
        s = s + ' ';
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a == ' ') {
                dic.put(num, dic.getOrDefault(num, 0) + 1);
                num = 0;
            } else if (a <= '9' && a>= '0') {
                num = num * 10 + (int) (a - '0');
            }
        }
    }

    public static void sort(int[] arr, int l, int r) {
        if ((r-l) <= 1) return ;
        int first = l, last = r, key = dic.get(arr[l]), temp = arr[l];
        while (first < last) {
            while (first < last && dic.get(arr[last]) <= key) {
                last--;
            }
            arr[first] = arr[last];
            while (first < last && dic.get(arr[first]) >= key) {
                first++;
            }
            arr[last] = arr[first];
        }
        arr[first] = temp;
        sort(arr, l, first);
        sort(arr, first+1, r);
        return ;
    }
}
