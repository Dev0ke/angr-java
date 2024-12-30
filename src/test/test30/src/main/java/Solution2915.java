import java.util.Arrays;
import java.util.List;

public class Solution2915 {
    private static final int INF = (int) 1e9;

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[] f = new int[target + 1];
        Arrays.fill(f, -INF);
        f[0] = 0;
        for (Integer num : nums) {
            for (int j = target; j >= num; j--) {
                f[j] = Math.max(f[j], f[j - num] + 1);
                if (f[j] < 0) {
                    f[j] = -INF;
                }
            }
        }
        return f[target] == -INF ? -1 : f[target];
    }
}
/*
2915. 和为目标值的最长子序列的长度
https://leetcode.cn/problems/length-of-the-longest-subsequence-that-sums-to-target/

第 116 场双周赛 T3。

给你一个下标从 0 开始的整数数组 nums 和一个整数 target 。
返回和为 target 的 nums 子序列中，子序列 长度的最大值 。如果不存在和为 target 的子序列，返回 -1 。
子序列 指的是从原数组中删除一些或者不删除任何元素后，剩余元素保持原来的顺序构成的数组。
提示：
1 <= nums.length <= 1000
1 <= nums[i] <= 1000
1 <= target <= 1000

0-1 背包问题，刚好装满背包场景，需要初始化 -inf
时间复杂度 O(n^2)
 */