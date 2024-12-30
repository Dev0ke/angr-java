import java.util.Arrays;

public class SolutionP568 {
    private int[][] flights;
    private int[][] days;
    private int[][] memo;
    private int n;
    private int k;

    public int maxVacationDays(int[][] flights, int[][] days) {
        this.flights = flights;
        this.days = days;
        // n == flights.length
        // n == flights[i].length
        n = flights.length;
        k = days[0].length;

        memo = new int[n][k];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return f(0, 0);
    }

    // 第 i 个城市，第 j 周
    private int f(int city, int week) {
        if (week == k) {
            return 0;
        }
        if (memo[city][week] != -1) {
            return memo[city][week];
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (flights[city][i] == 1 || i == city) {
                int vacation = days[i][week] + f(i, week + 1);
                max = Math.max(max, vacation);
            }
        }
        memo[city][week] = max;
        return max;
    }
}
/*
$568. 最大休假天数
https://leetcode.cn/problems/maximum-vacation-days/

力扣想让一个最优秀的员工在 N 个城市间旅行来收集算法问题。 但只工作不玩耍，聪明的孩子也会变傻，所以您可以在某些特定的城市和星期休假。您的工作就是安排旅行使得最大化你可以休假的天数，但是您需要遵守一些规则和限制。
规则和限制：
1.您只能在 N 个城市之间旅行，用 0 到 n-1 的索引表示。一开始，您在索引为 0 的城市，并且那天是星期一。
2.这些城市通过航班相连。这些航班用 n x n 矩阵 flights（不一定是对称的）表示，flights[i][j] 代表城市 i 到城市 j 的航空状态。如果没有城市 i 到城市 j 的航班，flights[i][j] = 0 ；否则，flights[i][j] = 1 。同时，对于所有的 i ，flights[i][i] = 0 。
3.您总共有 k 周（每周7天）的时间旅行。您每天最多只能乘坐一次航班，并且只能在每周的星期一上午乘坐航班。由于飞行时间很短，我们不考虑飞行时间的影响。
4.对于每个城市，不同的星期您休假天数是不同的，给定一个 N*K 矩阵 days 代表这种限制，days[i][j] 代表您在第j个星期在城市i能休假的最长天数。
5.如果您从 A 市飞往 B 市，并在当天休假，扣除的假期天数将计入 B 市当周的休假天数。
6.我们不考虑飞行时数对休假天数计算的影响。
给定 flights 矩阵和 days 矩阵，您需要输出 k 周内可以休假的最长天数。
提示:
n == flights.length
n == flights[i].length
n == days.length
k == days[i].length
1 <= n, k <= 100
flights[i][j] 不是 0 就是 1
0 <= days[i] <= 7

记忆化搜索
时间复杂度 O(k*n^2)
空间复杂度 O(nk)
 */