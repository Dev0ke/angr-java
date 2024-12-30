public class Solution2547 {
    public int minCost(int[] nums, int k) {
        int n = nums.length;
        int[] g = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int[] cnt = new int[n];
            int unique = 0;
            int min = Integer.MAX_VALUE;
            for (int j = i; j >= 0; j--) {
                int x = nums[j];
                if (cnt[x] == 0) {
                    // 首次出现
                    cnt[x] = 1;
                    unique++;
                } else if (cnt[x] == 1) {
                    // 非首次出现
                    cnt[x] = 2;
                    unique--;
                }
                min = Math.min(min, g[j] - unique);
            }
            g[i + 1] = k + min;
        }
        return g[n] + n;
    }
}
/*
2547. 拆分数组的最小代价
https://leetcode.cn/problems/minimum-cost-to-split-an-array/

第 329 场周赛 T4。

给你一个整数数组 nums 和一个整数 k 。
将数组拆分成一些非空子数组。拆分的 代价 是每个子数组中的 重要性 之和。
令 trimmed(subarray) 作为子数组的一个特征，其中所有仅出现一次的数字将会被移除。
- 例如，trimmed([3,1,2,4,3,4]) = [3,4,3,4] 。
子数组的 重要性 定义为 k + trimmed(subarray).length 。
- 例如，如果一个子数组是 [1,2,3,3,3,4,4] ，trimmed([1,2,3,3,3,4,4]) = [3,3,3,4,4] 。这个子数组的重要性就是 k + 5 。
找出并返回拆分 nums 的所有可行方案中的最小代价。
子数组 是数组的一个连续 非空 元素序列。
提示：
1 <= nums.length <= 1000
0 <= nums[i] < nums.length
1 <= k <= 10^9

划分型 DP
f[i] = min(k + cost(j,i) + f[j-1]) j in [0,i]
f[i+1] = min(k + cost(j,i) + f[j])
f[i+1] 表示划分 nums 前 i 个数的最小代价
cost(j,i)
子数组长度 - unique
f[i+1] = min(k + i-j+1 - unique_j + f[j])
f[i+1] = (i + 1) + k + min(f[j]-j - unique_j)
g[i] = f[i] - i
g[i+1] = k + min(g[j] - unique_j)
f[n] = g[n] + n
时间复杂度 O(n^2)
 */