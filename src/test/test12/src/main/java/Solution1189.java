public class Solution1189 {
    public int maxNumberOfBalloons(String text) {
        int cntB = 0;
        int cntA = 0;
        int cntL = 0;
        int cntO = 0;
        int cntN = 0;
        for (char ch : text.toCharArray()) {
            if (ch == 'a') {
                cntA++;
            } else if (ch == 'b') {
                cntB++;
            } else if (ch == 'l') {
                cntL++;
            } else if (ch == 'o') {
                cntO++;
            } else if (ch == 'n') {
                cntN++;
            }
        }
        int min = Math.min(cntB, cntA);
        min = Math.min(min, cntL / 2);
        min = Math.min(min, cntO / 2);
        min = Math.min(min, cntN);
        return min;
    }
}
/*
1189. “气球” 的最大数量
https://leetcode.cn/problems/maximum-number-of-balloons/

给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
提示：
1 <= text.length <= 10^4
text 全部由小写英文字母组成

统计字符频次，取最小值。
 */