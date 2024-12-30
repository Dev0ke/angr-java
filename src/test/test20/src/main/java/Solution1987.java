public class Solution1987 {
    private static final int MOD = (int) (1e9 + 7);

    // 空间复杂度 O(n)
    public int numberOfUniqueGoodSubsequences(String binary) {
        int len = binary.length();

        // f[i][j] 表示以 binary 的前 i 个字符组成以 j 结尾的不同的好子序列数目
        long[][] f = new long[len][2];
        if (binary.charAt(0) == '1') {
            f[0][1] = 1;
        }
        for (int i = 1; i < len; i++) {
            char ch = binary.charAt(i);
            if (ch == '0') {
                f[i][0] = (f[i - 1][0] + f[i - 1][1]) % MOD;
                f[i][1] = f[i - 1][1];
            } else {
                f[i][0] = f[i - 1][0];
                f[i][1] = (f[i - 1][0] + f[i - 1][1] + 1) % MOD;
            }
        }
        long res = f[len - 1][0] + f[len - 1][1] + (binary.contains("0") ? 1 : 0);
        return (int) (res % MOD);
    }

    // 空间复杂度 O(1)
    public int numberOfUniqueGoodSubsequences2(String binary) {
        // f[i][j] 表示以 binary 的前 i 个字符组成以 j 结尾的不同的好子序列数目
        // f0 = f[i][0], f1 = f[i][1]
        int f0 = 0;
        int f1 = 0;
        for (char ch : binary.toCharArray()) {
            if (ch == '0') {
                f0 = (f0 + f1) % MOD;
            } else {
                f1 = (f0 + f1 + 1) % MOD;
            }
        }
        long res = f0 + f1 + (binary.contains("0") ? 1 : 0);
        return (int) (res % MOD);
    }
}
/*
1987. 不同的好子序列数目
https://leetcode.cn/problems/number-of-unique-good-subsequences/

第 256 场周赛 T4。

给你一个二进制字符串 binary 。 binary 的一个 子序列 如果是 非空 的且没有 前导 0 （除非数字是 "0" 本身），那么它就是一个 好 的子序列。
请你找到 binary 不同好子序列 的数目。
- 比方说，如果 binary = "001" ，那么所有 好 子序列为 ["0", "0", "1"] ，所以 不同 的好子序列为 "0" 和 "1" 。 注意，子序列 "00" ，"01" 和 "001" 不是好的，因为它们有前导 0 。
请你返回 binary 中 不同好子序列 的数目。由于答案可能很大，请将它对 10^9 + 7 取余 后返回。
一个 子序列 指的是从原数组中删除若干个（可以一个也不删除）元素后，不改变剩余元素顺序得到的序列。
提示：
1 <= binary.length <= 10^5
binary 只含有 '0' 和 '1' 。

动态规划
时间复杂度 O(n)
相似题目: 940. 不同的子序列 II
https://leetcode.cn/problems/distinct-subsequences-ii/
 */