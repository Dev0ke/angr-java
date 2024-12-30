import java.util.Arrays;

public class Solution2376 {
    private char[] s;
    private int[][] dp;

    public int countSpecialNumbers(int n) {
        s = String.valueOf(n).toCharArray();
        int len = s.length;
        dp = new int[len][1 << 10];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, 0, true, false);
    }

    // 数位 dp
    // 返回从 i 开始填数字，i 前面填的数字的集合是 state，能构造出的特殊整数的数目
    // isLimit 表示前面填的数字是否都是 n 对应位上的，如果为 true，那么当前位至多为 s[i]-'0'，否则至多为 9
    // isNum 表示前面是否填了数字（是否跳过），如果为 true，那么当前位可以从 0 开始，如果为 false，那么我们可以跳过，或者从 1 开始填数字
    private int f(int i, int state, boolean isLimit, boolean isNum) {
        if (i == s.length) {
            return isNum ? 1 : 0;
        }
        // 记忆化搜索
        if (!isLimit && isNum && dp[i][state] >= 0) {
            return dp[i][state];
        }
        int res = 0;
        if (!isNum) {
            // 可以跳过当前数位
            res = f(i + 1, state, false, false);
        }
        for (int d = isNum ? 0 : 1, up = isLimit ? s[i] - '0' : 9; d <= up; d++) {
            // 枚举要填入的数字 d
            if (((state >> d) & 1) == 0) {
                // d 不在 mask 中
                res += f(i + 1, state | (1 << d), isLimit && d == up, true);
            }
        }
        if (!isLimit && isNum) {
            dp[i][state] = res;
        }
        return res;
    }
}
/*
2376. 统计特殊整数
https://leetcode.cn/problems/count-special-integers/

第 306 场周赛 T4。

如果一个正整数每一个数位都是 互不相同 的，我们称它是 特殊整数 。
给你一个 正 整数 n ，请你返回区间 [1, n] 之间特殊整数的数目。
提示：
1 <= n <= 2 * 10^9

数位 DP
相似题目: 357. 统计各位数字都不同的数字个数
https://leetcode.cn/problems/count-numbers-with-unique-digits/
1012. 至少有 1 位重复的数字
https://leetcode.cn/problems/numbers-with-repeated-digits/
 */