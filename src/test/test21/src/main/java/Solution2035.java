import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Solution2035 {
    /**
     * meet in the middle（折半搜索）
     * 时间复杂度 = O(n*2^(n/2)) <= 30 * 32768 (n 最大取到 30)
     * 思路参考 https://www.bilibili.com/video/BV1Rh411J7Dd
     */
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int[] nums1 = new int[n];
        int[] nums2 = new int[n];
        System.arraycopy(nums, 0, nums1, 0, n);
        System.arraycopy(nums, n, nums2, 0, n);
        int sum = Arrays.stream(nums).sum();

        // 预处理 nums2 子集和，key 为对应子集的元素个数，TreeSet 便于二分
        Map<Integer, TreeSet<Integer>> nums2subsetSumMap = getNumsSubsetSumMap(nums2);
        int min = Integer.MAX_VALUE;
        for (int state = 0; state < (1 << n); state++) {
            // 二进制 1 的个数，1 代表选取
            int i = Integer.bitCount(state);
            // nums1 子集和（i 个元素）
            int sum1 = 0;
            for (int k = 0; k < n; k++) {
                if (((state >> k) & 1) > 0) {
                    sum1 += nums1[k];
                }
            }

            // nums2 子集和（j 个元素）
            int j = n - i;
            TreeSet<Integer> treeSet = nums2subsetSumMap.get(j);
            // 期望找到最接近的 子集和
            int sum2 = sum / 2 - sum1;
            Integer floor = treeSet.floor(sum2);
            if (floor != null) {
                min = Math.min(min, Math.abs(sum - 2 * (sum1 + floor)));
            }
            Integer ceiling = treeSet.ceiling(sum2);
            if (ceiling != null) {
                min = Math.min(min, Math.abs(sum - 2 * (sum1 + ceiling)));
            }
        }
        return min;
    }

    private Map<Integer, TreeSet<Integer>> getNumsSubsetSumMap(int[] nums) {
        int n = nums.length;
        Map<Integer, TreeSet<Integer>> nums2subsetMap = new HashMap<>();
        for (int state = 0; state < (1 << n); state++) {
            int i = Integer.bitCount(state);
            TreeSet<Integer> treeSet = nums2subsetMap.getOrDefault(i, new TreeSet<>());
            int sum = 0;
            for (int k = 0; k < n; k++) {
                if (((state >> k) & 1) == 1) {
                    sum += nums[k];
                }
            }
            treeSet.add(sum);
            nums2subsetMap.put(i, treeSet);
        }
        return nums2subsetMap;
    }

    /**
     * 状态压缩 dp（暴力）
     * 时间复杂度 = O(n*2^n) <= 30 * 1,073,741,824 (n 最大取到 30)
     */
    public int minimumDifference2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int target = sum / 2;
        int min = Integer.MAX_VALUE;
        // 2 * n 的整数数组 选 n 个
        TreeSet<Integer> treeSet = getNumsSubsetSum(nums);
        Integer floor = treeSet.floor(target);
        if (floor != null) {
            min = Math.min(min, Math.abs(sum - floor - floor));
        }
        Integer ceiling = treeSet.ceiling(target);
        if (ceiling != null) {
            min = Math.min(min, Math.abs(sum - ceiling - ceiling));
        }
        return min;
    }

    private TreeSet<Integer> getNumsSubsetSum(int[] nums) {
        int n = nums.length;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int state = 0; state < (1 << n); state++) {
            int i = Integer.bitCount(state);
            // 2 * n 的整数数组 选 n 个
            if (i == n / 2) {
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    if (((state >> k) & 1) > 0) {
                        sum += nums[k];
                    }
                }
                treeSet.add(sum);
            }
        }
        return treeSet;
    }
}
/*
2035. 将数组分成两个数组并最小化数组和的差
https://leetcode.cn/problems/partition-array-into-two-arrays-to-minimize-sum-difference/

第 262 场周赛 T4。

给你一个长度为 2 * n 的整数数组。你需要将 nums 分成 两个 长度为 n 的数组，分别求出两个数组的和，并 最小化 两个数组和之 差的绝对值 。
nums 中每个元素都需要放入两个数组之一。
请你返回 最小 的数组和之差。

折半搜索。
相似题目: 1755. 最接近目标值的子序列和
https://leetcode.cn/problems/closest-subsequence-sum/
 */