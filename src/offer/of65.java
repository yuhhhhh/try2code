package offer;

public class of65 {
    public static void main(String[] args) {
        int a = 1, b = 2;
        int c = 0;
        while (b != 0){
            c = a ^ b;
            b = (a&b) << 1;
            a = c;
        }
        System.out.println(c);
    }
}
