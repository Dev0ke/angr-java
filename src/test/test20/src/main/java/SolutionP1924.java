import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolutionP1924 {
    public double[] outerTrees(int[][] trees) {
        int n = trees.length;
        List<Point> a = new ArrayList<>(n);
        for (int[] p : trees) {
            a.add(new Point(p[0], p[1]));
        }
        Collections.shuffle(a); // 随机打乱

        Point o = a.get(0); // 圆心
        double r2 = 0; // 半径的平方
        for (int i = 0; i < n; i++) {
            Point p = a.get(i);
            if (dis2(o, p) < r2 + eps) continue; // p 在最小圆内部或边上
            o = p;
            r2 = 0;
            for (int j = 0; j < i; j++) {
                Point q = a.get(j);
                if (dis2(o, q) < r2 + eps) continue; // q 在最小圆内部或边上
                o = new Point((p.x + q.x) / 2, (p.y + q.y) / 2);
                r2 = dis2(o, p);
                for (int k = 0; k < j; k++) {
                    Point x = a.get(k);
                    if (dis2(o, x) < r2 + eps) continue; // 保证三点不会共线
                    o = circumcenter(p, q, x);
                    r2 = dis2(o, p);
                }
            }
        }
        return new double[]{o.x, o.y, Math.sqrt(r2)};
    }

    // 两点距离的平方
    private double dis2(Point p, Point q) {
        return (p.x - q.x) * (p.x - q.x) + (p.y - q.y) * (p.y - q.y);
    }

    // 三角形外心
    private Point circumcenter(Point a, Point b, Point c) {
        double a1 = b.x - a.x, b1 = b.y - a.y, a2 = c.x - a.x, b2 = c.y - a.y;
        double c1 = a1 * a1 + b1 * b1, c2 = a2 * a2 + b2 * b2, d = 2 * (a1 * b2 - a2 * b1);
        return new Point(a.x + (c1 * b2 - c2 * b1) / d, a.y + (a1 * c2 - a2 * c1) / d);
    }

    static final double eps = 1e-8;

    static class Point {
        double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
/*
$1924. 安装栅栏 II
https://leetcode.cn/problems/erect-the-fence-ii/description/

给你一个二维整数数组 trees，其中 trees[i] = [xi, yi] 表示花园中第 i 棵树的坐标。
你需要用最少的原材料给花园安装一个 圆形 的栅栏，使花园中所有的树都在被 围在栅栏内部（在栅栏边界上的树也算在内）。
正式地说，你需要求出栅栏的圆心坐标 (x,y) 和半径 r，使花园中所有的树都在圆的内部或边界上，并且让半径 r 最小。
请用一个长度为 3 的数组 [x,y,r] 来返回圆心坐标和半径。如果答案与正确答案的误差不超过 10^-5，则该答案将被视为正确答案通过。
提示:
1 <= trees.length <= 3000
trees[i].length == 2
0 <= xi, yi <= 3000

最小圆覆盖 Welzl 算法
https://oi-wiki.org/geometry/random-incremental/
https://leetcode.cn/problems/erect-the-fence-ii/solutions/1141323/go-zui-xiao-yuan-fu-gai-welzl-suan-fa-by-v6yz/
时间复杂度 O(n)
 */