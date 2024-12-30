import java.util.Arrays;

public class Solution918 {
    public int maxSubarraySumCircular(int[] nums) {
        // 求和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int len = nums.length;
        // [0:len-1]
        int ans1 = kadane(nums, 0, len - 1, 1);
        // [1:len-1]
        int ans2 = sum + kadane(nums, 1, len - 1, -1);
        // [0:len-2]
        int ans3 = sum + kadane(nums, 0, len - 2, -1);
        return Math.max(ans1, Math.max(ans2, ans3));
    }

    private int kadane(int[] sum, int i, int j, int sign) {
        // The maximum non-empty subarray for array
        // [sign * A[i], sign * A[i+1], ..., sign * A[j]]
        int ans = Integer.MIN_VALUE / 2;
        int cur = Integer.MIN_VALUE / 2;
        for (int k = i; k <= j; k++) {
            cur = sign * sum[k] + Math.max(cur, 0);
            ans = Math.max(ans, cur);
        }
        return ans;
    }

    public int maxSubarraySumCircular2(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        // case1: 最大数组和在中间，和平时一样解法
        int dp = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp = nums[i] + Math.max(dp, 0);
            max = Math.max(max, dp);
        }

        // case2: 最大数组和是跨越头尾，找中间段最小，和减去最小得最大
        dp = nums[0];
        int min = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            dp = nums[i] + Math.min(dp, 0);
            min = Math.min(min, dp);
        }
        return Math.max(sum - min, max);
    }
}
/*
918. 环形子数组的最大和
https://leetcode.cn/problems/maximum-sum-circular-subarray/

第 105 场周赛 T2。

给定一个长度为 n 的环形整数数组nums，返回nums的非空 子数组 的最大可能和。
环形数组意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i]的前一个元素是 nums[(i - 1 + n) % n] 。
子数组 最多只能包含固定缓冲区nums中的每个元素一次。形式上，对于子数组nums[i], nums[i + 1], ..., nums[j]，不存在i <= k1, k2 <= j其中k1 % n == k2 % n。
提示：
n == nums.length
1 <= n <= 3 * 10^4
-3 * 10^4 <= nums[i] <= 3 * 10^4

Kadane 算法（动态规划）
https://leetcode.cn/problems/maximum-sum-circular-subarray/solution/huan-xing-zi-shu-zu-de-zui-da-he-by-leetcode/
时间复杂度 O(n)
空间复杂度 O(1)
相似题目: 53. 最大子数组和
https://leetcode.cn/problems/maximum-subarray/
 */