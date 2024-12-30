import java.util.Arrays;

public class Solution2999 {
    private int limit;
    private String suf;
    private int diff;

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        this.limit = limit;
        this.suf = s;
        long ans1 = count(start - 1);
        long ans2 = count(finish);
        return ans2 - ans1;
    }

    private char[] s;
    private long[] dp;

    private long count(long num) {
        s = String.valueOf(num).toCharArray();
        int n = s.length;
        diff = n - suf.length();
        if (diff < 0) return 0;
        dp = new long[n];
        Arrays.fill(dp, -1);
        return f(0, true, false);
    }

    private long f(int i, boolean isLimit, boolean isNum) {
        if (i == s.length) {
            return isNum ? 1 : 0;
        }
        if (!isLimit && isNum && dp[i] != -1) {
            return dp[i];
        }
        long res = 0;
        if (!isNum) {
            if (i < diff) {
                res = f(i + 1, false, false);
            }
        }
        int down = isNum ? 0 : 1;
        int up = isLimit ? s[i] - '0' : 9;
        if (i < diff) {
            for (int d = down; d <= Math.min(up, limit); d++) {
                res += f(i + 1, isLimit && d == up, true);
            }
        } else {
            // 必须填 int(s[i-diff])
            int x = suf.charAt(i - diff) - '0';
            if (down <= x && x <= Math.min(up, limit)) {
                res = f(i + 1, isLimit && x == up, true);
            }
        }
        if (!isLimit && isNum) {
            dp[i] = res;
        }
        return res;
    }

    static class V2 {
        private int limit;
        private String suf;
        private int n;
        private char[] low, high;
        private int diff;
        private long[] dp;

        public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
            this.limit = limit;
            this.suf = s;
            high = String.valueOf(finish).toCharArray();
            n = high.length;
            low = ("0".repeat(n - String.valueOf(start).length()) + start).toCharArray();
            diff = n - s.length();
            dp = new long[n];
            Arrays.fill(dp, -1);
            return f(0, true, true);
        }

        private long f(int i, boolean downLimit, boolean upLimit) {
            if (i == n) {
                return 1;
            }
            if (!downLimit && !upLimit && dp[i] != -1) {
                return dp[i];
            }
            int down = downLimit ? low[i] - '0' : 0;
            int up = upLimit ? high[i] - '0' : 9;
            long res = 0;
            if (i < diff) {
                for (int d = down; d <= Math.min(up, limit); d++) {
                    res += f(i + 1, downLimit && d == down, upLimit && d == up);
                }
            } else {
                // 必须填 int(s[i-diff])
                int x = suf.charAt(i - diff) - '0';
                if (down <= x && x <= Math.min(up, limit)) {
                    res = f(i + 1, downLimit && x == down, upLimit && x == up);
                }
            }
            if (!downLimit && !upLimit) {
                dp[i] = res;
            }
            return res;
        }
    }
}
/*
2999. 统计强大整数的数目
https://leetcode.cn/problems/count-the-number-of-powerful-integers/description/

第 121 场双周赛 T4。

给你三个整数 start ，finish 和 limit 。同时给你一个下标从 0 开始的字符串 s ，表示一个 正 整数。
如果一个 正 整数 x 末尾部分是 s （换句话说，s 是 x 的 后缀），且 x 中的每个数位至多是 limit ，那么我们称 x 是 强大的 。
请你返回区间 [start..finish] 内强大整数的 总数目 。
如果一个字符串 x 是 y 中某个下标开始（包括 0 ），到下标为 y.length - 1 结束的子字符串，那么我们称 x 是 y 的一个后缀。比方说，25 是 5125 的一个后缀，但不是 512 的后缀。
提示：
1 <= start <= finish <= 10^15
1 <= limit <= 9
1 <= s.length <= floor(log10(finish)) + 1
s 数位中每个数字都小于等于 limit 。
s 不包含任何前导 0 。

数位 DP
时间复杂度 O(n * log(finish))
 */