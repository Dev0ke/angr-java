public class Solution1611 {
    public int minimumOneBitOperations(int n) {
        int ans = 0;
        while (n > 0) {
            ans ^= n;
            n >>= 1;
        }
        return ans;
    }
}
/*
1611. 使整数变为 0 的最少操作次数
https://leetcode.cn/problems/minimum-one-bit-operations-to-make-integers-zero/description/

给你一个整数 n，你需要重复执行多次下述操作将其转换为 0 ：
- 翻转 n 的二进制表示中最右侧位（第 0 位）。
- 如果第 (i-1) 位为 1 且从第 (i-2) 位到第 0 位都为 0，则翻转 n 的二进制表示中的第 i 位。
返回将 n 转换为 0 的最小操作次数。
提示：
0 <= n <= 10^9

格雷码
相似题目: 1404. 将二进制表示减到 1 的步骤数
https://leetcode.cn/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/description/
1558. 得到目标数组的最少函数调用次数
https://leetcode.cn/problems/minimum-numbers-of-function-calls-to-make-target-array/description/
89. 格雷编码
https://leetcode.cn/problems/gray-code/
 */