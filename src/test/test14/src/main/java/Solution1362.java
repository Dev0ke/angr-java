public class Solution1362 {
    public int[] closestDivisors(int num) {
        int[] ans = {1, num + 2};
        for (int product = num + 1; product <= num + 2; product++) {
            // 下取整
            int sqrt = (int) Math.sqrt(product);
            for (int x = sqrt; x >= 1; x--) {
                if (product % x == 0) {
                    // y >= x
                    int y = product / x;
                    if (y - x < ans[1] - ans[0]) {
                        ans[0] = x;
                        ans[1] = y;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
/*
1362. 最接近的因数
https://leetcode.cn/problems/closest-divisors/

给你一个整数 num，请你找出同时满足下面全部要求的两个整数：
- 两数乘积等于  num + 1 或 num + 2
- 以绝对差进行度量，两数大小最接近
你可以按任意顺序返回这两个整数。
提示：
1 <= num <= 10^9

[1, sqrt(num)] 之间的因素是连续的，(sqrt(num), INF) 之间的因素是不连续的
时间复杂度 O(√n)
空间复杂度 O(1)
 */
