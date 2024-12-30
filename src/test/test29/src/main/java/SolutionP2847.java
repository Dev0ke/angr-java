public class SolutionP2847 {
    public String smallestNumber(long n) {
        if (n < 10) return String.valueOf(n);
        StringBuilder factors = new StringBuilder();
        for (int i = 9; i >= 2; i--) {
            while (n % i == 0) {
                factors.append(i);
                n /= i;
            }
        }
        if (n != 1) return "-1";
        return factors.reverse().toString();
    }
}
/*
$2847. 给定数字乘积的最小数字
https://leetcode.cn/problems/smallest-number-with-given-digit-product/description/

给定一个 正 整数 n，返回一个字符串，表示使其各位数字的乘积等于 n 的 最小正整数，如果不存在这样的数字，则返回 "-1" 。
提示：
1 <= n <= 10^18

因数分解（[2,9] 的因子）。由大到小枚举。
由小到大（倒序）排序。
 */