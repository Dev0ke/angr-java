import java.util.Arrays;

public class Solution1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        // 正负数分隔下标 有 idx 个负数
        int idx0 = binarySearchLeftBound(nums, 0);
        boolean has0 = Arrays.binarySearch(nums, 0) >= 0;
        // 贪心
        // step1 优先考虑将负数替换为正数
        // step2 如果负数调整完还有盈余，存在 0，对 0 下手。
        // step3 如果已经没有负数或 0，挑最小的正数下手
        int i = 0;
        while (i < idx0 && i < k) {
            nums[i] = -nums[i];
            i++;
        }
        int remain = k - i;
        if (remain > 0) {
            // 不存在 0
            if (!has0) {
                int min = Arrays.stream(nums).min().orElseThrow();
                if (remain % 2 == 1) {
                    return Arrays.stream(nums).sum() - min - min;
                }
            }
        }
        return Arrays.stream(nums).sum();
    }

    private int binarySearchLeftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left;
    }
}
/*
1005. K 次取反后最大化的数组和
https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations/

第 127 场周赛 T1。

给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
- 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
以这种方式修改数组后，返回数组 可能的最大和 。
提示：
1 <= nums.length <= 10^4
-100 <= nums[i] <= 100
1 <= k <= 104
 */