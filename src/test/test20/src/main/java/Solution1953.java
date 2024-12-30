public class Solution1953 {
    public long numberOfWeeks(int[] milestones) {
        int max = milestones[0];
        long sum = 0;
        for (int milestone : milestones) {
            max = Math.max(max, milestone);
            sum += milestone;
        }
        long diff = sum - max;
        return Math.min(sum, diff * 2 + 1);
    }
}
/*
1953. 你可以工作的最大周数
https://leetcode.cn/problems/maximum-number-of-weeks-for-which-you-can-work/

第 252 场周赛 T2。

给你 n 个项目，编号从 0 到 n - 1 。同时给你一个整数数组 milestones ，其中每个 milestones[i] 表示第 i 个项目中的阶段任务数量。
你可以按下面两个规则参与项目中的工作：
- 每周，你将会完成 某一个 项目中的 恰好一个 阶段任务。你每周都 必须 工作。
- 在 连续的 两周中，你 不能 参与并完成同一个项目中的两个阶段任务。
一旦所有项目中的全部阶段任务都完成，或者仅剩余一个阶段任务都会导致你违反上面的规则，那么你将 停止工作 。注意，由于这些条件的限制，你可能无法完成所有阶段任务。
返回在不违反上面规则的情况下你 最多 能工作多少周。
提示：
n == milestones.length
1 <= n <= 10^5
1 <= milestones[i] <= 10^9

找出任务数量最多的项目。观察除此之外项目的任务数量之和：
1 2 3 = 6
1 2 4 = 7
1 2 5 = 7
不难得出，答案不会超过除最多之外的和 * 2 + 1，同时显然答案也不会超过原数组各项之和。
取二者较小值即可。
 */