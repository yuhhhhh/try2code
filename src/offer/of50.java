package offer;

import java.util.HashMap;
import java.util.Map;

public class of50 {
    public static void main(String[] args) {
        String s = "abaccdeff";
        Map<Character, Integer> map = new HashMap<>();
        int min = s.length();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        for (Character character : map.keySet()) {
            if (map.get(character) < min) min = map.get(character);
        }
        System.out.println(s.charAt(min));

    }
}
