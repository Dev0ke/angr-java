public class Solution920 {
    // 5ms
    static class V1 {
        private static final int MOD = (int) (1e9 + 7);

        public int numMusicPlaylists(int n, int goal, int k) {
            // f[i][j] 表示播放列表长度为 i 包含恰好 j 首不同歌曲的数量。
            long[][] f = new long[goal + 1][n + 1];
            f[0][0] = 1;
            for (int i = 1; i <= goal; i++) {
                for (int j = 1; j <= n; j++) {
                    f[i][j] = f[i - 1][j - 1] * (n - j + 1) + f[i - 1][j] * Math.max(j - k, 0);
                    f[i][j] %= MOD;
                }
            }
            return (int) f[goal][n];
        }
    }

    // 4ms 滚动数组 优化
    static class V2 {
        private static final int MOD = (int) (1e9 + 7);

        public int numMusicPlaylists(int n, int goal, int k) {
            long[] f = new long[n + 1];
            f[0] = 1;
            for (int i = 1; i <= goal; i++) {
                long[] g = new long[n + 1];
                for (int j = 1; j <= n; j++) {
                    g[j] = f[j - 1] * (n - j + 1) + f[j] * Math.max(j - k, 0);
                    g[j] %= MOD;
                }
                f = g;
            }
            return (int) f[n];
        }
    }
}
/*
920. 播放列表的数量
https://leetcode.cn/problems/number-of-music-playlists/description/

你的音乐播放器里有 n 首不同的歌，在旅途中，你计划听 goal 首歌（不一定不同，即，允许歌曲重复）。你将会按如下规则创建播放列表：
- 每首歌 至少播放一次 。
- 一首歌只有在其他 k 首歌播放完之后才能再次播放。
给你 n、goal 和 k ，返回可以满足要求的播放列表的数量。由于答案可能非常大，请返回对 10^9 + 7 取余 的结果。
提示：
0 <= k < n <= goal <= 100

动态规划。
时间复杂度 O(n*goal)。
 */