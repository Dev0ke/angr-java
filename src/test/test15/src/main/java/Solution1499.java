import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1499 {
    public int findMaxValueOfEquation(int[][] points, int k) {
        // yi + yj + |xi - xj|
        // yi + yj + xj - xi
        // xj + yj + (yi - xi) 枚举 (yi - xi) 最大值
        int ans = Integer.MIN_VALUE;
        // xi, yi-xi
        Deque<int[]> deque = new ArrayDeque<>();
        for (int[] p : points) {
            int x = p[0], y = p[1];
            while (!deque.isEmpty() && deque.getFirst()[0] < x - k) {
                deque.removeFirst();
            }
            if (!deque.isEmpty()) {
                ans = Math.max(ans, x + y + deque.getFirst()[1]);
            }
            while (!deque.isEmpty() && deque.getLast()[1] <= y - x) {
                deque.removeLast();
            }
            deque.addLast(new int[]{x, y - x});
        }
        return ans;
    }
}
/*
1499. 满足不等式的最大值
https://leetcode.cn/problems/max-value-of-equation/

给你一个数组 points 和一个整数 k 。数组中每个元素都表示二维平面上的点的坐标，并按照横坐标 x 的值从小到大排序。也就是说 points[i] = [xi, yi] ，并且在 1 <= i < j <= points.length 的前提下， xi < xj 总成立。
请你找出 yi + yj + |xi - xj| 的 最大值，其中 |xi - xj| <= k 且 1 <= i < j <= points.length。
题目测试数据保证至少存在一对能够满足 |xi - xj| <= k 的点。
提示：
2 <= points.length <= 10^5
points[i].length == 2
-10^8 <= points[i][0], points[i][1] <= 10^8
0 <= k <= 2 * 10^8
对于所有的1 <= i < j <= points.length ，points[i][0] < points[j][0] 都成立。也就是说，xi 是严格递增的。

单调队列
时间复杂度 O(n)
 */