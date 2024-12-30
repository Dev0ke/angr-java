public class Solution2843 {
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;
        for (int i = low; i <= high; i++) {
            if (check(i)) {
                ans++;
            }
        }
        return ans;
    }

    private boolean check(int x) {
        String s = String.valueOf(x);
        int n = s.length();
        if (n % 2 == 1) return false;
        n /= 2;
        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            left += s.charAt(i) - '0';
        }
        for (int i = n; i < n * 2; i++) {
            right += s.charAt(i) - '0';
        }
        return left == right;
    }
}
/*
2843. 统计对称整数的数目
https://leetcode.cn/problems/count-symmetric-integers/

第 361 场周赛 T1。

给你两个正整数 low 和 high 。
对于一个由 2 * n 位数字组成的整数 x ，如果其前 n 位数字之和与后 n 位数字之和相等，则认为这个数字是一个对称整数。
返回在 [low, high] 范围内的 对称整数的数目 。

暴力 / 数位 DP
 */