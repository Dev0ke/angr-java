public class Solution3201 {
    public int maximumLength(int[] nums) {
        return maximumLength(nums, 2);
    }

    private int maximumLength(int[] nums, int k) {
        int ans = 0;
        int[][] f = new int[k][k];
        for (int x : nums) {
            x %= k;
            for (int y = 0; y < k; y++) {
                f[y][x] = f[x][y] + 1;
                ans = Math.max(ans, f[y][x]);
            }
        }
        return ans;
    }
}
/*
3201. 找出有效子序列的最大长度 I
https://leetcode.cn/problems/find-the-maximum-length-of-valid-subsequence-i/description/

第 404 场周赛 T2。

给你一个整数数组 nums。
nums 的子序列 sub 的长度为 x ，如果其满足以下条件，则称其为 有效子序列：
- (sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x - 1]) % 2
返回 nums 的 最长的有效子序列 的长度。
一个 子序列 指的是从原数组中删除一些元素（也可以不删除任何元素），剩余元素保持原来顺序组成的新数组。
提示：
2 <= nums.length <= 2 * 10^5
1 <= nums[i] <= 10^7

同: 3202. 找出有效子序列的最大长度 II
https://leetcode.cn/problems/find-the-maximum-length-of-valid-subsequence-ii/description/
 */