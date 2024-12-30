import java.util.Arrays;

public class Solution1991 {
    public int findMiddleIndex(int[] nums) {
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
1991. 找到数组的中间位置
https://leetcode.cn/problems/find-the-middle-index-in-array/

第 60 场双周赛 T1。

给你一个下标从 0 开始的整数数组 nums ，请你找到 最左边 的中间位置 middleIndex （也就是所有可能中间位置下标最小的一个）。
中间位置 middleIndex 是满足
nums[0] + nums[1] + ... + nums[middleIndex-1] == nums[middleIndex+1] + nums[middleIndex+2] + ... + nums[nums.length-1] 的数组下标。
如果 middleIndex == 0 ，左边部分的和定义为 0 。类似的，如果 middleIndex == nums.length - 1 ，右边部分的和定义为 0 。
请你返回满足上述条件 最左边 的 middleIndex ，如果不存在这样的中间位置，请你返回 -1 。
提示：
1 <= nums.length <= 100
-1000 <= nums[i] <= 1000

同: 724. 寻找数组的中心下标
https://leetcode.cn/problems/find-pivot-index/
 */