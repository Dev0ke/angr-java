import java.util.HashSet;
import java.util.Set;

public class Solution2521 {
    public int distinctPrimeFactors(int[] nums) {
        Set<Integer> primeFactorSet = new HashSet<>();
        for (int num : nums) {
            for (int i = 2; i * i <= num; i++) {
                // 如果 i 能够整除 N，说明 i 为 N 的一个质因子。
                if (num % i == 0) {
                    while (num % i == 0) {
                        num /= i;
                    }
                    primeFactorSet.add(i);
                }
            }
            // 说明再经过操作之后 N 留下了一个素数
            if (num != 1) {
                primeFactorSet.add(num);
            }
        }
        return primeFactorSet.size();
    }
}
/*
2521. 数组乘积中的不同质因数数目
https://leetcode.cn/problems/distinct-prime-factors-of-product-of-array/

第 326 场周赛 T2。

给你一个正整数数组 nums ，对 nums 所有元素求积之后，找出并返回乘积中 不同质因数 的数目。
注意：
- 质数 是指大于 1 且仅能被 1 及自身整除的数字。
- 如果 val2 / val1 是一个整数，则整数 val1 是另一个整数 val2 的一个因数。
提示：
1 <= nums.length <= 10^4
2 <= nums[i] <= 1000

分解质因数
时间复杂度 O(n√n)
 */