import java.util.Arrays;

public class Solution724 {
    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
            if (leftSum - nums[i] == sum - leftSum) {
                return i;
            }
        }
        return -1;
    }
}
/*
724. 寻找数组的中心下标
https://leetcode.cn/problems/find-pivot-index/

给你一个整数数组 nums, 请计算数组的 中心下标 。
数组 中心下标 是数组的一个下标, 其左侧所有元素相加的和等于右侧所有元素相加的和。
如果中心下标位于数组最左端, 那么左侧数之和视为 0, 因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
如果数组有多个中心下标, 应该返回 最靠近左边 的那一个。如果数组不存在中心下标, 返回 -1.
提示：
1 <= nums.length <= 10^4
-1000 <= nums[i] <= 1000
注意：本题与主站 1991 题相同：https://leetcode.cn/problems/find-the-middle-index-in-array/

枚举中心点即可。
时间复杂度 O(n)
空间复杂度 O(1)
 */