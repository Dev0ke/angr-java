public class SolutionP1121 {
    public boolean canDivideIntoSubsequences(int[] nums, int k) {
        if (k == 1) {
            return true;
        }
        int max = 0;
        int cnt = 0;
        int pre = -1;
        for (int num : nums) {
            if (num != pre) {
                cnt = 1;
            } else {
                cnt++;
            }
            max = Math.max(max, cnt);
            pre = num;
        }
        return max * k <= nums.length;
    }
}
/*
$1121. 将数组分成几个递增序列
https://leetcode.cn/problems/divide-array-into-increasing-sequences/

给你一个 非递减 的正整数数组 nums 和整数 K，判断该数组是否可以被分成一个或几个 长度至少 为 K 的 不相交的递增子序列。
提示：
1 <= nums.length <= 10^5
1 <= K <= nums.length
1 <= nums[i] <= 10^5

贪心，设最大频次为 c，c * k 需小于等于 n
 */