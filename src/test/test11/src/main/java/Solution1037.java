public class Solution1037 {
    public boolean isBoomerang(int[][] points) {
        int x1 = points[0][0];
        int y1 = points[0][1];
        int x2 = points[1][0];
        int y2 = points[1][1];
        int x3 = points[2][0];
        int y3 = points[2][1];

        // 这些点 各不相同
        if ((x1 == x2 && y1 == y2) || (x1 == x3 && y1 == y3) || (x2 == x3 && y2 == y3)) {
            return false;
        }
        // 不在一条直线上
        return (x2 - x1) * (y3 - y1) != (x3 - x1) * (y2 - y1);
    }
}
/*
1037. 有效的回旋镖
https://leetcode.cn/problems/valid-boomerang/

给定一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点，如果这些点构成一个 回旋镖 则返回 true 。
回旋镖 定义为一组三个点，这些点 各不相同 且 不在一条直线上 。
提示：
points.length == 3
points[i].length == 2
0 <= xi, yi <= 100

比较斜率
 */