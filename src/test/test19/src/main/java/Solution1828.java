public class Solution1828 {
    public int[] countPoints(int[][] points, int[][] queries) {
        int q = queries.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            // c 表示 circle
            int cx = queries[i][0], cy = queries[i][1], cr = queries[i][2];
            int cnt = 0;
            for (int[] p : points) {
                int px = p[0], py = p[1];
                if ((px - cx) * (px - cx) + (py - cy) * (py - cy) <= cr * cr) {
                    cnt++;
                }
            }
            ans[i] = cnt;
        }
        return ans;
    }
}
/*
1828. 统计一个圆中点的数目
https://leetcode.cn/problems/queries-on-number-of-points-inside-a-circle/description/

给你一个数组 points ，其中 points[i] = [xi, yi] ，表示第 i 个点在二维平面上的坐标。多个点可能会有 相同 的坐标。
同时给你一个数组 queries ，其中 queries[j] = [xj, yj, rj] ，表示一个圆心在 (xj, yj) 且半径为 rj 的圆。
对于每一个查询 queries[j] ，计算在第 j 个圆 内 点的数目。如果一个点在圆的 边界上 ，我们同样认为它在圆 内 。
请你返回一个数组 answer ，其中 answer[j]是第 j 个查询的答案。
提示：
1 <= points.length <= 500
points[i].length == 2
0 <= xi, yi <= 500
1 <= queries.length <= 500
queries[j].length == 3
0 <= xj, yj <= 500
1 <= rj <= 500
所有的坐标都是整数。

枚举。
时间复杂度 O(nq)。
 */