public class Solution2928 {
    public int distributeCandies(int n, int limit) {
        int ans = 0;
        for (int a = 0; a <= Math.min(n, limit); a++) {
            int bc = n - a;
            if (bc > limit + limit) continue;
            // 上下界
            int minB = Math.max(0, bc - limit);
            int maxB = bc - minB;
            ans += maxB - minB + 1;
        }
        return ans;
    }
}
/*
2928. 给小朋友们分糖果 I
https://leetcode.cn/problems/distribute-candies-among-children-i/description/

第 117 场双周赛 T1。

给你两个正整数 n 和 limit 。
请你将 n 颗糖果分给 3 位小朋友，确保没有任何小朋友得到超过 limit 颗糖果，请你返回满足此条件下的 总方案数 。
提示：
1 <= n <= 50
1 <= limit <= 50

枚举上下界。
时间复杂度 O(n)
与 II 题有 int 和 long 的区别
相似题目: 2929. 给小朋友们分糖果 II
https://leetcode.cn/problems/distribute-candies-among-children-ii/description/
 */