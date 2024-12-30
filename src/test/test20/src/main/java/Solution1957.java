public class Solution1957 {
    public String makeFancyString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int cnt = 0;
        int lastCh = s.charAt(0);
        for (char ch : s.toCharArray()) {
            if (ch == lastCh) {
                cnt++;
            } else {
                lastCh = ch;
                cnt = 1;
            }
            if (cnt < 3) {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }
}
/*
1957. 删除字符使字符串变好
https://leetcode.cn/problems/delete-characters-to-make-fancy-string/

第 58 场双周赛 T1。

一个字符串如果没有 三个连续 相同字符，那么它就是一个 好字符串 。
给你一个字符串 s ，请你从 s 删除 最少 的字符，使它变成一个 好字符串 。
请你返回删除后的字符串。题目数据保证答案总是 唯一的 。
提示：
1 <= s.length <= 10^5
s 只包含小写英文字母。

直接模拟即可。
 */