import java.util.Arrays;
import java.util.Comparator;

public class Solution1665 {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, Comparator.comparingInt(o -> o[1] - o[0]));

        int ans = 0;
        for (int[] task : tasks) {
            ans = Math.max(ans + task[0], task[1]);
        }
        return ans;
    }
}
/*
1665. 完成所有任务的最少初始能量
https://leetcode.cn/problems/minimum-initial-energy-to-finish-tasks/description/

给你一个任务数组 tasks ，其中 tasks[i] = [actuali, minimumi] ：
- actuali 是完成第 i 个任务 需要耗费 的实际能量。
- minimumi 是开始第 i 个任务前需要达到的最低能量。
比方说，如果任务为 [10, 12] 且你当前的能量为 11 ，那么你不能开始这个任务。如果你当前的能量为 13 ，你可以完成这个任务，且完成它后剩余能量为 3 。
你可以按照 任意顺序 完成任务。
请你返回完成所有任务的 最少 初始能量。
提示：
1 <= tasks.length <= 10^5
1 <= actual_i <= minimum_i <= 10^4

贪心。排序。
时间复杂度 O(nlogn)。
 */