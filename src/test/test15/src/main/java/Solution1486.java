public class Solution1486 {
    // 模拟 O(n)
    public int xorOperation(int n, int start) {
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans ^= (start + i * 2);
        }
        return ans;
    }

    // 数学 O(1)
    public int xorOperation2(int n, int start) {
        int s = start >> 1, e = n & start & 1;
        int ret = sumXor(s - 1) ^ sumXor(s + n - 1);
        return ret << 1 | e;
    }

    private int sumXor(int x) {
        if (x % 4 == 0) return x;
        else if (x % 4 == 1) return 1;
        else if (x % 4 == 2) return x + 1;
        return 0;
    }
}
/*
1486. 数组异或操作
https://leetcode.cn/problems/xor-operation-in-an-array/description/

给你两个整数，n 和 start 。
数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
请返回 nums 中所有元素按位异或（XOR）后得到的结果。
提示：
1 <= n <= 1000
0 <= start <= 1000
n == nums.length

\forall k\in Z，有4i \oplus (4i+1) \oplus (4i+2) \oplus (4i+3) = 0

sumXor(x)=
\begin{cases}
x, & x=4k,k\in Z \\
(x-1) \oplus x, & x=4k+1,k\in Z \\
(x-2) \oplus (x-1) \oplus x, & x=4k+2,k\in Z \\
(x-3) \oplus (x-2) \oplus (x-1) \oplus x, & x=4k+3,k\in Z
\end{cases}

sumXor(x)=
\begin{cases}
x, & x=4k,k\in Z \\
1, & x=4k+1,k\in Z \\
x+1, & x=4k+2,k\in Z \\
0, & x=4k+3,k\in Z
\end{cases}
 */