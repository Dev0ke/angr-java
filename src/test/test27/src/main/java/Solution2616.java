import java.util.Arrays;

public class Solution2616 {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i] - nums[i - 1]);
        }

        int left = 0;
        int right = max;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(nums, p, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean checkMid(int[] nums, int p, int mid) {
        int cnt = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] <= mid) {
                cnt++;
                i++;
            }
        }
        return cnt >= p;
    }
}
/*
2616. 最小化数对的最大差值
https://leetcode.cn/problems/minimize-the-maximum-difference-of-pairs/

第 340 场周赛 T3。

给你一个下标从 0 开始的整数数组 nums 和一个整数 p 。请你从 nums 中找到 p 个下标对，每个下标对对应数值取差值，你需要使得这 p 个差值的 最大值 最小。同时，你需要确保每个下标在这 p 个下标对中最多出现一次。
对于一个下标对 i 和 j ，这一对的差值为 |nums[i] - nums[j]| ，其中 |x| 表示 x 的 绝对值 。
请你返回 p 个下标对对应数值 最大差值 的 最小值 。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^9
0 <= p <= (nums.length)/2

二分查找 + 贪心。
排序后，基于贪心写 check 函数。
时间复杂度 O(nlogn + nlogU)，其中 n = nums.length, U = max(nums[i]) - min(nums[i])
 */