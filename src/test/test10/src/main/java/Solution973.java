import java.util.Arrays;
import java.util.Comparator;

public class Solution973 {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, Comparator.comparingInt(o -> (o[0] * o[0] + o[1] * o[1])));
        return Arrays.copyOf(points, k);
    }
}
/*
973. 最接近原点的 K 个点
https://leetcode.cn/problems/k-closest-points-to-origin/

第 119 场周赛 T1。

给定一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点，并且是一个整数 k ，返回离原点 (0,0) 最近的 k 个点。
这里，平面上两点之间的距离是 欧几里德距离（ √(x1 - x2)2 + (y1 - y2)2 ）。
你可以按 任何顺序 返回答案。除了点坐标的顺序之外，答案 确保 是 唯一 的。
提示：
1 <= k <= points.length <= 10^4
-10^4 < xi, yi < 10^4

按平方和升序排列后，返回子数组即可。
 */
