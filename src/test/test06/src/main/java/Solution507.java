public class Solution507 {
    // 时间复杂度 O(√num)
    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        int sqrt = (int) Math.sqrt(num);
        int sum = 1;
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                sum += i + num / i;
            }
        }
        return sum == num;
    }

    // 数学 欧几里得-欧拉定理
    public boolean checkPerfectNumber2(int num) {
        return num == 6 || num == 28 || num == 496 || num == 8128 || num == 33550336;
    }
}
/*
507. 完美数
https://leetcode.cn/problems/perfect-number/

对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
给定一个 整数 n， 如果是完美数，返回 true，否则返回 false
提示：
1 <= num <= 10^8

枚举
 */