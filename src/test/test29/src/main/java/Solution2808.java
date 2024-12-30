import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2808 {
    public int minimumSeconds(List<Integer> nums) {
        int n = nums.size();
        Map<Integer, List<Integer>> posMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            posMap.computeIfAbsent(nums.get(i), key -> new ArrayList<>()).add(i);
        }

        int ans = n;
        if (posMap.size() == 1) {
            return 0;
        }
        for (List<Integer> value : posMap.values()) {
            int sz = value.size();
            int mx = 0;
            for (int i = 1; i < sz; i++) {
                mx = Math.max(mx, value.get(i) - value.get(i - 1) - 1);
            }
            mx = Math.max(mx, value.get(0) + n - value.get(sz - 1) - 1);
            ans = Math.min(ans, (mx + 1) / 2);
        }
        return ans;
    }
}
/*
2808. 使循环数组所有元素相等的最少秒数
https://leetcode.cn/problems/minimum-seconds-to-equalize-a-circular-array/

第 110 场双周赛 T3。

给你一个下标从 0 开始长度为 n 的数组 nums 。
每一秒，你可以对数组执行以下操作：
- 对于范围在 [0, n - 1] 内的每一个下标 i ，将 nums[i] 替换成 nums[i] ，nums[(i - 1 + n) % n] 或者 nums[(i + 1) % n] 三者之一。
注意，所有元素会被同时替换。
请你返回将数组 nums 中所有元素变成相等元素所需要的 最少 秒数。
提示：
1 <= n == nums.length <= 10^5
1 <= nums[i] <= 10^9

下标分组，求每组的最大间隔值。
再在所有组种取最小的。
 */