public class Solution1672 {
    public int maximumWealth(int[][] accounts) {
        int M = accounts.length;
        int N = accounts[0].length;

        int max = 0;
        for (int i = 0; i < M; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += accounts[i][j];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
/*
1672. 最富有客户的资产总量
https://leetcode.cn/problems/richest-customer-wealth/

给你一个 m x n 的整数网格 accounts ，其中 accounts[i][j] 是第 i 位客户在第 j 家银行托管的资产数量。返回最富有客户所拥有的 资产总量 。
客户的 资产总量 就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户。
提示：
m == accounts.length
n == accounts[i].length
1 <= m, n <= 50
1 <= accounts[i][j] <= 100

模拟。
 */