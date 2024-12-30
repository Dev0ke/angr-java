import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution587 {
    public int[][] outerTrees(int[][] trees) {
        // Andrew 算法求凸包
        int n = trees.length;
        if (n <= 3) {
            return trees;
        }

        // 对所有点坐标的双关键字排序
        Arrays.sort(trees, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });

        List<Integer> hull = new ArrayList<>();
        boolean[] used = new boolean[n];
        hull.add(0);

        // 升序枚举 求出下凸壳
        for (int i = 1; i < n; i++) {
            while (hull.size() > 1 && crossProduct(trees[hull.get(hull.size() - 2)], trees[hull.get(hull.size() - 1)], trees[i]) < 0) {
                used[hull.get(hull.size() - 1)] = false;
                hull.remove(hull.size() - 1);
            }
            used[i] = true;
            hull.add(i);
        }

        // 然后 降序 求出上凸壳。
        int m = hull.size();
        for (int i = n - 2; i >= 0; i--) {
            if (used[i]) continue;

            while (hull.size() > m && crossProduct(trees[hull.get(hull.size() - 2)], trees[hull.get(hull.size() - 1)], trees[i]) < 0) {
                used[hull.get(hull.size() - 1)] = false;
                hull.remove(hull.size() - 1);
            }
            used[i] = true;
            hull.add(i);
        }

        // hull[0] 同时参与凸包的上半部分检测，因此需去掉重复的 hull[0]
        hull.remove(hull.size() - 1);

        int sz = hull.size();
        int[][] res = new int[sz][2];
        for (int i = 0; i < sz; i++) {
            res[i] = trees[hull.get(i)];
        }
        return res;
    }

    // 叉乘
    private int crossProduct(int[] p, int[] q, int[] r) {
        int x1 = q[0] - p[0];
        int y1 = q[1] - p[1];
        int x2 = r[0] - q[0];
        int y2 = r[1] - q[1];
        return x1 * y2 - x2 * y1;
    }
}
/*
587. 安装栅栏
https://leetcode.cn/problems/erect-the-fence/

给定一个数组 trees，其中 trees[i] = [xi, yi] 表示树在花园中的位置。
你被要求用最短长度的绳子把整个花园围起来，因为绳子很贵。只有把 所有的树都围起来，花园才围得很好。
返回恰好位于围栏周边的树木的坐标。
注意:
1 <= points.length <= 3000
points[i].length == 2
0 <= xi, yi <= 100
所有给定的点都是 唯一 的。

凸包 https://oi-wiki.org/geometry/convex-hull/
Andrew 算法求凸包
叉乘
相似题目: $469. 凸多边形
https://leetcode.cn/problems/convex-polygon/
 */