package a360;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class exam2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int zhuN = Integer.parseInt(input[0]), weiN = Integer.parseInt(input[1]), binN = Integer.parseInt(input[2]);
        input = br.readLine().split(" ");
        Set<String> zhu = new HashSet<>(Arrays.asList(input).subList(0, zhuN));
        input = br.readLine().split(" ");
        Set<String> wei = new HashSet<>(Arrays.asList(input).subList(0, weiN));
        input = br.readLine().split(" ");
        Set<String> bin = new HashSet<>(Arrays.asList(input).subList(0, binN));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            int st = 1;
            boolean flag = false;
            for (int j = 0; j < input.length; j++) {
                String str = input[j];
                if (st == 1) {
                    if (!zhu.contains(str)) {
                        if (j == 0 || j == input.length - 1) {
                            flag = true;
                            break;
                        } else {
                            st++;
                        }
                    }
                }
                if (st == 2) {
                    if (wei.contains(str)) {
                        st++;
                        continue;
                    } else {
                        flag = true;
                        break;
                    }
                }
                if (st == 3) {
                    if (!bin.contains(str)) {
                        flag = true;
                        break;
                    }
                }
            }
            if (flag) {
                System.out.println("NO");
            } else {
                System.out.println("OK");
            }

        }
    }
}
