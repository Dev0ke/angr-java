import java.util.Arrays;

public class Solution913 {
    private static final int MOUSE_WIN = 1;
    private static final int CAT_WIN = 2;
    private static final int DRAW = 0;

    private int[][] graph;
    private int n;
    private int[][][] dp;

    public int catMouseGame(int[][] graph) {
        this.graph = graph;
        this.n = graph.length;
        // {cat, mouse, turns}
        this.dp = new int[n][n][n * 2 * (n - 1)];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        // 老鼠从节点 1 开始，第一个出发；猫从节点 2 开始，第二个出发。在节点 0 处有一个洞。
        return dfs(2, 1, 0);
    }

    private int dfs(int cat, int mouse, int turns) {
        if (turns == n * 2 * (n - 1)) {
            return DRAW;
        } else {
            if (dp[cat][mouse][turns] == -1) {
                // 如果老鼠到达洞中，老鼠获胜。
                if (mouse == 0) {
                    dp[cat][mouse][turns] = MOUSE_WIN;
                }
                // 如果猫和老鼠出现在同一个节点，猫获胜。
                else if (cat == mouse) {
                    dp[cat][mouse][turns] = CAT_WIN;
                } else {
                    int curMove = (turns % 2 == 0) ? mouse : cat;
                    int defaultRes = (curMove == mouse) ? CAT_WIN : MOUSE_WIN;
                    int res = defaultRes;
                    for (int next : graph[curMove]) {
                        // 猫无法移动到洞中（节点 0）。
                        if (curMove == cat && next == 0) {
                            continue;
                        }
                        int nextCat = (curMove == cat) ? next : cat;
                        int nextMouse = (curMove == mouse) ? next : mouse;
                        int nextRes = dfs(nextCat, nextMouse, turns + 1);
                        if (nextRes != defaultRes) {
                            res = nextRes;
                            if (res != DRAW) {
                                break;
                            }
                        }
                    }
                    dp[cat][mouse][turns] = res;
                }
            }
            return dp[cat][mouse][turns];
        }
    }
}
/*
913. 猫和老鼠
https://leetcode.cn/problems/cat-and-mouse/

第 104 场周赛 T4。

两位玩家分别扮演猫和老鼠，在一张 无向 图上进行游戏，两人轮流行动。
图的形式是：graph[a] 是一个列表，由满足 ab 是图中的一条边的所有节点 b 组成。
老鼠从节点 1 开始，第一个出发；猫从节点 2 开始，第二个出发。在节点 0 处有一个洞。
在每个玩家的行动中，他们 必须 沿着图中与所在当前位置连通的一条边移动。例如，如果老鼠在节点 1 ，那么它必须移动到 graph[1] 中的任一节点。
此外，猫无法移动到洞中（节点 0）。
然后，游戏在出现以下三种情形之一时结束：
- 如果猫和老鼠出现在同一个节点，猫获胜。
- 如果老鼠到达洞中，老鼠获胜。
- 如果某一位置重复出现（即，玩家的位置和移动顺序都与上一次行动相同），游戏平局。
给你一张图 graph ，并假设两位玩家都都以最佳状态参与游戏：
- 如果老鼠获胜，则返回 1；
- 如果猫获胜，则返回 2；
- 如果平局，则返回 0 。
提示：
3 <= graph.length <= 50
1 <= graph[i].length < graph.length
0 <= graph[i][j] < graph.length
graph[i][j] != i
graph[i] 互不相同
猫和老鼠在游戏中总是移动

动态规划。
时间复杂度 O(n^5)
由于老鼠可能的位置有 n 个，猫可能的位置有 n - 1 个，游戏轮数最大为 2n(n - 1)，因此动态规划的状态数是 O(n^4)，
对于每个状态需要 O(n) 的时间计算状态值，因此总时间复杂度是 O(n^5)，该时间复杂度会超出时间限制，因此自顶向下的动态规划不适用于这道题。
以下代码为自顶向下的动态规划的实现，仅供读者参考。
 */