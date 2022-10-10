package youka;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class exam1 {
    public static void main(String[] args) {
        System.out.println(Float.parseFloat("1.23"));
    }
    public int halfQuestions (int[] questions) {
        // write code here
        int n = questions.length / 4;
        Map<Integer, Integer> dict = new HashMap<>();
        for (int q : questions) {
            dict.put(q, dict.getOrDefault(q, 0) + 1);
        }
        return Math.min(dict.size(), 2 * n);
    }
}
