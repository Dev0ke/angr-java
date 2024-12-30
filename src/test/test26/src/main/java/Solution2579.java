public class Solution2579 {
    public long coloredCells(int n) {
        long k = n * 2L - 1;
        return (k * k + 1) / 2;
    }
}
/*
2579. 统计染色格子数
https://leetcode.cn/problems/count-total-number-of-colored-cells/

第 99 场双周赛 T2。

有一个无穷大的二维网格图，一开始所有格子都未染色。给你一个正整数 n ，表示你需要执行以下步骤 n 分钟：
- 第一分钟，将 任一 格子染成蓝色。
- 之后的每一分钟，将与蓝色格子相邻的 所有 未染色格子染成蓝色。
下图分别是 1、2、3 分钟后的网格图。
请你返回 n 分钟之后 被染色的格子 数目。
提示：
1 <= n <= 10^5

找规律。
时间复杂度 O(1)
https://oeis.org/A001844
 */