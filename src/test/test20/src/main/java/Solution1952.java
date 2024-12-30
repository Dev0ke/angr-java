public class Solution1952 {
    public boolean isThree(int n) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                cnt++;
            }
        }
        return cnt == 3;
    }
}
/*
1952. 三除数
https://leetcode.cn/problems/three-divisors/

第 252 场周赛 T1。

给你一个整数 n 。如果 n 恰好有三个正除数 ，返回 true ；否则，返回 false 。
如果存在整数 k ，满足 n = k * m ，那么整数 m 就是 n 的一个 除数 。
提示：
n <= 10^4

直接根据题意进行模拟即可。
 */