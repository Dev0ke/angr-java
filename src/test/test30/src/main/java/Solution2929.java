public class Solution2929 {
    // 时间复杂度 O(1)
    public long distributeCandies2(int n, int limit) {
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
2929. 给小朋友们分糖果 II
https://leetcode.cn/problems/distribute-candies-among-children-ii/description/

第 117 场双周赛 T2。

给你两个正整数 n 和 limit 。
请你将 n 颗糖果分给 3 位小朋友，确保没有任何小朋友得到超过 limit 颗糖果，请你返回满足此条件下的 总方案数 。
提示：
1 <= n <= 10^6
1 <= limit <= 10^6

容斥原理
所有方案数：C(n+2, 2)
至少1个小朋友分到的糖果超过 limit：考虑分 A (limit+1) 颗糖果，剩下 k1 = n-(limit+1) 颗分给 B、C, C(k1+2, 2) B、C 同理，3*C(k1+2, 2)
至少2个小朋友分到的糖果超过 limit：考虑分 A、B 2(limit+1) 颗糖果，剩下 k2 = n-2(limit+1) 颗分给 B、C, C(k2+2, 2) B、C 同理，3*C(k2+2, 2)
3个小朋友分到的糖果超过 limit：k3 = n-3(limit+1) 颗分给 B、C, C(k3+2, 2) B、C 同理，3*C(k3+2, 2)
时间复杂度 O(1)
相似题目: $2927. 给小朋友们分糖果 III
https://leetcode.cn/problems/distribute-candies-among-children-iii/description/
 */