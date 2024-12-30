public class Solution1003 {
    public boolean isValid(String s) {
        StringBuilder st = new StringBuilder();
        for (char c : s.toCharArray()) {
            st.append(c);
            if (st.length() >= 3 && st.substring(st.length() - 3).equals("abc")) {
                st.delete(st.length() - 3, st.length());
            }
        }
        return st.isEmpty();
    }
}
/*
1003. 检查替换后的词是否有效
https://leetcode.cn/problems/check-if-word-is-valid-after-substitutions/description/

给你一个字符串 s ，请你判断它是否 有效 。
字符串 s 有效 需要满足：假设开始有一个空字符串 t = "" ，你可以执行 任意次 下述操作将 t 转换为 s ：
- 将字符串 "abc" 插入到 t 中的任意位置。形式上，t 变为 tleft + "abc" + tright，其中 t == tleft + tright 。注意，tleft 和 tright 可能为 空 。
如果字符串 s 有效，则返回 true；否则，返回 false。
提示：
1 <= s.length <= 2 * 10^4
s 由字母 'a'、'b' 和 'c' 组成

栈模拟。
因需要下标取数，使用 StringBuilder 模拟栈。
时间复杂度 O(n)。
相似题目: 1209. 删除字符串中的所有相邻重复项 II
https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string-ii/description/
 */