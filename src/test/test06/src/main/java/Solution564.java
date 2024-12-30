import java.util.ArrayList;
import java.util.List;

public class Solution564 {
    // 866
    public String nearestPalindromic(String n) {
        int L = n.length();
        long low = (long) Math.pow(10, L - 1);
        long high = (long) Math.pow(10, L);

        List<Long> pals = new ArrayList<>();
        pals.add(low - 1);
        pals.add(high + 1);
        long half = Long.parseLong(n.substring(0, (L + 1) / 2));
        // Check for odd-length palindromes
        for (long root = half - 1; root <= half + 1; root++) {
            long p = root;
            for (long x = root / 10; x > 0; x /= 10) {
                p = p * 10 + x % 10;
            }
            pals.add(p);
        }
        // Check for even-length palindromes
        for (long root = half - 1; root <= half + 1; root++) {
            long p = root;
            for (long x = root; x > 0; x /= 10) {
                p = p * 10 + x % 10;
            }
            pals.add(p);
        }

        long ans = -1;
        long num = Long.parseLong(n);
        for (long pal : pals) {
            if (pal != num) {
                if (ans == -1 ||
                        Math.abs(pal - num) < Math.abs(ans - num) ||
                        Math.abs(pal - num) == Math.abs(ans - num) && pal < ans) {
                    ans = pal;
                }
            }
        }
        return String.valueOf(ans);
    }
}
/*
564. 寻找最近的回文数
https://leetcode.cn/problems/find-the-closest-palindrome/description/

给定一个表示整数的字符串 n ，返回与它最近的回文整数（不包括自身）。如果不止一个，返回较小的那个。
“最近的”定义为两个整数差的绝对值最小。
提示:
1 <= n.length <= 18
n 只由数字组成
n 不含前导 0
n 代表在 [1, 10^18 - 1] 范围内的整数

相似题目: 866. 回文素数
https://leetcode.cn/problems/prime-palindrome/
 */