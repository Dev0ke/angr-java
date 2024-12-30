public class Solution2543 {
    public boolean isReachable(int targetX, int targetY) {
        int gcd = getGCD(targetX, targetY);
        // 是否为 2 的幂
        return (gcd & (gcd - 1)) == 0;
    }

    private int getGCD(int num1, int num2) {
        if (num1 == 0) {
            return num2;
        }
        return getGCD(num2 % num1, num1);
    }
}
/*
2543. 判断一个点是否可以到达
https://leetcode.cn/problems/check-if-point-is-reachable/

第 96 场双周赛 T4。

给你一个无穷大的网格图。一开始你在 (1, 1) ，你需要通过有限步移动到达点 (targetX, targetY) 。
每一步 ，你可以从点 (x, y) 移动到以下点之一：
- (x, y - x)
- (x - y, y)
- (2 * x, y)
- (x, 2 * y)
给你两个整数 targetX 和 targetY ，分别表示你最后需要到达点的 X 和 Y 坐标。如果你可以从 (1, 1) 出发到达这个点，请你返回true ，否则返回 false 。
提示：
1 <= targetX, targetY <= 10^9

数学
前两个操作是辗转相除法，即 GCD。
后两个移动让 GCD 乘以 2^k.
时间复杂度 O(logmin(targetX, targetY))
空间复杂度 O(1)
 */