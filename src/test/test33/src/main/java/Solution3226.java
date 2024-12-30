public class Solution3226 {
    public int minChanges(int n, int k) {
        if ((n & k) == k) {
            return Integer.bitCount(n) - Integer.bitCount(k);
        }
        return -1;
    }
}
/*
3226. 使两个整数相等的位更改次数
https://leetcode.cn/problems/number-of-bit-changes-to-make-two-integers-equal/description/

第 407 场周赛 T1。

给你两个正整数 n 和 k。
你可以选择 n 的 二进制表示 中任意一个值为 1 的位，并将其改为 0。
返回使得 n 等于 k 所需要的更改次数。如果无法实现，返回 -1。
提示：
1 <= n, k <= 10^6

位运算。先判断 n 是否包含 k，如果包含，答案就是 1 数量的差值。
时间复杂度 O(logU)。
 */