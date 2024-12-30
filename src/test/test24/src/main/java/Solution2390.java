public class Solution2390 {
    public String removeStars(String s) {
        int len = s.length();
        int del = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '*') {
                del++;
            } else if (del > 0) {
                del--;
            } else {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.reverse().toString();
    }
}
/*
2390. 从字符串中移除星号
https://leetcode.cn/problems/removing-stars-from-a-string/

第 308 场周赛 T2。

给你一个包含若干星号 * 的字符串 s 。
在一步操作中，你可以：
- 选中 s 中的一个星号。
- 移除星号 左侧 最近的那个 非星号 字符，并移除该星号自身。
返回移除 所有 星号之后的字符串。
注意：
- 生成的输入保证总是可以执行题面中描述的操作。
- 可以证明结果字符串是唯一的。
提示：
1 <= s.length <= 10^5
s 由小写英文字母和星号 * 组成
s 可以执行上述操作

栈思想，后往前枚举，遇到一个星号代表可以忽略一个非星号字符
时间复杂度 O(n)
 */