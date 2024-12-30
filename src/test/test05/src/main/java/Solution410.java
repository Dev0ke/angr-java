public class Solution410 {
    public int splitArray(int[] nums, int m) {
        // 二分查找，[left, right] = [max, sum]
        int max = 0;
        int sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        int left = max;
        int right = sum;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(nums, m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 连续子数组和不超过 mid，判断分割数目是否满足(< m)
    private boolean checkMid(int[] nums, int m, int mid) {
        int cur = 0;
        int idx = 0;
        int cnt = 0;
        while (idx < nums.length) {
            if (cur + nums[idx] <= mid) {
                cur += nums[idx];
            } else {
                cnt++;
                cur = nums[idx];
            }
            idx++;
        }
        return cnt < m;
    }
}
/*
410. 分割数组的最大值
https://leetcode.cn/problems/split-array-largest-sum/

给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
设计一个算法使得这 m 个子数组各自和的最大值最小。
提示：
1 <= nums.length <= 1000
0 <= nums[i] <= 10^6
1 <= m <= min(50, nums.length)

左边界二分。
 */