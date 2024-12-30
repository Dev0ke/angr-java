import java.util.Arrays;

public class Solution902 {
    private String[] digits;
    private char[] s;
    private int[] dp;

    public int atMostNGivenDigitSet(String[] digits, int n) {
        this.digits = digits;
        s = String.valueOf(n).toCharArray();
        int len = s.length;
        dp = new int[len];
        Arrays.fill(dp, -1);
        return f(0, true, false);
    }

    private int f(int i, boolean isLimit, boolean isNum) {
        if (i == s.length) {
            return isNum ? 1 : 0;
        }
        // 记忆化搜索
        if (!isLimit && isNum && dp[i] >= 0) {
            return dp[i];
        }
        int res = 0;
        if (!isNum) {
            // 可以跳过当前数位
            res = f(i + 1, false, false);
        }
        char up = isLimit ? s[i] : '9';
        for (String digit : digits) {
            char d = digit.charAt(0);
            // 枚举要填入的数字 d
            if (d > up) {
                break;
            }
            res += f(i + 1, isLimit && d == up, true);
        }
        if (!isLimit && isNum) {
            dp[i] = res;
        }
        return res;
    }
}
/*
902. 最大为 N 的数字组合
https://leetcode.cn/problems/numbers-at-most-n-given-digit-set/

给定一个按 非递减顺序 排列的数字数组 digits 。你可以用任意次数 digits[i] 来写的数字。例如，如果 digits = ['1','3','5']，我们可以写数字，如 '13', '551', 和 '1351315'。
返回 可以生成的小于或等于给定整数 n 的正整数的个数 。
提示：
1 <= digits.length <= 9
digits[i].length == 1
digits[i] 是从 '1' 到 '9' 的数
digits 中的所有值都 不同 
digits 按 非递减顺序 排列
1 <= n <= 10^9

数位 DP
 */