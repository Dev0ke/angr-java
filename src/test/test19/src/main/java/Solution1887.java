import java.util.Arrays;

public class Solution1887 {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0, cnt = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] != nums[i]) {
                cnt++;
            }
            ans += cnt;
        }
        return ans;
    }
}
/*
1887. 使数组元素相等的减少操作次数
https://leetcode.cn/problems/reduction-operations-to-make-the-array-elements-equal/description/

给你一个整数数组 nums ，你的目标是令 nums 中的所有元素相等。完成一次减少操作需要遵照下面的几个步骤：
1.找出 nums 中的 最大 值。记这个值为 largest 并取其下标 i （下标从 0 开始计数）。如果有多个元素都是最大值，则取最小的 i 。
2.找出 nums 中的 下一个最大 值，这个值 严格小于 largest ，记为 nextLargest 。
3.将 nums[i] 减少到 nextLargest 。
返回使 nums 中的所有元素相等的操作次数。
提示：
1 <= nums.length <= 5 * 10^4
1 <= nums[i] <= 5 * 10^4

排序。
时间复杂度 O(nlogn)。
 */