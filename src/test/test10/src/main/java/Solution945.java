import java.util.Arrays;

public class Solution945 {
    public int minIncrementForUnique(int[] nums) {
        int cnt = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                int increase = nums[i - 1] - nums[i] + 1;
                nums[i] += increase;
                cnt += increase;
            }
        }
        return cnt;
    }
}
/*
945. 使数组唯一的最小增量
https://leetcode.cn/problems/minimum-increment-to-make-array-unique/

第 112 场周赛 T1。

给你一个整数数组 nums 。每次 move 操作将会选择任意一个满足 0 <= i < nums.length 的下标 i，并将 nums[i] 递增 1。
返回使 nums 中的每个值都变成唯一的所需要的最少操作次数。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^5

排序后，后一个数 增加到刚好大于 前一个数 即可。
排序时间复杂度 O(nlogn)
 */