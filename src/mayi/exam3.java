package mayi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class exam3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        long cnt = 0;
        for (int len = 1; len <= s.length(); len += 2) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < len; i++) {
                addElement(set, s.charAt(i));
            }
            if (set.size() == 1) cnt++;
            for (int i = len; i < s.length(); i++) {
                addElement(set, s.charAt(i - len));
                addElement(set, s.charAt(i));
                if (set.size() == 1) cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void addElement(Set<Character> set, char c) {
        if (set.isEmpty()) set.add(c);
        else {
            if (set.contains(c)){
                set.remove(c);
            } else {
                set.add(c);
            }
        }
    }
}
