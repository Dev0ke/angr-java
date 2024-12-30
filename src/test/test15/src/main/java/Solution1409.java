public class Solution1409 {
    public int[] processQueries(int[] queries, int m) {
        int q = queries.length;
        Fenwick fenwick = new Fenwick(m + q);

        // queries = [3,1,2,1], m = 5 时，下标对应 5,6,7,8,9
        int[] pos = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            pos[i] = q + i;
            fenwick.add(pos[i], 1);
        }

        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int curIdx = pos[queries[i]];
            fenwick.add(curIdx, -1); // 置 0
            ans[i] = fenwick.getSum(curIdx);
            curIdx = q - i; // 从右往左放置
            pos[queries[i]] = curIdx;
            fenwick.add(curIdx, 1); // 置 1
        }
        return ans;
    }

    static class Fenwick {
        private final int n;
        private final int[] tree;

        public Fenwick(int n) {
            this.n = n;
            this.tree = new int[n + 1];
        }

        int lowbit(int x) {
            return x & -x;
        }

        // nums[x] add k
        void add(int x, int k) {
            while (x <= n) {
                tree[x] += k;
                x += lowbit(x);
            }
        }

        // nums [1,x] 的和
        int getSum(int x) {
            int ans = 0;
            while (x > 0) {
                ans += tree[x];
                x -= lowbit(x);
            }
            return ans;
        }
    }
}
/*
1409. 查询带键的排列
https://leetcode.cn/problems/queries-on-a-permutation-with-key/description/

给定一个正整数数组 queries ，其取值范围在 1 到 m 之间。 请你根据以下规则按顺序处理所有 queries[i]（从 i=0 到 i=queries.length-1）：
- 首先，你有一个排列 P=[1,2,3,...,m]。
- 对于当前的 i ，找到 queries[i] 在排列 P 中的位置（从 0 开始索引），然后将它移到排列 P 的开头（即下标为 0 处）。注意， queries[i] 的查询结果是 queries[i] 在 P 中移动前的位置。
返回一个数组，包含从给定  queries 中查询到的结果。
提示：
1 <= m <= 10^3
1 <= queries.length <= m
1 <= queries[i] <= m

直接模拟的时间复杂度是 O(MQ)
看成 M+Q 个位置（下标从 1 开始）
时间复杂度 O(Qlog(M+Q))
 */