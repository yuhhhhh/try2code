package shence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class exam3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> map = new HashMap<>();
        String input = br.readLine();
        int cur = 0, max = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == 'f') {
                map.put(c, map.getOrDefault(c, 0) + 1);
                cur++;
            } else if (c == 'a') {
                if (map.containsKey('f') && map.get('f') > 0) {
                    map.put(c, map.getOrDefault(c, 0) + 1);
                    map.put('f', map.get('f') - 1);
                } else {
                    max = -1;
                    break;
                }
            } else if (c == 'i') {
                if (map.containsKey('a') && map.get('a') > 0) {
                    map.put(c, map.getOrDefault(c, 0) + 1);
                    map.put('a', map.get('a') - 1);
                } else {
                    max = -1;
                    break;
                }
            } else if (c == 'l') {
                if (map.containsKey('i') && map.get('i') > 0) {
                    map.put(c, map.getOrDefault(c, 0) + 1);
                    map.put('i', map.get('i') - 1);
                } else {
                    max = -1;
                    break;
                }
            } else if (c == 'e') {
                if (map.containsKey('l') && map.get('l') > 0) {
                    map.put(c, map.getOrDefault(c, 0) + 1);
                    map.put('l', map.get('l') - 1);
                } else {
                    max = -1;
                    break;
                }
            } else if (c == 'd') {
                if (map.containsKey('e') && map.get('e') > 0) {
                    map.put('e', map.get('e') - 1);
                    cur--;
                } else {
                    max = -1;
                    break;
                }
            } else {
                max = -1;
                break;
            }
            max = Math.max(cur, max);
        }
        for (Character c : map.keySet()) {
            if (map.get(c) >0) {
                max = -1;
                break;
            }
        }
        System.out.println(max);
    }
}
