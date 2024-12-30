public class Solution1712 {
    private static final int MOD = (int) (1e9 + 7);

    public int waysToSplit(int[] nums) {
        int len = nums.length;

        // 前缀和
        int[] preSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        // 三部分 [0,i] [i+1,j] [j+1,len-1]
        // 对每个 i，找出 j 的下界和上界
        long cnt = 0;
        for (int i = 0; i < len; i++) {
            int sum1 = preSum[i + 1] - preSum[0];

            // minJ
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 边界二分 F, F,..., F, [T, T,..., T]
                // ----------------------^
                // sum2 >= sum1 FFFTTT
                int sum2 = preSum[mid + 1] - preSum[i + 1];
                if (sum2 >= sum1) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            int minJ = left;

            // maxJ
            left = i + 1;
            right = len - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 边界二分 F, F,..., F, [T, T,..., T]
                // ----------------------^
                // sum3 >= sum2 TTTFFF sum3 < sum2 FFFTTT
                int sum2 = preSum[mid + 1] - preSum[i + 1];
                int sum3 = preSum[len] - preSum[mid + 1];
                if (sum3 < sum2) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            int maxJ = left - 1;

            cnt += Math.max(0, maxJ - minJ + 1);
            cnt %= MOD;
        }
        return (int) cnt;
    }
}
/*
1712. 将数组分成三个子数组的方案数
https://leetcode.cn/problems/ways-to-split-array-into-three-subarrays/

我们称一个分割整数数组的方案是 好的 ，当它满足：
- 数组被分成三个 非空 连续子数组，从左至右分别命名为 left ， mid ， right 。
- left 中元素和小于等于 mid 中元素和，mid 中元素和小于等于 right 中元素和。
给你一个 非负 整数数组 nums ，请你返回 好的 分割 nums 方案数目。由于答案可能会很大，请你将结果对 10^9 + 7 取余后返回。
提示：
3 <= nums.length <= 10^5
0 <= nums[i] <= 10^4

三部分 [0,i] [i+1,j] [j+1,n-1]
固定 i 坐标，二分求 j 坐标的最小值与最大值
 */