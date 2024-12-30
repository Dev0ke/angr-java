import java.util.Arrays;
import java.util.Comparator;

public class Solution1851 {
    public int[] minInterval(int[][] intervals, int[] queries) {
        // 按照区间长度由小到大排序，这样每次回答的时候用的就是长度最小的区间
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1] - o[0]));

        int m = queries.length;
        // pos, i
        int[][] qs = new int[m][2];
        for (int i = 0; i < m; i++) {
            qs[i] = new int[]{queries[i], i};
        }
        // 离线：按查询位置排序
        Arrays.sort(qs, Comparator.comparingInt(o -> o[0]));

        DSU dsu = new DSU(m + 1);
        int[] ans = new int[m];
        Arrays.fill(ans, -1);
        for (int[] interval : intervals) {
            int l = interval[0], r = interval[1];

            // 二分找大于等于区间左端点的最小询问
            int left = 0;
            int right = m;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 边界二分 F, F,..., F, [T, T,..., T]
                // ----------------------^
                if (qs[mid][0] >= l) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            for (int i = dsu.find(left); i < m && qs[i][0] <= r; i = dsu.find(i + 1)) {
                ans[qs[i][1]] = r - l + 1;
                dsu.fa[i] = i + 1;
            }
        }
        return ans;
    }

    private static class DSU {
        int[] fa;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        int find(int x) {
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }
    }
}
/*
1851. 包含每个查询的最小区间
https://leetcode.cn/problems/minimum-interval-to-include-each-query/

给你一个二维整数数组 intervals ，其中 intervals[i] = [lefti, righti] 表示第 i 个区间开始于 lefti 、结束于 righti（包含两侧取值，闭区间）。
区间的 长度 定义为区间中包含的整数数目，更正式地表达是 righti - lefti + 1 。
再给你一个整数数组 queries 。第 j 个查询的答案是满足 lefti <= queries[j] <= righti 的 长度最小区间 i 的长度 。如果不存在这样的区间，那么答案是 -1 。
以数组形式返回对应查询的所有答案。
提示：
1 <= intervals.length <= 10^5
1 <= queries.length <= 10^5
queries[i].length == 2
1 <= lefti <= righti <= 10^7
1 <= queries[j] <= 10^7

离线 + 二分 + 并查集
https://leetcode.cn/problems/minimum-interval-to-include-each-query/solution/an-qu-jian-chang-du-pai-xu-chi-xian-bing-6jzs/
相似题目: E. Minimum Array
https://codeforces.com/contest/1157/problem/E
 */