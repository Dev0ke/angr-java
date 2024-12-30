public class Solution2358 {
    public int maximumGroups(int[] grades) {
        int n = grades.length;

        // 求满足 k(k+1)/2 <= n 的最大 k
        int k = 1;
        while (k * (k + 1) <= n * 2) {
            k++;
        }
        return k - 1;
    }
}
/*
2358. 分组的最大数量
https://leetcode.cn/problems/maximum-number-of-groups-entering-a-competition/

第 304 场周赛 T2。

给你一个正整数数组 grades ，表示大学中一些学生的成绩。你打算将 所有 学生分为一些 有序 的非空分组，其中分组间的顺序满足以下全部条件：
- 第 i 个分组中的学生总成绩 小于 第 (i + 1) 个分组中的学生总成绩，对所有组均成立（除了最后一组）。
- 第 i 个分组中的学生总数 小于 第 (i + 1) 个分组中的学生总数，对所有组均成立（除了最后一组）。
返回可以形成的 最大 组数。
提示：
1 <= grades.length <= 10^5
1 <= grades[i] <= 10^5

脑筋急转弯。答案只与数组的长度有关。
题目示例的迷惑性太强，故意用了一种不好的方案得到最优结果，类似 2136
 */