import java.util.HashMap;
import java.util.Map;

public class Solution697 {
    public int findShortestSubArray(int[] nums) {
        int maxC = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            int c = cnt.merge(x, 1, Integer::sum);
            maxC = Math.max(maxC, c);
        }
        cnt.clear();

        int n = nums.length;
        int ans = n;
        int l = 0, r = 0;
        while (r < n) {
            cnt.merge(nums[r], 1, Integer::sum);
            while (cnt.get(nums[r]) == maxC) {
                ans = Math.min(ans, r - l + 1);
                cnt.merge(nums[l], -1, Integer::sum);
                l++;
            }
            r++;
        }
        return ans;
    }
}
/*
697. 数组的度
https://leetcode.cn/problems/degree-of-an-array/description/

给定一个非空且只包含非负数的整数数组 nums，数组的 度 的定义是指数组里任一元素出现频数的最大值。
你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
提示：
nums.length 在 1 到 50,000 范围内。
nums[i] 是一个在 0 到 49,999 范围内的整数。

双指针 + 滑动窗口
时间复杂度 O(n)。
 */