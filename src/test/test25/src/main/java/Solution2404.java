import java.util.Map;
import java.util.TreeMap;

public class Solution2404 {
    public int mostFrequentEven(int[] nums) {
        int maxCnt = -1;
        TreeMap<Integer, Integer> cntMap = new TreeMap<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
                maxCnt = Math.max(maxCnt, cntMap.get(num));
            }
        }
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            if (entry.getValue() == maxCnt) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
/*
2404. 出现最频繁的偶数元素
https://leetcode.cn/problems/most-frequent-even-element/

第 310 场周赛 T1。

给你一个整数数组 nums ，返回出现最频繁的偶数元素。
如果存在多个满足条件的元素，只需要返回 最小 的一个。如果不存在这样的元素，返回 -1 。
提示：
1 <= nums.length <= 2000
0 <= nums[i] <= 10^5

统计频次，得出最大频次，从最小的偶数开始，如果其频次等于最大频次，返回结果，否则返回 -1。
 */