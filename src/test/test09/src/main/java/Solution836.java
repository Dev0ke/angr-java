public class Solution836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // rec1 [x1, y1, x2, y2]
        int aX1 = rec1[0];
        int aY1 = rec1[1];
        int aX2 = rec1[2];
        int aY2 = rec1[3];
        // rec2 [x1, y1, x2, y2]
        int bX1 = rec2[0];
        int bY1 = rec2[1];
        int bX2 = rec2[2];
        int bY2 = rec2[3];

        // x 轴相交
        boolean rec1ContainRec2X = bX1 < aX2 && bX2 > aX1;
        // y 轴相交
        boolean rec1ContainRec2Y = bY1 < aY2 && bY2 > aY1;

        // 矩形重叠即为 xy 轴相交
        return rec1ContainRec2X && rec1ContainRec2Y;
    }
}
/*
836. 矩形重叠
https://leetcode.cn/problems/rectangle-overlap/

第 85 场周赛 T1。

矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。矩形的上下边平行于 x 轴，左右边平行于 y 轴。
如果相交的面积为 正 ，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
给出两个矩形 rec1 和 rec2 。如果它们重叠，返回 true；否则，返回 false 。
提示：
rect1.length == 4
rect2.length == 4
-109 <= rec1[i], rec2[i] <= 10^9
rec1 和 rec2 表示一个面积不为零的有效矩形

需要明确的是，只在角或边接触的两个矩形不构成重叠。
用草稿纸稍微推导一下即可
 */