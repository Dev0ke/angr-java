import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1861 {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;

        // 翻转
        char[][] ans = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][m - 1 - i] = box[i][j];
            }
        }

        // 每一列
        for (int j = 0; j < m; j++) {
            Deque<Integer> deque = new ArrayDeque<>();
            int cntStone = 0;
            // 由下往上
            for (int i = n - 1; i >= 0; i--) {
                if (ans[i][j] == '*') {
                    deque.addLast(cntStone);
                    cntStone = 0;
                    continue;
                }
                if (ans[i][j] == '#') {
                    cntStone++;
                }
            }
            deque.addLast(cntStone);

            int stones = deque.removeFirst();
            for (int i = n - 1; i >= 0; i--) {
                if (ans[i][j] == '*') {
                    stones = deque.removeFirst();
                    continue;
                }

                if (stones > 0) {
                    ans[i][j] = '#';
                } else {
                    ans[i][j] = '.';
                }
                stones--;
            }
        }

        return ans;
    }
}
/*
1861. 旋转盒子
https://leetcode.cn/problems/rotating-the-box/

给你一个 m x n 的字符矩阵 box ，它表示一个箱子的侧视图。箱子的每一个格子可能为：
- '#' 表示石头
- '*' 表示固定的障碍物
- '.' 表示空位置
这个箱子被 顺时针旋转 90 度 ，由于重力原因，部分石头的位置会发生改变。每个石头会垂直掉落，直到它遇到障碍物，另一个石头或者箱子的底部。重力 不会 影响障碍物的位置，同时箱子旋转不会产生惯性 ，也就是说石头的水平位置不会发生改变。
题目保证初始时 box 中的石头要么在一个障碍物上，要么在另一个石头上，要么在箱子的底部。
请你返回一个 n x m的矩阵，表示按照上述旋转后，箱子内的结果。
提示：
m == box.length
n == box[i].length
1 <= m, n <= 500
box[i][j] 只可能是 '#' ，'*' 或者 '.' 。

模拟。
时间复杂度 O(mn)
相似题目: G. Fall Down
https://codeforces.com/contest/1669/problem/G
 */