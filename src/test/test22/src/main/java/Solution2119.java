public class Solution2119 {
    public boolean isSameAfterReversals(int num) {
        if (num == 0) {
            return true;
        }
        return num % 10 != 0;
    }
}
/*
2119. 反转两次的数字
https://leetcode.cn/problems/a-number-after-a-double-reversal/

第 273 场周赛 T1。

反转 一个整数意味着倒置它的所有位。
例如，反转 2021 得到 1202 。反转 12300 得到 321 ，不保留前导零 。
给你一个整数 num ，反转 num 得到 reversed1 ，接着反转 reversed1 得到 reversed2 。如果 reversed2 等于 num ，返回 true ；否则，返回 false 。

末位为 0 的都不能反转（0 是特例）。
 */