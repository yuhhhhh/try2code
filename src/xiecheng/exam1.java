package xiecheng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            String n = br.readLine();
            String res = "-1";
            for (int j = n.length() - 1; j >= 0; j--) {
                int c = n.charAt(j) - '0';
                if (c % 2 == 0) {
                    res = n.substring(0, j) + n.substring(j + 1) + c;
                    break;
                }
            }
            System.out.println(res);
        }
    }
}
