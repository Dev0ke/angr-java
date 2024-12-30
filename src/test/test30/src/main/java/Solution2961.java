import java.util.ArrayList;
import java.util.List;

public class Solution2961 {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        int n = variables.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] p = variables[i];
            int a = p[0], b = p[1], c = p[2], m = p[3];
            long res = quickPow(quickPow(a, b, 10), c, m);
            if (res == target) {
                ans.add(i);
            }
        }
        return ans;
    }

    private long quickPow(long a, long b, long mod) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % mod;
            }
            a = a * a % mod;
            b >>= 1;
        }
        return res;
    }
}
/*
2961. 双模幂运算
https://leetcode.cn/problems/double-modular-exponentiation/description/

第 375 场周赛 T2。

给你一个下标从 0 开始的二维数组 variables ，其中 variables[i] = [ai, bi, ci, mi]，以及一个整数 target 。
如果满足以下公式，则下标 i 是 好下标：
- 0 <= i < variables.length
- ((aibi % 10)ci) % mi == target
返回一个由 好下标 组成的数组，顺序不限 。
提示：
1 <= variables.length <= 100
variables[i] == [ai, bi, ci, mi]
1 <= ai, bi, ci, mi <= 10^3
0 <= target <= 10^3

模拟 + 快速幂。
时间复杂度 O(nlogU)
 */