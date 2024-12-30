public class Solution2651 {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}
/*
2651. 计算列车到站时间
https://leetcode.cn/problems/calculate-delayed-arrival-time/

第 342 场周赛 T1。

给你一个正整数 arrivalTime 表示列车正点到站的时间（单位：小时），另给你一个正整数 delayedTime 表示列车延误的小时数。
返回列车实际到站的时间。
注意，该问题中的时间采用 24 小时制。
提示：
1 <= arrivaltime < 24
1 <= delayedTime <= 24

时间复杂度 O(1)
 */