public class Solution2427 {
    public int commonFactors(int a, int b) {
        int min = Math.min(a, b);
        int cnt = 0;
        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
/*
2427. 公因子的数目
https://leetcode.cn/problems/number-of-common-factors/

第 313 场周赛 T1。

给你两个正整数 a 和 b ，返回 a 和 b 的 公 因子的数目。
如果 x 可以同时整除 a 和 b ，则认为 x 是 a 和 b 的一个 公因子 。
提示：
1 <= a, b <= 1000

暴力模拟。
时间复杂度 O(n^2)
 */