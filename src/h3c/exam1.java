package h3c;

import java.util.HashSet;
import java.util.Set;

public class exam1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 判断给定字符串包含的字符是否唯一
     * @param str string字符串 给定的字符串
     * @return bool布尔型
     */
    public boolean isUnique (String str) {
        // write code here
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (set.contains(c)) {
                return false;
            } else {
                set.add(c);
            }
        }
        return true;
    }
}
