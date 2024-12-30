import java.util.Arrays;

public class Solution2733 {
    public int findNonMinOrMax(int[] nums) {
        int min = Arrays.stream(nums).min().orElseThrow();
        int max = Arrays.stream(nums).max().orElseThrow();
        for (int x : nums) {
            if (x != min && x != max) {
                return x;
            }
        }
        return -1;
    }
}
/*
2733. 既不是最小值也不是最大值
https://leetcode.cn/problems/neither-minimum-nor-maximum/

第 349 场周赛 T1。

给你一个整数数组 nums ，数组由 不同正整数 组成，请你找出并返回数组中 任一 既不是 最小值 也不是 最大值 的数字，如果不存在这样的数字，返回 -1 。
返回所选整数。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 100
nums 中的所有数字互不相同

遍历。
时间复杂度 O(n)
 */