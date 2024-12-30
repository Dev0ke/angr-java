public class Solution2299 {
    public boolean strongPasswordCheckerII(String password) {
        // 它有至少 8 个字符
        if (password.length() < 8) {
            return false;
        }

        // 它 不 包含 2 个连续相同的字符
        for (int i = 1; i < password.length(); i++) {
            if (password.charAt(i) == password.charAt(i - 1)) {
                return false;
            }
        }

        // 至少包含 一个小写英文 字母。
        // 至少包含 一个大写英文 字母。
        // 至少包含 一个数字 。
        // 至少包含 一个特殊字符 。
        int mask = 0;
        for (char ch : password.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                mask |= 1;
            } else if (Character.isUpperCase(ch)) {
                mask |= 2;
            } else if (Character.isDigit(ch)) {
                mask |= 4;
            } else if ("!@#$%^&*()-+".contains(String.valueOf(ch))) {
                mask |= 8;
            }
        }
        return mask == 15;
    }
}
/*
2299. 强密码检验器 II
https://leetcode.cn/problems/strong-password-checker-ii/

第 80 场双周赛 T1。

如果一个密码满足以下所有条件，我们称它是一个 强 密码：
- 它有至少 8 个字符。
- 至少包含 一个小写英文 字母。
- 至少包含 一个大写英文 字母。
- 至少包含 一个数字 。
- 至少包含 一个特殊字符 。特殊字符为："!@#$%^&*()-+" 中的一个。
- 它 不 包含 2 个连续相同的字符（比方说 "aab" 不符合该条件，但是 "aba" 符合该条件）。
给你一个字符串 password ，如果它是一个 强 密码，返回 true，否则返回 false 。
提示：
1 <= password.length <= 100
password 包含字母，数字和 "!@#$%^&*()-+" 这些特殊字符。

模拟。
 */