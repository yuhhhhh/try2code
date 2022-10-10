public class CodeEveryDay {
    public int minAddToMakeValid(String s) {
        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                l++;
            } else if (c == ')') {
                if (l > 0) l--;
                else r++;
            }
        }
        return l + r;
    }
}
