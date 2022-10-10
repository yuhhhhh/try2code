package code.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (String cp : cpdomains) {
            String[] strs = cp.split(" ");
            int cnt = Integer.parseInt(strs[0]);
            String[] domain = strs[1].split("\\.");
            int start = 0;
            for (String value : domain) {
                String s = strs[1].substring(start);
                map.put(s, map.getOrDefault(s, 0) + cnt);
                start += value.length() + 1;
            }
        }
        for (String key : map.keySet()) {
            res.add(map.get(key) + " " + key);
        }
        return res;
    }
}
