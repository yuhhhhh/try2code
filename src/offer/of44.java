package offer;

public class of44 {
    public static void main(String[] args) {
        int n = 1000000000;
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n-1)/digit;
        System.out.println(Long.toString(num).charAt((n-1)%digit) - '0');
        char a = '9';
        int i = a - '0';
        System.out.println(i);
    }
}
