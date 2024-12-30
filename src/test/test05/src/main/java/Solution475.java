import java.util.TreeSet;

public class Solution475 {
    public int findRadius(int[] houses, int[] heaters) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int heater : heaters) {
            treeSet.add(heater);
        }
        // 贪心
        // 求每个房屋离最近加热器的距离
        int len = houses.length;
        int[] minDistances = new int[len];
        for (int i = 0; i < len; i++) {
            Integer ceiling = treeSet.ceiling(houses[i]);
            Integer floor = treeSet.floor(houses[i]);
            minDistances[i] = Integer.MAX_VALUE;
            if (ceiling != null) {
                minDistances[i] = Math.min(minDistances[i], ceiling - houses[i]);
            }
            if (floor != null) {
                minDistances[i] = Math.min(minDistances[i], houses[i] - floor);
            }
        }
        // 再找 加热器的最大距离
        int res = 0;
        for (int minDistance : minDistances) {
            res = Math.max(res, minDistance);
        }
        return res;
    }
}
/*
475. 供暖器
https://leetcode.cn/problems/heaters/

冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
在加热器的加热半径范围内的每个房屋都可以获得供暖。
现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
提示：
1 <= houses.length, heaters.length <= 3 * 10^4
1 <= houses[i], heaters[i] <= 10^9

贪心。
 */