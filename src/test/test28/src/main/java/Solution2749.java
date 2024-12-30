public class Solution2749 {
    public int makeTheIntegerZero(int num1, int num2) {
        long delta = num1;
        // https://www.wolframalpha.com/input?i=solve+equation
        // 30 + log_2(x+1) = x, x= 35.177
        for (int k = 1; k <= 36; k++) {
            delta -= num2;
            // 每次最少减 2^0 = 1
            if (delta < k) return -1;
            if (Long.bitCount(delta) <= k) return k;
        }
        return -1;
    }
}
/*
2749. 得到整数零需要执行的最少操作数
https://leetcode.cn/problems/minimum-operations-to-make-the-integer-zero/

第 351 场周赛 T2。

给你两个整数：num1 和 num2 。
在一步操作中，你需要从范围 [0, 60] 中选出一个整数 i ，并从 num1 减去 2i + num2 。
请你计算，要想使 num1 等于 0 需要执行的最少操作数，并以整数形式返回。
如果无法使 num1 等于 0 ，返回 -1 。
提示：
1 <= num1 <= 10^9
-10^9 <= num2 <= 10^9

二进制
减去 2^i 相当于移除二进制 bit 为 1 的值。
相似题目: C. p-binary
https://codeforces.com/contest/1247/problem/C
 */