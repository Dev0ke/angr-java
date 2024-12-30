import java.util.HashMap;
import java.util.Map;

public class Solution2768 {
    public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        Map<Long, Integer> cntMap = new HashMap<>();
        for (int[] p : coordinates) {
            int x = p[0], y = p[1];
            // 以左上角表示受影响的矩形，(x,y) 会影响到 (x-1,y-1), (x-1,y), (x,y-1), (x,y)
            for (int nx = x - 1; nx <= x; nx++) {
                for (int ny = y - 1; ny <= y; ny++) {
                    // 注意要取到左上角
                    if (nx >= 0 && nx < m - 1 && ny >= 0 && ny < n - 1) {
                        long key = (long) nx << 32 | ny;
                        cntMap.put(key, cntMap.getOrDefault(key, 0) + 1);
                    }
                }
            }
        }

        long[] ans = new long[5];
        for (Integer val : cntMap.values()) {
            ans[val]++;
        }
        long total = (m - 1L) * (n - 1);
        ans[0] = total - ans[1] - ans[2] - ans[3] - ans[4];
        return ans;
    }
}
/*
2768. 黑格子的数目
https://leetcode.cn/problems/number-of-black-blocks/

第 108 场双周赛 T4。

给你两个整数 m 和 n ，表示一个下标从 0 开始的 m x n 的网格图。
给你一个下标从 0 开始的二维整数矩阵 coordinates ，其中 coordinates[i] = [x, y] 表示坐标为 [x, y] 的格子是 黑色的 ，所有没出现在 coordinates 中的格子都是 白色的。
一个块定义为网格图中 2 x 2 的一个子矩阵。更正式的，对于左上角格子为 [x, y] 的块，其中 0 <= x < m - 1 且 0 <= y < n - 1 ，包含坐标为 [x, y] ，[x + 1, y] ，[x, y + 1] 和 [x + 1, y + 1] 的格子。
请你返回一个下标从 0 开始长度为 5 的整数数组 arr ，arr[i] 表示恰好包含 i 个 黑色 格子的块的数目。
提示：
2 <= m <= 10^5
2 <= n <= 10^5
0 <= coordinates.length <= 10^4
coordinates[i].length == 2
0 <= coordinates[i][0] < m
0 <= coordinates[i][1] < n
coordinates 中的坐标对两两互不相同。

哈希表统计。
比赛时候考虑 16 种网格的去重，把自己绕晕了。。
时间复杂度 O(|coordinates|)
 */