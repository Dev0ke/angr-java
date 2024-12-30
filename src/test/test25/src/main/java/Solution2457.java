public class Solution2457 {
    public long makeIntegerBeautiful(long n, int target) {
        String ss = String.valueOf(n);
        int len = ss.length();

        // 预处理成下标 [1, n]
        int[] digits = new int[len + 1];
        for (int i = 0; i < len; i++) {
            digits[i + 1] = ss.charAt(i) - '0';
        }

        long res = 0;
        // 进位
        int[] carry = new int[len + 1];
        for (int i = len; i > 0; i--) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += digits[j] + carry[j];
            }
            if (sum > target) {
                res += (10 - digits[i] - carry[i]) * Math.pow(10, len - i);
                digits[i] = 0;
                carry[i - 1] = 1;
            }
        }
        return res;
    }
}
/*
2457. 美丽整数的最小增量
https://leetcode.cn/problems/minimum-addition-to-make-integer-beautiful/

第 317 场周赛 T3。

给你两个正整数 n 和 target 。
如果某个整数每一位上的数字相加小于或等于 target ，则认为这个整数是一个 美丽整数 。
找出并返回满足 n + x 是 美丽整数 的最小非负整数 x 。生成的输入保证总可以使 n 变成一个美丽整数。
提示：
1 <= n <= 10^12
1 <= target <= 150
生成的输入保证总可以使 n 变成一个美丽整数。

贪心，从低位到高位 "推平"
时间复杂度 O(logn)
 */