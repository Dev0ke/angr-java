import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3138 {
    private int n;
    private int[][] ps26;

    public int minAnagramLength(String S) {
        char[] s = S.toCharArray();
        n = s.length;
        // 26 维前缀和
        ps26 = new int[26][n + 1];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < n; j++) {
                ps26[i][j + 1] = ps26[i][j] + (s[j] - 'a' == i ? 1 : 0);
            }
        }

        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
                factors.add(n / i);
            }
        }
        factors.sort(null);
        for (Integer k : factors) {
            if (check(k)) return k;
        }
        return -1;
    }

    // 长度为 k 时是否成立
    private boolean check(int k) {
        int[] cnt_each_one = null;
        for (int j = 0; j < n / k; j++) {
            int[] cnt = new int[26];
            for (int i = 0; i < 26; i++) {
                cnt[i] = ps26[i][j * k + k] - ps26[i][j * k];
            }
            if (cnt_each_one == null || Arrays.equals(cnt_each_one, cnt)) cnt_each_one = cnt;
            else return false;
        }
        return true;
    }
}
/*
3138. 同位字符串连接的最小长度
https://leetcode.cn/problems/minimum-length-of-anagram-concatenation/description/

第 396 场周赛 T3。

给你一个字符串 s ，它由某个字符串 t 和若干 t  的 同位字符串 连接而成。
请你返回字符串 t 的 最小 可能长度。
同位字符串 指的是重新排列一个单词得到的另外一个字符串，原来字符串中的每个字符在新字符串中都恰好只使用一次。
提示：
1 <= s.length <= 10^5
s 只包含小写英文字母。

枚举因子 k，判断子串长度为 k 时是否成立。
时间复杂度 O(An)。其中 n 为 s 的长度，A 为 n 的因子个数。
 */