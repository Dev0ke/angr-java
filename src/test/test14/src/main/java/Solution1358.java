public class Solution1358 {
    public int numberOfSubstrings(String S) {
        int n = S.length(), l = 0, r = 0, ans = 0;
        char[] s = S.toCharArray();
        int[] cnt = new int[3];
        while (r < n) {
            cnt[s[r] - 'a']++;
            while (cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0) {
                ans += n - r;
                cnt[s[l] - 'a']--;
                l++;
            }
            r++;
        }
        return ans;
    }
}
/*
1358. 包含所有三种字符的子字符串数目
https://leetcode.cn/problems/number-of-substrings-containing-all-three-characters/

给你一个字符串 s ，它只包含三种字符 a, b 和 c 。
请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。
提示：
3 <= s.length <= 5 x 10^4
s 只包含字符 a，b 和 c 。

双指针。
时间复杂度 O(n)
 */