import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SolutionP1548 {
    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {
        int m = targetPath.length;

        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] p : roads) {
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }

        // f[i][j] 表示城市 i 对应 targetPath[j] 的路径中，编辑距离的最小值
        int[][] f = new int[n][m];
        for (int i = 0; i < n; i++) {
            f[i][0] = names[i].equals(targetPath[0]) ? 0 : 1;
        }
        for (int j = 1; j < m; j++) {
            for (int i = 0; i < n; i++) {
                // 编辑距离
                int editDist = Integer.MAX_VALUE;
                for (Integer city : g[i]) {
                    editDist = Math.min(editDist, f[city][j - 1]);
                }
                f[i][j] = editDist + (names[i].equals(targetPath[j]) ? 0 : 1);
            }
        }

        int minDist = f[0][m - 1], minPos = 0;
        for (int i = 1; i < n; i++) {
            if (minDist > f[i][m - 1]) {
                minDist = f[i][m - 1];
                minPos = i;
            }
        }

        int lastPos = minPos;
        List<Integer> resList = new ArrayList<>();
        resList.add(lastPos);
        for (int i = m - 2; i >= 0; i--) {
            minDist = Integer.MAX_VALUE;
            for (Integer city : g[lastPos]) {
                if (minDist > f[city][i]) {
                    minDist = f[city][i];
                    lastPos = city;
                }
            }
            resList.add(lastPos);
        }
        Collections.reverse(resList);
        return resList;
    }
}
/*
$1548. 图中最相似的路径
https://leetcode.cn/problems/the-most-similar-path-in-a-graph/

我们有 n 座城市和 m 条双向道路 roads ，其中 roads[i] = [ai, bi] 连接城市 ai 和城市 bi。每个城市的名称由字符串数组 names 中给出的三个大写英文字母组成。
从任意城市 x 出发，你可以到达任意城市 y ，其中 y != x （即：城市和道路形成一张无向连通图）。
给定一个字符串数组 targetPath，你需要找出图中与 targetPath 的 长度相同 且 编辑距离最小 的路径。
你需要返回 编辑距离最小的路径中节点的顺序 。该路径应当与 targetPath 的长度相等，且路径需有效（即： ans[i] 和 ans[i + 1] 间应存在直接连通的道路）。
如果有多个答案，返回任意一个。
编辑距离 的定义如下：
```
define editDistance(targetPath, myPath) {
    dis := 0
    a := targetPath.length
    b := myPath.length
    if a != b {
        return 1000000000
    }
    for (i := 0; i < a; i += 1) {
        if targetPath[i] != myPath[i] {
            dis += 1
        }
    }
    return dis
}
```
提示：
2 <= n <= 100
m == roads.length
n - 1 <= m <= (n * (n - 1) / 2)
0 <= ai, bi <= n - 1
ai != bi
给定的图保证是连通的，任意两个节点至多有一个直接连通的道路。
names.length == n
names[i].length == 3
names[i] 包含大写英文字母。
可能有两个名称相同的城市。
1 <= targetPath.length <= 100
targetPath[i].length == 3
targetPath[i] 由大写英文字母组成。
进阶：如果路径中每个节点只可访问一次，你该如何修改你的答案？

动态规划
https://leetcode.cn/problems/the-most-similar-path-in-a-graph/solution/java-er-wei-dp-by-saltyfish-dcyv/
 */