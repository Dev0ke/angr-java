import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2869 {
    public int minOperations(List<Integer> nums, int k) {
        int n = nums.size();
        Set<Integer> set = new HashSet<>();
        for (int i = n - 1; i >= 0; i--) {
            if (nums.get(i) <= k) {
                set.add(nums.get(i));
            }
            if (set.size() == k) {
                return n - i;
            }
        }
        return -1;
    }
}
/*
2869. 收集元素的最少操作次数
https://leetcode.cn/problems/minimum-operations-to-collect-elements/description/

第 114 场双周赛 T1。

给你一个正整数数组 nums 和一个整数 k 。
一次操作中，你可以将数组的最后一个元素删除，将该元素添加到一个集合中。
请你返回收集元素 1, 2, ..., k 需要的 最少操作次数 。
提示：
1 <= nums.length <= 50
1 <= nums[i] <= nums.length
1 <= k <= nums.length
输入保证你可以收集到元素 1, 2, ..., k 。

集合 模拟
时间复杂度 O(n)
 */