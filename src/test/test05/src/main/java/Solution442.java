import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution442 {
    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> resList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            if (entry.getValue() == 2) {
                resList.add(entry.getKey());
            }
        }
        return resList;
    }
}
/*
442. 数组中重复的数据
https://leetcode.cn/problems/find-all-duplicates-in-an-array/

给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。请你找出所有出现 两次 的整数，并以数组形式返回。
你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
提示：
n == nums.length
1 <= n <= 10^5
1 <= nums[i] <= n
nums 中的每个元素出现 一次 或 两次
 */
