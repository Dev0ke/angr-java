import java.util.Arrays;

public class Solution3035 {
    public int maxPalindromesAfterOperations(String[] words) {
        int n = words.length;

        int[] len = new int[n];
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            len[i] = words[i].length();
            for (char c : words[i].toCharArray()) {
                cnt[c - 'a']++;
            }
        }
        // 下取整到偶数就行了
        int pair = 0;
        for (int c : cnt) {
            pair += c / 2;
        }

        Arrays.sort(len);
        int ans = 0;
        for (int l : len) {
            if (pair >= l / 2) {
                pair -= l / 2;
                ans++;
            }
        }
        return ans;
    }
}
/*
3035. 回文字符串的最大数量
https://leetcode.cn/problems/maximum-palindromes-after-operations/description/

第 384 场周赛 T3。

给你一个下标从 0 开始的字符串数组 words ，数组的长度为 n ，且包含下标从 0 开始的若干字符串。
你可以执行以下操作 任意 次数（包括零次）：
- 选择整数i、j、x和y，满足0 <= i, j < n，0 <= x < words[i].length，0 <= y < words[j].length，交换 字符 words[i][x] 和 words[j][y] 。
返回一个整数，表示在执行一些操作后，words 中可以包含的回文字符串的 最大 数量。
注意：在操作过程中，i 和 j 可以相等。
提示：
1 <= words.length <= 1000
1 <= words[i].length <= 100
words[i] 仅由小写英文字母组成。

贪心。统计字符频次 和 长度，然后从长度短的开始枚举，看能否凑对即可。
时间复杂度 O(nlogn)
 */