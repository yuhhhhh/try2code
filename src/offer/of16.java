package offer;

import java.util.Deque;
import java.util.LinkedList;

public class of16 {
    public static void main(String[] args) {
        double x = 2.0;
        int n = -2;
        double res = 1;
        int k = n;
        if (n < 0) x = 1/x;
        while(k != 0) {
            if ((k & 1) == 1) res *= x;
            k /= 2;
            x *= x;
        }
        System.out.println(res);
    }
//    public static void main(String[] args) {
//        Deque<Integer> stk = new LinkedList<Integer>();
//
//        double x = 2;
//        int n = 10;
//        double res;
//        if (n > -1) {
//            res = powFun(x, n);
//        } else {
//            res = 1/powFun(x, n);
//        }
//        System.out.println(res);
//    }
//    public static double powFun(double x, int n) {
//        if (n == 0) return 1;
//        double val = powFun(x, n/2);
//        return n%2==0? val*val:val*val*x;
//    }
}
