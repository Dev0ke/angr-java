public class Solution223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);
        int overlapX = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int overlapY = Math.min(ay2, by2) - Math.max(ay1, by1);
        int overlapArea = Math.max(overlapX, 0) * Math.max(overlapY, 0);
        return area1 + area2 - overlapArea;
    }
}
/*
223. 矩形面积
https://leetcode.cn/problems/rectangle-area/description/

给你 二维 平面上两个 由直线构成且边与坐标轴平行/垂直 的矩形，请你计算并返回两个矩形覆盖的总面积。
每个矩形由其 左下 顶点和 右上 顶点坐标表示：
- 第一个矩形由其左下顶点 (ax1, ay1) 和右上顶点 (ax2, ay2) 定义。
- 第二个矩形由其左下顶点 (bx1, by1) 和右上顶点 (bx2, by2) 定义。
提示：
-10^4 <= ax1, ay1, ax2, ay2, bx1, by1, bx2, by2 <= 10^4

面积之和 减去 重叠面积。
时间复杂度 O(1)
 */