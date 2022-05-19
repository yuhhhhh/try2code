package code.middle;

import java.util.HashMap;
import java.util.Map;

public class lc621 {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> dict = new HashMap<>();
        int maxExec = 0;
        for (char c : tasks) {
            int exec = dict.getOrDefault(c, 0) + 1;
            dict.put(c, exec);
            maxExec = Math.max(maxExec, exec);
        }
        int maxCount = 0;
        for (Character c : dict.keySet()) {
            int exec = dict.get(c);
            if (exec == maxExec) maxCount++;
        }
        return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);
    }
}
