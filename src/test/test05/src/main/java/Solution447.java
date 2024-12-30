import java.util.HashMap;
import java.util.Map;

public class Solution447 {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;

        for (int[] x : points) {
            Map<Integer, Integer> cntMap = new HashMap<>();
            for (int[] y : points) {
                int dist = (y[0] - x[0]) * (y[0] - x[0]) + (y[1] - x[1]) * (y[1] - x[1]);
                cntMap.put(dist, cntMap.getOrDefault(dist, 0) + 1);
            }

            for (int cnt : cntMap.values()) {
                res += cnt * (cnt - 1);
            }
        }
        return res;
    }
}
/*
447. 回旋镖的数量
https://leetcode.cn/problems/number-of-boomerangs/

给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的欧式距离相等（需要考虑元组的顺序）。
返回平面上所有回旋镖的数量。
提示：
n == points.length
1 <= n <= 500
points[i].length == 2
-10^4 <= xi, yi <= 10^4
所有点都 互不相同

三层循环会 TLE，使用 HashMap 优化掉一层循环。
 */