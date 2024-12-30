import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2150 {
    public List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> resList = new ArrayList<>();
        for (int num : cntMap.keySet()) {
            if (cntMap.get(num) == 1 && !cntMap.containsKey(num - 1) && !cntMap.containsKey(num + 1)) {
                resList.add(num);
            }
        }
        return resList;
    }
}
/*
2150. 找出数组中的所有孤独数字
https://leetcode.cn/problems/find-all-lonely-numbers-in-the-array/

第 277 场周赛 T3。

给你一个整数数组 nums 。如果数字 x 在数组中仅出现 一次 ，且没有 相邻 数字（即，x + 1 和 x - 1）出现在数组中，则认为数字 x 是 孤独数字 。
返回 nums 中的 所有 孤独数字。你可以按 任何顺序 返回答案。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^6

HashMap 统计 + 模拟。
时间复杂度 O(n)
 */