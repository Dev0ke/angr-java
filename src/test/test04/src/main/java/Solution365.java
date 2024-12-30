public class Solution365 {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity + jug2Capacity < targetCapacity) {
            return false;
        }
        if (jug1Capacity == 0 || jug2Capacity == 0) {
            return targetCapacity == 0 || jug1Capacity + jug2Capacity == targetCapacity;
        }
        return targetCapacity % getGCD(jug1Capacity, jug2Capacity) == 0;
    }

    private int getGCD(int num1, int num2) {
        if (num1 == 0) {
            return num2;
        }
        return getGCD(num2 % num1, num1);
    }
}
/*
365. 水壶问题
https://leetcode.cn/problems/water-and-jug-problem/

有两个水壶，容量分别为 jug1Capacity 和 jug2Capacity 升。水的供应是无限的。确定是否有可能使用这两个壶准确得到 targetCapacity 升。
如果可以得到 targetCapacity 升水，最后请用以上水壶中的一或两个来盛放取得的 targetCapacity 升水。
你可以：
- 装满任意一个水壶
- 清空任意一个水壶
- 从一个水壶向另外一个水壶倒水，直到装满或者倒空
提示:
1 <= jug1Capacity, jug2Capacity, targetCapacity <= 10^6

裴蜀定理。OI WIKI: https://oi-wiki.org/math/number-theory/bezouts/
ax+by=z 有解当且仅当 z 是 x,y 的最大公约数的倍数。
相似题目: 1250. 检查「好数组」
https://leetcode.cn/problems/check-if-it-is-a-good-array/
 */