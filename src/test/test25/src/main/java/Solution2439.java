import java.util.Arrays;

public class Solution2439 {
    public int minimizeArrayValue(int[] nums) {
        // 二分下界为 nums[0]，上界为 max(nums[i])
        int left = nums[0];
        int right = Arrays.stream(nums).max().orElseThrow();
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(nums, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean checkMid(int[] nums, int mid) {
        long remain = 0L;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > mid) {
                remain += nums[i] - mid;
            } else if (nums[i] < mid) {
                remain -= Math.min(remain, mid - nums[i]);
            }
        }
        return remain == 0;
    }

    // O(n) 解法
    public int minimizeArrayValue2(int[] nums) {
        long res = nums[0];
        long sum = 0;
        long cnt = 0;
        for (int num : nums) {
            cnt++;
            sum += num;
            // 数论上取整
            long avg = ((sum + cnt - 1) / cnt);
            res = Math.max(res, avg);
        }
        return (int) res;
    }

    // O(n) 解法
    public int minimizeArrayValue3(int[] nums) {
        long sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // 数论向上取整法
            max = (int) Math.max(max, (sum + i) / (i + 1));
        }
        return max;
    }
}
/*
2439. 最小化数组中的最大值
https://leetcode.cn/problems/minimize-maximum-of-array/

第 89 场双周赛 T3。

给你一个下标从 0 开始的数组 nums ，它含有 n 个非负整数。
每一步操作中，你需要：
- 选择一个满足 1 <= i < n 的整数 i ，且 nums[i] > 0 。
- 将 nums[i] 减 1 。
- 将 nums[i - 1] 加 1 。
你可以对数组执行 任意 次上述操作，请你返回可以得到的 nums 数组中 最大值 最小 为多少。
提示：
n == nums.length
2 <= n <= 10^5
0 <= nums[i] <= 10^9

二分。想象有一个推土机，从右推到左，最后是否有剩余的土。
 */