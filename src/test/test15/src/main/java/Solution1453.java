import java.util.ArrayList;
import java.util.List;

public class Solution1453 {
    private static final double DELTA = 1e-6;

    // 24ms
    public int numPoints(int[][] darts, int r) {
        int n = darts.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            List<double[]> angles = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                double dx = darts[j][0] - darts[i][0];
                double dy = darts[j][1] - darts[i][1];
                double dis = Math.hypot(dx, dy);

                if (dis > 2 * r + DELTA) continue;
                double B = Math.acos(dis / (r * 2));
                double A = Math.atan(dy / dx);
                // fix 精度，扩展到 [-pi, pi] 区域
                if (dx < 0) A = (dy > 0) ? A + Math.PI : A - Math.PI;
                double alpha = A - B;
                double beta = A + B;
                angles.add(new double[]{alpha, -1});
                angles.add(new double[]{beta, 1});
            }
            angles.sort((a, b) -> {
                if (Math.abs(a[0] - b[0]) < DELTA) {
                    return Double.compare(a[1], b[1]);
                }
                return Double.compare(a[0], b[0]);
            });
            int cnt = 1;
            for (double[] p : angles) {
                cnt -= (int) p[1];
                if (cnt > ans) ans = cnt;
            }
        }
        return ans;
    }
}
/*
1453. 圆形靶内的最大飞镖数量
https://leetcode.cn/problems/maximum-number-of-darts-inside-of-a-circular-dartboard/description/

Alice 向一面非常大的墙上掷出 n 支飞镖。给你一个数组 darts ，其中 darts[i] = [xi, yi] 表示 Alice 掷出的第 i 支飞镖落在墙上的位置。
Bob 知道墙上所有 n 支飞镖的位置。他想要往墙上放置一个半径为 r 的圆形靶。使 Alice 掷出的飞镖尽可能多地落在靶上。
给你整数 r ，请返回能够落在 任意 半径为 r 的圆形靶内或靶上的最大飞镖数。
提示：
1 <= darts.length <= 100
darts[i].length == 2
-10^4 <= xi, yi <= 10^4
darts 中的元素互不相同
1 <= r <= 5000

Angular Sweep（给定半径的圆内可以包围的最大点数）
https://www.geeksforgeeks.org/angular-sweep-maximum-points-can-enclosed-circle-given-radius/
原帖的解法似乎有精度问题。。
时间复杂度 O(n^2 * logn)。
 */