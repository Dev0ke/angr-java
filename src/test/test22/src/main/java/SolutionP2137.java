public class SolutionP2137 {
    static final double DELTA = 1e-6;

    public double equalizeWater(int[] buckets, int loss) {
        int n = buckets.length;
        double sum = 0; // 会爆int
        for (int v : buckets) sum += v;

        double left = 0;
        double right = sum / n;
        while (left + DELTA < right) {
            double mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(buckets, loss, mid)) {
                right = mid;
            } else {
                left = mid + DELTA;
            }
        }
        return left;
    }

    private boolean checkMid(int[] buckets, int loss, double target) {
        double pourIn = 0, pourOut = 0;
        for (int bucket : buckets) {
            if (bucket < target) {
                pourIn += target - bucket;
            } else {
                pourOut += bucket - target;
            }
        }
        return pourIn > pourOut * (100 - loss) / 100;
    }
}
/*
$2137. 通过倒水操作让所有的水桶所含水量相等
https://leetcode.cn/problems/pour-water-between-buckets-to-make-water-levels-equal/description/

你有 n 个水桶，每个水桶中所含的水量用一个 下标从 0 开始 的数组 buckets 给出，第 i 个水桶中有 buckets[i] 升水。
你想让所有的水桶中所含的水量相同。你可以从一个水桶向其它任意一个水桶倒任意数量的水（可以不是整数）。但是，你每倒 k 升水，百分之 loss 的水会洒掉。
请返回经过倒水操作，所有水桶中的水量相同时，每个水桶中的 最大 水量。如果你的答案和标准答案的误差不超过 10^-5，那么答案将被通过。
提示:
1 <= buckets.length <= 10^5
0 <= buckets[i] <= 10^5
0 <= loss <= 99

二分答案。
注意浮点数二分的写法。
时间复杂度 O(n log(sum/n))。
 */