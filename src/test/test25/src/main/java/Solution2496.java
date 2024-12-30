public class Solution2496 {
    public int maximumValue(String[] strs) {
        int max = 0;
        for (String str : strs) {
            int n;
            try {
                n = Integer.parseInt(str);
            } catch (Exception e) {
                n = str.length();
            }
            max = Math.max(max, n);
        }
        return max;
    }
}
/*
2496. 数组中字符串的最大值
https://leetcode.cn/problems/maximum-value-of-a-string-in-an-array/

第 93 场双周赛 T1。

一个由字母和数字组成的字符串的 值 定义如下：
- 如果字符串 只 包含数字，那么值为该字符串在 10 进制下的所表示的数字。
- 否则，值为字符串的 长度 。
给你一个字符串数组 strs ，每个字符串都只由字母和数字组成，请你返回 strs 中字符串的 最大值 。
提示：
1 <= strs.length <= 100
1 <= strs[i].length <= 9
strs[i] 只包含小写英文字母和数字。

库函数 try-catch
 */