public class Solution2980 {
    public boolean hasTrailingZeros(int[] nums) {
        int cnt = 0;
        for (int x : nums) {
            if ((x & 1) == 0) {
                cnt++;
            }
        }
        return cnt >= 2;
    }
}
/*
2980. 检查按位或是否存在尾随零
https://leetcode.cn/problems/check-if-bitwise-or-has-trailing-zeros/description/

第 378 场周赛 T1。

给你一个 正整数 数组 nums 。
你需要检查是否可以从数组中选出 两个或更多 元素，满足这些元素的按位或运算（ OR）结果的二进制表示中 至少 存在一个尾随零。
例如，数字 5 的二进制表示是 "101"，不存在尾随零，而数字 4 的二进制表示是 "100"，存在两个尾随零。
如果可以选择两个或更多元素，其按位或运算结果存在尾随零，返回 true；否则，返回 false 。
提示：
2 <= nums.length <= 100
1 <= nums[i] <= 100

枚举，统计是否有 2 个以上
时间复杂度 O(n)
 */