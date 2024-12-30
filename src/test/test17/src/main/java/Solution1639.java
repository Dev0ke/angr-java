import java.util.Arrays;

public class Solution1639 {
    private static final int MOD = (int) 1e9 + 7;

    public int numWays(String[] words, String target) {
        int m = words.length;
        int n = words[0].length();
        int len = target.length();

        int[][] cntArr = new int[n + 1][26];
        for (String word : words) {
            for (int k = 1; k <= n; k++) {
                cntArr[k][word.charAt(k - 1) - 'a']++;
            }
        }

        // f[i][k] 表示 target 第 i 个字符匹配 words 上第 k 个字符的字符串方案数
        long[][] f = new long[len + 1][n + 1];
        // 初始状态
        Arrays.fill(f[0], 1);
//        for (int j = 0; j <= n; j++) {
//            f[0][j] = 1;
//        }

        // target 第 i 个字符
        for (int i = 1; i <= len; i++) {
            int to = n - (len - i);
            int ch = target.charAt(i - 1) - 'a';
            // 来自 words 中第 k 位置 方法数
            for (int k = i; k <= to; k++) {
                f[i][k] = (f[i - 1][k - 1] * cntArr[k][ch] + f[i][k - 1]) % MOD;
            }
        }
        return (int) f[len][n];
    }
}
/*
1639. 通过给定词典构造目标字符串的方案数
https://leetcode.cn/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/

给你一个字符串列表 words 和一个目标字符串 target 。words 中所有字符串都 长度相同  。
你的目标是使用给定的 words 字符串列表按照下述规则构造 target ：
- 从左到右依次构造 target 的每一个字符。
- 为了得到 target 第 i 个字符（下标从 0 开始），当 target[i] = words[j][k] 时，你可以使用 words 列表中第 j 个字符串的第 k 个字符。
- 一旦你使用了 words 中第 j 个字符串的第 k 个字符，你不能再使用 words 字符串列表中任意单词的第 x 个字符（x <= k）。也就是说，所有单词下标小于等于 k 的字符都不能再被使用。
- 请你重复此过程直到得到目标字符串 target 。
请注意， 在构造目标字符串的过程中，你可以按照上述规定使用 words 列表中 同一个字符串 的 多个字符 。
请你返回使用 words 构造 target 的方案数。由于答案可能会很大，请对 10^9 + 7 取余 后返回。
（译者注：此题目求的是有多少个不同的 k 序列，详情请见示例。）
提示：
1 <= words.length <= 1000
1 <= words[i].length <= 1000
words 中所有单词长度相同。
1 <= target.length <= 1000
words[i] 和 target 都仅包含小写英文字母。

动态规划
 */