import java.util.Arrays;

public class Solution943 {
    private String[] words;
    private int[][] overlaps;
    private int n, full;
    private int[][] memo;
    private StringBuilder ans;

    public String shortestSuperstring(String[] words) {
        this.words = words;
        this.n = words.length;
        this.full = (1 << n) - 1;

        // 预处理
        overlaps = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j) continue;
                int mn = Math.min(words[i].length(), words[j].length());
                for (int k = mn; k >= 0; k--) {
                    if (words[i].endsWith(words[j].substring(0, k))) {
                        overlaps[i][j] = k;
                        break;
                    }
                }
            }
        }

        memo = new int[1 << n][n + 1];
        for (int i = 0; i < 1 << n; i++) {
            Arrays.fill(memo[i], -1);
        }
        dfs(0, -1);

        ans = new StringBuilder();
        make_ans(0, -1);
        return ans.toString();
    }

    private int dfs(int mask, int i) {
        if (mask == full) return 0;
        if (i >= 0 && memo[mask][i] != -1) return memo[mask][i];
        int res = 0;
        for (int j = 0; j < n; j++) {
            if ((mask >> j & 1) == 0) {
                int overlap = i >= 0 ? overlaps[i][j] : 0;
                res = Math.max(res, dfs(mask | (1 << j), j) + overlap);
            }
        }
        if (i >= 0) memo[mask][i] = res;
        return res;
    }

    private void make_ans(int mask, int i) {
        if (mask == full) return;
//        if (i >= 0 && memo[mask][i] != -1) return memo[mask][i];
        int final_res = dfs(mask, i);
        for (int j = 0; j < n; j++) {
            if ((mask >> j & 1) == 0) {
                int overlap = i >= 0 ? overlaps[i][j] : 0;
                int res1 = dfs(mask | (1 << j), j) + overlap;
                if (res1 == final_res) {
                    ans.append(words[j].substring(overlap));
                    make_ans(mask | (1 << j), j);
                    break;
                }
            }
        }
//        if (i >= 0) memo[mask][i] = res;
//        return res;
    }
}
/*
943. 最短超级串
https://leetcode.cn/problems/find-the-shortest-superstring/description/

给定一个字符串数组 words，找到以 words 中每个字符串作为子字符串的最短字符串。如果有多个有效最短字符串满足题目条件，返回其中 任意一个 即可。
我们可以假设 words 中没有字符串是 words 中另一个字符串的子字符串。
提示：
1 <= words.length <= 12
1 <= words[i].length <= 20
words[i] 由小写英文字母组成
words 中的所有字符串 互不相同

递归搜索 + 保存递归返回值 = 记忆化搜索。
时间复杂度 O(n^2 * 2^n)。
相似题目: 3149. 找出分数最低的排列
https://leetcode.cn/problems/find-the-minimum-cost-array-permutation/description/
 */