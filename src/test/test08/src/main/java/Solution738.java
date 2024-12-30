public class Solution738 {
    public int monotoneIncreasingDigits(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int len = chars.length;

        int i = 1;
        while (i < len && chars[i - 1] <= chars[i]) {
            i++;
        }
        if (i < len) {
            while (i - 1 >= 0 && chars[i - 1] > chars[i]) {
                i--;
                chars[i]--;
            }
            // [i+1:] 的数字全置为 9
            for (int j = i + 1; j < len; j++) {
                chars[j] = '9';
            }
        }
        return Integer.parseInt(new String(chars));
    }
}
/*
738. 单调递增的数字
https://leetcode.cn/problems/monotone-increasing-digits/

当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
提示:
0 <= n <= 10^9

贪心。
从左往右遍历，找到第一个开始下降的数字 [i]，将 [i] 减 1，然后将 [i+1:] 的数字全置为 9
时间复杂度 O(logn)
 */