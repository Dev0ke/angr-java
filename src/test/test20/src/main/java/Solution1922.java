import java.util.Arrays;

public class Solution1922 {
    private static final int MOD = (int) (1e9 + 7);

    public int countGoodNumbers(long n) {
        long pow = n / 2;
        if (n % 2 == 1L) {
            // 奇数
            return (int) (5 * quickPow(20, pow) % MOD);
        } else {
            // 偶数
            return (int) (quickPow(20, pow) % MOD);
        }
    }

    // 模下的 a^b
    private long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }

    // 打表
    public static void main(String[] args) {
        int[] cnt = new int[10];
        for (int i = 0; i < 10000000; i++) {
            String numStr = String.valueOf(i);
            if (isGoodNum(numStr)) {
                cnt[numStr.length()]++;
            }
        }
        System.out.println(Arrays.toString(cnt));
    }

    private static boolean isGoodNum(String numStr) {
        for (int i = 0; i < numStr.length(); i++) {
            boolean goodNum;
            if (i % 2 == 0) {
                // 偶数
                goodNum = numStr.charAt(i) == '0' || numStr.charAt(i) == '2' || numStr.charAt(i) == '4' || numStr.charAt(i) == '6' || numStr.charAt(i) == '8';
            } else {
                // 奇数
                goodNum = numStr.charAt(i) == '2' || numStr.charAt(i) == '3' || numStr.charAt(i) == '5' || numStr.charAt(i) == '7';
            }
            if (!goodNum) {
                return false;
            }
        }
        return true;
    }
}
/*
1922. 统计好数字的数目
https://leetcode.cn/problems/count-good-numbers/

第 248 场周赛 T3。

我们称一个数字字符串是 好数字 当它满足（下标从 0 开始）偶数 下标处的数字为 偶数 且 奇数 下标处的数字为 质数 （2，3，5 或 7）。
- 比方说，"2582" 是好数字，因为偶数下标处的数字（2 和 8）是偶数且奇数下标处的数字（5 和 2）为质数。但 "3245" 不是 好数字，因为 3 在偶数下标处但不是偶数。
给你一个整数 n ，请你返回长度为 n 且为好数字的数字字符串 总数 。由于答案可能会很大，请你将它对 10^9 + 7 取余后返回 。
一个 数字字符串 是每一位都由 0 到 9 组成的字符串，且可能包含前导 0 。
提示：
1 <= n <= 10^15

找规律 + 快速幂
打表找规律，一开始求出 n = 4 结果是 320，随后发现题目注明 “可能包含前导 0”，那就很简单了：
奇数: (5^(pow+1) * 4^pow) % mod == (5 * 20^pow) % mod
偶数: (5^pow * 4^pow) % mod == (20^pow) % mod
由于 pow 能达到 10^15，会溢出，快速幂中需要每步取模
快速幂推导过程可参考 https://leetcode.cn/problems/powx-n/solution/powx-n-by-leetcode-solution/
 */