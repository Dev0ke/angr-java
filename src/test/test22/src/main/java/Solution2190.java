import java.util.HashMap;
import java.util.Map;

public class Solution2190 {
    public int mostFrequent(int[] nums, int key) {
        int n = nums.length;
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int i = 0; i <= n - 2; i++) {
            if (nums[i] == key) {
                int target = nums[i + 1];
                cntMap.put(target, cntMap.getOrDefault(target, 0) + 1);
            }
        }

        int res = 0;
        int resCnt = 0;
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            if (entry.getValue() > resCnt) {
                res = entry.getKey();
                resCnt = entry.getValue();
            }
        }
        return res;
    }
}
/*
2190. 数组中紧跟 key 之后出现最频繁的数字
https://leetcode.cn/problems/most-frequent-number-following-key-in-an-array/

第 73 场双周赛 T1。

给你一个下标从 0 开始的整数数组 nums ，同时给你一个整数 key ，它在 nums 出现过。
统计 在 nums 数组中紧跟着 key 后面出现的不同整数 target 的出现次数。换言之，target 的出现次数为满足以下条件的 i 的数目：
- 0 <= i <= n - 2
- nums[i] == key 且
- nums[i + 1] == target 。
请你返回出现 最多 次数的 target 。测试数据保证出现次数最多的 target 是唯一的。
提示：
2 <= nums.length <= 1000
1 <= nums[i] <= 1000
测试数据保证答案是唯一的。

模拟统计。
 */