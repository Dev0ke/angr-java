public class SolutionP1100 {
    public int numKLenSubstrNoRepeats(String s, int k) {
        int len = s.length();
        // 无解情况：字符串长度小于 k 或 k 大于 26
        if (len < k || k > 26) {
            return 0;
        }
        int cnt = 0;
        for (int i = 0; i + k - 1 < len; i++) {
            if (check(s, i, i + k - 1)) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean check(String s, int left, int right) {
        int[] chCnt = new int[26];
        for (int i = left; i <= right; i++) {
            char ch = s.charAt(i);
            if (chCnt[ch - 'a'] > 0) {
                return false;
            }
            chCnt[ch - 'a']++;
        }
        return true;
    }
}
/*
$1100. 长度为 K 的无重复字符子串
https://leetcode.cn/problems/find-k-length-substrings-with-no-repeated-characters/

第 3 场双周赛 T2。

给你一个字符串 S，找出所有长度为 K 且不含重复字符的子串，请你返回全部满足要求的子串的 数目。
提示：
1 <= S.length <= 10^4
S 中的所有字符均为小写英文字母
1 <= K <= 10^4

显然 k 超过 26 子串必定含重复字符。
数量级 10^4 * 26 < 10^6 直接暴力枚举即可。
 */