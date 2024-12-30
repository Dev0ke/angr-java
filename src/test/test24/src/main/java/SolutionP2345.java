import java.util.Arrays;

public class SolutionP2345 {
    public int visibleMountains(int[][] peaks) {
        int n = peaks.length;
        int[][] intervals = new int[n][];
        for (int i = 0; i < n; i++) {
            int x = peaks[i][0], y = peaks[i][1];
            intervals[i] = new int[]{x - y, x + y};
        }
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) return Integer.compare(o2[1], o1[1]);
            return Integer.compare(o1[0], o2[0]);
        });

        int count = 0;
        int maxRight = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (intervals[i][1] > maxRight) {
                int left = intervals[i][0], right = intervals[i][1];
                // 除非两座或两座以上的山完全重叠。
                if (i + 1 < n) {
                    int[] next = intervals[i + 1];
                    if (next[0] == left && next[1] == right) count--;
                }
                count++;
                maxRight = right;
            }
        }
        return count;
    }
}
/*
$2345. 寻找可见山的数量
https://leetcode.cn/problems/finding-the-number-of-visible-mountains/description/

给定一个 下标从 0 开始 的二维整数数组 peaks，其中 peaks[i] = [xi, yi] 表示山 i 在坐标 (xi, yi) 处有一个峰值。山可以被描述为一个直角等腰三角形，它的底部沿着 x 轴，山峰处有一个直角。更正式地说，上山和下山的 梯度 分别为 1 和 -1。
一座山如果它的顶峰不在另一座山 (包括其他山的边界) 之内，那么它被认为是 可见 的。
返回可见山的数量。
提示:
1 <= peaks.length <= 10^5
peaks[i].length == 2
1 <= xi, yi <= 10^5

由于都是等腰直角三角形，只要底边被包含在大三角形的底边内，整个三角形就会被包含在里面，我们先对区间排序，再去重即可。
 */