import java.util.Arrays;

public class Solution1420 {
    private static final int MOD = (int) (1e9 + 7);
    private int m;
    private int k;
    private int[][][] memo;

    public int numOfArrays(int n, int m, int k) {
        this.m = m;
        this.k = k;
        // 记忆化搜索
        memo = new int[51][101][51];
        for (int i = 0; i < 51; i++) {
            for (int j = 0; j < 101; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return dfs(n - 1, 0, 0);
    }

    private int dfs(int pos, int _m, int _k) {
        if (pos < 0) {
            if (_k == k) {
                return 1;
            }
            return 0;
        }
        if (_k > k) {
            return 0;
        }
        if (memo[pos][_m][_k] != -1) {
            return memo[pos][_m][_k];
        }

        int res = 0;
        for (int i = 1; i <= m; i++) {
            if (i > _m) {
                res = (res + dfs(pos - 1, i, _k + 1)) % MOD;
            } else {
                // 最大值不变
                res = (res + dfs(pos - 1, _m, _k)) % MOD;
            }
        }
        memo[pos][_m][_k] = res;
        return res;
    }
}
/*
1420. 生成数组
https://leetcode.cn/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons/

给你三个整数 n、m 和 k 。下图描述的算法用于找出正整数数组中最大的元素。
maximum_value = -1
maximum_index = -1
search_cost = 0
n = arr.length
for (i = 0; i < n; i++) {
    if(maximum_value < arr[i]){
        maximum_value = arr[i]
        maximum_index = i
        search_cost = search_cost + 1
    }
}
return maximum_index
请你生成一个具有下述属性的数组 arr ：
- arr 中有 n 个整数。
- 1 <= arr[i] <= m 其中 (0 <= i < n) 。
- 将上面提到的算法应用于 arr ，search_cost 的值等于 k 。
返回上述条件下生成数组 arr 的 方法数 ，由于答案可能会很大，所以 必须 对 10^9 + 7 取余。
提示：
1 <= n <= 50
1 <= m <= 100
0 <= k <= n

类数位 DP
 */