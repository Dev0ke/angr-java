import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionP2184 {
    private static final int MOD = (int) (1e9 + 7);

    // 80ms
    public int buildWall(int height, int width, int[] bricks) {
        // 预处理 建造一排墙的所有可能方式
        int[] ways = getAllBuildWaysOfOneRow(width, bricks);
        int n = ways.length;
        if (n == 0) return 0;
        // dp[i] 表示以 ways[i] 为顶行的排列方式的数量
        int[] f = new int[n];
        // 初始状态：dp[i] = 1，因为第 1 行可以以任何方式构建
        Arrays.fill(f, 1);
        for (int i = 1; i < height; i++) {
            int[] g = new int[n];
            for (int j = 0; j < n; j++) { // 迭代当前行的每种可能的方法
                for (int k = 0; k < n; k++) { // 迭代上一行的每种可能的方法
                    if ((ways[j] & ways[k]) == 1) { // 如果 ways[j] 可以建立在方法 ways[k] 之上
                        g[j] = (g[j] + f[k]) % MOD;
                    }
                }
            }
            f = g;
        }
        int ans = 0;
        for (int fi : f) ans = (ans + fi) % MOD;
        return ans;
    }

    private int[] getAllBuildWaysOfOneRow(int width, int[] bricks) {
        List<Integer> res = new ArrayList<>();
        dfs(width, bricks, 0, res);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    // DFS 生成所有可能的方法来构建一行墙
    private void dfs(int width, int[] bricks, int val, List<Integer> res) {
        if (width == 0) {
            res.add(val);
        } else if (width > 0) {
            for (int brick : bricks) {
                dfs(width - brick, bricks, (val << brick) + 1, res);
            }
        }
    }
}
/*
$2184. 建造坚实的砖墙的方法数
https://leetcode.cn/problems/number-of-ways-to-build-sturdy-brick-wall/description/

给你两个整数 height 与width ，表示你要建造的砖墙的高和宽。再给你一个下标从 0 开始的数组 bricks ，其中第 i 块砖的高度是 1 ，宽度为 bricks[i] 。每种砖的数量都是 无限 的，并且砖 不可以 进行旋转。
墙的每一行必须正好 width 单位长。为了让墙体 坚实 ，除了在首尾的位置，相邻的行砖缝 不能 在同一个位置。
请你返回建造坚实的砖墙的方法数，由于答案可能很大，需要对 10^9 + 7 取余 。
提示：
1 <= height <= 100
1 <= width <= 10
1 <= bricks.length <= 10
1 <= bricks[i] <= 10
bricks 中所有数字 互不相同

DFS预处理+DP。
 */