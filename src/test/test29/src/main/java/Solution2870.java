import java.util.HashMap;
import java.util.Map;

public class Solution2870 {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int x : nums) {
            cntMap.put(x, cntMap.getOrDefault(x, 0) + 1);
        }
        int ans = 0;
        for (Integer c : cntMap.values()) {
            if (c == 1) {
                return -1;
            } else {
                // 数论向上取整法
                ans += (c + 2) / 3;
            }
        }
        return ans;
    }
}
/*
2870. 使数组为空的最少操作次数
https://leetcode.cn/problems/minimum-number-of-operations-to-make-array-empty/description/

第 114 场双周赛 T2。

给你一个下标从 0 开始的正整数数组 nums 。
你可以对数组执行以下两种操作 任意次 ：
- 从数组中选择 两个 值 相等 的元素，并将它们从数组中 删除 。
- 从数组中选择 三个 值 相等 的元素，并将它们从数组中 删除 。
请你返回使数组为空的 最少 操作次数，如果无法达成，请返回 -1 。
提示：
2 <= nums.length <= 10^5
1 <= nums[i] <= 10^6

统计 + 数学
时间复杂度 O(n)
 */