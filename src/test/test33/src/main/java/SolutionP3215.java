public class SolutionP3215 {
    public long tripletCount(int[] a, int[] b, int[] c) {
        long[] d1 = f(a);
        long[] d2 = f(b);
        long[] d3 = f(c);
        return d1[0] * d2[0] * d3[0] + d1[0] * d2[1] * d3[1] + d1[1] * d2[0] * d3[1] + d1[1] * d2[1] * d3[0];
    }

    private long[] f(int[] a) {
        long[] d = new long[2];
        for (int num : a) {
            d[Integer.bitCount(num) % 2]++;
        }
        return d;
    }
}
/*
$3215. 用偶数异或设置位计数三元组 II
https://leetcode.cn/problems/count-triplets-with-even-xor-set-bits-ii/description/

给定三个整数数组 a，b 和 c，返回组内元素按位 XOR 有 偶数 个 设置位 的三元组 (a[i], b[j], c[k]) 的数量。
提示：
1 <= a.length, b.length, c.length <= 10^5
0 <= a[i], b[i], c[i] <= 10^9

a ^ b 的设置位数是偶数, 那么a和b的设置位数的奇偶性一定一致;
如果a和b的设置位数的奇偶性一致, 那么a ^ b 的设置位数一定是偶数
https://leetcode.cn/problems/count-triplets-with-even-xor-set-bits-ii/solutions/2840346/wei-yun-suan-by-leetcode_syz-1q2s/
相似题目: $3199. 用偶数异或设置位计数三元组 I
https://leetcode.cn/problems/count-triplets-with-even-xor-set-bits-i/description/
 */
