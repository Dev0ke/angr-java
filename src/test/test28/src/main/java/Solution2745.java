import java.util.Arrays;

public class Solution2745 {
    private int[][][][] memo;

    public int longestString(int x, int y, int z) {
        memo = new int[3][x + 1][y + 1][z + 1];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < x + 1; j++) {
                for (int k = 0; k < y + 1; k++) {
                    Arrays.fill(memo[i][j][k], -1);
                }
            }
        }
        int ans = 0;
        ans = Math.max(ans, dfs(0, x - 1, y, z));
        ans = Math.max(ans, dfs(1, x, y - 1, z));
        ans = Math.max(ans, dfs(2, x, y, z - 1));
        return ans * 2;
    }

    // pre：前一个数 0:x 1:y 2:z
    private int dfs(int pre, int x, int y, int z) {
        if (memo[pre][x][y][z] != -1) {
            return memo[pre][x][y][z];
        }
        int res = 1;
        if (pre == 0) {
            // x->y
            if (y > 0) res = Math.max(res, dfs(1, x, y - 1, z) + 1);
        } else if (pre == 1) {
            // y->x/z
            if (x > 0) res = Math.max(res, dfs(0, x - 1, y, z) + 1);
            if (z > 0) res = Math.max(res, dfs(2, x, y, z - 1) + 1);
        } else if (pre == 2) {
            // z->x/z
            if (x > 0) res = Math.max(res, dfs(0, x - 1, y, z) + 1);
            if (z > 0) res = Math.max(res, dfs(2, x, y, z - 1) + 1);
        }
        return memo[pre][x][y][z] = res;
    }
}
/*
2745. 构造最长的新字符串
https://leetcode.cn/problems/construct-the-longest-new-string/

第 107 场双周赛 T2。

给你三个整数 x ，y 和 z 。
这三个整数表示你有 x 个 "AA" 字符串，y 个 "BB" 字符串，和 z 个 "AB" 字符串。你需要选择这些字符串中的部分字符串（可以全部选择也可以一个都不选择），将它们按顺序连接得到一个新的字符串。新字符串不能包含子字符串 "AAA" 或者 "BBB" 。
请你返回新字符串的最大可能长度。
子字符串 是一个字符串中一段连续 非空 的字符序列。
提示：
1 <= x, y, z <= 50

记忆化搜索 / 贪心
 */