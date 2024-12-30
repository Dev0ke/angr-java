import java.util.Arrays;

public class Solution1626 {
    private static final int MAX_N = 1000;

    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
        Arrays.sort(ids, (o1, o2) -> {
            if (scores[o1] == scores[o2]) {
                return Integer.compare(ages[o1], ages[o2]);
            }
            return Integer.compare(scores[o1], scores[o2]);
        });

        Fenwick fenwick = new Fenwick(MAX_N);
        for (Integer id : ids) {
            fenwick.update(ages[id], fenwick.getMax(ages[id]) + scores[id]);
        }
        return fenwick.getMax(MAX_N);
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

        // nums[x] 置为 mx
        void update(int x, int max) {
            while (x <= n) {
                tree[x] = Math.max(tree[x], max);
                x += lowbit(x);
            }
        }

        // nums [1,x] 的最大值
        int getMax(int x) {
            int max = 0;
            while (x > 0) {
                max = Math.max(max, tree[x]);
                x -= lowbit(x);
            }
            return max;
        }
    }
}
/*
1626. 无矛盾的最佳球队
https://leetcode.cn/problems/best-team-with-no-conflicts/

假设你是球队的经理。对于即将到来的锦标赛，你想组合一支总体得分最高的球队。球队的得分是球队中所有球员的分数 总和 。
然而，球队中的矛盾会限制球员的发挥，所以必须选出一支 没有矛盾 的球队。如果一名年龄较小球员的分数 严格大于 一名年龄较大的球员，则存在矛盾。同龄球员之间不会发生矛盾。
给你两个列表 scores 和 ages，其中每组 scores[i] 和 ages[i] 表示第 i 名球员的分数和年龄。请你返回 所有可能的无矛盾球队中得分最高那支的分数 。
提示：
1 <= scores.length, ages.length <= 1000
scores.length == ages.length
1 <= scores[i] <= 10^6
1 <= ages[i] <= 1000

LIS
相似题目: 300. 最长递增子序列
https://leetcode.cn/problems/longest-increasing-subsequence/
354. 俄罗斯套娃信封问题
https://leetcode.cn/problems/russian-doll-envelopes/
1691. 堆叠长方体的最大高度
https://leetcode.cn/problems/maximum-height-by-stacking-cuboids/
2407. 最长递增子序列 II
https://leetcode.cn/problems/longest-increasing-subsequence-ii/
 */