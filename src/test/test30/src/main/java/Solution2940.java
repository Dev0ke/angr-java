import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2940 {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int q = queries.length;
        int[] ans = new int[q];
        Arrays.fill(ans, -1);

        for (int qi = 0; qi < q; qi++) {
            int i = queries[qi][0], j = queries[qi][1];
            if (i > j) {
                i = queries[qi][1];
                j = queries[qi][0];
            }
            queries[qi] = new int[]{i, j, qi};
        }
        Arrays.sort(queries, (o1, o2) -> Integer.compare(o2[1], o1[1]));

        // 右边第一个严格大于 heights[i] 的 j
        int i = n - 1;
        List<Integer> st = new ArrayList<>();
        for (int[] p : queries) {
            int a = p[0], b = p[1], qi = p[2];
            if (a == b || heights[a] < heights[b]) {
                ans[qi] = b;
                continue;
            }
            for (; i > b; i--) {
                while (!st.isEmpty() && heights[i] >= heights[st.get(st.size() - 1)]) {
                    st.remove(st.size() - 1);
                }
                st.add(i);
            }
            // 单调栈上二分
            int j = upperBound(heights, st, heights[a]);
            if (j < st.size()) {
                ans[qi] = st.get(st.size() - 1 - j);
            }
        }
        return ans;
    }

    private int upperBound(int[] heights, List<Integer> st, int key) {
        int l = 0, r = st.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (heights[st.get(st.size() - 1 - m)] > key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
2940. 找到 Alice 和 Bob 可以相遇的建筑
https://leetcode.cn/problems/find-building-where-alice-and-bob-can-meet/description/

第 372 场周赛 T4。

给你一个下标从 0 开始的正整数数组 heights ，其中 heights[i] 表示第 i 栋建筑的高度。
如果一个人在建筑 i ，且存在 i < j 的建筑 j 满足 heights[i] < heights[j] ，那么这个人可以移动到建筑 j 。
给你另外一个数组 queries ，其中 queries[i] = [ai, bi] 。第 i 个查询中，Alice 在建筑 ai ，Bob 在建筑 bi 。
请你能返回一个数组 ans ，其中 ans[i] 是第 i 个查询中，Alice 和 Bob 可以相遇的 最左边的建筑 。如果对于查询 i ，Alice 和 Bob 不能相遇，令 ans[i] 为 -1 。
提示：
1 <= heights.length <= 5 * 10^4
1 <= heights[i] <= 10^9
1 <= queries.length <= 5 * 10^4
queries[i] = [ai, bi]
0 <= ai, bi <= heights.length - 1

单调栈上二分
相似题目: 2736. 最大和查询
https://leetcode.cn/problems/maximum-sum-queries/
 */