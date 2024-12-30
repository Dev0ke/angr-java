import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution963 {
    private static final double inf = 1e10;
    private Map<Long, Double> hash;
    private double ans;

    // https://leetcode.cn/problems/minimum-area-rectangle-ii/solutions/707666/c-on2-0ms-100-by-hqztrue-9ij7/
    public double minAreaFreeRect(int[][] points) {
        int n = points.length;
        ans = inf;
        hash = new HashMap<>();
        Arrays.sort(points, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });

        for (int i = 0; i < n; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0], y2 = points[j][1];
                if (y2 > y1) {
                    // 边长、斜率以及垂线在 y 轴上的截距
                    double l = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
                    double t = (double) (x2 - x1) / (y2 - y1);
                    double d = x1 * t + y1;

                    insert(h1(l, t, d), l * Math.sqrt(x1 * x1 + (y1 - d) * (y1 - d)));
                }
            }
        }
        return ans == inf ? 0 : ans;
    }

    // 实数哈希，一般题目要求实数误差不超过 1e-5，这里放大 1e5 应该也可以
    private long h1(double l, double t, double d) {
        return (long) ((l * 3.14159 + t * 1.2345 + d) * 1e5);
    }

    private void insert(long x, double y) {
        if (hash.containsKey(x)) {
            ans = Math.min(ans, y - hash.get(x));
        }
        hash.put(x, y);
    }
}
/*
963. 最小面积矩形 II
https://leetcode.cn/problems/minimum-area-rectangle-ii/description/

给定在 xy 平面上的一组点，确定由这些点组成的任何矩形的最小面积，其中矩形的边不一定平行于 x 轴和 y 轴。
如果没有任何矩形，就返回 0。
提示：
1 <= points.length <= 50
0 <= points[i][0] <= 40000
0 <= points[i][1] <= 40000
所有的点都是不同的。
与真实值误差不超过 10^-5 的答案将视为正确结果。

时间复杂度 O(n^2)。
注意在最坏情况下 n 个点可以组成 O(n^2logn) 个矩形
https://link.springer.com/content/pdf/10.1007/BF01931281.pdf [Sharir'89, Personal communication]
所以所有需要枚举所有矩形的算法(无论是否使用hashing加速)的复杂度下界为 Ω(n^2logn)。
@hqztrue
相似题目: 939. 最小面积矩形
https://leetcode.cn/problems/minimum-area-rectangle/description/
 */