public class Solution3330 {
    public int possibleStringCount(String word) {
        int n = word.length();
        char[] s = word.toCharArray();
        int i = 0;
        int ans = 1;
        while (i < n) {
            int st = i;
            for (i++; i < n && s[i] == s[st]; i++) {
            }
            int len = i - st;
            ans += len - 1;
        }
        return ans;
    }
}
/*
3330. 找到初始输入字符串 I
https://leetcode.cn/problems/find-the-original-typed-string-i/description/

第 142 场双周赛 T1。

Alice 正在她的电脑上输入一个字符串。但是她打字技术比较笨拙，她 可能 在一个按键上按太久，导致一个字符被输入 多次 。
尽管 Alice 尽可能集中注意力，她仍然可能会犯错 至多 一次。
给你一个字符串 word ，它表示 最终 显示在 Alice 显示屏上的结果。
请你返回 Alice 一开始可能想要输入字符串的总方案数。
提示：
1 <= word.length <= 100
word 只包含小写英文字母。

中国时间：2024-10-26 22:30
东莞·三丫坡 与 yangjl。只 AC 了一道，大佬 AK 了，，
分组循环。
 */