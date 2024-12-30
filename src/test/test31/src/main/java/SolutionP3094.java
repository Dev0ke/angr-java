public class SolutionP3094 {
    static class Solution extends Problem {
        static final int TOTAL_BITS = 30;

        public int findNumber() {
            int n = 0;
            int zeroBits = commonBits(0);
            for (int i = 0; i < TOTAL_BITS; i++) {
                if (commonBits(1 << i) > zeroBits) {
                    n |= 1 << i;
                }
                commonBits(1 << i);
            }
            return n;
        }
    }

    static class Problem {
        int commonBits(int num) {
            return -1;
        }
    }
}
/*
$3094. 使用按位查询猜测数字 II
https://leetcode.cn/problems/guess-the-number-using-bitwise-questions-ii/description/

你需要找到一个在 0 和 230 - 1 （均包含）之间的数字 n。
有一个预定义的 API int commonBits(int num) 能帮助你完成任务。但挑战是每次你调用这个函数，n 都会以某种方式改变。但是记住，你需要找到的是 n 的 初始值。
commonBits(int num) 的操作如下：
- 计算 n 和 num 的二进制表示中值相同的二进制位的位的数量 count。
- n = n XOR num
- 返回 count。
返回数字 n。
注意：在这个世界中，所有数字都在 0 和 230 - 1 之间（均包含），因此在计算公共二进制位时，我们只看那些数字的前 30 个二进制位。
提示：
0 <= n <= 2^30 - 1
0 <= num <= 2^30 - 1
如果你查询的 num 超出了给定的范围，输出将会是不可靠的。

https://leetcode.cn/problems/guess-the-number-using-bitwise-questions-ii/solutions/2737360/3094-shi-yong-an-wei-cha-xun-cai-ce-shu-w4z62/
相似题目: 3064. 使用按位查询猜测数字 I
https://leetcode.cn/problems/guess-the-number-using-bitwise-questions-i/description/
 */