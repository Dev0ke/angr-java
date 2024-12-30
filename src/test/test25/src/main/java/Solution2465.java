import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution2465 {
    public int distinctAverages(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < len / 2; i++) {
            hashSet.add(nums[i] + nums[len - 1 - i]);
        }
        return hashSet.size();
    }
}
/*
2465. 不同的平均值数目
https://leetcode.cn/problems/number-of-distinct-averages/

第 91 场双周赛 T1。

给你一个下标从 0 开始长度为 偶数 的整数数组 nums 。
只要 nums 不是 空数组，你就重复执行以下步骤：
- 找到 nums 中的最小值，并删除它。
- 找到 nums 中的最大值，并删除它。
- 计算删除两数的平均值。
两数 a 和 b 的 平均值 为 (a + b) / 2 。
- 比方说，2 和 3 的平均值是 (2 + 3) / 2 = 2.5 。
返回上述过程能得到的 不同 平均值的数目。
注意 ，如果最小值或者最大值有重复元素，可以删除任意一个。
提示：
2 <= nums.length <= 100
nums.length 是偶数。
0 <= nums[i] <= 100

HashSet去重
 */