package offer;

public class of58 {
    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        int len = s.length();
        char[] res = new char[len];
        for (int i = 0; i < len; i++) {
            res[i] = s.charAt((i+k)%(len));
        }
        String s1 = String.valueOf(res);
        System.out.println(s1);
    }
}
