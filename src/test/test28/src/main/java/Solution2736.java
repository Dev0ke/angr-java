import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution2736 {
    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length;
        int q = queries.length;
        int[] ans = new int[q];
        Arrays.fill(ans, -1);

        // 按 x 升序排序 nums1, nums2
        int[][] zip = new int[n][2];
        for (int i = 0; i < n; i++) {
            zip[i][0] = nums1[i];
            zip[i][1] = nums2[i];
        }
        Arrays.sort(zip, Comparator.comparingInt(o -> o[0]));

        // 按 x 降序排序 queries
        for (int i = 0; i < q; i++) {
            queries[i] = new int[]{queries[i][0], queries[i][1], i};
        }
        Arrays.sort(queries, (o1, o2) -> Integer.compare(o2[0], o1[0]));

        List<int[]> st = new ArrayList<>();
        int i = n - 1;
        for (int[] p : queries) {
            int x = p[0], y = p[1], qi = p[2];
            for (; i >= 0 && zip[i][0] >= x; i--) {
                int ax = zip[i][0], ay = zip[i][1];
                // ay >= stack.peek()[0]
                while (!st.isEmpty() && st.get(st.size() - 1)[1] <= ax + ay) {
                    st.remove(st.size() - 1);
                }
                if (st.isEmpty() || st.get(st.size() - 1)[0] < ay) {
                    st.add(new int[]{ay, ax + ay});
                }
            }
            // 单调栈上二分
            int j = lowerBound(st, y);
            if (j < st.size()) {
                ans[qi] = st.get(j)[1];
            }
        }
        return ans;
    }

    private int lowerBound(List<int[]> a, int key) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a.get(m)[0] >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
2736. 最大和查询
https://leetcode.cn/problems/maximum-sum-queries/

第 349 场周赛 T4。

给你两个长度为 n 、下标从 0 开始的整数数组 nums1 和 nums2 ，另给你一个下标从 1 开始的二维数组 queries ，其中 queries[i] = [xi, yi] 。
对于第 i 个查询，在所有满足 nums1[j] >= xi 且 nums2[j] >= yi 的下标 j (0 <= j < n) 中，找出 nums1[j] + nums2[j] 的 最大值 ，如果不存在满足条件的 j 则返回 -1 。
返回数组 answer ，其中 answer[i] 是第 i 个查询的答案。
提示：
nums1.length == nums2.length 
n == nums1.length 
1 <= n <= 10^5
1 <= nums1[i], nums2[i] <= 10^9
1 <= queries.length <= 10^5
queries[i].length == 2
xi == queries[i][1]
yi == queries[i][2]
1 <= xi, yi <= 10^9

二维偏序问题。
单调栈上二分。由于 Java 官方推荐使用 Deque<E> 来模拟栈，而 Deque 没法直接通过下标检索（来实现手写二分），引入一个 TreeMap 辅助即可。
时间复杂度 O(n + qlogn)
相似题目: 2250. 统计包含每个点的矩形数目
https://leetcode.cn/problems/count-number-of-rectangles-containing-each-point/
2940. 找到 Alice 和 Bob 可以相遇的建筑
https://leetcode.cn/problems/find-building-where-alice-and-bob-can-meet/description/
 */