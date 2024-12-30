import java.util.Arrays;

public class Solution2976 {
    static final int INF = (int) 1e9;

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = source.length();
        int m = original.length;

        int[][] dis = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(dis[i], INF);
            dis[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            int x = original[i] - 'a', y = changed[i] - 'a', wt = cost[i];
            dis[x][y] = Math.min(dis[x][y], wt);
        }
        // Floyd
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            int x = source.charAt(i) - 'a', y = target.charAt(i) - 'a';
            if (dis[x][y] == INF) {
                return -1;
            }
            ans += dis[x][y];
        }
        return ans;
    }
}
/*
2976. 转换字符串的最小成本 I
https://leetcode.cn/problems/minimum-cost-to-convert-string-i/description/

第 377 场周赛 T3。

给你两个下标从 0 开始的字符串 source 和 target ，它们的长度均为 n 并且由 小写 英文字母组成。
另给你两个下标从 0 开始的字符数组 original 和 changed ，以及一个整数数组 cost ，其中 cost[i] 代表将字符 original[i] 更改为字符 changed[i] 的成本。
你从字符串 source 开始。在一次操作中，如果 存在 任意 下标 j 满足 cost[j] == z  、original[j] == x 以及 changed[j] == y 。你就可以选择字符串中的一个字符 x 并以 z 的成本将其更改为字符 y 。
返回将字符串 source 转换为字符串 target 所需的 最小 成本。如果不可能完成转换，则返回 -1 。
注意，可能存在下标 i 、j 使得 original[j] == original[i] 且 changed[j] == changed[i] 。
提示：
1 <= source.length == target.length <= 10^5
source、target 均由小写英文字母组成
1 <= cost.length== original.length == changed.length <= 2000
original[i]、changed[i] 是小写英文字母
1 <= cost[i] <= 10^6
original[i] != changed[i]

建图 + Floyd
时间复杂度 O(n + m + 26^3)。
 */