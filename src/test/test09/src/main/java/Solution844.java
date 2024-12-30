import java.util.ArrayDeque;
import java.util.Deque;

public class Solution844 {
    public boolean backspaceCompare(String s, String t) {
        return backspaceStr(s).equals(backspaceStr(t));
    }

    private String backspaceStr(String str) {
        // 栈模拟
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : str.toCharArray()) {
            if (ch == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }
        // 还原为字符串
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }
}
/*
844. 比较含退格的字符串
https://leetcode.cn/problems/backspace-string-compare/

第 87 场周赛 T1。

给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，请你判断二者是否相等。# 代表退格字符。
如果相等，返回 true ；否则，返回 false 。
注意：如果对空文本输入退格字符，文本继续为空。
提示：
1 <= s.length, t.length <= 200
s 和 t 只含有小写字母以及字符 '#'

使用栈，根据题意进行模拟即可，pop 前需注意判断是否空栈
 */