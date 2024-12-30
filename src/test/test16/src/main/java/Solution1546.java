import java.util.HashSet;
import java.util.Set;

public class Solution1546 {
    public int maxNonOverlapping(int[] nums, int target) {
        int preSum = 0;
        Set<Integer> set = new HashSet<>();
        int cnt = 0;
        for (int num : nums) {
            preSum += num;
            if (preSum == target || set.contains(preSum - target)) {
                preSum = 0;
                set.clear();
                cnt++;
            } else {
                set.add(preSum);
            }
        }
        return cnt;
    }
}
/*
1546. 和为目标值且不重叠的非空子数组的最大数目
https://leetcode.cn/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/

给你一个数组 nums 和一个整数 target 。
请你返回 非空不重叠 子数组的最大数目，且每个子数组中数字和都为 target 。
提示：
1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
0 <= target <= 10^6

前缀和 + 贪心 + 哈希表
 */