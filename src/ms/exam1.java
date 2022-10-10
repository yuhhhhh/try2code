package ms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class exam1 {
    public static void main(String[] args) {
        System.out.println(new exam1().solution("555444223366"));
        System.out.println(new exam1().solution("0000005"));
        System.out.println(new exam1().solution(""));
    }
    public String solution(String S) {
        // write your code in Java 8 (Java SE 8)
        if (S.length() == 0) return "";
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            int c = S.charAt(i) - '0';
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //ArrayList<Integer> oddNum = new ArrayList<>();
        ArrayList<Integer> evenNum = new ArrayList<>();
        int maxOddCnt = 0, odd = 0;
        for (int n : map.keySet()) {
            int tmp = map.get(n);
            if (tmp % 2 == 0) {
                int cnt = tmp / 2;
                for (int i = 0; i < cnt; i++) {
                    evenNum.add(n);
                }
            } else {
                if (tmp >= maxOddCnt) {
                    if (tmp == maxOddCnt) {
                        if (n > odd) odd = n;
                    } else {
                        odd = n;
                        maxOddCnt = tmp;
                    }
                }
                //oddNum.add(n);
            }
        }
        int cnt = maxOddCnt / 2;
        for (int i = 0; i < cnt; i++) {
            evenNum.add(odd);
        }
        //oddNum.sort((n1, n2)->n2-n1);
        evenNum.sort((n1, n2)->n2-n1);
        StringBuilder sb = new StringBuilder();
        if (evenNum.get(0) == 0) return String.valueOf(odd);
        for (int i = 0; i < evenNum.size(); i++) {
            sb.append(evenNum.get(i));
        }
        sb.append(odd);
        for (int i = evenNum.size() - 1; i >= 0; i--) {
            sb.append(evenNum.get(i));
        }
        return sb.toString();
    }
}
