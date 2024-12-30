import java.util.HashMap;
import java.util.Map;

public class Solution3348 {
    private char[] s;
    private int cnt, n;
    private int[] ans;
    private Map<Long, Boolean> memo;

    public String smallestNumber(String num, long t) {
        long tmp = t;
        cnt = 1;
        for (long p : new long[]{2, 3, 5, 7}) {
            while (tmp % p == 0) {
                tmp /= p;
                cnt++;
            }
        }
        if (tmp > 1) return "-1";

        // 补前导零（至少一个）
        cnt = Math.max(cnt - num.length(), 1);
        s = ("0".repeat(cnt) + num).toCharArray();

        n = s.length;
        ans = new int[n];

        memo = new HashMap<>();
        dfs(0, t, true);
        StringBuilder sb = new StringBuilder();
        for (int v : ans) sb.append(v);
        int i = 0;
        while (sb.charAt(i) == '0') i++;
        return sb.substring(i);
    }

    private boolean dfs(int i, long t, boolean is_limit) {
        if (i == n) {
            return t == 1;
        }
        long key = (long) i << 50L | t << 1 | (is_limit ? 1 : 0);
        if (memo.containsKey(key)) return memo.get(key);
        int x = s[i] - '0';
        int low;
        if (is_limit) {
            low = x != 0 || i < cnt ? x : 1;
        } else {  // 没有约束，随便填（非零数字）
            low = 1;
        }
        for (int d = low; d < 10; d++) {
            ans[i] = d;
            long new_t = (d > 1) ? t / gcd(t, d) : t;
            if (dfs(i + 1, new_t, is_limit && d == x)) {
                memo.put(key, true);
                return true;
            }
        }
        memo.put(key, false);
        return false;
    }

    private long gcd(long num1, long num2) {
        return num1 == 0 ? num2 : gcd(num2 % num1, num1);
    }
}
/*
3348. 最小可整除数位乘积 II
https://leetcode.cn/problems/smallest-divisible-digit-product-ii/description/

第 143 场双周赛 T4。

给你一个字符串 num ，表示一个 正 整数，同时给你一个整数 t 。
如果一个整数 没有 任何数位是 0 ，那么我们称这个整数是 无零 数字。
请你返回一个字符串，这个字符串对应的整数是大于等于 num 的 最小无零 整数，且 各数位之积 能被 t 整除。如果不存在这样的数字，请你返回 "-1" 。
提示：
2 <= num.length <= 2 * 10^5
num 只包含 ['0', '9'] 之间的数字。
num 不包含前导 0 。
1 <= t <= 10^14

史上最难的力扣题。
相似题目: 3260. 找出最大的 N 位 K 回文数
https://leetcode.cn/problems/find-the-largest-palindrome-divisible-by-k/description/
rating 3109 (clist.by)
 */