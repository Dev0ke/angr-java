public class SolutionP774 {
    public double minmaxGasDist(int[] stations, int k) {
        double left = 0;
        double right = 1e8;

        while (right - left > 1e-6) {
            double mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(stations, k, mid)) {
                right = mid;
            } else {
                left = mid + 1e-6;
            }
        }
        return left;
    }

    // 间隔为 mid 是否成立 FFFTTT
    private boolean checkMid(int[] stations, int k, double mid) {
        int cnt = 0;
        for (int i = 1; i < stations.length; i++) {
            cnt += (int) ((stations[i] - stations[i - 1]) / mid);
        }
        return cnt <= k;
    }
}
/*
$774. 最小化去加油站的最大距离
https://leetcode.cn/problems/minimize-max-distance-to-gas-station/

整数数组 stations 表示 水平数轴 上各个加油站的位置。给你一个整数 k 。
请你在数轴上增设 k 个加油站，新增加油站可以位于 水平数轴 上的任意位置，而不必放在整数位置上。
设 penalty() 是：增设 k 个新加油站后，相邻 两个加油站间的最大距离。
请你返回 penalty() 可能的最小值。与实际答案误差在 10^-6 范围内的答案将被视作正确答案。
提示：
10 <= stations.length <= 2000
0 <= stations[i] <= 10^8
stations 按 严格递增 顺序排列
1 <= k <= 10^6

二分，注意浮点数
相似题目: $644. 子数组最大平均数 II
https://leetcode.cn/problems/maximum-average-subarray-ii/
 */