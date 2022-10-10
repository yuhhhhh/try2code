package a360;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class exam1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String t = br.readLine();
            if (s.length() > t.length()) {
                System.out.println("NO");
                continue;
            }
            boolean flag = false;
            int idxS = 0, idxJ = 0;
            while (idxJ < t.length() && idxS < s.length()) {
                char c = t.charAt(idxJ);
                if (s.charAt(idxS) == c) {
                    int lenS = 0, lenT = 0;
                    while (idxS < s.length() && c == s.charAt(idxS)) {
                        idxS++;
                        lenS++;
                    }
                    while (idxJ < t.length() && c == t.charAt(idxJ)) {
                        idxJ++;
                        lenT++;
                    }
                    if (lenS > lenT) {
                        flag = true;
                        break;
                    }
                } else {
                    flag = true;
                    break;
                }
            }
            if (idxS != s.length() || idxJ != t.length()) {
                flag = true;
            }
            if (flag) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
