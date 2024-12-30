import java.util.Arrays;

public class Solution2977 {
    private static final int INF = (int) 1e9;
    private static final long INF64 = (long) 1e18;
    private char[] s, t;
    private Trie root;
    private int sid;
    private int[][] dis;
    private long[] memo;

    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        s = source.toCharArray();
        t = target.toCharArray();
        root = new Trie();
        sid = 0;

        int n = source.length();
        int m = original.length;
        dis = new int[m * 2][m * 2];
        for (int i = 0; i < m * 2; i++) {
            Arrays.fill(dis[i], INF);
            dis[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            int x = insert(original[i]);
            int y = insert(changed[i]);
            int wt = cost[i];
            dis[x][y] = Math.min(dis[x][y], wt);
        }
        // Floyd
        for (int k = 0; k < sid; k++) {
            for (int i = 0; i < sid; i++) {
                for (int j = 0; j < sid; j++) {
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }

        memo = new long[n];
        Arrays.fill(memo, -1);
        long ans = dfs(0);
        return ans < INF64 ? ans : -1;
    }

    private long dfs(int i) {
        if (i >= s.length) return 0;
        if (memo[i] != -1) return memo[i];
        long res = INF64;
        if (s[i] == t[i]) {
            res = dfs(i + 1);
        }
        Trie p = root, q = root;
        for (int j = i; j < s.length; j++) {
            p = p.child[s[j] - 'a'];
            q = q.child[t[j] - 'a'];
            if (p == null || q == null) break;
            if (p.sid < 0 || q.sid < 0) continue;
            if (dis[p.sid][q.sid] < INF) {
                res = Math.min(res, dis[p.sid][q.sid] + dfs(j + 1));
            }
        }
        return memo[i] = res;
    }

    private static class Trie {
        Trie[] child = new Trie[26];
        int sid = -1;
    }

    private int insert(String s) {
        Trie o = root;
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            if (o.child[i] == null) {
                o.child[i] = new Trie();
            }
            o = o.child[i];
        }
        if (o.sid < 0) {
            o.sid = sid++;
        }
        return o.sid;
    }
}
/*
2977. 转换字符串的最小成本 II
https://leetcode.cn/problems/minimum-cost-to-convert-string-ii/description/

第 377 场周赛 T4。

给你两个下标从 0 开始的字符串 source 和 target ，它们的长度均为 n 并且由 小写 英文字母组成。
另给你两个下标从 0 开始的字符串数组 original 和 changed ，以及一个整数数组 cost ，其中 cost[i] 代表将字符串 original[i] 更改为字符串 changed[i] 的成本。
你从字符串 source 开始。在一次操作中，如果 存在 任意 下标 j 满足 cost[j] == z  、original[j] == x 以及 changed[j] == y ，你就可以选择字符串中的 子串 x 并以 z 的成本将其更改为 y 。 你可以执行 任意数量 的操作，但是任两次操作必须满足 以下两个 条件 之一 ：
- 在两次操作中选择的子串分别是 source[a..b] 和 source[c..d] ，满足 b < c  或 d < a 。换句话说，两次操作中选择的下标 不相交 。
- 在两次操作中选择的子串分别是 source[a..b] 和 source[c..d] ，满足 a == c 且 b == d 。换句话说，两次操作中选择的下标 相同 。
返回将字符串 source 转换为字符串 target 所需的 最小 成本。如果不可能完成转换，则返回 -1 。
注意，可能存在下标 i 、j 使得 original[j] == original[i] 且 changed[j] == changed[i] 。
提示：
1 <= source.length == target.length <= 1000
source、target 均由小写英文字母组成
1 <= cost.length == original.length == changed.length <= 100
1 <= original[i].length == changed[i].length <= source.length
original[i]、changed[i] 均由小写英文字母组成
original[i] != changed[i]
1 <= cost[i] <= 10^6

建图 + Floyd。
由单个字符升级为了字符串，需要引入字典树。
时间复杂度 O(n^2 + mn + m^3)。
 */