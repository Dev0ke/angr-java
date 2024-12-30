public class Solution1869 {
    public boolean checkZeroOnes(String s) {
        int maxOne = maxNum(s, "0");
        int maxZero = maxNum(s, "1");
        return maxOne > maxZero;
    }

    private int maxNum(String s, String split) {
        String[] nums = s.split(split);
        int cnt = 0;
        for (String num : nums) {
            if (num.length() > cnt) {
                cnt = num.length();
            }
        }
        return cnt;
    }
}
/*
1869. 哪种连续子字符串更长
https://leetcode.cn/problems/longer-contiguous-segments-of-ones-than-zeros/

第 242 场周赛 T1。

给你一个二进制字符串 s 。如果字符串中由 1 组成的 最长 连续子字符串 严格长于 由 0 组成的 最长 连续子字符串，返回 true ；否则，返回 false 。
- 例如，s = "110100010" 中，由 1 组成的最长连续子字符串的长度是 2 ，由 0 组成的最长连续子字符串的长度是 3 。
注意，如果字符串中不存在 0 ，此时认为由 0 组成的最长连续子字符串的长度是 0 。字符串中不存在 1 的情况也适用此规则。
提示：
1 <= s.length <= 100
s[i] 不是 '0' 就是 '1'

String#split() 后统计最大值进行比较即可。
 */
