public class Solution420 {
    // https://leetcode.cn/problems/strong-password-checker/solutions/1387891/by-ac_oier-unp5
    public int strongPasswordChecker(String password) {
        int n = password.length();
        char[] s = password.toCharArray();
        int A = 0, B = 0, C = 0;
        for (char c : s) {
            if (Character.isLowerCase(c)) A = 1;
            else if (Character.isDigit(c)) B = 1;
            else if (Character.isUpperCase(c)) C = 1;
        }

        int m = A + B + C;
        if (n < 6) {
            return Math.max(6 - n, 3 - m);
        }
        if (n <= 20) {
            int tot = 0;
            int i = 0;
            while (i < n) {
                // 分组循环
                int st = i;
                for (i++; i < n && s[i] == s[i - 1]; i++) {
                }
                int cnt = i - st;
                if (cnt >= 3) {
                    tot += cnt / 3;
                }
            }
            return Math.max(tot, 3 - m);
        }
        // n > 20
        int tot = 0;
        int[] cnts = new int[3];
        int i = 0;
        while (i < n) {
            int st = i;
            for (i++; i < n && s[i] == s[i - 1]; i++) {
            }
            int cnt = i - st;
            if (cnt >= 3) {
                tot += cnt / 3;
                cnts[cnt % 3]++;
            }
        }
        int base = n - 20, cur = n - 20;
        for (int j = 0; j < 3; j++) {
            if (j == 2) cnts[j] = tot;
            if (cnts[j] != 0 && cur != 0) {
                int t = Math.min(cnts[j] * (j + 1), cur);
                cur -= t;
                tot -= t / (j + 1);
            }
        }
        return base + Math.max(tot, 3 - m);
    }
}
/*
420. 强密码检验器
https://leetcode.cn/problems/strong-password-checker/description/

满足以下条件的密码被认为是强密码：
- 由至少 6 个，至多 20 个字符组成。
- 包含至少 一个小写 字母，至少 一个大写 字母，和至少 一个数字 。
- 不包含连续三个重复字符 (比如 "Baaabb0" 是弱密码, 但是 "Baaba0" 是强密码)。
给你一个字符串 password ，返回 将 password 修改到满足强密码条件需要的最少修改步数。如果 password 已经是强密码，则返回 0 。
在一步修改操作中，你可以：
- 插入一个字符到 password ，
- 从 password 中删除一个字符，或
- 用另一个字符来替换 password 中的某个字符。
提示：
1 <= password.length <= 50
password 由字母、数字、点 '.' 或者感叹号 '!' 组成

分类讨论
时间复杂度 O(n)
 */