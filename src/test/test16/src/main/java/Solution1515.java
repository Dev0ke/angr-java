public class Solution1515 {
    private final double delta = 1e-6;
    private int[][] positions;

    public double getMinDistSum(int[][] positions) {
        this.positions = positions;

        // ternarySearch_u
        double l = 0, r = 100;
        while (r - l > delta) {
            double m1 = (l * 2 + r) / 3;
            double m2 = (l + r * 2) / 3;
            if (f(m1) > f(m2)) l = m1;
            else r = m2;
        }
        double res = f(l);
        for (double i = l + 1; i <= r; i++) {
            res = Math.min(res, f(i));
        }
        return res;
    }

    // 固定 xc，使用三分法找出最优的 yc
    private double f(double xc) {
        // ternarySearch_u
        double l = 0, r = 100;
        while (r - l > delta) {
            double m1 = (l * 2 + r) / 3;
            double m2 = (l + r * 2) / 3;
            if (f1(xc, m1) > f1(xc, m2)) l = m1;
            else r = m2;
        }
        double res = f1(xc, l);
        for (double i = l + 1; i <= r; i++) {
            res = Math.min(res, f1(xc, i));
        }
        return res;
    }

    // 计算服务中心 (xc, yc) 到客户的欧几里得距离之和
    private double f1(double xc, double yc) {
        double res = 0;
        for (int[] p : positions) {
            res += Math.sqrt((p[0] - xc) * (p[0] - xc) + (p[1] - yc) * (p[1] - yc));
        }
        return res;
    }
}
/*
1515. 服务中心的最佳位置
https://leetcode.cn/problems/best-position-for-a-service-centre/description/

一家快递公司希望在新城市建立新的服务中心。公司统计了该城市所有客户在二维地图上的坐标，并希望能够以此为依据为新的服务中心选址：使服务中心 到所有客户的欧几里得距离的总和最小 。
给你一个数组 positions ，其中 positions[i] = [xi, yi] 表示第 i 个客户在二维地图上的位置，返回到所有客户的 欧几里得距离的最小总和 。
换句话说，请你为服务中心选址，该位置的坐标 [xcentre, ycentre] 需要使下面的公式取到最小值：
与真实值误差在 10-5之内的答案将被视作正确答案。
提示：
1 <= positions.length <= 50
positions[i].length == 2
0 <= xi, yi <= 100

凹函数，三分法取最小值。
时间复杂度 O(UlogU * nUlogU)。其中 n = positions.length, U = 100
注意 delta 取 1e-5 会被卡精度。
 */