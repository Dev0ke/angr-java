public class Solution2406 {
    public int minGroups(int[][] intervals) {
        int len = 1000005;

        // 差分数组
        int[] diff = new int[len + 1];
        for (int[] interval : intervals) {
            int i = interval[0];
            int j = interval[1];
            diff[i] += 1;
            diff[j + 1] -= 1;
        }

        int max = 0;
        int[] res = new int[len];
        res[0] = diff[0];
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] + diff[i];
            max = Math.max(max, res[i]);
        }
        return max;
    }
}
/*
2406. 将区间分为最少组数
https://leetcode.cn/problems/divide-intervals-into-minimum-number-of-groups/

第 310 场周赛 T3。

给你一个二维整数数组 intervals ，其中 intervals[i] = [lefti, righti] 表示 闭 区间 [lefti, righti] 。
你需要将 intervals 划分为一个或者多个区间 组 ，每个区间 只 属于一个组，且同一个组中任意两个区间 不相交 。
请你返回 最少 需要划分成多少个组。
如果两个区间覆盖的范围有重叠（即至少有一个公共数字），那么我们称这两个区间是 相交 的。比方说区间 [1, 5] 和 [5, 8] 相交。
提示：
1 <= intervals.length <= 10^5
intervals[i].length == 2
1 <= lefti <= righti <= 10^6

差分数组模拟。
相似题目: $253. 会议室 II
https://leetcode.cn/problems/meeting-rooms-ii/
732. 我的日程安排表 III
https://leetcode.cn/problems/my-calendar-iii/
 */