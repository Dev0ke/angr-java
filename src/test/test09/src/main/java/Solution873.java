import java.util.HashMap;
import java.util.Map;

public class Solution873 {
    public int lenLongestFibSubseq(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> idxMap = new HashMap<>();
        // f[j][k] 表示以下标 j,k 结尾的最长的斐波那契子序列的长度
        int[][] f = new int[len][len];
        int max = 0;

        // i < j < k
        for (int j = 0; j < len; j++) {
            for (int k = j + 1; k < len; k++) {
                // nums[i] + nums[j] = nums[k]
                // nums[i] = nums[k] - nums[j]
                int i = idxMap.getOrDefault(nums[k] - nums[j], -1);
                if (i >= 0) {
                    f[j][k] = f[i][j] + 1;
                    max = Math.max(max, f[j][k]);
                }
            }
            idxMap.put(nums[j], j);
        }
        return max == 0 ? 0 : max + 2;
    }
}
/*
873. 最长的斐波那契子序列的长度
https://leetcode.cn/problems/length-of-longest-fibonacci-subsequence/

第 94 场周赛 T4。

如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是斐波那契式的：
- n >= 3
- 对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
给定一个严格递增的正整数数组形成序列 arr，找到 arr 中最长的斐波那契式的子序列的长度。如果一个不存在，返回 0 。
（回想一下，子序列是从原序列 arr 中派生出来的，它从 arr 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。
例如，[3, 5, 8]是[3, 4, 5, 6, 7, 8]的一个子序列）
提示：
3 <= arr.length <= 1000
1 <= arr[i] < arr[i + 1] <= 10^9

动态规划。
时间复杂度 O(n^2)
空间复杂度 O(n^2)
相似题目: 1027. 最长等差数列
https://leetcode.cn/problems/longest-arithmetic-subsequence/
 */