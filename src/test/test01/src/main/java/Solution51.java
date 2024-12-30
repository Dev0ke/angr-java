import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution51 {
    // 在 O(1) 的时间内判断该位置所在的列和两条斜线上是否已经有皇后
    // 列
    private final Set<Integer> columnSet = new HashSet<>();
    // 主对角线
    private final Set<Integer> mainDiagonalSet = new HashSet<>();
    // 副对角线
    private final Set<Integer> antiDiagonalSet = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> resList = new ArrayList<>();
        int[] queens = new int[n];
        // 初始化
        Arrays.fill(queens, -1);
        // 迭代
        dfs(n, resList, queens, 0);
        return resList;
    }

    private void dfs(int n, List<List<String>> res, int[] queens, int row) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            res.add(board);
        } else {
            for (int i = 0; i < n; i++) {
                if (columnSet.contains(i)) {
                    continue;
                }
                int mainDiagonal = row - i;
                if (mainDiagonalSet.contains(mainDiagonal)) {
                    continue;
                }
                int antiDiagonal = row + i;
                if (antiDiagonalSet.contains(antiDiagonal)) {
                    continue;
                }
                // 操作
                queens[row] = i;
                columnSet.add(i);
                mainDiagonalSet.add(mainDiagonal);
                antiDiagonalSet.add(antiDiagonal);
                // 下一迭代
                dfs(n, res, queens, row + 1);
                // 回退操作
                queens[row] = -1;
                columnSet.remove(i);
                mainDiagonalSet.remove(mainDiagonal);
                antiDiagonalSet.remove(antiDiagonal);
            }
        }
    }

    private List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
/*
51. N 皇后
https://leetcode.cn/problems/n-queens/

n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
提示：
1 <= n <= 9

回溯算法。
经典八皇后问题，数学家高斯穷其一生也没有计算出正确答案。而我们借助计算机可秒出答案。
为了降低总时间复杂度，每次放置皇后时需要快速判断每个位置是否可以放置皇后，
显然，最理想的情况是在 O(1) 的时间内判断该位置所在的列和两条斜线上是否已经有皇后。
时间复杂度 O(n!)
空间复杂度 O(n)
 */
