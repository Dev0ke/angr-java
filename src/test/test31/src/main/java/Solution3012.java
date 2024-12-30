import java.util.Arrays;

public class Solution3012 {
    public int minimumArrayLength(int[] nums) {
        int mn = Arrays.stream(nums).min().orElseThrow();
        int c = 0;
        for (int v : nums) {
            if (v == mn) c++;
            if (v % mn > 0) {
                return 1;
            }
        }
        return (c + 1) / 2;
    }
}
/*
3012. 通过操作使数组长度最小
https://leetcode.cn/problems/minimize-length-of-array-using-operations/description/

第 122 场双周赛 T3。

给你一个下标从 0 开始的整数数组 nums ，它只包含 正 整数。
你的任务是通过进行以下操作 任意次 （可以是 0 次） 最小化 nums 的长度：
- 在 nums 中选择 两个不同 的下标 i 和 j ，满足 nums[i] > 0 且 nums[j] > 0 。
- 将结果 nums[i] % nums[j] 插入 nums 的结尾。
- 将 nums 中下标为 i 和 j 的元素删除。
请你返回一个整数，它表示进行任意次操作以后 nums 的 最小长度 。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9

脑筋急转弯。
假设 a < b，那么 a % b = a，意味着小数可以无损消除大数。直接计算最小数的频次 c，返回 (c + 1) / 2，不出意外 wa 了。
注意到可能由 b % a 得到比 a 小的非零数，这种情况，最小数频次变为 1，答案为 1。
时间复杂度 O(n)
 */