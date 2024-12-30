public class SolutionP3064 {
    static class Solution extends Problem {
        static final int TOTAL_BITS = 30;

        public int findNumber() {
            int n = 0;
            for (int i = 0; i < TOTAL_BITS; i++) {
                if (commonSetBits(1 << i) > 0) {
                    n |= 1 << i;
                }
            }
            return n;
        }
    }

    static class Problem {
        int commonSetBits(int num) {
            return -1;
        }
    }
}
/*
$3064. 使用按位查询猜测数字 I
https://leetcode.cn/problems/guess-the-number-using-bitwise-questions-i/description/

你需要找到一个数字 n。
这里有一个预定义的 API int commonSetBits(int num)，它返回 n 和 num 在二进制表示的同一位置上都是 1 的位数。换句话说，它返回 n & num 的 设置位 数量，其中 & 是按位 AND 运算符。
返回数字 n。
提示：
1 <= n <= 2^30 - 1
0 <= num <= 2^30 - 1
如果你查询的 num 超出了给定的范围，输出就不可靠。

逐位遍历
时间复杂度 O(30)
相似题目: 3094. 使用按位查询猜测数字 II
https://leetcode.cn/problems/guess-the-number-using-bitwise-questions-ii/description/
 */