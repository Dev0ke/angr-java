public class Solution1017 {
    public String baseNeg2(int n) {
        int max_val = 0x55555555; // 最大值。所有的偶数位全部都为 1，奇数位全为 0
        int ans = max_val ^ (max_val - n);
        return Integer.toBinaryString(ans);
    }
}
/*
1017. 负二进制转换
https://leetcode.cn/problems/convert-to-base-2/description/

给你一个整数 n ，以二进制字符串的形式返回该整数的 负二进制（base -2）表示。
注意，除非字符串就是 "0"，否则返回的字符串中不能含有前导零。
提示：
0 <= n <= 10^9

数学。
最大值即所有的偶数位全部都为 1，奇数位全为 0，最大值即为 0x55555555
最小值即所有的偶数位全部都为 0，奇数位全为 1，最小值即为 0xAAAAAAAA
设 maxVal 与 n 的差为 diff，则此时 diff=maxVal−n，如果我们将 maxVal 在「负二进制」表示下减去 diff，那么得到的「负二进制」一定为 n 的「负二进制」。
已知 maxVal 中的偶数位全为 1，奇数位全为 0，此时的减法操作可以用异或来实现:
「负二进制」减法等同于 maxVal xor diff
相似题目: 1073. 负二进制数相加
https://leetcode.cn/problems/adding-two-negabinary-numbers/description/
 */