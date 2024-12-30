public class Solution3036 {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int[] a = new int[n - 1];
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i]) a[i - 1] = 1;
            if (nums[i - 1] > nums[i]) a[i - 1] = -1;
        }
        return kmpSearch(a, pattern);
    }

    private int kmpSearch(int[] txt, int[] pat) {
        int[] pi = prefix_function(pat);
        int matchCnt = 0;
        for (int i = 0, j = 0; i < txt.length; i++) {
            while (j > 0 && txt[i] != pat[j]) j = pi[j - 1];
            if (txt[i] == pat[j]) j++;
            if (j == pat.length) {
                matchCnt++;
                j = pi[j - 1];
            }
        }
        return matchCnt;
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
}
/*
3036. 匹配模式数组的子数组数目 II
https://leetcode.cn/problems/number-of-subarrays-that-match-a-pattern-ii/description/

第 384 场周赛 T4。

给你一个下标从 0 开始长度为 n 的整数数组 nums ，和一个下标从 0 开始长度为 m 的整数数组 pattern ，pattern 数组只包含整数 -1 ，0 和 1 。
大小为 m + 1 的子数组 nums[i..j] 如果对于每个元素 pattern[k] 都满足以下条件，那么我们说这个子数组匹配模式数组 pattern ：
- 如果 pattern[k] == 1 ，那么 nums[i + k + 1] > nums[i + k]
- 如果 pattern[k] == 0 ，那么 nums[i + k + 1] == nums[i + k]
- 如果 pattern[k] == -1 ，那么 nums[i + k + 1] < nums[i + k]
请你返回匹配 pattern 的 nums 子数组的 数目 。
提示：
2 <= n == nums.length <= 10^6
1 <= nums[i] <= 10^9
1 <= m == pattern.length < n
-1 <= pattern[i] <= 1

kmp。
时间复杂度 O(n)
相似题目: 2851. 字符串转换
https://leetcode.cn/problems/string-transformation/
 */