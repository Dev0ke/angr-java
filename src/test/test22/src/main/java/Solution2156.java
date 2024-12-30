public class Solution2156 {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        int len = s.length();
        // p^(k-1) % mod
        long pK1 = fastPower(power, k - 1, modulo);

        // 最后 k 长字符串的 hash
        String lastSub = s.substring(len - k);
        long hash = hash(lastSub, power, modulo);

        String res = "";
        if (hash == hashValue) {
            res = lastSub;
        }
        for (int i = len - k - 1; i >= 0; i--) {
            long tail = val(s, i + k) * pK1 % modulo;
            long head = val(s, i);
            hash = (hash - tail) * power + head;
            hash = ((hash % modulo) + modulo) % modulo;
            if (hash == hashValue) {
                res = s.substring(i, i + k);
            }
        }
        return res;
    }

    private long val(String s, int idx) {
        return s.charAt(idx) - 'a' + 1;
    }

    private long hash(String s, int power, int modulo) {
        long sum = 0;
        int len = s.length();
        for (int k = 0; k < len; k++) {
            sum += val(s, k) * fastPower(power, k, modulo);
            sum %= modulo;
        }
        return sum;
    }

    // x^power % mod
    private long fastPower(long x, long pow, int mod) {
        x %= mod;
        long ans = 1;
        while (pow > 0) {
            if (pow % 2 == 1) {
                ans *= x;
                ans %= mod;
            }
            x *= x;
            x %= mod;
            pow /= 2;
        }
        return ans;
    }

    // TLE
    public String subStrHash2(String s, int power, int modulo, int k, int hashValue) {
        int len = s.length();
        for (int i = 0; i + k <= len; i++) {
            String subString = s.substring(i, i + k);
            if (hash(subString, power, modulo) == hashValue) {
                return subString;
            }
        }
        return "-1";
    }
}
/*
2156. 查找给定哈希值的子串
https://leetcode.cn/problems/find-substring-with-given-hash-value/

第 278 场周赛 T3。

给定整数 p 和 m ，一个长度为 k 且下标从 0 开始的字符串 s 的哈希值按照如下函数计算：
- hash(s, p, m) = (val(s[0]) * p0 + val(s[1]) * p1 + ... + val(s[k-1]) * pk-1) mod m.
其中 val(s[i]) 表示 s[i] 在字母表中的下标，从 val('a') = 1 到 val('z') = 26 。
给你一个字符串 s 和整数 power，modulo，k 和 hashValue 。请你返回 s 中 第一个 长度为 k 的 子串 sub ，满足 hash(sub, power, modulo) == hashValue 。
测试数据保证一定 存在 至少一个这样的子串。
子串 定义为一个字符串中连续非空字符组成的序列。
提示：
1 <= k <= s.length <= 2 * 10^4
1 <= power, modulo <= 10^9
0 <= hashValue < modulo
s 只包含小写英文字母。
测试数据保证一定 存在 满足条件的子串。

直接快速幂会超时，考虑优化。
从后往前滑窗。每次去尾 val(s[k-1]) * pk-1 ，乘 power，补头 val(s[0]) * p0
 */