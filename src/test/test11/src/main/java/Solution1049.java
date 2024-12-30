import java.util.Arrays;
import java.util.TreeSet;

public class Solution1049 {
    public int lastStoneWeightII(int[] stones) {
        // meet in the middle（折半搜索）
        int len = stones.length;
        // 拆分成两个长度接近的子数组
        int len1 = len / 2;
        int len2 = len - len1;
        int[] nums1 = new int[len1];
        int[] nums2 = new int[len2];
        System.arraycopy(stones, 0, nums1, 0, len1);
        System.arraycopy(stones, len1, nums2, 0, len2);
        int sum = Arrays.stream(stones).sum();

        TreeSet<Integer> treeSet = getNumsSubsetSum(nums2);
        int min = Integer.MAX_VALUE;
        for (int state = 0; state < (1 << len1); state++) {
            // nums1 子集和
            int sum1 = 0;
            for (int k = 0; k < len1; k++) {
                if (((state >> k) & 1) == 1) {
                    sum1 += nums1[k];
                }
            }

            int target = sum / 2 - sum1;
            // 期望找到最接近的 子集和
            Integer floor = treeSet.floor(target);
            if (floor != null) {
                min = Math.min(min, Math.abs(sum - 2 * (sum1 + floor)));
            }
            Integer ceiling = treeSet.ceiling(target);
            if (ceiling != null) {
                min = Math.min(min, Math.abs(sum - 2 * (sum1 + ceiling)));
            }
        }
        return min;
    }

    private TreeSet<Integer> getNumsSubsetSum(int[] nums) {
        int n = nums.length;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int state = 0; state < (1 << n); state++) {
            int sum = 0;
            for (int k = 0; k < n; k++) {
                if (((state >> k) & 1) > 0) {
                    sum += nums[k];
                }
            }
            treeSet.add(sum);
        }
        return treeSet;
    }

    // 动态规划 时间复杂度 O(n*sum)
    public int lastStoneWeightII2(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int halfSum = sum / 2;

        boolean[] dp = new boolean[halfSum + 1];
        dp[0] = true;
        for (int weight : stones) {
            for (int j = halfSum; j >= weight; j--) {
                dp[j] = dp[j] || dp[j - weight];
            }
        }

        for (int j = halfSum; j >= 0; j--) {
            if (dp[j]) {
                return sum - 2 * j;
            }
        }
        return 0;
    }
}
/*
1049. 最后一块石头的重量 II
https://leetcode.cn/problems/last-stone-weight-ii/

第 137 场周赛 T4。

有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
如果 x == y，那么两块石头都会被完全粉碎；
如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
提示：
1 <= stones.length <= 30
1 <= stones[i] <= 100

本题总和很小，30*1000 不超过 3000。适合 0-1 背包（时间复杂度 O(n*sum) <= 30 * 3000）
也可以用折半搜索解决。时间复杂度 O(n*2^(n/2)) <= 30 * 32768
相似题目: 1755. 最接近目标值的子序列和
https://leetcode.cn/problems/closest-subsequence-sum/
2035. 将数组分成两个数组并最小化数组和的差
https://leetcode.cn/problems/partition-array-into-two-arrays-to-minimize-sum-difference/
 */