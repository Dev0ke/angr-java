public class Solution3038 {
    public int maxOperations(int[] nums) {
        int n = nums.length;
        int sum = nums[0] + nums[1];
        int ans = 1;
        for (int i = 2; i < n; i += 2) {
            if (i + 1 < n && nums[i] + nums[i + 1] == sum) {
                ans++;
            } else {
                break;
            }
        }
        return ans;
    }
}
/*
3038. 相同分数的最大操作数目 I
https://leetcode.cn/problems/maximum-number-of-operations-with-the-same-score-i/description/

第 124 场双周赛 T1。

给你一个整数数组 nums ，如果 nums 至少 包含 2 个元素，你可以执行以下操作：
- 选择 nums 中的前两个元素并将它们删除。
一次操作的 分数 是被删除元素的和。
在确保 所有操作分数相同 的前提下，请你求出 最多 能进行多少次操作。
请你返回按照上述要求 最多 可以进行的操作次数。
提示：
2 <= nums.length <= 100
1 <= nums[i] <= 1000

模拟。
时间复杂度 O(n)
 */