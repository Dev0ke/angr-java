import java.util.Arrays;

public class Solution2563 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        Arrays.sort(nums);

        long res = 0L;
        for (int i = 0; i < n; i++) {
            // 左边界 nums[i] + nums[j] >= lower; nums[j] >= lower - nums[i];
            int l0 = i + 1;
            int r0 = n;
            while (l0 < r0) {
                int mid = l0 + (r0 - l0) / 2;
                if (nums[mid] >= lower - nums[i]) {
                    r0 = mid;
                } else {
                    l0 = mid + 1;
                }
            }
            int left = l0;

            // 右边界 nums[i] + nums[j] <= upper; nums[j] <= upper - nums[i];
            int l1 = i + 1;
            int r1 = n;
            while (l1 < r1) {
                int mid = l1 + (r1 - l1) / 2;
                if (nums[mid] > upper - nums[i]) {
                    r1 = mid;
                } else {
                    l1 = mid + 1;
                }
            }
            int right = l1 - 1;

            res += right - left + 1;
        }
        return res;
    }
}
/*
2563. 统计公平数对的数目
https://leetcode.cn/problems/count-the-number-of-fair-pairs/

第 332 场周赛 T2。

给你一个下标从 0 开始、长度为 n 的整数数组 nums ，和两个整数 lower 和 upper ，返回 公平数对的数目 。
如果 (i, j) 数对满足以下情况，则认为它是一个 公平数对 ：
- 0 <= i < j < n，且
- lower <= nums[i] + nums[j] <= upper
提示：
1 <= nums.length <= 10^5
nums.length == n
-10^9 <= nums[i] <= 10^9
-10^9 <= lower <= upper <= 10^9

排序 + 二分查找
相似题目: 34. 在排序数组中查找元素的第一个和最后一个位置
https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 */