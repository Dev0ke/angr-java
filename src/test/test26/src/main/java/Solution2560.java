import java.util.Arrays;

public class Solution2560 {
    public int minCapability(int[] nums, int k) {
        int left = Arrays.stream(nums).min().orElseThrow();
        int right = Arrays.stream(nums).max().orElseThrow();
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean checkMid(int[] nums, int k, int mid) {
        int n = nums.length;
        int[] f = new int[n];
        f[0] = nums[0] <= mid ? 1 : 0;
        f[1] = nums[1] <= mid ? 1 : f[0];
        for (int i = 2; i < n; i++) {
            if (nums[i] <= mid) {
                f[i] = Math.max(f[i - 1], f[i - 2] + 1);
            } else {
                f[i] = f[i - 1];
            }
        }
        return f[n - 1] >= k;
    }
}
/*
2560. 打家劫舍 IV
https://leetcode.cn/problems/house-robber-iv/

第 331 场周赛 T3。

沿街有一排连续的房屋。每间房屋内都藏有一定的现金。现在有一位小偷计划从这些房屋中窃取现金。
由于相邻的房屋装有相互连通的防盗系统，所以小偷 不会窃取相邻的房屋 。
小偷的 窃取能力 定义为他在窃取过程中能从单间房屋中窃取的 最大金额 。
给你一个整数数组 nums 表示每间房屋存放的现金金额。形式上，从左起第 i 间房屋中放有 nums[i] 美元。
另给你一个整数数组 k ，表示窃贼将会窃取的 最少 房屋数。小偷总能窃取至少 k 间房屋。
返回小偷的 最小 窃取能力。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
1 <= k <= (nums.length + 1)/2

二分 + 动态规划
时间复杂度 O(nlogn)
相似题目: 198. 打家劫舍
https://leetcode.cn/problems/house-robber/
 */