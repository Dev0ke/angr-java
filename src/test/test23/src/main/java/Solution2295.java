import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2295 {
    public int[] arrayChange(int[] nums, int[][] operations) {
        int n = nums.length;

        // 预处理下标
        Map<Integer, List<Integer>> idxListMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idxListMap.computeIfAbsent(nums[i], key -> new ArrayList<>()).add(i);
        }

        // 模拟
        for (int[] operation : operations) {
            int oldKey = operation[0];
            int newKey = operation[1];
            List<Integer> idxList = idxListMap.get(oldKey);
            idxListMap.remove(oldKey);
            idxListMap.put(newKey, idxList);
        }

        // 离线还原
        int[] res = new int[n];
        for (Map.Entry<Integer, List<Integer>> entry : idxListMap.entrySet()) {
            int key = entry.getKey();
            List<Integer> idxList = entry.getValue();
            for (int idx : idxList) {
                res[idx] = key;
            }
        }
        return res;
    }
}
/*
2295. 替换数组中的元素
https://leetcode.cn/problems/replace-elements-in-an-array/

第 296 场周赛 T3。

给你一个下标从 0 开始的数组 nums ，它包含 n 个 互不相同 的正整数。
请你对这个数组执行 m 个操作，在第 i 个操作中，你需要将数字 operations[i][0] 替换成 operations[i][1] 。
题目保证在第 i 个操作中：
- operations[i][0] 在 nums 中存在。
- operations[i][1] 在 nums 中不存在。
请你返回执行完所有操作后的数组。
提示：
n == nums.length
m == operations.length
1 <= n, m <= 10^5
nums 中所有数字 互不相同 。
operations[i].length == 2
1 <= nums[i], operations[i][0], operations[i][1] <= 10^6
在执行第 i 个操作时，operations[i][0] 在 nums 中存在。
在执行第 i 个操作时，operations[i][1] 在 nums 中不存在。

HashMap 模拟更新，离线还原。
时间复杂度 O(n + m)
 */