public class Solution2544 {
    public int alternateDigitSum(int n) {
        boolean positive = true;
        int res = 0;
        while (n > 0) {
            res += (positive ? 1 : -1) * (n % 10);
            n /= 10;
            positive = !positive;
        }
        return positive ? -res : res;
    }
}
/*
2544. 交替数字和
https://leetcode.cn/problems/alternating-digit-sum/

第 329 场周赛 T1。

给你一个正整数 n 。n 中的每一位数字都会按下述规则分配一个符号：
- 最高有效位 上的数字分配到 正 号。
- 剩余每位上数字的符号都与其相邻数字相反。
返回所有数字及其对应符号的和。
提示：
1 <= n <= 10^9

模拟
 */