public class Solution3190 {
    public int minimumOperations(int[] nums) {
        int ans = 0;
        for (int v : nums) {
            if (v % 3 != 0) ans++;
        }
        return ans;
    }
}
/*
3190. 使所有元素都可以被 3 整除的最少操作数
https://leetcode.cn/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/description/

第 133 场双周赛 T1。

给你一个整数数组 nums 。一次操作中，你可以将 nums 中的 任意 一个元素增加或者减少 1 。
请你返回将 nums 中所有元素都可以被 3 整除的 最少 操作次数。
提示：
1 <= nums.length <= 50
1 <= nums[i] <= 50

遍历。
时间复杂度 O(n)。
 */