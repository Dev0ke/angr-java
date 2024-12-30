public class Solution2550 {
    private static final int MOD = (int) (1e9 + 7);

    public int monkeyMove(int n) {
        // 2^n - 2
        long res = (quickPow(2, n) - 2 + MOD) % MOD;
        return (int) res;
    }

    // 模下的 a^b
    private long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}
/*
2550. 猴子碰撞的方法数
https://leetcode.cn/problems/count-collisions-of-monkeys-on-a-polygon/

第 330 场周赛 T2。

现在有一个正凸多边形，其上共有 n 个顶点。顶点按顺时针方向从 0 到 n - 1 依次编号。每个顶点上 正好有一只猴子 。下图中是一个 6 个顶点的凸多边形。
每个猴子同时移动到相邻的顶点。顶点 i 的相邻顶点可以是：
- 顺时针方向的顶点 (i + 1) % n ，或
- 逆时针方向的顶点 (i - 1 + n) % n 。
如果移动后至少有两个猴子位于同一顶点，则会发生 碰撞 。
返回猴子至少发生 一次碰撞 的移动方法数。由于答案可能非常大，请返回对 10^9+7 取余后的结果。
注意，每只猴子只能移动一次。
提示：
3 <= n <= 10^9

数学。快速幂。
观察规律，正难则反。一共有 2^n 种方案，只有 2 种不会发生碰撞。结果为 2^n - 2
 */