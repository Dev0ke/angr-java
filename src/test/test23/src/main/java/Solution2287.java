public class Solution2287 {
    public int rearrangeCharacters(String s, String target) {
        int[] sCntArr = new int[26];
        int[] tCntArr = new int[26];
        for (char ch : s.toCharArray()) {
            sCntArr[ch - 'a']++;
        }
        for (char ch : target.toCharArray()) {
            tCntArr[ch - 'a']++;
        }

        int cnt = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (tCntArr[i] > 0) {
                cnt = Math.min(cnt, sCntArr[i] / tCntArr[i]);
            }
        }
        return cnt;
    }
}
/*
2287. 重排字符形成目标字符串
https://leetcode.cn/problems/rearrange-characters-to-make-target-string/

第 295 场周赛 T1。

给你两个下标从 0 开始的字符串 s 和 target 。你可以从 s 取出一些字符并将其重排，得到若干新的字符串。
从 s 中取出字符并重新排列，返回可以形成 target 的 最大 副本数。
提示：
1 <= s.length <= 100
1 <= target.length <= 10
s 和 target 由小写英文字母组成

统计字符频次，取 s[ch] / target[ch] 的最小值
 */