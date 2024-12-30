public class Solution793 {
    public int preimageSizeFZF(int k) {
        // int 536870902
        // long 2305843009213693937
        long left = 0;
        long right = Long.MAX_VALUE;
        while (left < right) {
            long mid = left + (right - left) / 2;

            // 朴素二分
            long trailingZeroes = trailingZeroes(mid);
            if (trailingZeroes == k) {
                return 5;
            } else if (trailingZeroes < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return 0;
    }

    public long trailingZeroes(long n) {
        // 2 的数量远多于 5 的数量，因此统计 5 的数量即可
        long cnt5 = 0;
        while (n > 0) {
            n /= 5;
            cnt5 += n;
        }
        return cnt5;
    }
}
/*
793. 阶乘函数后 K 个零
https://leetcode.cn/problems/preimage-size-of-factorial-zeroes-function/

f(x) 是 x! 末尾是 0 的数量。回想一下 x! = 1 * 2 * 3 * ... * x，且 0! = 1 。
- 例如， f(3) = 0 ，因为 3! = 6 的末尾没有 0 ；而 f(11) = 2 ，因为 11!= 39916800 末端有 2 个 0 。
给定 k，找出返回能满足 f(x) = k 的非负整数 x 的数量。
提示:
0 <= k <= 10^9

二分，答案不是 0 就是 5。
相似题目: 172. 阶乘后的零
https://leetcode.cn/problems/factorial-trailing-zeroes/
 */