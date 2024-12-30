import java.util.Arrays;

public class Solution561 {
    public int arrayPairSum(int[] nums) {
        // 长度为 2n 的整数数组 nums
        int n = nums.length / 2;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < n; i++) {
            // 贪心
            res += nums[i * 2];
        }
        return res;
    }
}
/*
561. 数组拆分 I
https://leetcode.cn/problems/array-partition-i/

给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到 n 的 min(ai, bi) 总和最大。
返回该 最大总和 。
提示：
1 <= n <= 10^4
nums.length == 2 * n
-10^4 <= nums[i] <= 10^4

贪心。
 */