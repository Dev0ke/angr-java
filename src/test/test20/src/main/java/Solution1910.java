public class Solution1910 {
    public String removeOccurrences(String s, String part) {
        while (s.contains(part)) {
            s = s.replaceFirst(part, "");
        }
        return s;
    }
}
/*
1910. 删除一个字符串中所有出现的给定子字符串
https://leetcode.cn/problems/remove-all-occurrences-of-a-substring/

第 55 场双周赛 T2。

给你两个字符串 s 和 part ，请你对 s 反复执行以下操作直到 所有 子字符串 part 都被删除：
- 找到 s 中 最左边 的子字符串 part ，并将它从 s 中删除。
请你返回从 s 中删除所有 part 子字符串以后得到的剩余字符串。
一个 子字符串 是一个字符串中连续的字符序列。
提示：
1 <= s.length <= 1000
1 <= part.length <= 1000
s 和 part 只包小写英文字母。

库函数 模拟。
删除完的字符串作为新的入参，递归迭代到不在出现为止。注意 String#replace、String#replaceAll、String#replaceFirst 的区别。
 */