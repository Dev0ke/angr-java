public class Solution2186 {
    public int minSteps(String s, String t) {
        int[] cntArrS = new int[26];
        int[] cntArrT = new int[26];
        for (char ch : s.toCharArray()) {
            cntArrS[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            cntArrT[ch - 'a']++;
        }

        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            cnt += Math.abs(cntArrS[i] - cntArrT[i]);
        }
        return cnt;
    }
}
/*
2186. 使两字符串互为字母异位词的最少步骤数
https://leetcode.cn/problems/minimum-number-of-steps-to-make-two-strings-anagram-ii/

第 282 场周赛 T2。

给你两个字符串 s 和 t 。在一步操作中，你可以给 s 或者 t 追加 任一字符 。
返回使 s 和 t 互为 字母异位词 所需的最少步骤数。
字母异位词 指字母相同但是顺序不同（或者相同）的字符串。
提示：
1 <= s.length, t.length <= 2 * 10^5
s 和 t 由小写英文字符组成

模拟+贪心。
时间复杂度 O(s+t)
 */