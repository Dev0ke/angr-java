public class Solution3325 {
    public int numberOfSubstrings(String S, int k) {
        int n = S.length();
        char[] s = S.toCharArray();
        int l = 0, r = 0;
        int ans = 0;
        int[] cnt = new int[26];
        int gtk = 0;
        while (r < n) {
            if (++cnt[s[r] - 'a'] == k) gtk++;

            while (gtk > 0) {
                ans += n - r;
                if (--cnt[s[l] - 'a'] == k - 1) gtk--;
                l++;
            }
            r++;
        }
        return ans;
    }
}
/*
3325. 字符至少出现 K 次的子字符串 I
https://leetcode.cn/problems/count-substrings-with-k-frequency-characters-i/description/

第 420 场周赛 T2。

给你一个字符串 s 和一个整数 k，在 s 的所有子字符串中，请你统计并返回 至少有一个 字符 至少出现 k 次的子字符串总数。
子字符串 是字符串中的一个连续、 非空 的字符序列。
提示：
1 <= s.length <= 3000
1 <= k <= s.length
s 仅由小写英文字母组成。

双指针 滑动窗口。
时间复杂度 O(n)。
 */