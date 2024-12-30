import java.util.Arrays;

public class Solution2217 {
    public long[] kthPalindrome(int[] queries, int intLength) {
        int L = (intLength + 1) / 2;
        int low = (int) Math.pow(10, L - 1);
        int high = (int) Math.pow(10, L);

        int q = queries.length;
        long[] ans = new long[q];
        Arrays.fill(ans, -1);
        for (int i = 0; i < q; i++) {
            int root = low + queries[i] - 1;
            if (root < high) {
                long p = root;
                if (L * 2 > intLength) {
                    // Check for odd-length palindromes
                    for (long x = p / 10; x > 0; x /= 10) {
                        p = p * 10 + x % 10;
                    }
                } else {
                    // Check for even-length palindromes
                    for (long x = p; x > 0; x /= 10) {
                        p = p * 10 + x % 10;
                    }
                }
                ans[i] = p;
            }
        }
        return ans;
    }
}
/*
2217. 找到指定长度的回文数
https://leetcode.cn/problems/find-palindrome-with-fixed-length/

第 286 场周赛 T3。

给你一个整数数组 queries 和一个 正 整数 intLength ，请你返回一个数组 answer ，
其中 answer[i] 是长度为 intLength 的 正回文数 中第 queries[i] 小的数字，如果不存在这样的回文数，则为 -1 。
回文数 指的是从前往后和从后往前读一模一样的数字。回文数不能有前导 0 。
提示：
1 <= queries.length <= 5 * 10^4
1 <= queries[i] <= 10^9
1 <= intLength <= 15

打表？intLength <= 15 显然打不了表，考虑 “回文根”
相似题目: 866. 回文素数
https://leetcode.cn/problems/prime-palindrome/
 */
