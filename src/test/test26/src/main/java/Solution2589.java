import java.util.Arrays;
import java.util.Comparator;

public class Solution2589 {
    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, Comparator.comparingInt(o -> o[1]));
        boolean[] isRun = new boolean[2001];
        for (int[] task : tasks) {
            int start = task[0], end = task[1], duration = task[2];
            for (int i = start; i <= end; i++) {
                if (isRun[i]) {
                    duration--;
                }
            }
            if (duration > 0) {
                for (int i = end; duration > 0; i--) {
                    if (isRun[i]) continue;
                    isRun[i] = true;
                    duration--;
                }
            }
        }

        int res = 0;
        for (int i = 1; i <= 2000; i++) {
            if (isRun[i]) {
                res++;
            }
        }
        return res;
    }
}
/*
2589. 完成所有任务的最少时间
https://leetcode.cn/problems/minimum-time-to-complete-all-tasks/

第 336 场周赛 T4。

你有一台电脑，它可以 同时 运行无数个任务。给你一个二维整数数组 tasks ，
其中 tasks[i] = [starti, endi, durationi] 表示第 i 个任务需要在 闭区间 时间段 [starti, endi] 内运行 durationi 个整数时间点（但不需要连续）。
当电脑需要运行任务时，你可以打开电脑，如果空闲时，你可以将电脑关闭。
请你返回完成所有任务的情况下，电脑最少需要运行多少秒。
提示：
1 <= tasks.length <= 2000
tasks[i].length == 3
1 <= starti, endi <= 2000
1 <= durationi <= endi - starti + 1

贪心 + 暴力。
按 右端点 升序排序，与前一个若有重叠部分必然是其后缀。
时间复杂度 O(n^2)
相似题目: LCP 32. 批量处理任务
https://leetcode.cn/problems/t3fKg1/
 */