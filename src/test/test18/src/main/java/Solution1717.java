public class Solution1717 {
    public int maximumGain(String s, int x, int y) {
        return x >= y ? getAns(s, x, y, "ab", "ba") : getAns(s, y, x, "ba", "ab");
    }

    // 先删除 sx 得到 x 分，再删除 sy 得到 y 分
    private int getAns(String s, int x, int y, String sx, String sy) {
        int ans = 0;
        StringBuilder st = new StringBuilder();
        for (char c : s.toCharArray()) {
            st.append(c);
            if (st.length() >= sx.length() && st.substring(st.length() - sx.length()).equals(sx)) {
                st.delete(st.length() - sx.length(), st.length());
                ans += x;
            }
        }
        char[] s2 = st.toString().toCharArray();
        st.delete(0, st.length());
        for (char c : s2) {
            st.append(c);
            if (st.length() >= sy.length() && st.substring(st.length() - sy.length()).equals(sy)) {
                st.delete(st.length() - sy.length(), st.length());
                ans += y;
            }
        }
        return ans;
    }
}
/*
1717. 删除子字符串的最大得分
https://leetcode.cn/problems/maximum-score-from-removing-substrings/description/

给你一个字符串 s 和两个整数 x 和 y 。你可以执行下面两种操作任意次。
- 删除子字符串 "ab" 并得到 x 分。
  - 比方说，从 "cabxbae" 删除 ab ，得到 "cxbae" 。
- 删除子字符串"ba" 并得到 y 分。
  - 比方说，从 "cabxbae" 删除 ba ，得到 "cabxe" 。
请返回对 s 字符串执行上面操作若干次能得到的最大得分。
提示：
1 <= s.length <= 10^5
1 <= x, y <= 10^4
s 只包含小写英文字母。

贪心。
当 x≥y 时，首先删除字符串中的所有 “ab"，然后删除字符串中的所有 “ba"。
当 x<y 时，首先删除字符串中的所有 “ba"，然后删除字符串中的所有 “ab"。
时间复杂度 O(n)。
相似题目: 1003. 检查替换后的词是否有效
https://leetcode.cn/problems/check-if-word-is-valid-after-substitutions/description/
 */