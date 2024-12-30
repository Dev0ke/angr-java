import java.util.HashMap;
import java.util.Map;

public class Solution2341 {
    public int[] numberOfPairs(int[] nums) {
        // 统计频次
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }

        int[] answer = new int[2];
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            int cnt = entry.getValue();
            // 形成的数对数目
            answer[0] += cnt / 2;
            if (cnt % 2 != 0) {
                // 剩下的整数数目
                answer[1] += 1;
            }
        }
        return answer;
    }
}
/*
2341. 数组能形成多少数对
https://leetcode.cn/problems/maximum-number-of-pairs-in-array/

第 302 场周赛 T1。

给你一个下标从 0 开始的整数数组 nums 。在一步操作中，你可以执行以下步骤：
- 从 nums 选出 两个 相等的 整数
- 从 nums 中移除这两个整数，形成一个 数对
请你在 nums 上多次执行此操作直到无法继续执行。
返回一个下标从 0 开始、长度为 2 的整数数组 answer 作为答案，其中 answer[0] 是形成的数对数目，answer[1] 是对 nums 尽可能执行上述操作后剩下的整数数目。
提示：
1 <= nums.length <= 100
0 <= nums[i] <= 100

模拟。
时间复杂度 O(n)
 */