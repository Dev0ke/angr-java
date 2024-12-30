import java.util.Arrays;

public class Solution3361 {
    private static final long INF = (long) 1e18;

    public long shiftDistance(String s, String t, int[] nextCost, int[] previousCost) {
        int C = 26;
        long[][] dis = new long[C][C];
        for (int i = 0; i < C; i++) {
            Arrays.fill(dis[i], INF);
            dis[i][i] = 0;
        }
        for (int i = 0; i < C; i++) {
            dis[i][(i + 1) % C] = nextCost[i];
            dis[i][(i - 1 + C) % C] = previousCost[i];
        }
        // Floyd
        for (int k = 0; k < C; k++) {
            for (int i = 0; i < C; i++) {
                for (int j = 0; j < C; j++) {
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }

        int n = s.length();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int x = s.charAt(i) - 'a';
            int y = t.charAt(i) - 'a';
            ans += dis[x][y];
        }
        return ans;
    }
}
/*
3361. 两个字符串的切换距离
https://leetcode.cn/problems/shift-distance-between-two-strings/description/

第 144 场双周赛 T2。

给你两个长度相同的字符串 s 和 t ，以及两个整数数组 nextCost 和 previousCost 。
一次操作中，你可以选择 s 中的一个下标 i ，执行以下操作 之一 ：
- 将 s[i] 切换为字母表中的下一个字母，如果 s[i] == 'z' ，切换后得到 'a' 。操作的代价为 nextCost[j] ，其中 j 表示 s[i] 在字母表中的下标。
- 将 s[i] 切换为字母表中的上一个字母，如果 s[i] == 'a' ，切换后得到 'z' 。操作的代价为 previousCost[j] ，其中 j 是 s[i] 在字母表中的下标。
切换距离 指的是将字符串 s 变为字符串 t 的 最少 操作代价总和。
请你返回从 s 到 t 的 切换距离 。
提示：
1 <= s.length == t.length <= 10^5
s 和 t 都只包含小写英文字母。
nextCost.length == previousCost.length == 26
0 <= nextCost[i], previousCost[i] <= 10^9

Floyd 是更通用的做法。
时间复杂度 O(n + C^3)。其中 C = 26。
 */