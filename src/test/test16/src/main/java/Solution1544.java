public class Solution1544 {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            // 判断两个字符是否一个大写，一个小写 (c1 ^ c2) == 32
            if (!sb.isEmpty() && (sb.charAt(sb.length() - 1) ^ c) == 32) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
/*
1544. 整理字符串
https://leetcode.cn/problems/make-the-string-great/description/

给你一个由大小写英文字母组成的字符串 s 。
一个整理好的字符串中，两个相邻字符 s[i] 和 s[i+1]，其中 0<= i <= s.length-2 ，要满足如下条件:
- 若 s[i] 是小写字符，则 s[i+1] 不可以是相同的大写字符。
- 若 s[i] 是大写字符，则 s[i+1] 不可以是相同的小写字符。
请你将字符串整理好，每次你都可以从字符串中选出满足上述条件的 两个相邻 字符并删除，直到字符串整理好为止。
请返回整理好的 字符串 。题目保证在给出的约束条件下，测试样例对应的答案是唯一的。
注意：空字符串也属于整理好的字符串，尽管其中没有任何字符。
提示：
1 <= s.length <= 100
s 只包含小写和大写英文字母

栈思想。
时间复杂度 O(n)。
 */