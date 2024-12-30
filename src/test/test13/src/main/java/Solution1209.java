import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1209 {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Deque<Integer> st = new ArrayDeque<>(); // 当前字符与前一个不同时，往栈中压入 1。否则栈顶元素加 1。
        for (int i = 0; i < sb.length(); ++i) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                st.push(1);
            } else {
                int incremented = st.pop() + 1;
                if (incremented == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                } else {
                    st.push(incremented);
                }
            }
        }
        return sb.toString();
    }
}
/*
1209. 删除字符串中的所有相邻重复项 II
https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string-ii/description/

给你一个字符串 s，「k 倍重复项删除操作」将会从 s 中选择 k 个相邻且相等的字母，并删除它们，使被删去的字符串的左侧和右侧连在一起。
你需要对 s 重复进行无限次这样的删除操作，直到无法继续为止。
在执行完所有删除操作后，返回最终得到的字符串。
本题答案保证唯一。
提示：
1 <= s.length <= 10^5
2 <= k <= 10^4
s 中只含有小写英文字母。

栈思想。
相似题目: 1003. 检查替换后的词是否有效
https://leetcode.cn/problems/check-if-word-is-valid-after-substitutions/description/
 */