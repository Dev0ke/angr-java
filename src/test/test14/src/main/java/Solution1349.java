import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1349 {
    public int maxStudents(char[][] seats) {
        int m = seats.length;
        int n = seats[0].length;

        List<Integer> validity = new ArrayList<>();
        for (char[] seat : seats) {
            int mask = 0;
            for (int j = 0; j < n; j++) {
                mask = mask << 1 | (seat[j] == '.' ? 1 : 0);
            }
            validity.add(mask);
        }

        // f[i][mask] 表示前 i 行学生的最大数量，而第 i 行的学生遵循掩码。掩码中不应该有相邻的有效状态。
        // 状态转移为 dp[i][mask] = max(dp[i - 1][mask']) + number of valid bits(mask)
        int[][] f = new int[m + 1][1 << n];
        for (int i = 0; i < m + 1; i++) {
            Arrays.fill(f[i], -1);
        }
        f[0][0] = 0;

        for (int i = 1; i <= m; i++) {
            int valid = validity.get(i - 1);

            for (int j = 0; j < (1 << n); j++) {
                // 我们可以使用 (x & y) == x 来检查 x 是否是 y 的子集；
                // 我们可以使用 (x & (x >> 1)) == 0 来检查 x 中是否没有相邻的有效状态；
                if (((j & valid) == j) && (j & (j >> 1)) == 0) {

                    for (int k = 0; k < (1 << n); k++) {
                        if ((j & (k >> 1)) == 0 && ((j >> 1) & k) == 0 && f[i - 1][k] != -1) {
                            f[i][j] = Math.max(f[i][j], f[i - 1][k] + Integer.bitCount(j));
                        }
                    }
                }
            }
        }
        return Arrays.stream(f[m]).max().orElseThrow();
    }
}
/*
1349. 参加考试的最大学生数
https://leetcode.cn/problems/maximum-students-taking-exam/

给你一个 m * n 的矩阵 seats 表示教室中的座位分布。如果座位是坏的（不可用），就用 '#' 表示；否则，用 '.' 表示。
学生可以看到左侧、右侧、左上、右上这四个方向上紧邻他的学生的答卷，但是看不到直接坐在他前面或者后面的学生的答卷。请你计算并返回该考场可以容纳的一起参加考试且无法作弊的最大学生人数。
学生必须坐在状况良好的座位上。
提示：
seats 只包含字符 '.' 和'#'
m == seats.length
n == seats[i].length
1 <= m <= 8
1 <= n <= 8

状态压缩动态规划
https://leetcode.com/problems/maximum-students-taking-exam/solutions/503686/a-simple-tutorial-on-this-bitmasking-problem/
 */