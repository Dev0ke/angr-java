import java.util.ArrayList;
import java.util.List;

public class Solution2900 {
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i + 1 < n; i++) {
            if (groups[i] != groups[i + 1]) {
                ans.add(words[i]);
            }
        }
        ans.add(words[n - 1]);
        return ans;
    }
}
/*
2900. 最长相邻不相等子序列 I
https://leetcode.cn/problems/longest-unequal-adjacent-groups-subsequence-i/description/

第 115 场双周赛 T2。

给你一个整数 n 和一个下标从 0 开始的字符串数组 words ，和一个下标从 0 开始的 二进制 数组 groups ，两个数组长度都是 n 。
你需要从下标 [0, 1, ..., n - 1] 中选出一个 最长子序列 ，将这个子序列记作长度为 k 的 [i0, i1, ..., ik - 1] ，对于所有满足 0 < j + 1 < k 的 j 都有 groups[ij] != groups[ij + 1] 。
请你返回一个字符串数组，它是下标子序列 依次 对应 words 数组中的字符串连接形成的字符串数组。如果有多个答案，返回任意一个。
子序列 指的是从原数组中删掉一些（也可能一个也不删掉）元素，剩余元素不改变相对位置得到的新的数组。
注意：words 中的字符串长度可能 不相等 。
提示：
1 <= n == words.length == groups.length <= 100
1 <= words[i].length <= 10
0 <= groups[i] < 2
words 中的字符串 互不相同 。
words[i] 只包含小写英文字母。

脑筋急转弯，一次遍历即可。
时间复杂度 O(n)
 */