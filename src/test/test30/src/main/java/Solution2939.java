public class Solution2939 {
    private static final int MOD = (int) (1e9 + 7);

    public int maximumXorProduct(long a, long b, int n) {
        if (a < b) {
            long tmp = a;
            a = b;
            b = tmp;
        }

        long ax = 0, bx = 0;
        for (int i = 49; i >= n; i--) {
            long bitA = a >> i & 1, bitB = b >> i & 1;
            ax |= bitA << i;
            bx |= bitB << i;
        }
        // 如果 ax 已经比 bx 大，就全分给 bx
        boolean toB = ax > bx;

        for (int i = n - 1; i >= 0; i--) {
            long bitA = a >> i & 1, bitB = b >> i & 1;
            // (0^1) * (0^1) = 1
            if (bitA == bitB) {
                ax |= 1L << i;
                bx |= 1L << i;
                continue;
            }
            if (!toB) {
                ax |= 1L << i;
                toB = true;
            } else {
                bx |= 1L << i;
            }
        }
        return (int) (ax % MOD * (bx % MOD) % MOD);
    }

    public int maximumXorProduct2(long a, long b, int n) {
        if (a < b) {
            long tmp = a;
            a = b;
            b = tmp;
        }

        long full = (1L << n) - 1;
        long ax = a & ~full; // 无法通过 XOR x 修改的部分
        long bx = b & ~full;
        a &= full; // 保留低于 n 的比特位
        b &= full;

        long left = a ^ b; // 其中一个是 1，另一个是 0 的那些比特位
        long one = full ^ left; // a 和 b 在这个比特位全为 0 或者全为 1
        ax |= one; // 异或结果一定是 1，先加到异或结果中
        bx |= one;

        // 接下来就是分配 left
        if (left > 0 && ax == bx) {
            long highBit = 1L << (63 - Long.numberOfLeadingZeros(left));
            ax |= highBit;
            left ^= highBit; // 从 left 中去掉最高比特位
        }
        // 剩下的都给 bx
        bx |= left;

        return (int) (ax % MOD * (bx % MOD) % MOD);
    }
}
/*
2939. 最大异或乘积
https://leetcode.cn/problems/maximum-xor-product/description/

第 372 场周赛 T3。

给你三个整数 a ，b 和 n ，请你返回 (a XOR x) * (b XOR x) 的 最大值 且 x 需要满足 0 <= x < 2^n。
由于答案可能会很大，返回它对 10^9 + 7 取余 后的结果。
注意，XOR 是按位异或操作。
提示：
0 <= a, b < 2^50
0 <= n <= 50

(a XOR x) * (b XOR x)
---
a b x
0 0 0 (0^0) * (0^0) = 0
0 1 0 (0^0) * (1^0) = 0
1 0 0 (1^0) * (0^0) = 0
1 1 0 (1^0) * (1^0) = 1
0 0 1 (0^1) * (0^1) = 1
0 1 1 (0^1) * (1^1) = 0
1 0 1 (1^1) * (0^1) = 0
1 1 1 (1^1) * (1^1) = 0
---
位运算
1、对于同一个比特位，如果一个是 0 另一个是 1，那么 x 无论填 0 还是 1
这个地方的异或结果总是 一个是 0 另一个是 1
2、推论1：在把同为 0 的比特位改成 1 之后，1 的总个数是不变的
3、推论2：ax = a^x, bx = b^x, ax + bx 是一个定值
在 ax + bx 是一个定值的情况下，求 ax * bx 的最大值
均值定理 基本不等式
4、结论：让 ax 和 bx 尽量接近（差的绝对值）
5、分配方案：把最高位的 1 给 ax，其余的 1 给 bx
 */