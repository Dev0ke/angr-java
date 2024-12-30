public class Solution2409 {
    private static final int MAX_N = 12;
    private static final int[] DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private int[] preSum;

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        // 前缀和
        preSum = new int[MAX_N + 1];
        for (int i = 0; i < MAX_N; i++) {
            preSum[i + 1] = preSum[i] + DAYS[i];
        }

        // 线段取交集
        int arriveMax = Math.max(getIdx(arriveAlice), getIdx(arriveBob));
        int leaveMin = Math.min(getIdx(leaveAlice), getIdx(leaveBob));
        return Math.max(0, leaveMin - arriveMax + 1);
    }

    private int getIdx(String s) {
        int month = Integer.parseInt(s.substring(0, 2));
        int day = Integer.parseInt(s.substring(3, 5));
        return preSum[month - 1] + day;
    }
}
/*
2409. 统计共同度过的日子数
https://leetcode.cn/problems/count-days-spent-together/

第 87 场双周赛 T1。

Alice 和 Bob 计划分别去罗马开会。
给你四个字符串 arriveAlice ，leaveAlice ，arriveBob 和 leaveBob 。Alice 会在日期 arriveAlice 到 leaveAlice 之间在城市里（日期为闭区间），
而 Bob 在日期 arriveBob 到 leaveBob 之间在城市里（日期为闭区间）。每个字符串都包含 5 个字符，格式为 "MM-DD" ，对应着一个日期的月和日。
请你返回 Alice和 Bob 同时在罗马的天数。
你可以假设所有日期都在 同一个 自然年，而且 不是 闰年。每个月份的天数分别为：[31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31] 。
提示：
所有日期的格式均为 "MM-DD" 。
Alice 和 Bob 的到达日期都 早于或等于 他们的离开日期。
题目测试用例所给出的日期均为 非闰年 的有效日期。

模拟。把日期转化为一年中的第 n 天（即下标），再求交集即可。
时间复杂度 O(1)
 */