public class SolutionP2067 {
    public int equalCountSubstrings(String S, int count) {
        int n = S.length();
        char[] s = S.toCharArray();
        int ans = 0;
        for (int type = 1; type <= 26 && type * count <= n; type++) {
            int span = type * count;
            int[] cnt = new int[26];
            for (int i = 0; i < span; i++) {
                cnt[s[i] - 'a']++;
            }
            ans += check(count, cnt);
            for (int i = span; i < n; i++) {
                cnt[s[i] - 'a']++;
                cnt[s[i - span] - 'a']--;
                ans += check(count, cnt);
            }
        }
        return ans;
    }

    private int check(int count, int[] cnt) {
        for (int c : cnt) {
            if (c == 0) continue;
            if (c != count) return 0;
        }
        return 1;
    }
}
/*
$2067. 等计数子串的数量
https://leetcode.cn/problems/number-of-equal-count-substrings/description/

给你一个下标从 0 开始的字符串 s，只包含小写英文字母和一个整数 count。如果 s 的 子串 中的每种字母在子串中恰好出现 count 次，这个子串就被称为 等计数子串。
返回 s 中 等计数子串 的个数。
子串 是字符串中连续的非空字符序列。
提示:
1 <= s.length <= 3 * 10^4
1 <= count <= 3 * 10^4
s 只由小写英文字母组成。

枚举长度 + 定长滑动窗口。
时间复杂度 O(26n)。
 */