public class Solution2739 {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int ans = 0;
        while (mainTank >= 5) {
            int cost = mainTank / 5 * 5;
            mainTank -= cost;
            int add = Math.min(additionalTank, cost / 5);
            mainTank += add;
            additionalTank -= add;
            ans += cost * 10;
        }
        return ans + mainTank * 10;
    }
}
/*
2739. 总行驶距离
https://leetcode.cn/problems/total-distance-traveled/

第 350 场周赛 T1。

卡车有两个油箱。给你两个整数，mainTank 表示主油箱中的燃料（以升为单位），additionalTank 表示副油箱中的燃料（以升为单位）。
该卡车每耗费 1 升燃料都可以行驶 10 km。每当主油箱使用了 5 升燃料时，如果副油箱至少有 1 升燃料，则会将 1 升燃料从副油箱转移到主油箱。
返回卡车可以行驶的最大距离。
注意：从副油箱向主油箱注入燃料不是连续行为。这一事件会在每消耗 5 升燃料时突然且立即发生。
提示：
1 <= mainTank, additionalTank <= 100

模拟。
时间复杂度 O(log(5) n)
 */