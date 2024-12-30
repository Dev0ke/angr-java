import java.util.Arrays;

public class Solution1478 {
    public int minDistance(int[] houses, int k) {
        int len = houses.length;
        Arrays.sort(houses);

        // cost(l,r) 表示给 [l,r] 的房子安排一个邮筒，可以得到的最小距离总和
        // cost(l,r) = cost(l+1,r-1) + (houses[r] - houses[l])
        int[][] cost = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                // 中位数
                cost[i][j] = cost[i + 1][j - 1] + houses[j] - houses[i];
            }
        }

        // f[i][j] 表示前 i 栋房子安排 j 个邮筒的最小距离和
        // f[i][j] = min(f[i0][j-1] + cost(i0+1,i)
        // f[i][1] = cost(0,i)
        int[][] f = new int[len][k + 1];
        for (int i = 0; i < len; i++) {
            Arrays.fill(f[i], Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i < len; i++) {
            f[i][1] = cost[0][i];
            for (int j = 2; j <= k && j <= i + 1; j++) {
                for (int i0 = 0; i0 < i; i0++) {
                    f[i][j] = Math.min(f[i][j], f[i0][j - 1] + cost[i0 + 1][i]);
                }
            }
        }
        return f[len - 1][k];
    }
}
/*
1478. 安排邮筒
https://leetcode.cn/problems/allocate-mailboxes/

给你一个房屋数组houses 和一个整数 k ，其中 houses[i] 是第 i 栋房子在一条街上的位置，现需要在这条街上安排 k 个邮筒。
请你返回每栋房子与离它最近的邮筒之间的距离的 最小 总和。
答案保证在 32 位有符号整数范围以内。
提示：
n == houses.length
1 <= n <= 100
1 <= houses[i] <= 10^4
1 <= k <= n
数组 houses 中的整数互不相同。

动态规划。
时间复杂度 O(k·n^2)
空间复杂度 O(n^2 + nk)
 */