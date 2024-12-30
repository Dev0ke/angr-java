import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SolutionP1956 {
    private int k;
    private List<Point> newPoints;

    public int minDayskVariants(int[][] points, int k) {
        this.k = k;
        newPoints = new ArrayList<>();
        for (int[] p : points) {
            newPoints.add(new Point(p[1] + p[0], p[1] - p[0]));
        }
        newPoints.sort(Comparator.comparingInt(o -> o.x));

        int l = 0, r = (int) 1e9;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (checkMid(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    private boolean checkMid(int t) {
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        int pos = 0;
        for (Point p : newPoints) {
            int x = p.x, y = p.y;
            mp.merge(y, 1, Integer::sum);
            while (x - newPoints.get(pos).x > 2 * t) {
                mp.merge(newPoints.get(pos).y, -1, Integer::sum);
                pos++;
            }
            for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
                int from = entry.getKey(), to = from + 2 * t;
                Map.Entry<Integer, Integer> cur = null;
                int cnt = 0;
                for (Map.Entry<Integer, Integer> subEntry : mp.subMap(from, true, to, true).entrySet()) {
                    cnt += subEntry.getValue();
                    cur = subEntry;
                }
                if (cnt >= k && !((x + from) % 2 != 0 && 2 * t == x - newPoints.get(pos).x && cur.getKey() - 2 * t == from)) {
                    return true;
                }
            }
        }
        return false;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
/*
$1956. 感染 K 种病毒所需的最短时间
https://leetcode.cn/problems/minimum-time-for-k-virus-variants-to-spread/description/

在无限大的二维平面上有 n 种 不同 的病毒。给定二维数组 points ，第 i 项 points[i] = [xi, yi] 说明第 0 天有一种病毒在点 (xi, yi) 。注意初始状态下，可能有 多种 病毒在 同一点 上。
每天，被感染的点会把它感染的病毒传播到上、下、左、右四个邻居点。
现给定一个整数 k ，问 最少 需要多少天，方能找到一点感染 至少 k 种病毒？
提示：
n == points.length
2 <= n <= 50
points[i].length == 2
1 <= xi, yi <= 10^9
2 <= k <= n

二分 + 滑动窗口。
https://leetcode.cn/problems/minimum-time-for-k-virus-variants-to-spread/solutions/1058007/c-er-fen-hua-dong-chuang-kou-by-mu-bai-6-49zw/
 */