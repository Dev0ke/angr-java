import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution939 {
    private static final int MAX_N = (int) (4e4 + 5);
    private static final int INF = (int) 1e9;

    public int minAreaRect(int[][] points) {
        TreeMap<Integer, List<Integer>> rows = new TreeMap<>();
        for (int[] p : points) {
            int x = p[0], y = p[1];
            rows.computeIfAbsent(x, e -> new ArrayList<>()).add(y);
        }

        int ans = INF;
        Map<Integer, Integer> lastX = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> entry : rows.entrySet()) {
            int x = entry.getKey();
            List<Integer> row = entry.getValue();
            row.sort(null);
            int sz = row.size();
            for (int i = 0; i < sz; i++) {
                for (int j = i + 1; j < sz; j++) {
                    int y1 = row.get(i), y2 = row.get(j);
                    int code = MAX_N * y1 + y2;
                    if (lastX.containsKey(code)) {
                        ans = Math.min(ans, (x - lastX.get(code)) * (y2 - y1));
                    }
                    lastX.put(code, x);
                }
            }
        }
        return ans == INF ? 0 : ans;
    }
}
/*
939. 最小面积矩形
https://leetcode.cn/problems/minimum-area-rectangle/description/

给定在 xy 平面上的一组点，确定由这些点组成的矩形的最小面积，其中矩形的边平行于 x 轴和 y 轴。
如果没有任何矩形，就返回 0。
提示：
1 <= points.length <= 500
0 <= points[i][0] <= 40000
0 <= points[i][1] <= 40000
所有的点都是不同的。

排序后枚举。
时间复杂度 O(n^2)。
相似题目: 963. 最小面积矩形 II
https://leetcode.cn/problems/minimum-area-rectangle-ii/description/
 */