import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2453 {
    public int destroyTargets(int[] nums, int space) {
        int max = 0;
        Map<Integer, List<Integer>> cntMap = new HashMap<>();
        for (int num : nums) {
            int remain = num % space;
            cntMap.computeIfAbsent(remain, key -> new ArrayList<>()).add(num);
            max = Math.max(max, cntMap.get(remain).size());
        }

        int min = Integer.MAX_VALUE;
        for (Map.Entry<Integer, List<Integer>> entry : cntMap.entrySet()) {
            if (entry.getValue().size() == max) {
                min = Math.min(min, entry.getValue().stream().min(Integer::compareTo).orElseThrow());
            }
        }
        return min;
    }
}
/*
2453. 摧毁一系列目标
https://leetcode.cn/problems/destroy-sequential-targets/

第 90 场双周赛 T3。

给你一个下标从 0 开始的数组 nums ，它包含若干正整数，表示数轴上你需要摧毁的目标所在的位置。同时给你一个整数 space 。
你有一台机器可以摧毁目标。给机器 输入 nums[i] ，这台机器会摧毁所有位置在 nums[i] + c * space 的目标，其中 c 是任意非负整数。你想摧毁 nums 中 尽可能多 的目标。
请你返回在摧毁数目最多的前提下，nums[i] 的 最小值 。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
1 <= space <= 10^9

取模后收敛到 [0, space) 内，统计最多一组的最小整数即可。
时间复杂度 O(n)
 */