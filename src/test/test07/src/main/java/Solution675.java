import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution675 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int M;
    private int N;

    public int cutOffTree(List<List<Integer>> forest) {
        M = forest.size();
        N = forest.get(0).size();

        // 树的高度 [x,y]
        Map<Integer, int[]> heightMap = new HashMap<>();
        List<Integer> heightList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int height = forest.get(i).get(j);
                if (height > 1) {
                    heightMap.put(height, new int[]{i, j});
                    heightList.add(height);
                }
            }
        }
        // 你需要按照树的高度从低向高砍掉所有的树
        Collections.sort(heightList);

        int res = 0;
        int[] src = {0, 0};
        for (int height : heightList) {
            int[] target = heightMap.get(height);
            int dist = bfs(forest, src, target);
            src = target;
            if (dist == -1) {
                return -1;
            } else {
                res += dist;
            }
        }
        return res;
    }

    private int bfs(List<List<Integer>> forest, int[] src, int[] target) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[M][N];
        queue.add(src);
        visited[src[0]][src[1]] = true;
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                if (Arrays.equals(cur, target)) {
                    return dist;
                }

                for (int[] dir : DIRECTIONS) {
                    int nextM = cur[0] + dir[0];
                    int nextN = cur[1] + dir[1];
                    if (nextM >= 0 && nextM < M && nextN >= 0 && nextN < N && !visited[nextM][nextN]
                            && forest.get(nextM).get(nextN) > 0) {
                        visited[nextM][nextN] = true;
                        queue.add(new int[]{nextM, nextN});
                    }
                }
            }
            dist++;
        }
        return -1;
    }
}
/*
675. 为高尔夫比赛砍树
https://leetcode.cn/problems/cut-off-trees-for-golf-event/

你被请来给一个要举办高尔夫比赛的树林砍树。树林由一个 m x n 的矩阵表示， 在这个矩阵中：
- 0 表示障碍，无法触碰
- 1 表示地面，可以行走
- 比 1 大的数 表示有树的单元格，可以行走，数值表示树的高度
每一步，你都可以向上、下、左、右四个方向之一移动一个单位，如果你站的地方有一棵树，那么你可以决定是否要砍倒它。
你需要按照树的高度从低向高砍掉所有的树，每砍过一颗树，该单元格的值变为 1（即变为地面）。
你将从 (0, 0) 点开始工作，返回你砍完所有树需要走的最小步数。 如果你无法砍完所有的树，返回 -1 。
可以保证的是，没有两棵树的高度是相同的，并且你至少需要砍倒一棵树。
提示：
m == forest.length
n == forest[i].length
1 <= m, n <= 50
0 <= forest[i][j] <= 10^9

BFS
时间复杂度 O(mn*mn) mn 次 BFS 找最短路。
 */