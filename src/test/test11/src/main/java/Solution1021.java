import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1021 {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == ')') st.pop();
            if (!st.isEmpty()) ans.append(c);
            if (c == '(') st.push(c);
        }
        return ans.toString();
    }
}
/*
1021. 删除最外层的括号
https://leetcode.cn/problems/remove-outermost-parentheses/description/

有效括号字符串为空 ""、"(" + A + ")" 或 A + B ，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。
- 例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
如果有效字符串 s 非空，且不存在将其拆分为 s = A + B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
给出一个非空有效字符串 s，考虑将其进行原语化分解，使得：s = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
对 s 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 s 。
提示：
1 <= s.length <= 10^5
s[i] 为 '(' 或 ')'
s 是一个有效括号字符串

栈。
时间复杂度 O(n)。
 */