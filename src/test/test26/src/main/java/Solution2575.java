public class Solution2575 {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();

        long x = 0L;
        int[] div = new int[n];
        for (int i = 0; i < n; i++) {
            x = x * 10 + (word.charAt(i) - '0');
            if (x % m == 0) {
                div[i] = 1;
            }
            x %= m;
        }
        return div;
    }
}
/*
2575. 找出字符串的可整除数组
https://leetcode.cn/problems/find-the-divisibility-array-of-a-string/

第 334 场周赛 T2。

给你一个下标从 0 开始的字符串 word ，长度为 n ，由从 0 到 9 的数字组成。另给你一个正整数 m 。
word 的 可整除数组 div 是一个长度为 n 的整数数组，并满足：
- 如果 word[0,...,i] 所表示的 数值 能被 m 整除，div[i] = 1
- 否则，div[i] = 0
返回 word 的可整除数组。
提示：
1 <= n <= 10^5
word.length == n
word 由数字 0 到 9 组成
1 <= m <= 10^9

贪心。模运算。
如果 x 可以整除 m，那么 x * 10 也必然可以整除 m。取余之后不影响结果。
时间复杂度 O(n)
 */