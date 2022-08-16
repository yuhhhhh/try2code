package yuanfudao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class exam1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        Map<String, Map<Character, Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String[] words = br.readLine().split(" ");
            int[] record = new int[26];
            for (int j = 0; j < str.length(); j++) {
                record[str.charAt(i) - 'a'] += 1;
            }
            int[] wordsCnt = new int[words.length];
            int idx = 0;
            int res = 0;
            for (String word : words) {
                Map<Character, Integer> recordMap = new HashMap<>();
                for (int k = 0; k < word.length(); k++) {
                    char c = word.charAt(k);
                    recordMap.put(c, recordMap.getOrDefault(c, 0) + 1);
                }
                map.put(str, recordMap);
                int cnt = Integer.MAX_VALUE;
                for (Character c : recordMap.keySet()) {
                    cnt = Math.min(cnt, record[c - 'a'] / recordMap.get(c));
                }
                wordsCnt[idx++] = cnt;
                res = Math.max(res, cnt);
            }
            System.gc();
        }
    }
}
