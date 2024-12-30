import java.util.Arrays;

public class SolutionP2702 {
    private int[] nums;
    private int x, y;

    public int minOperations(int[] nums, int x, int y) {
        this.nums = nums;
        this.x = x;
        this.y = y;

        int mx = Arrays.stream(nums).max().orElseThrow();

        int left = 1;
        int right = (mx - 1) / y + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean checkMid(int operations) {
        int xTotalRequired = 0;
        int diff = x - y;
        for (int num : nums) {
            int yRequired = (num - 1) / y + 1;
            if (yRequired <= operations) {
                continue;
            }
            int remain = num - y * operations;
            int xRequired = (remain - 1) / diff + 1;
            xTotalRequired += xRequired;
            if (xTotalRequired > operations) {
                return false;
            }
        }
        return true;
    }
}
/*
$2702. 使数字变为非正数的最小操作次数
https://leetcode.cn/problems/minimum-operations-to-make-numbers-non-positive/description/

给定一个 下标从0开始 的整数数组 nums，以及两个整数 x 和 y。在每一次操作中，你需要选择一个满足条件 0 <= i < nums.length 的下标 i ，并执行以下操作：
- 将 nums[i] 减去 x。
- 将除了下标为 i 的位置外，其他位置的值都减去 y。
返回使得 nums 中的所有整数都 小于等于零 所需的最小操作次数。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
1 <= y < x <= 10^9

二分答案。
时间复杂度 O(nlogn)。
 */