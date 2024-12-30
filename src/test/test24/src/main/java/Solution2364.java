import java.util.HashMap;
import java.util.Map;

public class Solution2364 {
    public long countBadPairs(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int diff = i - nums[i];
            cntMap.put(diff, cntMap.getOrDefault(diff, 0) + 1);
        }

        // 总对数
        long total = len * (len - 1L) / 2L;
        // 相同对数
        long same = 0L;
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            int cnt = entry.getValue();
            same += cnt * (cnt - 1L) / 2L;
        }
        return total - same;
    }
}
/*
2364. 统计坏数对的数目
https://leetcode.cn/problems/count-number-of-bad-pairs/

第 84 场双周赛 T2。

给你一个下标从 0 开始的整数数组 nums 。如果 i < j 且 j - i != nums[j] - nums[i] ，那么我们称 (i, j) 是一个 坏数对 。
请你返回 nums 中 坏数对 的总数目。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9

数学。
直接求 坏数对 的总数目 并不容易，问题可转化为：坏数对 的总数目 = 数对总数目 - 非坏数对 的总数目
非坏数对定义：j - i != nums[j] - nums[i]
移项得 j - nums[j] == i - nums[i]
时间复杂度：O(n)
 */