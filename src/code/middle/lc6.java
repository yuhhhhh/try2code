package code.middle;

import java.util.ArrayList;
import java.util.List;

public class lc6 {
    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        char[] charArr = s.toCharArray();
        int idx = 0, flag = -1;
        for (char c : charArr) {
            list.get(idx).append(c);
            if (idx == 0 || idx == numRows - 1) flag = -flag;
            idx += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : list) res.append(sb.toString());
        return res.toString();
    }
}
