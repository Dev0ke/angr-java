public class Solution2566 {
    public int minMaxDifference(int num) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        String str = String.valueOf(num);
        for (char i = '0'; i <= '9'; i++) {
            for (char j = '0'; j <= '9'; j++) {
                if (i == j) continue;
                int n = Integer.parseInt(str.replace(i, j));
                min = Math.min(min, n);
                max = Math.max(max, n);
            }
        }
        return max - min;
    }
}
/*
2566. 替换一个数字后的最大差值
https://leetcode.cn/problems/maximum-difference-by-remapping-a-digit/

第 98 场双周赛 T1。

给你一个整数 num 。你知道 Danny Mittal 会偷偷将 0 到 9 中的一个数字 替换 成另一个数字。
请你返回将 num 中 恰好一个 数字进行替换后，得到的最大值和最小值的差位多少。
注意：
- 当 Danny 将一个数字 d1 替换成另一个数字 d2 时，Danny 需要将 nums 中所有 d1 都替换成 d2 。
- Danny 可以将一个数字替换成它自己，也就是说 num 可以不变。
- Danny 可以将数字分别替换成两个不同的数字分别得到最大值和最小值。
- 替换后得到的数字可以包含前导 0 。
- Danny Mittal 获得周赛 326 前 10 名，让我们恭喜他。
提示：
1 <= num <= 10^8

暴力
 */