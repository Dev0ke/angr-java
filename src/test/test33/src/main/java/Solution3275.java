import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution3275 {
    public int[] resultsArray(int[][] queries, int k) {
        int n = queries.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int sz = Math.min(k, n);
        for (int i = 0; i < sz; i++) {
            int d = Math.abs(queries[i][0]) + Math.abs(queries[i][1]);
            pq.add(d);
        }
        if (k - 1 < n) ans[k - 1] = pq.peek();
        for (int i = sz; i < n; i++) {
            int d = Math.abs(queries[i][0]) + Math.abs(queries[i][1]);
            pq.add(d);
            pq.remove();
            ans[i] = pq.peek();
        }
        return ans;
    }
}
/*
3275. 第 K 近障碍物查询
https://leetcode.cn/problems/k-th-nearest-obstacle-queries/description/

第 413 场周赛 T2。

有一个无限大的二维平面。
给你一个正整数 k ，同时给你一个二维数组 queries ，包含一系列查询：
- queries[i] = [x, y] ：在平面上坐标 (x, y) 处建一个障碍物，数据保证之前的查询 不会 在这个坐标处建立任何障碍物。
每次查询后，你需要找到离原点第 k 近 障碍物到原点的 距离 。
请你返回一个整数数组 results ，其中 results[i] 表示建立第 i 个障碍物以后，离原地第 k 近障碍物距离原点的距离。如果少于 k 个障碍物，results[i] == -1 。
注意，一开始 没有 任何障碍物。
坐标在 (x, y) 处的点距离原点的距离定义为 |x| + |y| 。
提示：
1 <= queries.length <= 2 * 10^5
所有 queries[i] 互不相同。
-10^9 <= queries[i][0], queries[i][1] <= 10^9
1 <= k <= 10^5

大顶堆 维护 top k 小
时间复杂度 O(mlogk)。
 */