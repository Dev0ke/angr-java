import java.util.ArrayList;
import java.util.List;

public class Solution3288 {
    public int maxPathLength(int[][] coordinates, int k) {
        int n = coordinates.length;

        int kx = coordinates[k][0], ky = coordinates[k][1];
        List<Point> low = new ArrayList<>();
        List<Point> high = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Point p = new Point(coordinates[i][0], coordinates[i][1], i);
            if (p.x < kx && p.y < ky) low.add(p);
            else if (p.x > kx && p.y > ky) high.add(p);
        }
        return getLIS(low) + getLIS(high) + 1;
    }

    private int getLIS(List<Point> low) {
        low.sort((o1, o2) -> {
            if (o1.x == o2.x) return Integer.compare(o2.y, o1.y);
            return Integer.compare(o1.x, o2.x);
        });

        // LIS
        List<Integer> a = new ArrayList<>();
        for (Point p : low) {
            int x = p.y;
            int j = lowerBound(a, x);
            if (j == a.size()) a.add(x);
            else a.set(j, x);
        }
        return a.size();
    }

    private int lowerBound(List<Integer> a, int key) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a.get(m) >= key) r = m;
            else l = m + 1;
        }
        return l;
    }

    static class Point {
        int x, y, i;

        public Point(int x, int y, int i) {
            this.x = x;
            this.y = y;
            this.i = i;
        }
    }
}
/*
3288. 最长上升路径的长度
https://leetcode.cn/problems/length-of-the-longest-increasing-path/description/

第 139 场双周赛 T4。

给你一个长度为 n 的二维整数数组 coordinates 和一个整数 k ，其中 0 <= k < n 。
coordinates[i] = [xi, yi] 表示二维平面里一个点 (xi, yi) 。
如果一个点序列 (x1, y1), (x2, y2), (x3, y3), ..., (xm, ym) 满足以下条件，那么我们称它是一个长度为 m 的 上升序列 ：
- 对于所有满足 1 <= i < m 的 i 都有 xi < xi + 1 且 yi < yi + 1 。
- 对于所有 1 <= i <= m 的 i 对应的点 (xi, yi) 都在给定的坐标数组里。
请你返回包含坐标 coordinates[k] 的 最长上升路径 的长度。
提示：
1 <= n == coordinates.length <= 10^5
coordinates[i].length == 2
0 <= coordinates[i][0], coordinates[i][1] <= 10^9
coordinates 中的元素 互不相同 。
0 <= k <= n - 1

拆成两个集合，然后用 354 的二分做法。
相似题目: 354. 俄罗斯套娃信封问题
https://leetcode.cn/problems/russian-doll-envelopes/
进阶：包含坐标 coordinates[i] 的 最长上升路径 的长度。
rating 2475 (clist.by)
 */