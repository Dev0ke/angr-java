import java.util.Arrays;

public class Solution2545 {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (o1, o2) -> Integer.compare(o2[k], o1[k]));
        return score;
    }
}
/*
2545. 根据第 K 场考试的分数排序
https://leetcode.cn/problems/sort-the-students-by-their-kth-score/

第 329 场周赛 T2。

班里有 m 位学生，共计划组织 n 场考试。给你一个下标从 0 开始、大小为 m x n 的整数矩阵 score ，
其中每一行对应一位学生，而 score[i][j] 表示第 i 位学生在第 j 场考试取得的分数。矩阵 score 包含的整数 互不相同 。
另给你一个整数 k 。请你按第 k 场考试分数从高到低完成对这些学生（矩阵中的行）的排序。
返回排序后的矩阵。
提示：
m == score.length
n == score[i].length
1 <= m, n <= 250
1 <= score[i][j] <= 10^5
score 由 不同 的整数组成
0 <= k < n

模拟/库函数
时间复杂度：库函数不讨论时间复杂度。
 */