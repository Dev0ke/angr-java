import java.util.Arrays;

public class Solution1531 {
    private static final int INF = (int) 1e9;

    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        // 表示对于原串 s 的前 i 个字符，通过删除其中的 j 个字符，剩余的 i−j 个字符可以得到的最小的压缩串的长度。
        int[][] f = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(f[i], INF);
        }
        // 空串对应的压缩串的长度为零
        f[0][0] = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= k && j <= i; ++j) {
                if (j > 0) {
                    f[i][j] = f[i - 1][j - 1];
                }
                int same = 0, diff = 0;
                for (int i0 = i; i0 >= 1 && diff <= j; --i0) {
                    if (s.charAt(i0 - 1) == s.charAt(i - 1)) {
                        ++same;
                        f[i][j] = Math.min(f[i][j], f[i0 - 1][j - diff] + calc(same));
                    } else {
                        ++diff;
                    }
                }
            }
        }
        return f[n][k];
    }

    // 压缩 x 个字符得到的长度
    private int calc(int x) {
        if (x == 1) return 1;
        if (x < 10) return 2;
        if (x < 100) return 3;
        return 4;
    }
}
/*
1531. 压缩字符串 II
https://leetcode.cn/problems/string-compression-ii/description/

行程长度编码 是一种常用的字符串压缩方法，它将连续的相同字符（重复 2 次或更多次）替换为字符和表示字符计数的数字（行程长度）。例如，用此方法压缩字符串 "aabccc" ，将 "aa" 替换为 "a2" ，"ccc" 替换为` "c3" 。因此压缩后的字符串变为 "a2bc3" 。
注意，本问题中，压缩时没有在单个字符后附加计数 '1' 。
给你一个字符串 s 和一个整数 k 。你需要从字符串 s 中删除最多 k 个字符，以使 s 的行程长度编码长度最小。
请你返回删除最多 k 个字符后，s 行程长度编码的最小长度 。
提示：
1 <= s.length <= 100
0 <= k <= s.length
s 仅包含小写英文字母

动态规划。
时间复杂度 O(n^2 * k)
相似题目: 443. 压缩字符串
https://leetcode.cn/problems/string-compression/
 */