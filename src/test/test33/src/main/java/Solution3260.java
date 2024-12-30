import java.math.BigInteger;
import java.util.Arrays;

public class Solution3260 {
    static class V1 {
        public String largestPalindrome(int n, int k) {
            char[] a = new char[n];
            Arrays.fill(a, '9');
            if (k == 1 || k == 3 || k == 9) {
                return new String(a);
            }
            if (k == 2 || k == 4 || k == 8) {
                if (n == 1) return "8";
                // 100, 1000
                int up = 1;
                if (k == 4) up = 2;
                if (k == 8) up = 3;
                for (int i = 0; i < Math.min(n / 2 + 1, up); i++) {
                    a[i] = '8';
                    a[n - 1 - i] = '8';
                }
                return new String(a);
            }
            if (k == 5) {
                a[0] = a[n - 1] = '5';
                return new String(a);
            }

            // {1=6, 2=66, 3=888, 4=8778, 5=89898, 6=897798, 7=8998998, 8=89977998, 9=899989998, 10=8999779998, 11=89999899998, 12=899997799998}
            if (k == 6) {
                if (n == 1) return "6";
                if (n == 2) return "66";
                a[0] = a[n - 1] = '8';
                if (n % 2 == 1) {
                    a[n / 2] = '8';
                } else {
                    a[n / 2 - 1] = a[n / 2] = '7';
                }
                return new String(a);
            }
            // 7
            // {1=7, 2=77, 3=959, 4=9779, 5=99799, 6=999999, 7=9994999, 8=99944999, 9=999969999, 10=9999449999, 11=99999499999, 12=999999999999, 13=9999997999999, 14=99999977999999, 15=999999959999999, 16=9999999779999999, 17=99999999799999999, 18=999999999999999999}
            if (n == 1) return "7";
            if (n == 2) return "77";
            if (n % 2 == 1) {
                for (char m = '9'; m >= '0'; m--) {
                    a[n / 2] = m;
                    BigInteger bigInt = new BigInteger(new String(a));
                    if (bigInt.mod(new BigInteger("7")).equals(BigInteger.ZERO)) {
                        return new String(a);
                    }
                }
            } else {
                for (char m = '9'; m >= '0'; m--) {
                    a[n / 2 - 1] = a[n / 2] = m;
                    BigInteger bigInt = new BigInteger(new String(a));
                    if (bigInt.mod(new BigInteger("7")).equals(BigInteger.ZERO)) {
                        return new String(a);
                    }
                }
            }
            return new String(a);
        }
    }

    static class V2 {
        private int n, k, m;
        private int[] pow10;
        private char[] ans;
        private boolean[][] vis;

        public String largestPalindrome(int n, int k) {
            this.n = n;
            this.k = k;
            m = (n + 1) / 2;

            pow10 = new int[n];
            Arrays.fill(pow10, 1);
            for (int i = 1; i < n; i++) {
                pow10[i] = pow10[i - 1] * 10 % k;
            }

            ans = new char[n];
            vis = new boolean[m + 1][k];
            dfs(0, 0);
            return new String(ans);
        }

        private boolean dfs(int i, int j) {
            if (i == m) {
                return j == 0;
            }
            vis[i][j] = true;
            for (int d = 9; d >= 1; d--) {
                int j2;
                if (n % 2 == 1 && i == m - 1) { // 正中间
                    j2 = (j + d * pow10[i]) % k;
                } else {
                    j2 = (j + d * (pow10[i] + pow10[n - 1 - i])) % k;
                }
                if (!vis[i + 1][j2] && dfs(i + 1, j2)) {
                    ans[i] = ans[n - 1 - i] = (char) (d + '0');
                    return true;
                }
            }
            return false;
        }
    }
}
/*
3260. 找出最大的 N 位 K 回文数
https://leetcode.cn/problems/find-the-largest-palindrome-divisible-by-k/description/

第 411 场周赛 T3。

给你两个 正整数 n 和 k。
如果整数 x 满足以下全部条件，则该整数是一个 k 回文数：
x 是一个 回文数。
x 可以被 k 整除。
以字符串形式返回 最大的  n 位 k 回文数。
注意，该整数 不 含前导零。
提示：
1 <= n <= 10^5
1 <= k <= 9

打表找规律（除了 7 以外，其他规律都很明显）。
灵神：建图+DFS+输出具体方案
https://leetcode.cn/problems/find-the-largest-palindrome-divisible-by-k/solutions/2884548/tong-yong-zuo-fa-jian-tu-dfsshu-chu-ju-t-m3pu/
 */