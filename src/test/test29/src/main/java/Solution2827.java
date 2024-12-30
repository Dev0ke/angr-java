import java.util.Arrays;

public class Solution2827 {
    private int k;

    public int numberOfBeautifulIntegers(int low, int high, int k) {
        this.k = k;
        int ans1 = count(low - 1);
        int ans2 = count(high);
        return ans2 - ans1;
    }

    private char[] s;
    private int[][][] dp;

    private int count(int num) {
        s = String.valueOf(num).toCharArray();
        int n = String.valueOf(num).length();
        dp = new int[n][k][n * 2 + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return f(0, 0, n, true, false);
    }

    // remain:%k的余数
    // diff:奇数数位的数目与偶数数位的数目的差（奇数 1，偶数 -1）
    private int f(int i, int remain, int diff, boolean isLimit, boolean isNum) {
        if (i == s.length) {
            return isNum && remain == 0 && diff == s.length ? 1 : 0;
        }
        if (!isLimit && isNum && dp[i][remain][diff] != -1) {
            return dp[i][remain][diff];
        }
        int ans = 0;
        if (!isNum) {
            ans += f(i + 1, remain, diff, false, false);
        }
        int down = isNum ? 0 : 1;
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = down; d <= up; d++) {
            ans += f(i + 1, (remain * 10 + d) % k, diff + (d % 2 == 1 ? 1 : -1), isLimit && d == up, true);
        }
        if (!isLimit && isNum) {
            dp[i][remain][diff] = ans;
        }
        return ans;
    }
}
/*
2827. 范围中美丽整数的数目
https://leetcode.cn/problems/number-of-beautiful-integers-in-the-range/

第 111 场双周赛 T4。

给你正整数 low ，high 和 k 。
如果一个数满足以下两个条件，那么它是 美丽的 ：
- 偶数数位的数目与奇数数位的数目相同。
- 这个整数可以被 k 整除。
请你返回范围 [low, high] 中美丽整数的数目。
提示：
0 < low <= high <= 10^9
0 < k <= 20

数位 DP
时间复杂度 O(n^2·k·D)。其中 n = log(high)，D = 10
空间复杂度 O(n^2·k)
相似题目: 2719. 统计整数数目
https://leetcode.cn/problems/count-of-integers/
2801. 统计范围内的步进数字数目
https://leetcode.cn/problems/count-stepping-numbers-in-range/
 */