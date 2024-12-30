public class Solution1822 {
    public int arraySign(int[] nums) {
        // 统计 < 0 的个数
        int cnt = 0;
        for (int num : nums) {
            // 剪枝
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                cnt++;
            }
        }
        if (cnt % 2 == 0) {
            return 1;
        }
        return -1;
    }
}
/*
1822. 数组元素积的符号
https://leetcode.cn/problems/sign-of-the-product-of-an-array/

第 236 场周赛 T1。

已知函数 signFunc(x) 将会根据 x 的正负返回特定值：
- 如果 x 是正数，返回 1 。
- 如果 x 是负数，返回 -1 。
- 如果 x 是等于 0 ，返回 0 。
给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。
返回 signFunc(product) 。
提示：
1 <= nums.length <= 1000
-100 <= nums[i] <= 100

正数个数无须统计，因为怎么乘也是正数。
统计负数的个数，若为个数为奇数，则结果为负数
如果中途出现 0，根据 0 乘以任何数都得 0，剪枝返回
 */