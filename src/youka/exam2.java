package youka;

import java.util.ArrayList;
import java.util.List;

public class exam2 {
    public static void main(String[] args) {
        System.out.println(new exam2().ambiguousCoordinates("(123)"));
    }
    List<String> res = new ArrayList<>();
    StringBuffer sb = new StringBuffer();

    public String ambiguousCoordinates(String s) {
        // write code here
        s = s.substring(1, s.length() - 1);
        int len = s.length();
        for (int i = 0; i < len - 1; i++) {
            addPoint(s.substring(0, i + 1), s.substring(i + 1, len), false);
        }
        res.sort((s1, s2) -> {
            Float s1High = Float.parseFloat(s1.split(",")[0]);
            Float s1Low = Float.parseFloat(s1.split(",")[1]);
            Float s2High = Float.parseFloat(s2.split(",")[0]);
            Float s2Low = Float.parseFloat(s2.split(",")[1]);
            if (s1High != s2High) {
                if (s1High > s2High) {
                    return 1;
                } else {
                    return -1;
                }

            } else {
                if (s1Low > s2Low) {
                    return 1;
                } else if (s1Low < s2Low) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        sb.delete(0, sb.length());
        for (int i = 0; i < res.size(); i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(res.get(i));
        }
        return sb.toString();
    }

    public void dfs(String s) {
        int len = s.length();
        for (int i = 0; i < len - 1; i++) {
            addPoint(s.substring(0, i + 1), s.substring(i + 1, len), false);
        }
    }

    public void addPoint(String s1, String s2, boolean st) {
        if (st) {
            int len = s2.length();
            for (int i = 0; i < len - 1; i++) {
                String high = s2.substring(0, i + 1);
                String low = s2.substring(i+1, len);
                if (high.equals("0")) continue;
                if (high.length() > 1 && high.charAt(0) == '0') continue;
                if (low.equals("0")) continue;
                if (low.length() > 1 && low.charAt(0) == '0') continue;
                sb.append("," + high + "." + low);
                res.add(sb.toString());
                sb.delete(sb.length() - len - 2, sb.length());
            }
            sb.append("," + s2);
            res.add(sb.toString());
            sb.delete(sb.length() - len - 1, sb.length());
        } else {
            int len = s1.length();
            for (int i = 0; i < len - 1; i++) {
                String high = s1.substring(0, i + 1);
                String low = s1.substring(i+1, len);
                if (high.equals("0")) continue;
                if (high.length() > 1 && high.charAt(0) == '0') continue;
                if (low.equals("0")) continue;
                if (low.length() > 1 && low.charAt(0) == '0') continue;
                sb.append(high + "." + low);
                addPoint(s1, s2, true);
                sb.delete(0, sb.length());
            }
            sb.append(s1);
            addPoint(s1, s2, true);
            sb.delete(0, sb.length());
        }

        return ;
    }
}
