package gaotu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String num1 = input[0], num2 = input[1];
        String res = "";
        for (int i = 0; i < num2.length(); i++) {
            int n1 = num2.charAt(i) - '0';
            StringBuffer sb = new StringBuffer();
            int flag = 0;
            for (int j = num1.length() - 1; j >= 0; j--) {
                int n2 = num1.charAt(j) - '0';
                int sum = n1 * n2 + flag;
                if (sum >= 10) {
                    flag = sum / 10;
                    sum = sum % 10;
                } else {
                    flag = 0;
                }
                sb.append(sum);
            }
            if (flag != 0) sb.append(flag);
            String tmp = sb.reverse().toString();
            res = addString(res, tmp);
        }
        int i = 0;
        while (res.charAt(i) == '0' && res.length() > 1) {
            res = res.substring(1);
        }
        System.out.println(res);
    }

    public static String addString(String str1, String str2) {
        str1 = str1 + "0";
        StringBuffer sb = new StringBuffer();
        int idx1 = str1.length() - 1, idx2 = str2.length() - 1;
        boolean flag = false;
        while (idx1 >= 0 && idx2 >= 0) {
            int n1 = str1.charAt(idx1--) - '0', n2 = str2.charAt(idx2--) - '0';
            int sum = flag ? n1 + n2 + 1 : n1 + n2;
            if (sum >= 10) {
                flag = true;
                sum = sum % 10;
            } else {
                flag = false;
            }
            sb.append(sum);
        }

        for (int i = idx1; i >= 0; i--) {
            int n = str1.charAt(i) - '0';
            int sum = flag ? n + 1 : n;
            if (sum >= 10) {
                flag = true;
                sum = sum % 10;
            } else {
                flag = false;
            }
            sb.append(sum);
        }

        for (int i = idx2; i >= 0; i--) {
            int n = str2.charAt(i) - '0';
            int sum = flag ? n + 1 : n;
            if (sum >= 10) {
                flag = true;
                sum = sum % 10;
            } else {
                flag = false;
            }
            sb.append(sum);
        }

        if (flag) sb.append("1");
        return sb.reverse().toString();
    }

}
