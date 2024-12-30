public class Solution3031 {
    public int minimumTimeToInitialState(String word, int k) {
        int n = word.length();
        int[] z = z_function(n, word.toCharArray());

        for (int i = 0; i < n; i += k) {
            if (i + k < n && z[i + k] + (i + k) >= n) {
                return (i + k) / k;
            }
        }
        return (n + k - 1) / k;
    }

    private int[] z_function(int n, char[] s) {
        int[] z = new int[n];
        for (int i = 1, l = 0, r = 0; i < n; ++i) {
            if (i <= r && z[i - l] < r - i + 1) {
                z[i] = z[i - l];
            } else {
                z[i] = Math.max(0, r - i + 1);
                while (i + z[i] < n && s[z[i]] == s[i + z[i]]) ++z[i];
            }
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }
        return z;
    }
}
/*
3031. 将单词恢复初始状态所需的最短时间 II
https://leetcode.cn/problems/minimum-time-to-revert-word-to-initial-state-ii/description/

第 383 场周赛 T4。

给你一个下标从 0 开始的字符串 word 和一个整数 k 。
在每一秒，你必须执行以下操作：
- 移除 word 的前 k 个字符。
- 在 word 的末尾添加 k 个任意字符。
注意 添加的字符不必和移除的字符相同。但是，必须在每一秒钟都执行 两种 操作。
返回将 word 恢复到其 初始 状态所需的 最短 时间（该时间必须大于零）。
提示：
1 <= word.length <= 10^5
1 <= k <= word.length
word仅由小写英文字母组成。

Z 函数（扩展 KMP）
时间复杂度 O(n)
相似题目: 2223. 构造字符串的总得分和
https://leetcode.cn/problems/sum-of-scores-of-built-strings/
 */