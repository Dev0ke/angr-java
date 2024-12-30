import java.util.Arrays;

public class Solution788 {
    private char[] s;
    private int[][] dp;

    public int rotatedDigits(int n) {
        s = String.valueOf(n).toCharArray();
        int len = s.length;
        dp = new int[len][2];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, false, true);
    }

    private int f(int i, boolean has2569, boolean isLimit) {
        if (i == s.length) {
            return has2569 ? 1 : 0;
        }
        // 记忆化搜索
        if (!isLimit && dp[i][has2569 ? 1 : 0] >= 0) {
            return dp[i][has2569 ? 1 : 0];
        }
        int res = 0;
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = 0; d <= up; d++) {
            if (d != 3 && d != 4 && d != 7) {
                res += f(i + 1, has2569 || d == 2 || d == 5 || d == 6 || d == 9, isLimit && d == up);
            }
        }
        if (!isLimit) {
            dp[i][has2569 ? 1 : 0] = res;
        }
        return res;
    }
}
/*
788. 旋转数字
https://leetcode.cn/problems/rotated-digits/

我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方
（在这种情况下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
提示：
N 的取值范围是 [1, 10000]。

数位DP
根据题目的要求，一个数是好数，当且仅当：
数中没有出现 3, 4, 7
数中至少出现一次 2 或 5 或 6 或 9
对于 0, 1, 8 则没有要求。
 */