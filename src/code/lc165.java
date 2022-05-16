package code;

import java.util.Arrays;

public class lc165 {
    public void main(String[] args) {
        String version1 = "1.01";
        String version2 = "1.001";
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        while(i < Math.min(v1.length, v2.length)) {
            int v1Int = Integer.parseInt(v1[i]);
            int v2Int = Integer.parseInt(v2[i]);
            if (v1Int < v2Int) System.out.println(-1);
            else if (v1Int > v2Int) System.out.println(1);
            i++;
        }
        if (v1.length > v2.length && isZero(v1, i)) System.out.println(1);;
        System.out.println(v1.length > v2.length ? 1 : -1);
    }

    public boolean isZero(String[] s, int i) {
        while (i < s.length) {
            if (Integer.parseInt(s[i]) != 0) return false;
        }
        return true;
    }
}
