public class Solution2201 {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        // 预处理
        boolean[][] digGrid = new boolean[n][n];
        for (int[] rc : dig) {
            digGrid[rc[0]][rc[1]] = true;
        }

        int cnt = 0;
        for (int[] artifact : artifacts) {
            if (check(digGrid, artifact)) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean check(boolean[][] digGrid, int[] artifact) {
        for (int i = artifact[0]; i <= artifact[2]; i++) {
            for (int j = artifact[1]; j <= artifact[3]; j++) {
                if (!digGrid[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
/*
2201. 统计可以提取的工件
https://leetcode.cn/problems/count-artifacts-that-can-be-extracted/

第 284 场周赛 T2。

存在一个 n x n 大小、下标从 0 开始的网格，网格中埋着一些工件。给你一个整数 n 和一个下标从 0 开始的二维整数数组 artifacts ，artifacts 描述了矩形工件的位置，
其中 artifacts[i] = [r1i, c1i, r2i, c2i] 表示第 i 个工件在子网格中的填埋情况：
- (r1i, c1i) 是第 i 个工件 左上 单元格的坐标，且
- (r2i, c2i) 是第 i 个工件 右下 单元格的坐标。
你将会挖掘网格中的一些单元格，并清除其中的填埋物。如果单元格中埋着工件的一部分，那么该工件这一部分将会裸露出来。如果一个工件的所有部分都都裸露出来，你就可以提取该工件。
给你一个下标从 0 开始的二维整数数组 dig ，其中 dig[i] = [ri, ci] 表示你将会挖掘单元格 (ri, ci) ，返回你可以提取的工件数目。
生成的测试用例满足：
- 不存在重叠的两个工件。
- 每个工件最多只覆盖 4 个单元格。
- dig 中的元素互不相同。
提示：
1 <= n <= 1000
1 <= artifacts.length, dig.length <= min(n^2, 10^5)
artifacts[i].length == 4
dig[i].length == 2
0 <= r1i, c1i, r2i, c2i, ri, ci <= n - 1
r1i <= r2i
c1i <= c2i
不存在重叠的两个工件
每个工件 最多 只覆盖 4 个单元格
dig 中的元素互不相同

题目条件：
不存在重叠的两个工件 => 枚举每个工件即可。
每个工件最多只覆盖 4 个单元格 => 每个工件近常数时间复杂度。
时间复杂度 O(n+m) n=artifacts.length, m=dig.length
 */