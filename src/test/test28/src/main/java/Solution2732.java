import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2732 {
    public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // 2^5 = 32 个数
        Map<Integer, List<Integer>> maskIdxMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int mask = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    mask |= 1 << j;
                }
            }
            maskIdxMap.computeIfAbsent(mask, key -> new ArrayList<>()).add(i);
        }

        // 特判 mask = 0
        if (maskIdxMap.containsKey(0)) {
            return List.of(maskIdxMap.get(0).get(0));
        }

        List<Integer> resList = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry1 : maskIdxMap.entrySet()) {
            int mask1 = entry1.getKey();
            List<Integer> val1 = entry1.getValue();

            for (Map.Entry<Integer, List<Integer>> entry2 : maskIdxMap.entrySet()) {
                int mask2 = entry2.getKey();
                List<Integer> val2 = entry2.getValue();

                // 如果 (mask1 & mask2) == 0，那么 mask1 != mask2
                if ((mask1 & mask2) == 0) {
                    resList.add(val1.get(0));
                    resList.add(val2.get(0));
                    resList.sort(null);
                    return resList;
                }
            }
        }
        return resList;
    }
}
/*
2732. 找到矩阵中的好子集
https://leetcode.cn/problems/find-a-good-subset-of-the-matrix/

第 106 场双周赛 T4。

给你一个下标从 0 开始大小为 m x n 的二进制矩阵 grid 。
从原矩阵中选出若干行构成一个行的 非空 子集，如果子集中任何一列的和至多为子集大小的一半，那么我们称这个子集是 好子集。
更正式的，如果选出来的行子集大小（即行的数量）为 k，那么每一列的和至多为 floor(k / 2) 。
请你返回一个整数数组，它包含好子集的行下标，请你将子集中的元素 升序 返回。
如果有多个好子集，你可以返回任意一个。如果没有好子集，请你返回一个空数组。
一个矩阵 grid 的行 子集 ，是删除 grid 中某些（也可能不删除）行后，剩余行构成的元素集合。
提示：
m == grid.length
n == grid[i].length
1 <= m <= 10^4
1 <= n <= 5
grid[i][j] 要么是 0 ，要么是 1 。

状态压缩枚举。猜想：
- 当 `n <= 5` 时，不存在大小大于 2 的好集合。
- 当 `n > 5` 时，可能存在大小为 4 的好集合，如：
101010
100101
011001
010110
详见 `tiger2005` 的证明：https://leetcode.cn/circle/discuss/9UKZwR/view/5AVVpH/
时间复杂度：`O(2^2n)`。理论上界 `32 * 32 = 1024`。
 */