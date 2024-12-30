public class Solution2953 {
    private char[] s;
    private int k;

    public int countCompleteSubstrings(String word, int k) {
        this.s = word.toCharArray();
        this.k = k;

        int n = s.length;
        int ans = 0, i = 0;
        while (i < n) {
            // 分组循环
            int st = i;
            for (i++; i < n && Math.abs(s[i] - s[i - 1]) <= 2; i++) {
            }
            ans += getSubAns(st, i);
        }
        return ans;
    }

    private int getSubAns(int st, int end) {
        int len = end - st;
        int res = 0;
        for (int m = 1; m <= 26 && m * k <= len; m++) {
            int span = m * k;
            // 滑动窗口
            int[] cnt = new int[26];
            for (int i = 0; i < span; i++) {
                cnt[s[st + i] - 'a']++;
            }
            if (checkAllEqK(cnt)) res++;
            for (int i = span; i < len; i++) {
                cnt[s[st + i] - 'a']++;
                cnt[s[st + i - span] - 'a']--;
                if (checkAllEqK(cnt)) res++;
            }
        }
        return res;
    }

    private boolean checkAllEqK(int[] cnt) {
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] != k) {
                return false;
            }
        }
        return true;
    }
}
/*
2953. 统计完全子字符串
https://leetcode.cn/problems/count-complete-substrings/description/

第 374 场周赛 T3。

给你一个字符串 word 和一个整数 k 。
如果 word 的一个子字符串 s 满足以下条件，我们称它是 完全字符串：
- s 中每个字符 恰好 出现 k 次。
- 相邻字符在字母表中的顺序 至多 相差 2 。也就是说，s 中两个相邻字符 c1 和 c2 ，它们在字母表中的位置相差 至多 为 2 。
请你返回 word 中 完全 子字符串的数目。
子字符串 指的是一个字符串中一段连续 非空 的字符序列。
提示：
1 <= word.length <= 10^5
word 只包含小写英文字母。
1 <= k <= word.length

分组循环 + 滑动窗口
时间复杂度 O(26*26*n)
空间复杂度 O(26)
 */