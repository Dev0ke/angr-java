import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2434 {
    public String robotWithString(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();

        // 预处理 rMin[i] 表示 [i, len-1] 最小值
        char[] rMin = new char[len];
        rMin[len - 1] = chars[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rMin[i] = (char) Math.min(chars[i], rMin[i + 1]);
        }

        StringBuilder stringBuilder = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && stack.peek() <= rMin[i]) {
                stringBuilder.append(stack.pop());
            }
            stack.push(chars[i]);
        }
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }
}
/*
2434. 使用机器人打印字典序最小的字符串
https://leetcode.cn/problems/using-a-robot-to-print-the-lexicographically-smallest-string/

第 314 场周赛 T3。

给你一个字符串 s 和一个机器人，机器人当前有一个空字符串 t 。执行以下操作之一，直到 s 和 t 都变成空字符串：
删除字符串 s 的 第一个 字符，并将该字符给机器人。机器人把这个字符添加到 t 的尾部。
删除字符串 t 的 最后一个 字符，并将该字符给机器人。机器人将该字符写到纸上。
请你返回纸上能写出的字典序最小的字符串。
提示：
1 <= s.length <= 10^5
s 只包含小写英文字母。

栈思想 + 贪心。
先预处理出 rMin[i] 为 s[i:] 字典序最小的字符，然后如果当前栈顶元素 小于等于 rMin[i] 则进行输出，否则入栈。
时间复杂度 O(n)
 */