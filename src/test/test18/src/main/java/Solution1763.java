public class Solution1763 {
    static class V1 {
        public String longestNiceSubstring(String s) {
            int n = s.length();
            int maxPos = 0, maxLen = 0;
            for (int i = 0; i < n; i++) {
                int lower_mask = 0, upper_mask = 0;
                for (int j = i; j < n; j++) {
                    int idx = Character.toLowerCase(s.charAt(j)) - 'a';
                    if (Character.isLowerCase(s.charAt(j))) {
                        lower_mask |= 1 << idx;
                    } else {
                        upper_mask |= 1 << idx;
                    }
                    if (lower_mask != upper_mask) continue;
                    if (maxLen < j - i + 1) {
                        maxLen = j - i + 1;
                        maxPos = i;
                    }
                }
            }
            return s.substring(maxPos, maxPos + maxLen);
        }
    }

    // 分治
    static class V2 {
        private int maxPos, maxLen;

        public String longestNiceSubstring(String s) {
            maxPos = 0;
            maxLen = 0;
            dfs(s.toCharArray(), 0, s.length());
            return s.substring(maxPos, maxPos + maxLen);
        }

        private void dfs(char[] s, int begin, int end) {
//        if (begin > end) return;
            int lower_mask = 0, upper_mask = 0;
            for (int i = begin; i < end; i++) {
                int j = Character.toLowerCase(s[i]) - 'a';
                if (Character.isLowerCase(s[i])) lower_mask |= 1 << j;
                else upper_mask |= 1 << j;
            }
            if (lower_mask == upper_mask) {
                if (maxLen < end - begin) {
                    maxLen = end - begin;
                    maxPos = begin;
                }
                return;
            }

            int valid = lower_mask & upper_mask;
            int i = begin;
            while (i < end) {
                begin = i;
                for (; i < end && (valid & (1 << Character.toLowerCase(s[i]) - 'a')) > 0; i++) {
                }
                dfs(s, begin, i);
                i++;
            }
        }
    }

    // 滑动窗口
    static class V3 {
        private int maxPos, maxLen;

        public String longestNiceSubstring(String s) {
            maxPos = 0;
            maxLen = 0;
            char[] cs = s.toCharArray();
            int typeMask = 0;
            for (char c : cs) {
                typeMask |= 1 << (Character.toLowerCase(c) - 'a');
            }
            for (int typeNum = 1; typeNum <= Integer.bitCount(typeMask); typeNum++) {
                check(cs, typeNum);
            }
            return s.substring(maxPos, maxPos + maxLen);
        }

        private void check(char[] s, int typeNum) {
            int n = s.length, l = 0, r = 0;
            int[] cnt_lower = new int[26], cnt_upper = new int[26];
            // 同时出现大小写的字符的种类数量, 字符种类数量
            int cnt = 0, total = 0;
            while (r < n) {
                int j = Character.toLowerCase(s[r]) - 'a'; // 不分大小写，j = s[i]-'a' or s[i]-'A'
                if (Character.isLowerCase(s[r])) {
                    cnt_lower[j]++;
                    if (cnt_lower[j] == 1 && cnt_upper[j] > 0) cnt++;
                } else {
                    cnt_upper[j]++;
                    if (cnt_lower[j] > 0 && cnt_upper[j] == 1) cnt++;
                }
                if (cnt_lower[j] + cnt_upper[j] == 1) total++;

                while (total > typeNum) {
                    j = Character.toLowerCase(s[l]) - 'a';
                    if (cnt_lower[j] + cnt_upper[j] == 1) total--;
                    if (Character.isLowerCase(s[l])) {
                        cnt_lower[j]--;
                        if (cnt_lower[j] == 0 && cnt_upper[j] > 0) cnt--;
                    } else {
                        cnt_upper[j]--;
                        if (cnt_lower[j] > 0 && cnt_upper[j] == 0) cnt--;
                    }
                    l++;
                }
                if (cnt == typeNum) {
                    if (maxLen < r - l + 1) {
                        maxLen = r - l + 1;
                        maxPos = l;
                    }
                }

                r++;
            }
        }
    }
}
/*
1763. 最长的美好子字符串
https://leetcode.cn/problems/longest-nice-substring/description/

当一个字符串 s 包含的每一种字母的大写和小写形式 同时 出现在 s 中，就称这个字符串 s 是 美好 字符串。
比方说，"abABB" 是美好字符串，因为 'A' 和 'a' 同时出现了，且 'B' 和 'b' 也同时出现了。然而，"abA" 不是美好字符串因为 'b' 出现了，而 'B' 没有出现。
给你一个字符串 s ，请你返回 s 最长的 美好子字符串 。如果有多个答案，请你返回 最早 出现的一个。如果不存在美好子字符串，请你返回一个空字符串。
提示：
1 <= s.length <= 100
s 只包含大写和小写英文字母。

相似题目: 395. 至少有 K 个重复字符的最长子串
https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/
 */