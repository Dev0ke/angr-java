public class Solution2810 {
    public String finalString(String s) {
        StringBuilder ans = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == 'i') {
                ans.reverse();
            } else {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}
/*
2810. 故障键盘
https://leetcode.cn/problems/faulty-keyboard/

第 357 场周赛 T1。

你的笔记本键盘存在故障，每当你在上面输入字符 'i' 时，它会反转你所写的字符串。而输入其他字符则可以正常工作。
给你一个下标从 0 开始的字符串 s ，请你用故障键盘依次输入每个字符。
返回最终笔记本屏幕上输出的字符串。
提示：
1 <= s.length <= 100
s 由小写英文字母组成
s[0] != 'i'

StringBuilder 模拟。也可以用双端队列。
 */