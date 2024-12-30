import java.util.Arrays;
import java.util.Comparator;

public class Solution3143 {
    public int maxPointsInsideSquare(int[][] points, String s) {
        int n = points.length;
        Point[] pointsArr = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1];
            int chebyshevDistance = Math.max(Math.abs(x), Math.abs(y));
            pointsArr[i] = new Point(x, y, chebyshevDistance, s.charAt(i));
        }
        Arrays.sort(pointsArr, Comparator.comparingInt(o -> o.chebyshevDistance));

        int ans = 0;
        boolean[] vis = new boolean[26];
        int i = 0;
        while (i < n) {
            // 分组循环
            int st = i;
            for (i++; i < n && pointsArr[i].chebyshevDistance == pointsArr[st].chebyshevDistance; i++) {
            }
            boolean flag = false;
            for (int j = st; j < i; j++) {
                Point p = pointsArr[j];
                if (!vis[p.ch - 'a']) {
                    vis[p.ch - 'a'] = true;
                } else {
                    flag = true;
                    break;
                }
            }
            if (flag) break;
            ans += i - st;
        }
        return ans;
    }

    static class Point {
        // 切比雪夫距离
        int x, y, chebyshevDistance;
        char ch;

        public Point(int x, int y, int chebyshevDistance, char ch) {
            this.x = x;
            this.y = y;
            this.chebyshevDistance = chebyshevDistance;
            this.ch = ch;
        }
    }
}
/*
3143. 正方形中的最多点数
https://leetcode.cn/problems/maximum-points-inside-the-square/description/

第 130 场双周赛 T2。

给你一个二维数组 points 和一个字符串 s ，其中 points[i] 表示第 i 个点的坐标，s[i] 表示第 i 个点的 标签 。
如果一个正方形的中心在 (0, 0) ，所有边都平行于坐标轴，且正方形内 不 存在标签相同的两个点，那么我们称这个正方形是 合法 的。
请你返回 合法 正方形中可以包含的 最多 点数。
注意：
- 如果一个点位于正方形的边上或者在边以内，则认为该点位于正方形内。
- 正方形的边长可以为零。
提示：
1 <= s.length, points.length <= 10^5
points[i].length == 2
-10^9 <= points[i][0], points[i][1] <= 10^9
s.length == points.length
points 中的点坐标互不相同。
s 只包含小写英文字母。

转化为 切比雪夫距离 + 排序 + 分组循环。
时间复杂度 O(nlogn)。
相似题目: 3102. 最小化曼哈顿距离
https://leetcode.cn/problems/minimize-manhattan-distances/description/
 */