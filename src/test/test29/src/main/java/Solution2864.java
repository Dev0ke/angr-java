public class Solution2864 {
    public String maximumOddBinaryNumber(String s) {
        int n = s.length();
        int cnt1 = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                cnt1++;
            }
        }
        return "1".repeat(cnt1 - 1) + "0".repeat(n - cnt1) + "1";
    }
}
/*
2864. 最大二进制奇数
https://leetcode.cn/problems/maximum-odd-binary-number/

第 364 场周赛 T1。

给你一个 二进制 字符串 s ，其中至少包含一个 '1' 。
你必须按某种方式 重新排列 字符串中的位，使得到的二进制数字是可以由该组合生成的 最大二进制奇数 。
以字符串形式，表示并返回可以由给定组合生成的最大二进制奇数。
注意 返回的结果字符串 可以 含前导零。
提示：
1 <= s.length <= 100
s 仅由 '0' 和 '1' 组成
s 中至少包含一个 '1'

贪心。把一个 1 放最后，其余的放最高位。
 */