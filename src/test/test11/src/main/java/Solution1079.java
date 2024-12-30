import java.util.HashMap;
import java.util.Map;

public class Solution1079 {
    // O(n * n!)
    static class V1 {
        private Map<Character, Integer> cnt;

        public int numTilePossibilities(String tiles) {
            cnt = new HashMap<>();
            for (char c : tiles.toCharArray()) {
                cnt.merge(c, 1, Integer::sum);
            }
            return dfs(tiles.length()) - 1;
        }

        private int dfs(int i) {
            if (i == 0) return 1;
            int res = 1;
            for (Character c : cnt.keySet()) {
                if (cnt.get(c) > 0) {
                    cnt.merge(c, -1, Integer::sum);
                    res += dfs(i - 1);
                    cnt.merge(c, 1, Integer::sum);
                }
            }
            return res;
        }
    }

    // O(n^2) 计数 DP
    // https://leetcode.cn/problems/letter-tile-possibilities/solutions/2275356/on2-ji-shu-dppythonjavacgo-by-endlessche-hmez/
    static class V2 {
        private static final int MX = 8;
        private static final int[][] C = new int[MX][MX];

        static {
            for (int i = 0; i < MX; i++) {
                C[i][0] = C[i][i] = 1;
                for (int j = 1; j < i; j++) {
                    C[i][j] = C[i - 1][j - 1] + C[i - 1][j]; // 预处理组合数
                }
            }
        }

        public int numTilePossibilities(String tiles) {
            // 注：改成 int[26] 统计可能会快一点点，感兴趣可以试试（下面 DP 跳过 cnt=0 的情况）
            Map<Character, Integer> cnt = new HashMap<>(); // 统计每个字母的出现次数
            for (char ch : tiles.toCharArray()) {
                cnt.merge(ch, 1, Integer::sum); // counts[c]++
            }
            int[] f = new int[tiles.length() + 1];
            f[0] = 1; // 构造空序列的方案数
            int n = 0;
            for (int c : cnt.values()) { // 枚举第 i 种字母
                n += c; // 常数优化：相比从 tiles.length() 开始要更快
                for (int j = n; j > 0; j--) { // 枚举序列长度 j
                    // 枚举第 i 种字母选了 k 个，注意 k=0 时的方案数已经在 f[j] 中了
                    for (int k = 1; k <= j && k <= c; k++) {
                        f[j] += f[j - k] * C[j][k];
                    }
                }
            }
            int ans = 0;
            for (int j = 1; j <= n; j++) {
                ans += f[j];
            }
            return ans;
        }
    }
}
/*
1079. 活字印刷
https://leetcode.cn/problems/letter-tile-possibilities/description/

你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
注意：本题中，每个活字字模只能使用一次。
提示：
1 <= tiles.length <= 7
tiles 由大写英文字母组成

回溯 / 计数 DP。
 */