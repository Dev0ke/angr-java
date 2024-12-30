import java.util.Arrays;

public class Solution1838 {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, l = 0, r = 0, ans = 0;
        long sum = 0;
        while (r < n) {
            sum += nums[r];
            while (sum + k < nums[r] * (r - l + 1L)) { // 无法在最多 k 次操作后“抹平”
                sum -= nums[l];
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}
/*
1838. 最高频元素的频数
https://leetcode.cn/problems/frequency-of-the-most-frequent-element/

第 238 场周赛 T2。

元素的 频数 是该元素在一个数组中出现的次数。
给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。
执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5
1 <= k <= 10^5

不定长滑动窗口（求最长/最大）。
排序后滑窗。
时间复杂度 O(nlogn)
 */