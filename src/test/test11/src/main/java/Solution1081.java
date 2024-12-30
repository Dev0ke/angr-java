import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1081 {
    public String smallestSubsequence(String s) {
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
            char ch = stack.removeLast();
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }
}
/*
1081. 不同字符的最小子序列
https://leetcode.cn/problems/smallest-subsequence-of-distinct-characters/

第 140 场周赛 T4。

返回 s 字典序最小的子序列，该子序列包含 s 的所有不同字符，且只包含一次。
提示：
1 <= s.length <= 1000
s 由小写英文字母组成

单调栈。
同: 316. 去除重复字母
https://leetcode.cn/problems/remove-duplicate-letters/
 */