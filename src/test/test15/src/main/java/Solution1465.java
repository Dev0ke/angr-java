import java.util.Arrays;

public class Solution1465 {
    private static final int MOD = (int) (1e9 + 7);

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long maxH = getMax(h, horizontalCuts);
        long maxW = getMax(w, verticalCuts);
        return (int) (maxH * maxW % MOD);
    }

    private int getMax(int n, int[] cuts) {
        Arrays.sort(cuts);
        int res = Math.max(cuts[0], n - cuts[cuts.length - 1]);
        for (int i = 1; i < cuts.length; i++) {
            res = Math.max(res, cuts[i] - cuts[i - 1]);
        }
        return res;
    }
}
/*
1465. 切割后面积最大的蛋糕
https://leetcode.cn/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/description/

矩形蛋糕的高度为 h 且宽度为 w，给你两个整数数组 horizontalCuts 和 verticalCuts，其中：
- horizontalCuts[i] 是从矩形蛋糕顶部到第  i 个水平切口的距离
- verticalCuts[j] 是从矩形蛋糕的左侧到第 j 个竖直切口的距离
请你按数组 horizontalCuts 和 verticalCuts 中提供的水平和竖直位置切割后，请你找出 面积最大 的那份蛋糕，并返回其 面积 。由于答案可能是一个很大的数字，因此需要将结果 对 10^9 + 7 取余 后返回。
提示：
2 <= h, w <= 10^9
1 <= horizontalCuts.length <= min(h - 1, 10^5)
1 <= verticalCuts.length <= min(w - 1, 10^5)
1 <= horizontalCuts[i] < h
1 <= verticalCuts[i] < w
题目数据保证 horizontalCuts 中的所有元素各不相同
题目数据保证 verticalCuts 中的所有元素各不相同

贪心。长和宽分别取最大值计算。
时间复杂度 O(nlogn + mlogm)
 */