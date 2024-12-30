public class Solution665 {
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i + 1 < n; i++) {
            if (nums[i] > nums[i + 1]) {
                cnt++;
                if (cnt > 1) {
                    return false;
                }
                if (i - 1 >= 0 && nums[i - 1] > nums[i + 1]) {
                    nums[i + 1] = nums[i];
                }
            }
        }
        return true;
    }
}
/*
665. 非递减数列
https://leetcode.cn/problems/non-decreasing-array/

给你一个长度为 n 的整数数组 nums ，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
提示：
n == nums.length
1 <= n <= 10^4
-10^5 <= nums[i] <= 10^5

贪心。
Q：要使数组 nums 变成一个非递减数列，数组中至多有多少个 i 满足 nums[i] > nums[i+1]？
A：至多一个
还要在此基础上修改数组，判断改好数组是否非递减。
 */