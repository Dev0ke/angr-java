import java.util.Arrays;

public class Solution2294 {
    public int partitionArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int cnt = 0;
        int pre = nums[0];
        int idx = 0;
        while (idx < n) {
            while (idx < n && nums[idx] - pre <= k) {
                idx++;
            }
            cnt++;
            if (idx < n) {
                pre = nums[idx];
            }
        }
        return cnt;
    }
}
/*
2294. 划分数组使最大差为 K
https://leetcode.cn/problems/partition-array-such-that-maximum-difference-is-k/

第 296 场周赛 T2。

给你一个整数数组 nums 和一个整数 k 。你可以将 nums 划分成一个或多个 子序列 ，使 nums 中的每个元素都 恰好 出现在一个子序列中。
在满足每个子序列中最大值和最小值之间的差值最多为 k 的前提下，返回需要划分的 最少 子序列数目。
子序列 本质是一个序列，可以通过删除另一个序列中的某些元素（或者不删除）但不改变剩下元素的顺序得到。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^5
0 <= k <= 10^5

贪心。排序后滑动窗口计数即可。
时间复杂度 O(nlogn)
 */