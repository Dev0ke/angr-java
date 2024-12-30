import java.util.HashSet;
import java.util.Set;

public class Solution2395 {
    public boolean findSubarrays(int[] nums) {
        int len = nums.length;
        Set<Integer> sumSet = new HashSet<>();
        for (int i = 1; i < len; i++) {
            int sum = nums[i - 1] + nums[i];
            if (sumSet.contains(sum)) {
                return true;
            }
            sumSet.add(sum);
        }
        return false;
    }
}
/*
2395. 和相等的子数组
https://leetcode.cn/problems/find-subarrays-with-equal-sum/

第 86 场双周赛 T1。

给你一个下标从 0 开始的整数数组 nums ，判断是否存在 两个 长度为 2 的子数组且它们的 和 相等。注意，这两个子数组起始位置的下标必须 不相同 。
如果这样的子数组存在，请返回 true，否则返回 false 。
子数组 是一个数组中一段连续非空的元素组成的序列。
提示：
2 <= nums.length <= 1000
-10^9 <= nums[i] <= 10^9

HashSet 模拟。
时间复杂度 O(n)
 */