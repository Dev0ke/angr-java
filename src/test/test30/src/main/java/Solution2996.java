import java.util.HashSet;
import java.util.Set;

public class Solution2996 {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        int s = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[0] == i) {
                s += nums[i];
            } else {
                break;
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        while (set.contains(s)) {
            s++;
        }
        return s;
    }
}
/*
2996. 大于等于顺序前缀和的最小缺失整数
https://leetcode.cn/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/description/

第 121 场双周赛 T1。

给你一个下标从 0 开始的整数数组 nums 。
如果一个前缀 nums[0..i] 满足对于 1 <= j <= i 的所有元素都有 nums[j] = nums[j - 1] + 1 ，那么我们称这个前缀是一个 顺序前缀 。特殊情况是，只包含 nums[0] 的前缀也是一个 顺序前缀 。
请你返回 nums 中没有出现过的 最小 整数 x ，满足 x 大于等于 最长 顺序前缀的和。
提示：
1 <= nums.length <= 50
1 <= nums[i] <= 50

模拟
时间复杂度 O(n)
 */