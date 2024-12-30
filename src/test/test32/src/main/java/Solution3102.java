import java.util.TreeMap;

public class Solution3102 {
    public int minimumDistance(int[][] points) {
        TreeMap<Integer, Integer> xs = new TreeMap<>();
        TreeMap<Integer, Integer> ys = new TreeMap<>();
        for (int[] p : points) {
            int x = p[0] + p[1], y = p[1] - p[0];
            xs.merge(x, 1, Integer::sum);
            ys.merge(y, 1, Integer::sum);
        }

        int ans = Integer.MAX_VALUE;
        for (int[] p : points) {
            int x = p[0] + p[1], y = p[1] - p[0];
            // erase
            if (xs.get(x) == 1) xs.remove(x);
            else xs.merge(x, -1, Integer::sum);
            if (ys.get(y) == 1) ys.remove(y);
            else ys.merge(y, -1, Integer::sum);
            // upd
            ans = Math.min(ans, Math.max(xs.lastKey() - xs.firstKey(), ys.lastKey() - ys.firstKey()));
            // insert
            xs.merge(x, 1, Integer::sum);
            ys.merge(y, 1, Integer::sum);
        }
        return ans;
    }
}
/*
3102. 最小化曼哈顿距离
https://leetcode.cn/problems/minimize-manhattan-distances/description/

第 391 场周赛 T4。

给你一个下标从 0 开始的数组 points ，它表示二维平面上一些点的整数坐标，其中 points[i] = [xi, yi] 。
两点之间的距离定义为它们的 曼哈顿距离 。
请你恰好移除一个点，返回移除后任意两点之间的 最大 距离可能的 最小 值。
提示：
3 <= points.length <= 10^5
points[i].length == 2
1 <= points[i][0], points[i][1] <= 10^8

曼哈顿距离转切比雪夫距离 + 平衡树。
切比雪夫距离：https://oi-wiki.org/geometry/distance/
时间复杂度 O(nlogn)
 */