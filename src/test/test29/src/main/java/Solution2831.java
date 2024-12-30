import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2831 {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int n = nums.size();
        // 把相同元素分组，组内做滑窗
        Map<Integer, List<Integer>> groupIdsMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            groupIdsMap.computeIfAbsent(nums.get(i), e -> new ArrayList<>()).add(i);
        }

        int ans = 0;
        for (List<Integer> ps : groupIdsMap.values()) {
            int l = 0, r = 0;
            while (r < ps.size()) {
                while ((ps.get(r) - ps.get(l) + 1) - (r - l + 1) > k) {
                    l++;
                }
                ans = Math.max(ans, r - l + 1);
                r++;
            }
        }
        return ans;
    }
}
/*
2831. 找出最长等值子数组
https://leetcode.cn/problems/find-the-longest-equal-subarray/

第 359 场周赛 T4。

给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
如果子数组中所有元素都相等，则认为子数组是一个 等值子数组 。注意，空数组是 等值子数组 。
从 nums 中删除最多 k 个元素后，返回可能的最长等值子数组的长度。
子数组 是数组中一个连续且可能为空的元素序列。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= nums.length
0 <= k <= nums.length

不定长滑动窗口（求最长/最大）。
时间复杂度 O(nlogn)
 */