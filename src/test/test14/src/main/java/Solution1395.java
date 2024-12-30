import java.util.Arrays;

public class Solution1395 {
    public int numTeams(int[] rating) {
        int max = Arrays.stream(rating).max().orElseThrow();

        Fenwick bitL = new Fenwick(max);
        Fenwick bitR = new Fenwick(max);
        for (int x : rating) {
            bitR.add(x, 1);
        }

        int res = 0;
        for (int x : rating) {
            bitR.add(x, -1);

            // rating[i] < rating[j] < rating[k]
            res += bitL.getSum(x - 1) * (bitR.getSum(max) - bitR.getSum(x));
            // rating[i] > rating[j] > rating[k]
            res += (bitL.getSum(max) - bitL.getSum(x)) * bitR.getSum(x - 1);
            bitL.add(x, 1);
        }
        return res;
    }

    private static class Fenwick {
        private final int n;
        private final int[] tree;

        public Fenwick(int n) {
            this.n = n;
            this.tree = new int[n + 1];
        }

        int lowbit(int x) {
            return x & -x;
        }

        void add(int x, int k) {
            while (x <= n) {
                tree[x] += k;
                x += lowbit(x);
            }
        }

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
1395. 统计作战单位数
https://leetcode.cn/problems/count-number-of-teams/

n 名士兵站成一排。每个士兵都有一个 独一无二 的评分 rating 。
每 3 个士兵可以组成一个作战单位，分组规则如下：
- 从队伍中选出下标分别为 i、j、k 的 3 名士兵，他们的评分分别为 rating[i]、rating[j]、rating[k]
- 作战单位需满足： rating[i] < rating[j] < rating[k] 或者 rating[i] > rating[j] > rating[k] ，其中  0 <= i < j < k < n
请你返回按上述条件可以组建的作战单位数量。每个士兵都可以是多个作战单位的一部分。
提示：
n == rating.length
3 <= n <= 1000
1 <= rating[i] <= 10^5
rating 中的元素都是唯一的

双树状数组
 */