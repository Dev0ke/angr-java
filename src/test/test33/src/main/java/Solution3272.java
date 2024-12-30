import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution3272 {
    static List<Long>[] palMap;

    static {
        // size = 199998, max = 9999999999
        palMap = new ArrayList[11];
        Arrays.setAll(palMap, e -> new ArrayList<>());
        for (int L = 1; L <= 5; L++) {
            int low = (int) Math.pow(10, L - 1);
            int high = (int) Math.pow(10, L);
            // Check for odd-length palindromes
            for (int root = low; root < high; root++) {
                long p = root;
                for (int x = root / 10; x > 0; x /= 10) {
                    p = p * 10 + x % 10;
                }
                palMap[L + L - 1].add(p);
            }
            // Check for even-length palindromes
            for (int root = low; root < high; root++) {
                long p = root;
                for (int x = root; x > 0; x /= 10) {
                    p = p * 10 + x % 10;
                }
                palMap[L + L].add(p);
            }
        }
    }

    public long countGoodIntegers(int n, int k) {
        long[] fac = new long[n + 1];
        fac[0] = 1;
        for (int i = 1; i <= n; i++) {
            fac[i] = fac[i - 1] * i;
        }

        long ans = 0;
        Set<String> vis = new HashSet<>();
        for (Long v : palMap[n]) {
            if (v % k != 0) continue;

            char[] sortedS = String.valueOf(v).toCharArray();
            Arrays.sort(sortedS);
            if (!vis.add(new String(sortedS))) { // 不能重复统计
                continue;
            }

            int[] cnt = new int[10];
            for (char c : sortedS) {
                cnt[c - '0']++;
            }
            long res = (n - cnt[0]) * fac[n - 1];
            for (int c : cnt) {
                res /= fac[c];
            }
            ans += res;
        }
        return ans;
    }
}
/*
3272. 统计好整数的数目
https://leetcode.cn/problems/find-the-count-of-good-integers/description/

第 138 场双周赛 T3。

给你两个 正 整数 n 和 k 。
如果一个整数 x 满足以下条件，那么它被称为 k 回文 整数 。
- x 是一个 回文整数 。
- x 能被 k 整除。
如果一个整数的数位重新排列后能得到一个 k 回文整数 ，那么我们称这个整数为 好 整数。比方说，k = 2 ，那么 2020 可以重新排列得到 2002 ，2002 是一个 k 回文串，所以 2020 是一个好整数。而 1010 无法重新排列数位得到一个 k 回文整数。
请你返回 n 个数位的整数中，有多少个 好 整数。
注意 ，任何整数在重新排列数位之前或者之后 都不能 有前导 0 。比方说 1010 不能重排列得到 101 。
提示：
1 <= n <= 10
1 <= k <= 9

预处理 回文数 + 组合数学。
时间复杂度 O(10^m * nlogn)。其中 m = (n-1)/2
空间复杂度 O(10^m * n)。
rating 2402 (clist.by)
 */