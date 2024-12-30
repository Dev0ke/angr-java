import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution2008 {
    public long maxTaxiEarnings(int n, int[][] rides) {
        int len = rides.length;

        Arrays.sort(rides, Comparator.comparingInt(o -> o[1]));

        long[] f = new long[len + 1];
        for (int i = 1; i <= len; i++) {
            int[] ri = rides[i - 1];

            // 二分优化
            int left = 0;
            int right = i - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (rides[mid][1] > ri[0]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            int last = left;

            // 选 or 不选
            // 可以 盈利 endi - starti + tipi 元
            f[i] = Math.max(f[i - 1], f[last] + (ri[1] - ri[0] + ri[2]));
        }
        return f[len];
    }

    // O(n)
    public long maxTaxiEarnings2(int n, int[][] rides) {
        List<int[]>[] rideMp = new ArrayList[n + 1];
        Arrays.setAll(rideMp, e -> new ArrayList<>());
        for (int[] p : rides) {
            rideMp[p[1]].add(p);
        }

        long[] f = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            f[i] = f[i - 1];
            for (int[] p : rideMp[i]) {
                f[i] = Math.max(f[i], f[p[0]] + p[1] - p[0] + p[2]);
            }
        }
        return f[n];
    }
}
/*
2008. 出租车的最大盈利
https://leetcode.cn/problems/maximum-earnings-from-taxi/

第 61 场双周赛 T3。

你驾驶出租车行驶在一条有 n 个地点的路上。这 n 个地点从近到远编号为 1 到 n ，你想要从 1 开到 n ，通过接乘客订单盈利。你只能沿着编号递增的方向前进，不能改变方向。
乘客信息用一个下标从 0 开始的二维数组 rides 表示，其中 rides[i] = [starti, endi, tipi] 表示第 i 位乘客需要从地点 starti 前往 endi ，愿意支付 tipi 元的小费。
每一位 你选择接单的乘客 i ，你可以 盈利 endi - starti + tipi 元。你同时 最多 只能接一个订单。
给你 n 和 rides ，请你返回在最优接单方案下，你能盈利 最多 多少元。
注意：你可以在一个地点放下一位乘客，并在同一个地点接上另一位乘客。
提示：
1 <= n <= 10^5
1 <= rides.length <= 3 * 10^4
rides[i].length == 3
1 <= starti < endi <= n
1 <= tipi <= 10^5

动态规划 + 二分优化
相似题目: 1235. 规划兼职工作
https://leetcode.cn/problems/maximum-profit-in-job-scheduling/
 */