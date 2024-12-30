import java.util.ArrayList;
import java.util.List;

public class Solution916 {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] cnt_max = new int[26];
        for (String s : words2) {
            int[] cnt = cnt(s);
            for (int i = 0; i < 26; i++) {
                cnt_max[i] = Math.max(cnt_max[i], cnt[i]);
            }
        }

        List<String> ans = new ArrayList<>();
        for (String s : words1) {
            int[] cnt = cnt(s);
            if (aContainsB(cnt, cnt_max)) {
                ans.add(s);
            }
        }
        return ans;
    }

    private boolean aContainsB(int[] cntA, int[] cntB) {
        for (int i = 0; i < 26; i++) {
            if (cntA[i] < cntB[i]) return false;
        }
        return true;
    }

    private int[] cnt(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        return cnt;
    }
}
/*
916. 单词子集
https://leetcode.cn/problems/word-subsets/description/

给你两个字符串数组 words1 和 words2。
现在，如果 b 中的每个字母都出现在 a 中，包括重复出现的字母，那么称字符串 b 是字符串 a 的 子集 。
- 例如，"wrr" 是 "warrior" 的子集，但不是 "world" 的子集。
如果对 words2 中的每一个单词 b，b 都是 a 的子集，那么我们称 words1 中的单词 a 是 通用单词 。
以数组形式返回 words1 中所有的通用单词。你可以按 任意顺序 返回答案。

枚举。把 b 的 cnt_max 求出来，枚举每个 a 是否满足即可。
时间复杂度 O(n + m)。其中常数位位 26。
 */