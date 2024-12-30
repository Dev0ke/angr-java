import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution52 {
    public int totalNQueens(int n) {
        return solveNQueens(n).size();
    }

    // 在 O(1) 的时间内判断该位置所在的列和两条斜线上是否已经有皇后
    // 列
    private final Set<Integer> columnSet = new HashSet<>();
    // 主对角线
    private final Set<Integer> mainDiagonalSet = new HashSet<>();
    // 副对角线
    private final Set<Integer> antiDiagonalSet = new HashSet<>();

    // solution51
    private List<List<String>> solveNQueens(int n) {
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
52. N皇后 II
https://leetcode.cn/problems/n-queens-ii/

n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
提示：
1 <= n <= 9

在 51 题基础上求方案数量即可。
相似题目: 51. N 皇后
https://leetcode.cn/problems/n-queens/
 */