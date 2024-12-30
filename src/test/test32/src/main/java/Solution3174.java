public class Solution3174 {
    public String clearDigits(String s) {
        StringBuilder ans = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                ans.deleteCharAt(ans.length() - 1);
            } else {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}
/*
3174. 清除数字
https://leetcode.cn/problems/clear-digits/description/

第 132 场双周赛 T1。

给你一个字符串 s 。
你的任务是重复以下操作删除 所有 数字字符：
- 删除 第一个数字字符 以及它左边 最近 的 非数字 字符。
请你返回删除所有数字字符以后剩下的字符串。
提示：
1 <= s.length <= 100
s 只包含小写英文字母和数字字符。
输入保证所有数字都可以按以上操作被删除。

栈模拟。
时间复杂度 O(n)。
 */