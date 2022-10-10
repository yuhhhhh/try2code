package baidu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class exam1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int cnt = 0, i = 0;
        while (i < str.length() - 4) {
            char c1 = str.charAt(i), c2 = str.charAt(i + 1), c3 = str.charAt(i + 2),
                    c4 = str.charAt(i + 3), c5 = str.charAt(i + 4);
            if (c2 == c3 || c2 == c5 || c3 == c5) {
                i++;
                continue;
            }
            if (!set.contains(c1) && !set.contains(c4)) {
                if (set.contains(c2) && set.contains(c3) && set.contains(c5)) {
                    cnt++;
                    System.out.println(i);
                    i += 3;
                    continue;
                }
            }
            i++;
        }
        System.out.println(cnt);
    }
}
