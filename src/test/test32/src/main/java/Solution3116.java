import java.util.ArrayList;
import java.util.List;

public class Solution3116 {
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        List<Long> prods = new ArrayList<>();
        for (int mask = 1; mask < 1 << n; mask++) {
            int bitCount = Integer.bitCount(mask);
            long sign = bitCount % 2 == 1 ? 1 : -1;
            long lcm = 1;
            for (int i = 0; i < n; i++) {
                if ((mask >> i & 1) == 1) {
                    lcm = getLCM(lcm, coins[i]);
                }
            }
            prods.add(sign * lcm);
        }

        long left = 0;
        long right = Long.MAX_VALUE / 2;
        while (left < right) {
            long mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(prods, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static long getLCM(long num1, long num2) {
        return num1 / getGCD(num1, num2) * num2;
    }

    private static long getGCD(long num1, long num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }

    private boolean checkMid(List<Long> prods, int k, long mid) {
        long tot = 0;
        for (Long prod : prods) {
            tot += mid / prod;
        }
        return k <= tot;
    }
}
/*
3116. 单面值组合的第 K 小金额
https://leetcode.cn/problems/kth-smallest-amount-with-single-denomination-combination/description/

第 393 场周赛 T3。

给你一个整数数组 coins 表示不同面额的硬币，另给你一个整数 k 。
你有无限量的每种面额的硬币。但是，你 不能 组合使用不同面额的硬币。
返回使用这些硬币能制造的 第 kth 小 金额。
提示：
1 <= coins.length <= 15
1 <= coins[i] <= 25
1 <= k <= 2 * 10^9
coins 包含两两不同的整数。

二进制枚举 + 二分答案 + 容斥定理
时间复杂度 O(n*2^n * logU)。其中 logU = 64。
有更精确的上界：O(n*2^n * log(mk) * logM)。其中 m = min(coins)，M = max(coins)。
rating 2404 (clist.by)
相似题目: 878. 第 N 个神奇数字
https://leetcode.cn/problems/nth-magical-number/
1201. 丑数 III
https://leetcode.cn/problems/ugly-number-iii/
 */