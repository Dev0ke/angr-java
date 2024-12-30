import java.util.Arrays;

public class Solution330 {
    public int minPatches(int[] nums, int n) {
        int ans = 0;
        Arrays.sort(nums);
        int j = 0;
        long x = 1;
        while (x <= n) {
            if (j < nums.length && nums[j] <= x) {
                x += nums[j];
                j++;
            } else {
                x += x;
                ans++;
            }
        }
        return ans;
    }
}
/*
330. 按要求补齐数组
https://leetcode.cn/problems/patching-array/description/

给定一个已排序的正整数数组 nums ，和一个正整数 n 。从 [1, n] 区间内选取任意个数字补充到 nums 中，使得 [1, n] 区间内的任何数字都可以用 nums 中某几个数字的和来表示。
请返回 满足上述要求的最少需要补充的数字个数 。
提示：
1 <= nums.length <= 1000
1 <= nums[i] <= 10^4
nums 按 升序排列
1 <= n <= 2^31 - 1

贪心。
时间复杂度 O(m + logn)
相似题目: 2952. 需要添加的硬币的最小数量
https://leetcode.cn/problems/minimum-number-of-coins-to-be-added/description/
 */