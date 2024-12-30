import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionP711 {
    private int[][] grid;
    private int M;
    private int N;
    private boolean[][] visited;
    private List<Integer> shape;

    public int numDistinctIslands2(int[][] grid) {
        this.grid = grid;
        M = grid.length;
        N = grid[0].length;
        visited = new boolean[M][N];
        Set<String> shapes = new HashSet<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                shape = new ArrayList<>();
                explore(i, j);
                if (!shape.isEmpty()) {
                    shapes.add(canonical(shape));
                }
            }
        }
        return shapes.size();
    }

    private void explore(int i, int j) {
        if (i >= 0 && i < M && j >= 0 && j < N && grid[i][j] == 1 && !visited[i][j]) {
            visited[i][j] = true;
            shape.add(i * N + j);
            explore(i + 1, j);
            explore(i - 1, j);
            explore(i, j + 1);
            explore(i, j - 1);
        }
    }

    // 规范化哈希
    private String canonical(List<Integer> shape) {
        int sz = shape.size();
        String ans = "";
        int lift = M + N;
        int[] out = new int[sz];
        int[] xs = new int[sz];
        int[] ys = new int[sz];

        for (int c = 0; c < 8; c++) {
            int t = 0;
            for (int s : shape) {
                int x = s / N;
                int y = s % N;
                // [x,y] [x,-y] [-x,y] [-x,-y]
                // [y,x] [y,-x] [-y,x] [-y,-x]
                xs[t] = c <= 1 ? x : (c <= 3 ? -x : (c <= 5 ? y : -y));
                ys[t] = c <= 3 ? (c % 2 == 0 ? y : -y) : (c % 2 == 0 ? x : -x);
                t++;
            }

            int mx = Arrays.stream(xs).min().orElseThrow();
            int my = Arrays.stream(ys).min().orElseThrow();

            for (int j = 0; j < sz; j++) {
                out[j] = (xs[j] - mx) * lift + (ys[j] - my);
            }
            Arrays.sort(out);
            String candidate = Arrays.toString(out);
            if (ans.compareTo(candidate) < 0) {
                ans = candidate;
            }
        }
        return ans;
    }
}
/*
$711. 不同岛屿的数量 II
https://leetcode.cn/problems/number-of-distinct-islands-ii/

给定一个 m x n 二进制数组表示的网格 grid ，一个岛屿由 四连通 （上、下、左、右四个方向）的 1 组成（代表陆地）。你可以认为网格的四周被海水包围。
如果两个岛屿的形状相同，或者通过旋转（顺时针旋转 90°，180°，270°）、翻转（左右翻转、上下翻转）后形状相同，那么就认为这两个岛屿是相同的。
返回 这个网格中形状 不同 的岛屿的数量 。
提示:
m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] 不是 0 就是 1.

难度升级，可以旋转，翻转。
规范性哈希。枚举 旋转+翻转 8 种情况的可能，用一个最小的矩形框住岛屿。
相似题目: $694. 不同岛屿的数量
https://leetcode.cn/problems/number-of-distinct-islands/
 */