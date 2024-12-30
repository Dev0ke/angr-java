public class Solution2485 {
    public int pivotInteger(int n) {
        for (int i = 1; i <= 1000; i++) {
            if ((1 + i) * i == (i + n) * (n - i + 1)) {
                return i;
            }
        }
        return -1;
    }
}
/*
2485. 找出中枢整数
https://leetcode.cn/problems/find-the-pivot-integer/

第 321 场周赛 T1。

给你一个正整数 n ，找出满足下述条件的 中枢整数 x ：
- 1 和 x 之间的所有元素之和等于 x 和 n 之间所有元素之和。
返回中枢整数 x 。如果不存在中枢整数，则返回 -1 。题目保证对于给定的输入，至多存在一个中枢整数。
提示：
1 <= n <= 1000

枚举
时间复杂度 O(n)
 */