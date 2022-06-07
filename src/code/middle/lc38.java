package code.middle;

public class lc38 {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        StringBuilder sb = new StringBuilder();
        String say = countAndSay(n - 1);
        char cur = ' ';
        int cnt = 0;
        for (int i = 0; i < say.length(); i++) {
            char c = say.charAt(i);
            if (cur == ' ') {
                cur = c;
            } else {
                if (c != cur) {
                    sb.append(cnt).append(cur);
                    cur = c;
                    cnt = 0;
                }
            }
            cnt++;
        }
        sb.append(cnt).append(cur);
        return sb.toString();
    }
}
