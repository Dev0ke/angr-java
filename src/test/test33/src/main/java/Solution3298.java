public class Solution3298 {
    public long validSubstringCount(String word1, String word2) {
        if (word1.length() < word2.length()) return 0;

        int[] cnt_window = new int[26];
        int[] cnt_p = new int[26];
        for (int i = 0; i < word2.length(); i++) {
            cnt_p[word2.charAt(i) - 'a']++;
        }
        int n = word1.length();
        int l = 0, r = 0;
        long ans = 0;
        while (r < n) {
            cnt_window[word1.charAt(r) - 'a']++;

            while (check(cnt_window, cnt_p)) {
                ans += n - r;
                cnt_window[word1.charAt(l) - 'a']--;
                l++;
            }
            r++;
        }
        return ans;
    }

    private boolean check(int[] cnt_window, int[] cnt_p) {
        for (int i = 0; i < 26; i++) {
            if (cnt_window[i] < cnt_p[i]) return false;
        }
        return true;
    }
}
/*
3298. 统计重新排列后包含另一个字符串的子字符串数目 II
https://leetcode.cn/problems/count-substrings-that-can-be-rearranged-to-contain-a-string-ii/description/

第 416 场周赛 T4。

给你两个字符串 word1 和 word2 。
如果一个字符串 x 重新排列后，word2 是重排字符串的 前缀 ，那么我们称字符串 x 是 合法的 。
请你返回 word1 中 合法 子字符串 的数目。
注意 ，这个问题中的内存限制比其他题目要 小 ，所以你 必须 实现一个线性复杂度的解法。
解释：
1 <= word1.length <= 10^6
1 <= word2.length <= 10^4
word1 和 word2 都只包含小写英文字母。

双指针。
相似题目: 438. 找到字符串中所有字母异位词
https://leetcode.cn/problems/find-all-anagrams-in-a-string/
 */