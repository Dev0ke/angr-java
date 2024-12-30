import java.util.ArrayList;
import java.util.List;

public class Solution1573 {
    private static final int MOD = (int) (1e9 + 7);

    public int numWays(String s) {
        int n = s.length();
        List<Integer> ones = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                ones.add(i);
            }
        }
        int sz = ones.size();
        if (sz % 3 != 0) return 0;
        if (sz == 0) return (int) ((long) (n - 1) * (n - 2) / 2 % MOD);

        int idx1 = sz / 3, idx2 = sz / 3 * 2;
        int cnt1 = ones.get(idx1) - ones.get(idx1 - 1);
        int cnt2 = ones.get(idx2) - ones.get(idx2 - 1);
        return (int) ((long) cnt1 * cnt2 % MOD);
    }
}
/*
1573. 分割字符串的方案数
https://leetcode.cn/problems/number-of-ways-to-split-a-string/description/

给你一个二进制串 s  （一个只包含 0 和 1 的字符串），我们可以将 s 分割成 3 个 非空 字符串 s1, s2, s3 （s1 + s2 + s3 = s）。
请你返回分割 s 的方案数，满足 s1，s2 和 s3 中字符 '1' 的数目相同。
由于答案可能很大，请将它对 10^9 + 7 取余后返回。
提示：
s[i] == '0' 或者 s[i] == '1'
3 <= s.length <= 10^5

数学。预处理 1 的下标。设有 m 个。先特判 2 种情况：
- 如果 m 不是 3 的倍数，返回 0
- 如果 m 是 0，乘法原理。
再看分割点 0 的个数。
时间复杂度 O(n)。
 */