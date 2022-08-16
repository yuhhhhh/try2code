package yuanfudao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class exam2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int p = Integer.parseInt(br.readLine());
        String input = " ";
        for (int i = 0; i < p; i++) {
            br.readLine();
        }
        Map<String, String> shengmu = new HashMap<>();
        Map<String, String> xunmu = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            input = br.readLine();
            String[] strs = input.split("/");
            shengmu.put(strs[1], strs[0]);
            String[] xunmus = strs[2].split(",");
            for (String s : xunmus) {
                xunmu.put(s, strs[0]);
            }
        }
    }
}
