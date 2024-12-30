public class Solution1281 {
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        while (n > 0) {
            int digital = n % 10;
            n /= 10;
            product *= digital;
            sum += digital;
        }
        return product - sum;
    }
}
/*
1281. 整数的各位积和之差
https://leetcode.cn/problems/subtract-the-product-and-sum-of-digits-of-an-integer/

给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
提示：
1 <= n <= 10^5

模拟。
 */