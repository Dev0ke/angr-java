import java.util.ArrayDeque;
import java.util.Deque;

public class Solution316 {
    public String removeDuplicateLetters2(String s) {
        // 右侧（含自身）元素频次
        int[] cntArr = new int[26];
        for (char ch : s.toCharArray()) {
            cntArr[ch - 'a']++;
        }

        // 栈中元素频次
        int[] stackArr = new int[26];
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            // 无法入栈
            if (stackArr[ch - 'a'] == 1) {
                cntArr[ch - 'a']--;
                continue;
            }
            // 栈顶元素能出栈
            while (!stack.isEmpty() && stack.peek() > ch && cntArr[stack.peek() - 'a'] > 1) {
                char pop = stack.pop();
                cntArr[pop - 'a']--;
                stackArr[pop - 'a']--;
            }
            stack.push(ch);
            stackArr[ch - 'a']++;
        }

        int sz = stack.size();
        char[] chars = new char[sz];
        for (int i = sz - 1; i >= 0; i--) {
            chars[i] = stack.pop();
        }
        return new String(chars);
    }

    public String removeDuplicateLetters(String s) {
        int len = s.length();
        // 记录各小写英文字母最后一次出现的下标
        int[] lastIndex = new int[26];
        for (int i = 0; i < len; i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        Deque<Character> stack = new ArrayDeque<>();
        // true: 栈中已存在 小写英文字母
        boolean[] visited = new boolean[26];
        for (int i = 0; i < len; i++) {
            if (visited[s.charAt(i) - 'a']) {
                continue;
            }
            // 栈非空 && 栈顶元素大于当前元素 && 当前栈顶元素非最后一次出现（栈顶元素可丢弃）
            while (!stack.isEmpty() && stack.peek() > s.charAt(i) && lastIndex[stack.peek() - 'a'] > i) {
                char top = stack.pop();
                visited[top - 'a'] = false;
            }
            stack.push(s.charAt(i));
            visited[s.charAt(i) - 'a'] = true;
        }
        // Deque<Character> => String
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            // 注意倒序
            char ch = stack.pop();
            stringBuilder.append(ch);
        }
        return stringBuilder.reverse().toString();
    }
}
/*
316. 去除重复字母
https://leetcode.cn/problems/remove-duplicate-letters/

给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
提示：
1 <= s.length <= 10^4
s 由小写英文字母组成

单调栈。
同: 1081. 不同字符的最小子序列
https://leetcode.cn/problems/smallest-subsequence-of-distinct-characters/
 */