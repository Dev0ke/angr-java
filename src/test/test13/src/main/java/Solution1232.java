public class Solution1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        int len = coordinates.length;

        // 斜率
        int[] point0 = coordinates[0];
        int[] point1 = coordinates[1];
        int dx = point1[0] - point0[0];
        int dy = point1[1] - point0[1];
        for (int i = 2; i < len; i++) {
            int[] pointI = coordinates[i];
            int dx1 = pointI[0] - point0[0];
            int dy1 = pointI[1] - point0[1];
            if (dx * dy1 != dy * dx1) {
                return false;
            }
        }
        return true;
    }
}
/*
1232. 缀点成线
https://leetcode.cn/problems/check-if-it-is-a-straight-line/

给定一个数组 coordinates ，其中 coordinates[i] = [x, y] ， [x, y] 表示横坐标为 x、纵坐标为 y 的点。请你来判断，这些点是否在该坐标系中属于同一条直线上。
提示：
2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates 中不含重复的点

数学，比较斜率。
 */