public class SolutionP2927 {
    public long distributeCandies(int n, int limit) {
        long k1 = n - (limit + 1);
        long k2 = n - 2L * (limit + 1);
        long k3 = n - 3L * (limit + 1);
        return c2(n + 2)
                - 3 * c2(k1 + 2)
                + 3 * c2(k2 + 2)
                - c2(k3 + 2);
    }

    private long c2(long n) {
        return n > 1 ? n * (n - 1) / 2 : 0;
    }
}
/*
$2927. 给小朋友们分糖果 III
https://leetcode.cn/problems/distribute-candies-among-children-iii/description/

你被给定两个正整数 n 和 limit。
返回 在每个孩子得到不超过 limit 个糖果的情况下，将 n 个糖果分发给 3 个孩子的 总方法数。
提示：
1 <= n <= 10^8
1 <= limit <= 10^8

相似题目: 2929. 给小朋友们分糖果 II
https://leetcode.cn/problems/distribute-candies-among-children-ii/description/
 */