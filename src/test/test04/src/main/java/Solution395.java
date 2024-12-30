public class Solution395 {
    // 分治
    static class V1 {
        public int longestSubstring(String s, int k) {
            return dfs(s.toCharArray(), k, 0, s.length());
        }

        // [begin, end) 左闭右开
        private int dfs(char[] s, int k, int begin, int end) {
            int[] cnt = new int[26];
            for (int i = begin; i < end; i++) {
                cnt[s[i] - 'a']++;
            }
            int split = -1;
            for (int i = 0; i < 26; i++) {
                if (cnt[i] > 0 && cnt[i] < k) {
                    split = i;
                    break;
                }
            }
            if (split == -1) return end - begin;

            int i = begin;
            int res = 0;
            while (i < end) {
                for (; i < end && s[i] - 'a' == split; i++) {
                }
                if (i >= end) break;
                int st = i;
                for (; i < end && s[i] - 'a' != split; i++) {
                }
                res = Math.max(res, dfs(s, k, st, i));
            }
            return res;
        }
    }

    // 滑动窗口
    static class V2 {
        public int longestSubstring(String s, int k) {
            int ans = 0;
            char[] cs = s.toCharArray();
            for (int typeNum = 1; typeNum <= 26; typeNum++) {
                ans = Math.max(ans, slidingWindow(cs, k, typeNum));
            }
            return ans;
        }

        // typeNum: 字符种类数量
        // 当确定了窗口内所包含的字符种类数量时，区间重新具有了二段性质
        public int slidingWindow(char[] s, int k, int typeNum) {
            int n = s.length, l = 0, r = 0, ans = 0;
            int cnt_unique = 0; // 去重后的个数
            int cnt_typeLessK = 0; // 频次小于 k 的字符数量
            int[] cnt = new int[26];
            while (r < n) {
                if (++cnt[s[r] - 'a'] == 1) {
                    cnt_unique++;
                    cnt_typeLessK++;
                }
                if (cnt[s[r] - 'a'] == k) cnt_typeLessK--;

                while (cnt_unique > typeNum) {
                    if (--cnt[s[l] - 'a'] == 0) {
                        cnt_unique--;
                        cnt_typeLessK--;
                    }
                    if (cnt[s[l] - 'a'] == k - 1) cnt_typeLessK++;
                    l++;
                }
                if (cnt_typeLessK == 0) {
                    ans = Math.max(ans, r - l + 1);
                }
                r++;
            }
            return ans;
        }
    }
}
/*
395. 至少有 K 个重复字符的最长子串
https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/

给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
提示：
1 <= s.length <= 10^4
s 仅由小写英文字母组成
1 <= k <= 10^5

滑动窗口
枚举字符串种类数量 typeNum（1~26），保证滑动窗口内的字符种类数量为 typeNum，余下的问题为判断每个字符个数是否大于等于 k；
用一个整数 lessK 代表当前小于 k 的字符数量，即可在时间复杂度 O(1) 内判断窗口内每个字符个数是否大于等于 k；
时间复杂度 O(n*26)
空间复杂度 O(1) 其中常数为 26
相似题目: 1763. 最长的美好子字符串
https://leetcode.cn/problems/longest-nice-substring/description/
 */