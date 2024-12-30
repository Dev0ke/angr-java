import java.util.Arrays;

public class Solution452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                // 注意溢出 不能直接 o1[0] - o2[0]
                return Integer.compare(o1[0], o2[0]);
            }
            // 注意溢出 不能直接 o1[1] - o2[1]
            return Integer.compare(o1[1], o2[1]);
        });

        int right = points[0][1];
        int cnt = 1;
        for (int[] point : points) {
            if (point[0] > right) {
                right = point[1];
                cnt++;
            }
        }
        return cnt;
    }
}
/*
452. 用最少数量的箭引爆气球
https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/

在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，
因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend，
且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。
我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
提示：
1 <= points.length <= 10^4
points[i].length == 2
-2^31 <= xstart < xend <= 2^31 - 1

贪心。考虑箭总在气球的右边界射出
按右边界升序排序，当左边界大于当前右边界时，需要下一箭才能引爆。
时间复杂度 O(nlogn)
相似题目: 435. 无重叠区间
https://leetcode.cn/problems/non-overlapping-intervals/
 */