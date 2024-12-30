import java.util.Arrays;

public class Solution1509 {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n <= 4) return 0;
        Arrays.sort(nums);
        int span = n - 3;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i + span - 1 < n; i++) {
            ans = Math.min(ans, nums[i + span - 1] - nums[i]);
        }
        return ans;
    }
}
/*
1509. 三次操作后最大值与最小值的最小差
https://leetcode.cn/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/description/

给你一个数组 nums 。
每次操作你可以选择 nums 中的任意一个元素并将它改成 任意值 。
在 执行最多三次移动后 ，返回 nums 中最大值与最小值的最小差值。
提示：
1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9

贪心 + 滑动窗口。三次操作等于移除掉 3 个元素。
时间复杂度 O(nlogn)
 */