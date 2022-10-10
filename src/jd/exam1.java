package jd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]), k = Integer.parseInt(input[1]);
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (i < k) {
                if (c >= 'a' && c <= 'z') {
                    c -= 32;
                }
            } else {
                if (c >= 'A' && c <= 'Z') {
                    c += 32;
                }
            }
            sb.append(c);
        }
        System.out.println(sb);
    }


}
