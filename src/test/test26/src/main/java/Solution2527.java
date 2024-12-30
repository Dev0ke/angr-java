public class Solution2527 {
    public int xorBeauty(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
/*
2527. 查询数组 Xor 美丽值
https://leetcode.cn/problems/find-xor-beauty-of-array/

第 95 场双周赛 T3。

给你一个下标从 0 开始的整数数组 nums 。
三个下标 i ，j 和 k 的 有效值 定义为 ((nums[i] | nums[j]) & nums[k]) 。
一个数组的 xor 美丽值 是数组中所有满足 0 <= i, j, k < n  的三元组 (i, j, k) 的 有效值 的异或结果。
请你返回 nums 的 xor 美丽值。
注意：
- val1 | val2 是 val1 和 val2 的按位或。
- val1 & val2 是 val1 和 val2 的按位与。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9

解法一：通用的做法
位运算的特点：每个比特位互不相干，拆分成每个比特，单独看。
看有多少个 1
((a | b) & c) == 1
c = 1
a|b = 1
a 和 b 不能都是 0
设这个比特位有 y 个 1, x=n-y 个 0
ones = (n^2 - x^2)*y （x^2 为 a 和 b 同时为 0 情况）
     = (n^2 - (n-y)^2)*y
     = (2n-y)*y^2
     = 2ny^2 - y^3
     异或 = y^3 % 2 （2n 为偶数）
看 ones 的奇偶性
=> 看 y 的奇偶性
由于 y 是 1 的个数，所以也可以看成是这个比特位的 0 和 1 异或的结果
解法二：巧妙的做法
((nums[i] | nums[j]) & nums[k]) == 1
用对称性
只有 i=j 对答案有贡献
nums[i] & nums[k]
只有 i=j=k 对答案有贡献
nums[i]
所以答案为 nums[i] 的异或和
 */