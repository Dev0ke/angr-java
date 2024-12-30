public class Solution1234 {
    private int n;
    private char[] s;

    public int balancedString(String s) {
        this.n = s.length();
        this.s = s.toCharArray();
        int[] cnt = new int[4];
        for (int i = 0; i < n; i++) {
            cnt[getId(i)]++;
        }
        if (check(cnt)) return 0;

        int l = 0, r = 0, minLen = n;
        while (r < n) {
            cnt[getId(r)]--;
            while (check(cnt)) {
                minLen = Math.min(minLen, r - l + 1);
                cnt[getId(l)]++;
                l++;
            }
            r++;
        }
        return minLen;
    }

    private int getId(int i) {
        if (s[i] == 'Q') return 0;
        if (s[i] == 'W') return 1;
        if (s[i] == 'E') return 2;
        return 3;
    }

    private boolean check(int[] cnt) {
        int part = n / 4;
        return cnt[0] <= part && cnt[1] <= part && cnt[2] <= part && cnt[3] <= part;
    }
}
/*
1234. 替换子串得到平衡字符串
https://leetcode.cn/problems/replace-the-substring-for-balanced-string/

有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。
假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。
给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。
你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。
请返回待替换子串的最小可能长度。
如果原字符串自身就是一个平衡字符串，则返回 0。
提示：
1 <= s.length <= 10^5
s.length 是 4 的倍数
s 中只含有 'Q', 'W', 'E', 'R' 四种字符

不定长滑动窗口（求最短/最小）
时间复杂度 O(n)
 */