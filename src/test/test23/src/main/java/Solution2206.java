import java.util.HashMap;
import java.util.Map;

public class Solution2206 {
    public boolean divideArray(int[] nums) {
        // 统计频次
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }

        // 判断频次是否为偶数
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                return false;
            }
        }
        return true;
    }
}
/*
2206. 将数组划分成相等数对
https://leetcode.cn/problems/divide-array-into-equal-pairs/

第 74 场双周赛 T1。

给你一个整数数组 nums ，它包含 2 * n 个整数。
你需要将 nums 划分成 n 个数对，满足：
- 每个元素 只属于一个 数对。
- 同一数对中的元素 相等 。
如果可以将 nums 划分成 n 个数对，请你返回 true ，否则返回 false 。
提示：
nums.length == 2 * n
1 <= n <= 500
1 <= nums[i] <= 500

判断每个数出现的频次是否是偶数次即可。
 */