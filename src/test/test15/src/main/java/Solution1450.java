public class Solution1450 {
    private static final int MAX_LEN = 1005;

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int len = startTime.length;

        // 差分
        int[] diff = new int[MAX_LEN];

        for (int i = 0; i < len; i++) {
            diff[startTime[i]] += 1;
            diff[endTime[i] + 1] -= 1;
        }

        // 原数组
        int[] res = new int[MAX_LEN];
        res[0] = diff[0];
        for (int i = 1; i < MAX_LEN; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res[queryTime];
    }
}
/*
1450. 在既定时间做作业的学生人数
https://leetcode.cn/problems/number-of-students-doing-homework-at-a-given-time/

给你两个整数数组 startTime（开始时间）和 endTime（结束时间），并指定一个整数 queryTime 作为查询时间。
已知，第 i 名学生在 startTime[i] 时开始写作业并于 endTime[i] 时完成作业。
请返回在查询时间 queryTime 时正在做作业的学生人数。形式上，返回能够使 queryTime 处于区间 [startTime[i], endTime[i]]（含）的学生人数。
提示：
startTime.length == endTime.length
1 <= startTime.length <= 100
1 <= startTime[i] <= endTime[i] <= 1000
1 <= queryTime <= 1000

差分模拟
时间复杂度 O(n)
 */