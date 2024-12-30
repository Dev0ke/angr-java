public class Solution1043 {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] f = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = i; j > i - k && j >= 0; j--) {
                max = Math.max(max, arr[j]);
                f[i + 1] = Math.max(f[i + 1], f[j] + (i - j + 1) * max);
            }
        }
        return f[n];
    }
}
/*
1043. 分隔数组以得到最大和
https://leetcode.cn/problems/partition-array-for-maximum-sum/

给你一个整数数组 arr，请你将该数组分隔为长度 最多 为 k 的一些（连续）子数组。分隔完成后，每个子数组的中的所有值都会变为该子数组中的最大值。
返回将数组分隔变换后能够得到的元素最大和。本题所用到的测试用例会确保答案是一个 32 位整数。
提示：
1 <= arr.length <= 500
0 <= arr[i] <= 10^9
1 <= k <= arr.length

动态规划
时间复杂度 O(nk)
空间复杂度 O(n)
相似题目: 1105. 填充书架
https://leetcode.cn/problems/filling-bookcase-shelves/
2369. 检查数组是否存在有效划分
https://leetcode.cn/problems/check-if-there-is-a-valid-partition-for-the-array/
 */