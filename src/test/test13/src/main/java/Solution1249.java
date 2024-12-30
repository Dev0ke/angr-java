import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Solution1249 {
    public String minRemoveToMakeValid(String s) {
        int len = s.length();
        // 模拟括号匹配
        Deque<Integer> stack = new ArrayDeque<>();
        // 记录保留的下标
        Set<Integer> saveIdxSet = new HashSet<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else {
                if (ch == ')' && !stack.isEmpty()) {
                    saveIdxSet.add(stack.pop());
                    saveIdxSet.add(i);
                }
            }
        }

        // 第二次扫描得出结果
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == ')') {
                if (saveIdxSet.contains(i)) {
                    stringBuilder.append(ch);
                }
            } else {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }
}
/*
1249. 移除无效的括号
https://leetcode.cn/problems/minimum-remove-to-make-valid-parentheses/

第 161 场周赛 T3。

给你一个由 '('、')' 和小写字母组成的字符串 s。
你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。
请返回任意一个合法字符串。
有效「括号字符串」应当符合以下 任意一条 要求：
- 空字符串或只包含小写字母的字符串
- 可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」
- 可以被写作 (A) 的字符串，其中 A 是一个有效的「括号字符串」
提示：
1 <= s.length <= 10^5
s[i] 可能是 '('、')' 或英文小写字母

栈模拟括号配对。
时间复杂度 O(n)
 */