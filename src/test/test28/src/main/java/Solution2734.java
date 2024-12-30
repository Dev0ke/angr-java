public class Solution2734 {
    public String smallestString(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        // 状态机 flag = 0,1,2
        int flag = 0;
        for (int i = 0; i < n; i++) {
            if (flag == 0) {
                if (cs[i] > 'a') {
                    cs[i]--;
                    flag = 1;
                }
            } else if (flag == 1) {
                if (cs[i] > 'a') {
                    cs[i]--;
                } else {
                    flag = 2;
                }
            }
        }
        // 恰好一次
        if (flag == 0) {
            cs[n - 1] = 'z';
        }
        return new String(cs);
    }
}
/*
2734. 执行子串操作后的字典序最小字符串
https://leetcode.cn/problems/lexicographically-smallest-string-after-substring-operation/

第 349 场周赛 T2。

给你一个仅由小写英文字母组成的字符串 s 。在一步操作中，你可以完成以下行为：
- 选则 s 的任一非空子字符串，可能是整个字符串，接着将字符串中的每一个字符替换为英文字母表中的前一个字符。例如，'b' 用 'a' 替换，'a' 用 'z' 替换。
返回执行上述操作 恰好一次 后可以获得的 字典序最小 的字符串。
子字符串 是字符串中的一个连续字符序列。
现有长度相同的两个字符串 x 和 字符串 y ，在满足 x[i] != y[i] 的第一个位置 i 上，如果  x[i] 在字母表中先于 y[i] 出现，则认为字符串 x 比字符串 y 字典序更小 。
提示：
1 <= s.length <= 3 * 10^5
s 仅由小写英文字母组成

状态机。子串问题。
相似题目: 1946. 子字符串突变后可能得到的最大整数
https://leetcode.cn/problems/largest-number-after-mutating-substring/
 */