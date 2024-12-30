import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1190 {
    public String reverseParentheses(String s) {
        Deque<String> st = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                st.push(sb.toString());
                sb.delete(0, sb.length());
            } else if (ch == ')') {
                sb.reverse();
                sb.insert(0, st.pop());
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
/*
1190. 反转每对括号间的子串
https://leetcode.cn/problems/reverse-substrings-between-each-pair-of-parentheses/description/

给出一个字符串 s（仅含有小写英文字母和括号）。
请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
注意，您的结果中 不应 包含任何括号。
提示：
1 <= s.length <= 2000
s 中只有小写英文字母和括号
题目测试用例确保所有括号都是成对出现的

栈模拟。
时间复杂度 O(n^2) 其中字符串翻转需要 O(n)
 */