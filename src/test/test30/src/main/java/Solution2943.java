import java.util.Arrays;

public class Solution2943 {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxH = getMax(hBars);
        int maxV = getMax(vBars);
        int min = Math.min(maxH, maxV);
        return min * min;
    }

    private int getMax(int[] bars) {
        int n = bars.length;
        Arrays.sort(bars);
        int max = 0;
        int i = 0;
        while (i < n) {
            // 分组循环
            int st = i;
            for (i++; i < n && bars[i] - bars[i - 1] == 1; i++) {
            }
            max = Math.max(max, i - st + 1);
        }
        return max;
    }
}
/*
2943. 最大化网格图中正方形空洞的面积
https://leetcode.cn/problems/maximize-area-of-square-hole-in-grid/description/

第 118 场双周赛 T2。

给你一个网格图，由 n + 2 条 横线段 和 m + 2 条 竖线段 组成，一开始所有区域均为 1 x 1 的单元格。
所有线段的编号从 1 开始。
给你两个整数 n 和 m 。
同时给你两个整数数组 hBars 和 vBars 。
- hBars 包含区间 [2, n + 1] 内 互不相同 的横线段编号。
- vBars 包含 [2, m + 1] 内 互不相同的 竖线段编号。
如果满足以下条件之一，你可以 移除 两个数组中的部分线段：
- 如果移除的是横线段，它必须是 hBars 中的值。
- 如果移除的是竖线段，它必须是 vBars 中的值。
请你返回移除一些线段后（可能不移除任何线段），剩余网格图中 最大正方形 空洞的面积，正方形空洞的意思是正方形 内部 不含有任何线段。
提示：
1 <= n <= 10^9
1 <= m <= 10^9
1 <= hBars.length <= 100
2 <= hBars[i] <= n + 1
1 <= vBars.length <= 100
2 <= vBars[i] <= m + 1
hBars 中的值互不相同。
vBars 中的值互不相同。

横竖分别统计+分组循环
时间复杂度 O(nlogn + mlogm)
 */