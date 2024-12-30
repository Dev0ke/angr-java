import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1411 {
    private static final int MOD = (int) (1e9 + 7);

    public int numOfWays(int n) {
        List<Integer> validList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < 3; k++) {
                    if (k == j) {
                        continue;
                    }
                    // 三进制 bitmask
                    validList.add(i * 9 + j * 3 + k);
                }
            }
        }

        int sz = validList.size();
        boolean[][] valid = new boolean[sz][sz];
        for (int i = 0; i < sz; i++) {
            int mask1 = validList.get(i);
            int x1 = mask1 / 9;
            int x2 = mask1 / 3 % 3;
            int x3 = mask1 % 3;
            for (int j = 0; j < sz; j++) {
                int mask2 = validList.get(j);
                int y1 = mask2 / 9;
                int y2 = mask2 / 3 % 3;
                int y3 = mask2 % 3;
                if (x1 != y1 && x2 != y2 && x3 != y3) {
                    valid[i][j] = true;
                }
            }
        }

        // 滚动数组优化
        int[] f = new int[sz];
        Arrays.fill(f, 1);
        for (int i = 1; i < n; i++) {
            int[] g = new int[sz];
            for (int j = 0; j < sz; j++) {
                for (int k = 0; k < sz; k++) {
                    if (valid[k][j]) {
                        g[j] = (g[j] + f[k]) % MOD;
                    }
                }
            }
            f = g;
        }

        int res = 0;
        for (int x : f) {
            res = (res + x) % MOD;
        }
        return res;
    }
}
/*
1411. 给 N x 3 网格图涂色的方案数
https://leetcode.cn/problems/number-of-ways-to-paint-n-3-grid/

你有一个 n x 3 的网格图 grid ，你需要用 红，黄，绿 三种颜色之一给每一个格子上色，且确保相邻格子颜色不同（也就是有相同水平边或者垂直边的格子颜色不同）。
给你网格图的行数 n 。
请你返回给 grid 涂色的方案数。由于答案可能会非常大，请你返回答案对 10^9 + 7 取余的结果。
提示：
n == grid.length
grid[i].length == 3
1 <= n <= 5000

状态压缩动态规划
时间复杂度 O(T^2 * n) 其中 T 是满足要求的 type 的数量，在示例一中已经给出了 T = 12
空间复杂度 O(T^2) 滚动数组优化
也可以直接套 1931 题代码。
相似题目: 1931. 用三种不同颜色为网格涂色
https://leetcode.cn/problems/painting-a-grid-with-three-different-colors/
 */