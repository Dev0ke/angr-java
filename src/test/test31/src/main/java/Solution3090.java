public class Solution3090 {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int l = 0, r = 0, ans = 0;
        int[] cnt = new int[26];
        while (r < n) {
            int b = s.charAt(r) - 'a';
            cnt[b]++;
            while (cnt[b] > 2) {
                cnt[s.charAt(l) - 'a']--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}
/*
3090. 每个字符最多出现两次的最长子字符串
https://leetcode.cn/problems/maximum-length-substring-with-two-occurrences/description/

第 390 场周赛 T1。

给你一个字符串 s ，请找出满足每个字符最多出现两次的最长子字符串，并返回该 子字符串 的 最大 长度。
提示：
2 <= s.length <= 100
s 仅由小写英文字母组成。

双指针。
时间复杂度 O(n)
 */