import java.util.HashMap;
import java.util.Map;

public class Solution1027 {
    public int longestArithSeqLength(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> idxMap = new HashMap<>();
        // f[j][k] 表示以下标 j,k 结尾的最长等差数列
        int[][] f = new int[len][len];
        int max = 0;

        // i < j < k
        for (int j = 0; j < len; j++) {
            for (int k = j + 1; k < len; k++) {
                // nums[j] - nums[i] == nums[k] - nums[j] == d
                // nums[i] = nums[j] - (nums[k] - nums[j])
                int i = idxMap.getOrDefault(nums[j] - (nums[k] - nums[j]), -1);
                if (i >= 0) {
                    f[j][k] = f[i][j] + 1;
                    max = Math.max(max, f[j][k]);
                }
            }
            idxMap.put(nums[j], j);
        }
        return max + 2;
    }
}
/*
1027. 最长等差数列
https://leetcode.cn/problems/longest-arithmetic-subsequence/

给你一个整数数组 nums，返回 nums 中最长等差子序列的长度。
回想一下，nums 的子序列是一个列表 nums[i1], nums[i2], ..., nums[ik] ，且 0 <= i1 < i2 < ... < ik <= nums.length - 1。
并且如果 seq[i+1] - seq[i]( 0 <= i < seq.length - 1) 的值都相同，那么序列 seq 是等差的。
提示：
2 <= nums.length <= 1000
0 <= nums[i] <= 500

相似题目: 873. 最长的斐波那契子序列的长度
https://leetcode.cn/problems/length-of-longest-fibonacci-subsequence/
 */