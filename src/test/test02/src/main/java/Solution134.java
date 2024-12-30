public class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;

        int gasSum = 0;
        int costSum = 0;
        // 当前距离
        int curLen = 0;
        for (int i = 0; i < len * 2; i++) {
            gasSum += gas[i % len];
            costSum += cost[i % len];
            if (gasSum < costSum) {
                curLen = 0;
                gasSum = 0;
                costSum = 0;
                continue;
            }
            curLen++;
            if (curLen == len) {
                return i + 1 - len;
            }
        }
        return -1;
    }
}
/*
134. 加油站
https://leetcode.cn/problems/gas-station/

在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
提示:
gas.length == n
cost.length == n
1 <= n <= 10^5
0 <= gas[i], cost[i] <= 10^4

贪心。枚举开始点。
时间复杂度 O(n)
 */