import java.util.ArrayList;
import java.util.List;

public class Solution2923 {
    public int findChampion(int[][] grid) {
        int n = grid.length;
        int[] inDeg = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    inDeg[j]++;
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0) {
                ans.add(i);
            }
        }
        return ans.size() == 1 ? ans.get(0) : -1;
    }
}
/*
2923. 找到冠军 I
https://leetcode.cn/problems/find-champion-i/description/

第 370 场周赛 T1。

一场比赛中共有 n 支队伍，按从 0 到  n - 1 编号。
给你一个下标从 0 开始、大小为 n * n 的二维布尔矩阵 grid 。对于满足 0 <= i, j <= n - 1 且 i != j 的所有 i, j ：如果 grid[i][j] == 1，那么 i 队比 j 队 强 ；否则，j 队比 i 队 强 。
在这场比赛中，如果不存在某支强于 a 队的队伍，则认为 a 队将会是 冠军 。
返回这场比赛中将会成为冠军的队伍。
提示：
n == grid.length
n == grid[i].length
2 <= n <= 100
grid[i][j] 的值为 0 或 1
对于所有 i， grid[i][i] 等于 0.
对于满足 i != j 的所有 i, j ，grid[i][j] != grid[j][i] 均成立
生成的输入满足：如果 a 队比 b 队强，b 队比 c 队强，那么 a 队比 c 队强

拓扑排序，入度为 0 的节点有且只有一个。
时间复杂度 O(n)
 */