import java.util.Arrays;

public class Solution1760 {
    public int minimumSize(int[] nums, int maxOperations) {
        int max = Arrays.stream(nums).max().orElseThrow();

        int left = 1;
        int right = max;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(nums, maxOperations, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 使开销为 mid，能否在 maxOperations 次操作下完成 FFFTTT
    private boolean checkMid(int[] nums, int maxOperations, int mid) {
        int countOperations = 0;
        for (int num : nums) {
            countOperations += (num - 1) / mid;
        }
        return countOperations <= maxOperations;
    }
}
/*
1760. 袋子里最少数目的球
https://leetcode.cn/problems/minimum-limit-of-balls-in-a-bag/

给你一个整数数组 nums ，其中 nums[i] 表示第 i 个袋子里球的数目。同时给你一个整数 maxOperations 。
你可以进行如下操作至多 maxOperations 次：
- 选择任意一个袋子，并将袋子里的球分到 2 个新的袋子中，每个袋子里都有 正整数 个球。
 - 比方说，一个袋子里有 5 个球，你可以把它们分到两个新袋子里，分别有 1 个和 4 个球，或者分别有 2 个和 3 个球。
你的开销是单个袋子里球数目的 最大值 ，你想要 最小化 开销。
请你返回进行上述操作后的最小开销。
提示：
1 <= nums.length <= 10^5
1 <= maxOperations, nums[i] <= 10^9

二分
 */