public class Solution2518 {
    private static final int MOD = (int) (1e9 + 7);

    public int countPartitions(int[] nums, int k) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < k * 2L) {
            return 0;
        }

        long res = 1;
        // f[i][j] 表示从前 i 个数中选择若干元素，和为 j 的方案数
        int[] f = new int[k];
        f[0] = 1;
        for (int x : nums) {
            res = res * 2 % MOD;
            for (int j = k - 1; j >= x; j--) {
                f[j] = (f[j] + f[j - x]) % MOD;
            }
        }
        for (int x : f) {
            res = (res - x * 2L % MOD + MOD) % MOD;
        }
        return (int) res;
    }
}
/*
2518. 好分区的数目
https://leetcode.cn/problems/number-of-great-partitions/

第 325 场周赛 T4。

给你一个正整数数组 nums 和一个整数 k 。
分区 的定义是：将数组划分成两个有序的 组 ，并满足每个元素 恰好 存在于 某一个 组中。如果分区中每个组的元素和都大于等于 k ，则认为分区是一个好分区。
返回 不同 的好分区的数目。由于答案可能很大，请返回对 10^9 + 7 取余 后的结果。
如果在两个分区中，存在某个元素 nums[i] 被分在不同的组中，则认为这两个分区不同。
提示：
1 <= nums.length, k <= 1000
1 <= nums[i] <= 10^9

0-1 背包变形（求方案数）
不选第 i 个数: f[i][j] = f[i-1][j]
选第 i 个数:   f[i][j] = f[i-1][j-nums[i]]
f[i][j] = f[i-1][j] + f[i-1][j-nums[i]]
相似题目: 494. 目标和
https://leetcode.cn/problems/target-sum/
 */