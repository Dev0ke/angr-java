public class Solution1744 {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;

        long[] ps = new long[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + candiesCount[i];
        }

        int q = queries.length;
        boolean[] ans = new boolean[q];
        for (int i = 0; i < q; i++) {
            int favoriteType = queries[i][0], favoriteDay = queries[i][1], dailyCap = queries[i][2];

            long x1 = favoriteDay + 1;
            long y1 = (long) (favoriteDay + 1) * dailyCap;
            long x2 = favoriteType == 0 ? 1 : ps[favoriteType] + 1;
            long y2 = ps[favoriteType + 1];

            ans[i] = !(x1 > y2 || y1 < x2);
        }
        return ans;
    }
}
/*
1744. 你能在你最喜欢的那天吃到你最喜欢的糖果吗？
https://leetcode.cn/problems/can-you-eat-your-favorite-candy-on-your-favorite-day/description/

给你一个下标从 0 开始的正整数数组 candiesCount ，其中 candiesCount[i] 表示你拥有的第 i 类糖果的数目。同时给你一个二维数组 queries ，其中 queries[i] = [favoriteTypei, favoriteDayi, dailyCapi] 。
你按照如下规则进行一场游戏：
- 你从第 0 天开始吃糖果。
- 你在吃完 所有 第 i - 1 类糖果之前，不能 吃任何一颗第 i 类糖果。
- 在吃完所有糖果之前，你必须每天 至少 吃 一颗 糖果。
请你构建一个布尔型数组 answer ，用以给出 queries 中每一项的对应答案。此数组满足：
- answer.length == queries.length 。answer[i] 是 queries[i] 的答案。
- answer[i] 为 true 的条件是：在每天吃 不超过 dailyCapi 颗糖果的前提下，你可以在第 favoriteDayi 天吃到第 favoriteTypei 类糖果；否则 answer[i] 为 false 。
注意，只要满足上面 3 条规则中的第二条规则，你就可以在同一天吃不同类型的糖果。
请你返回得到的数组 answer 。
提示：
1 <= candiesCount.length <= 10^5
1 <= candiesCount[i] <= 10^5
1 <= queries.length <= 10^5
queries[i].length == 3
0 <= favoriteTypei < candiesCount.length
0 <= favoriteDayi <= 10^9
1 <= dailyCapi <= 10^9

前缀和。
时间复杂度 O(n+q)。
 */