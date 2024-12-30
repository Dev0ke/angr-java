public class SolutionP3037 {
    public int findPattern(InfiniteStream infiniteStream, int[] pattern) {
        int n = pattern.length;
        int[] pi = prefix_function(pattern);
        for (int i = 0, j = 0; ; i++) {
            int cur = infiniteStream.next();
            while (j >= n || (j > 0 && cur != pattern[j])) j = pi[j - 1];
            if (cur == pattern[j]) j++;
            if (j == n) {
                return i - n + 1;
            }
        }
    }

    private int[] prefix_function(int[] s) {
        int n = s.length;
        int[] pi = new int[n];
        for (int i = 1; i < n; i++) {
            int j = pi[i - 1];
            while (j > 0 && s[i] != s[j]) j = pi[j - 1];
            if (s[i] == s[j]) j++;
            pi[i] = j;
        }
        return pi;
    }

    // UT
    interface InfiniteStream {
        public int next();
    }
}
/*
3037. 在无限流中寻找模式 II
https://leetcode.cn/problems/find-pattern-in-infinite-stream-ii/description/

给定一个二进制数组 pattern 和一个类 InfiniteStream 的对象 stream 表示一个下标从 0 开始的二进制位无限流。
类 InfiniteStream 包含下列函数：
- int next()：从流中读取 一个 二进制位 （是 0 或 1）并返回。
返回 第一个使得模式匹配流中读取的二进制位的 开始下标。例如，如果模式是 [1, 0]，第一个匹配是流中的高亮部分 [0, 1, 0, 1, ...]。
提示：
1 <= pattern.length <= 10^4
pattern 只包含 0 或 1。
stream 只包含 0 或 1。
生成的输入使模式的开始下标在流的前 10^5 个二进制位中。

KMP 模板题。
 */