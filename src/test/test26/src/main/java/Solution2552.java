public class Solution2552 {
    public long countQuadruplets(int[] nums) {
        int n = nums.length;

        // great[k][nums[j]] 表示 k 右边有多少比 nums[j] 大的数
        int[][] great = new int[n][n + 1];
        // k 范围 [2, n-2]
        for (int k = n - 2; k >= 2; k--) {
            great[k] = great[k + 1].clone();
            // x < nums[k+1]，对于 x，大于它的数的个数 +1
            for (int x = nums[k + 1] - 1; x >= 1; x--) {
                great[k][x]++;
            }
        }

        // less[j][nums[k]] 表示 j 左边有多少比 nums[k] 小的数
        int[][] less = new int[n][n + 1];
        // j 范围 [1, n-3]
        for (int j = 1; j <= n - 3; j++) {
            less[j] = less[j - 1].clone();
            // x > nums[j-1]，对于 x，小于它的数的个数 +1
            for (int x = nums[j - 1] + 1; x <= n; x++) {
                less[j][x]++;
            }
        }

        long res = 0;
        for (int j = 1; j <= n - 3; j++) {
            for (int k = j + 1; k <= n - 2; k++) {
                if (nums[j] > nums[k]) {
                    res += (long) less[j][nums[k]] * great[k][nums[j]];
                }
            }
        }
        return res;
    }
}
/*
2552. 统计上升四元组
https://leetcode.cn/problems/count-increasing-quadruplets/

第 330 场周赛 T4。

给你一个长度为 n 下标从 0 开始的整数数组 nums ，它包含 1 到 n 的所有数字，请你返回上升四元组的数目。
如果一个四元组 (i, j, k, l) 满足以下条件，我们称它是上升的：
- 0 <= i < j < k < l < n 且
- nums[i] < nums[k] < nums[j] < nums[l] 。
提示：
4 <= nums.length <= 4000
1 <= nums[i] <= nums.length
nums 中所有数字 互不相同 ，nums 是一个排列。

枚举中间的 j 和 k
k 右边有多少比 nums[j] 大的数；j 左边有多少比 nums[k] 小的数
时间复杂度 O(n^2)
相似题目: 2242. 节点序列的最大得分
https://leetcode.cn/problems/maximum-score-of-a-node-sequence/
 */