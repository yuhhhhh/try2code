package honor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point jian(Point p) {
        return new Point(x - p.x, y - p.y);
    }

    public int cheng(Point p) {
        return x * p.y - y * p.x;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

class Line {
    Point a;
    Point b;

    public Line(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    public int getMax() {
        return Math.max(a.x, b.x);
    }

    public int getMin() {
        return Math.min(a.x, b.x);
    }
}

public class exam2 {
    // L={-6,2,-4,5|-3,6,2,5|3,4,1,-3|-2,-3,-6,-2},Q={-4,7|2,7|4,5|3,-3|1,-5|-5,-4|-7,-1|-8,4},P=-2,2

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split("}");
        String LData = data[0].substring(3), QData = data[1].substring(4), PData = data[2].substring(3);
        List<Line> lines = new ArrayList<>();
        List<Point> points = new ArrayList<>();
        List<Point> res = new ArrayList<>();
        data = LData.split("\\|");
        for (String datum : data) {
            String[] str = datum.split(",");
            lines.add(new Line(new Point(Integer.parseInt(str[0]), Integer.parseInt(str[1])),
                    new Point(Integer.parseInt(str[2]), Integer.parseInt(str[3]))));
        }
        data = QData.split("\\|");
        for (String datum : data) {
            String[] str = datum.split(",");
            points.add(new Point(Integer.parseInt(str[0]), Integer.parseInt(str[1])));
        }
        data = PData.split(",");
        Point p = new Point(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
        for (Point a : points) {
            Line newLine = new Line(p, a);
            boolean flag = false;
            for (Line line: lines) {
                if (isXiangJiao(newLine, line)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) res.add(a);
        }
        for (Point a : res) {
            System.out.print(a);
        }
    }

    public static boolean isXiangJiao(Line l1, Line l2) {
        if (l1.getMax() < l2.getMin() || l2.getMax() < l1.getMin()) {
            return false;
        } else {
            if (l2.b.jian(l1.a).cheng(l1.b.jian(l1.a)) * l2.a.jian(l1.a).cheng(l1.b.jian(l1.a)) <= 0
            && l1.a.jian(l2.a).cheng(l2.b.jian(l2.a)) * l1.b.jian(l2.a).cheng(l2.b.jian(l2.a)) <= 0) {
                return true;
            } else {
                return false;
            }
        }
    }
}
