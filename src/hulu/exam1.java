package hulu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class exam1 {
    /**
     * 6
     * a 2021-01-01
     * b 2021-01-01
     * b 2021-01-05
     * a 2021-01-01
     * b 2021-01-10
     * c 2021-01-02
     * 3
     * @param args
     * @throws IOException
     * @throws ParseException
     */
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        HashMap<Long, List<String>> map = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        for (int i = 0; i < k; i++) {
            String[] input = br.readLine().split(" ");
            String user = input[0];
            Date date = sdf.parse(input[1]);
            List<String> list = map.getOrDefault(date.getTime(), new ArrayList<>());
            list.add(user);
            map.put(date.getTime(), list);
        }
        int n = Integer.parseInt(br.readLine());
        ArrayList<Long> list = new ArrayList<>(map.keySet());
        list.sort((t1, t2) -> (int) (t1 - t2));
        int w = 0, curCnt = 0;
        Map<String, Integer> dict = new HashMap<>();
        long res = Long.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            while (w < list.size() && dict.size() < n) {
                List<String> users = map.get(list.get(w++));
                users.forEach(u -> dict.put(u, dict.getOrDefault(u, 0) + 1));
            }
            if (dict.size() >= n) {
                res = Math.min(res, list.get(w - 1) - list.get(i));
            } else {
                if (w == list.size()) {
                    break;
                }
            }
            List<String> users = map.get(list.get(i));
            users.forEach(u -> {
                dict.put(u, dict.get(u) - 1);
                if (dict.get(u) == 0) {
                    dict.remove(u);
                }
            });
        }
        if (res != Long.MAX_VALUE) System.out.println(res/86400000 + 1);
        else System.out.println(-1);
    }
}
