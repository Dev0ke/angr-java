public class Solution1401 {
    // 求圆心到矩形区域的最短距离
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        double dist = 0;
        if (xCenter < x1 || xCenter > x2) {
            dist += Math.min(pow(x1 - xCenter), pow(x2 - xCenter));
        }
        if (yCenter < y1 || yCenter > y2) {
            dist += Math.min(pow(y1 - yCenter), pow(y2 - yCenter));
        }
        return dist <= pow(radius);
    }

    private int pow(int x) {
        return x * x;
    }
}
/*
1401. 圆和矩形是否有重叠
https://leetcode.cn/problems/circle-and-rectangle-overlapping/description/

给你一个以 (radius, xCenter, yCenter) 表示的圆和一个与坐标轴平行的矩形 (x1, y1, x2, y2) ，其中 (x1, y1) 是矩形左下角的坐标，而 (x2, y2) 是右上角的坐标。
如果圆和矩形有重叠的部分，请你返回 true ，否则返回 false 。
换句话说，请你检测是否 存在 点 (xi, yi) ，它既在圆上也在矩形上（两者都包括点落在边界上的情况）。
提示：
1 <= radius <= 2000
-10^4 <= xCenter, yCenter <= 10^4
-10^4 <= x1 < x2 <= 10^4
-10^4 <= y1 < y2 <= 10^4

分类讨论 / 求圆心到矩形区域的最短距离
分类讨论 思路是分别判断：
- 圆心在中心矩形中
- 圆心在上、下、左、右部矩形中
- 圆心在左上、左下、右上、右下方圆角中
共 9 种情况。
求圆心到矩形区域的最短距离 思路是 4 条直线将平面分割成 9 个区域。
时间复杂度 O(1)。
 */