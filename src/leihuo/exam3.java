package leihuo;

public class exam3 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param n  int整型 方格矩阵Cn下标
     * @param x1 int整型 方格1在方格矩阵中的横坐标
     * @param y1 int整型 方格1在方格矩阵中的纵坐标
     * @param x2 int整型 方格2在方格矩阵中的横坐标
     * @param y2 int整型 方格2在方格矩阵中的纵坐标
     * @return long长整型
     */
    public long solution(int n, int x1, int y1, int x2, int y2) {
        // write code here
        int len = (int) Math.pow(2, n);
        long distance = 0;
        int point1 = getIdx(x1, y1, len), point2 = getIdx(x2, y2, len);
        if (n == 1) {
            return Math.abs(point1 - point2);
        }
        int newX1 = x1 > len / 2 ? x1 - len / 2 : x1,
                newX2 = x2 > len / 2 ? x2 - len / 2 : x2,
                newY1 = y1 > len / 2 ? y1 - len / 2 : y1,
                newY2 = y2 > len / 2 ? y2 - len / 2 : y2;
        if (point1 == point2) {
            distance += solution(n - 1, newX1, newY1, newX2, newY2);
        } else {
            distance += (Math.abs(point1 - point2) - 1) * Math.pow(2, (2 * n) - 2);
            int end = (int) Math.pow(2, n - 1);
            if (point1 > point2) {
                distance += solution(n - 1, 0, 0, newX2, newY2)
                        + solution(n - 1, newX1, newY1, end, end);
            } else {
                distance += solution(n - 1, 0, 0, newX1, newY1)
                        + solution(n - 1, newX2, newY2, end, end);
            }
        }
        return distance;
    }

    public int getIdx(int x, int y, int len) {
        int res = 0;
        if (x <= len / 2) {
            if (y <= len / 2) {
                res = 1;
            } else {
                res = 2;
            }
        } else {
            if (y <= len / 2) {
                res = 4;
            } else {
                res = 3;
            }
        }
        return res;
    }
}
