import java.util.Arrays;

public class Solution2966 {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int[][] ans = new int[n / 3][3];
        for (int i = 0; i < n; i += 3) {
            if (nums[i + 2] - nums[i] > k) {
                return new int[0][];
            }
            ans[i / 3][0] = nums[i];
            ans[i / 3][1] = nums[i + 1];
            ans[i / 3][2] = nums[i + 2];
        }
        return ans;
    }
}
/*
2966. 划分数组并满足最大差限制
https://leetcode.cn/problems/divide-array-into-arrays-with-max-difference/description/

第 376 场周赛 T2。

给你一个长度为 n 的整数数组 nums，以及一个正整数 k 。
将这个数组划分为一个或多个长度为 3 的子数组，并满足以下条件：
- nums 中的 每个 元素都必须 恰好 存在于某个子数组中。
- 子数组中 任意 两个元素的差必须小于或等于 k 。
返回一个 二维数组 ，包含所有的子数组。如果不可能满足条件，就返回一个空数组。如果有多个答案，返回 任意一个 即可。
提示：
n == nums.length
1 <= n <= 10^5
n 是 3 的倍数
1 <= nums[i] <= 10^5
1 <= k <= 10^5

贪心，最小差出现在有序数组中，因此排序后遍历即可。
时间复杂度 O(nlogn)
 */