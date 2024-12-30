import java.util.HashMap;
import java.util.Map;

public class Solution2244 {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int task : tasks) {
            cntMap.put(task, cntMap.getOrDefault(task, 0) + 1);
        }

        int min = 0;
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            int count = entry.getValue();
            if (count == 1) {
                return -1;
            }
            // y=3a+2b
            for (int b = 0; ; b++) {
                if ((count - b * 2) % 3 == 0) {
                    int a = (count - b * 2) / 3;
                    min += a + b;
                    break;
                }
            }
        }
        return min;
    }
}
/*
2244. 完成所有任务需要的最少轮数
https://leetcode.cn/problems/minimum-rounds-to-complete-all-tasks/

第 289 场周赛 T2。

给你一个下标从 0 开始的整数数组 tasks ，其中 tasks[i] 表示任务的难度级别。在每一轮中，你可以完成 2 个或者 3 个 相同难度级别 的任务。
返回完成所有任务需要的 最少 轮数，如果无法完成所有任务，返回 -1 。
提示：
1 <= tasks.length <= 10^5
1 <= tasks[i] <= 10^9

贪心 枚举
先统计每个难度级别的频次，设为频次为 y，完成 3 个轮数 a，2 个轮数 b，有 y=3a+2b，要使 a+b 尽可能小，则 a 应尽可能大，b 尽可能小。
 */