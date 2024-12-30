public class Solution1750 {
    public int minimumLength(String s) {
        int len = s.length();

        int left = 0;
        int right = len - 1;
        while (left < right && s.charAt(left) == s.charAt(right)) {
            char ch = s.charAt(left);
            while (left <= right && s.charAt(left) == ch) {
                left++;
            }
            while (left <= right && s.charAt(right) == ch) {
                right--;
            }
        }
        return right - left + 1;
    }
}
/*
1750. 删除字符串两端相同字符后的最短长度
https://leetcode.cn/problems/minimum-length-of-string-after-deleting-similar-ends/

给你一个只包含字符 'a'，'b' 和 'c' 的字符串 s ，你可以执行下面这个操作（5 个步骤）任意次：
1.选择字符串 s 一个 非空 的前缀，这个前缀的所有字符都相同。
2.选择字符串 s 一个 非空 的后缀，这个后缀的所有字符都相同。
3.前缀和后缀在字符串中任意位置都不能有交集。
4.前缀和后缀包含的所有字符都要相同。
5.同时删除前缀和后缀。
请你返回对字符串 s 执行上面操作任意次以后（可能 0 次），能得到的 最短长度 。
提示：
1 <= s.length <= 10^5
s 只包含字符 'a'，'b' 和 'c' 。

模拟。双指针。
 */