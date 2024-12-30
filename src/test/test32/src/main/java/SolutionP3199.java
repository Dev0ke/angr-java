public class SolutionP3199 {
    public int tripletCount(int[] a, int[] b, int[] c) {
        int[] d1 = f(a);
        int[] d2 = f(b);
        int[] d3 = f(c);
        return d1[0] * d2[0] * d3[0] + d1[0] * d2[1] * d3[1] + d1[1] * d2[0] * d3[1] + d1[1] * d2[1] * d3[0];
    }

    private int[] f(int[] a) {
        int[] d = new int[2];
        for (int num : a) {
            d[Integer.bitCount(num) % 2]++;
        }
        return d;
    }
}
/*
$3199. 用偶数异或设置位计数三元组 I
https://leetcode.cn/problems/count-triplets-with-even-xor-set-bits-i/description/

给定三个整数数组 a，b 和 c，返回组内元素按位 XOR 有 偶数 个 设置位 的三元组 (a[i], b[j], c[k]) 的数量。
提示：
1 <= a.length, b.length, c.length <= 100
0 <= a[i], b[i], c[i] <= 100

相似题目: $3215. 用偶数异或设置位计数三元组 II
https://leetcode.cn/problems/count-triplets-with-even-xor-set-bits-ii/description/
 */