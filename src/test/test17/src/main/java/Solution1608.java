import java.util.Arrays;

public class Solution1608 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;

        // nums 中恰好有 x 个元素 大于或者等于 x
        for (int x = 0; x <= len; x++) {
            for (int i = 0; i < len; i++) {
                if (x <= nums[i]) {
                    if (len - i == x) {
                        return x;
                    } else {
                        break;
                    }
                }
            }
        }
        return -1;
    }

    // 朴素二分 时间复杂度 O(nlogn)
    public int specialArray2(int[] nums) {
        int len = nums.length;

        int left = 0;
        int right = len + 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // nums 中恰好有 x 个元素 大于或者等于 x
            int cnt = 0;
            for (int num : nums) {
                if (num >= mid) {
                    cnt++;
                }
            }

            // 朴素二分
            if (cnt < mid) {
                right = mid - 1;
            } else if (cnt > mid) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
/*
1608. 特殊数组的特征值
https://leetcode.cn/problems/special-array-with-x-elements-greater-than-or-equal-x/

给你一个非负整数数组 nums 。如果存在一个数 x ，使得 nums 中恰好有 x 个元素 大于或者等于 x ，那么就称 nums 是一个 特殊数组 ，而 x 是该数组的 特征值 。
注意： x 不必 是 nums 的中的元素。
如果数组 nums 是一个 特殊数组 ，请返回它的特征值 x 。否则，返回 -1 。可以证明的是，如果 nums 是特殊数组，那么其特征值 x 是 唯一的 。
提示：
1 <= nums.length <= 100
0 <= nums[i] <= 1000

模拟/二分
时间复杂度 O(n^2) n 范围不会超过 100
 */