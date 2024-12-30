import java.util.ArrayList;
import java.util.List;

public class Solution2161 {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> leftList = new ArrayList<>();
        List<Integer> midList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        for (int num : nums) {
            if (num < pivot) {
                leftList.add(num);
            } else if (num == pivot) {
                midList.add(num);
            } else {
                rightList.add(num);
            }
        }
        leftList.addAll(midList);
        leftList.addAll(rightList);
        return leftList.stream().mapToInt(i -> i).toArray();
    }
}
/*
2161. 根据给定数字划分数组
https://leetcode.cn/problems/partition-array-according-to-given-pivot/

第 71 场双周赛 T2。

给你一个下标从 0 开始的整数数组 nums 和一个整数 pivot 。请你将 nums 重新排列，使得以下条件均成立：
- 所有小于 pivot 的元素都出现在所有大于 pivot 的元素 之前 。
- 所有等于 pivot 的元素都出现在小于和大于 pivot 的元素 中间 。
- 小于 pivot 的元素之间和大于 pivot 的元素之间的 相对顺序 不发生改变。
  - 更正式的，考虑每一对 pi，pj ，pi 是初始时位置 i 元素的新位置，pj 是初始时位置 j 元素的新位置。
  对于小于 pivot 的元素，如果 i < j 且 nums[i] < pivot 和 nums[j] < pivot 都成立，那么 pi < pj 也成立。
  类似的，对于大于 pivot 的元素，如果 i < j 且 nums[i] > pivot 和 nums[j] > pivot 都成立，那么 pi < pj 。
请你返回重新排列 nums 数组后的结果数组。
提示：
1 <= nums.length <= 10^5
-10^6 <= nums[i] <= 10^6
pivot 等于 nums 中的一个元素。

数据量 10^5 可以使用时间复杂度 O(n) 的模拟算法。
 */