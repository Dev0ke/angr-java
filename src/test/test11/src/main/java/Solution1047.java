import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1047 {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        // stack => String
        int sz = stack.size();
        char[] chars = new char[sz];
        for (int i = sz - 1; i >= 0; i--) {
            chars[i] = stack.pop();
        }
        return new String(chars);
    }
}
/*
1047. 删除字符串中的所有相邻重复项
https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/

给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
在 S 上反复执行重复项删除操作，直到无法继续删除。
在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
提示：
1 <= S.length <= 20000
S 仅由小写英文字母组成。

栈模拟。
 */