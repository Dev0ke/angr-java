public class Solution1326 {
    public int minTaps(int n, int[] ranges) {
        // f[i] 表示下标 i 能到达的最远距离下标
        int[] f = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int l = Math.max(0, i - ranges[i]);
            f[l] = Math.max(f[l], i + ranges[i]);
        }

        // 能到达的最远距离下标，当前下标，步数
        int maxR = 0, curR = 0, step = 0;
        // [1, n) 返回可以灌溉整个花园的 最少水龙头数目
        for (int i = 0; i < n; i++) {
            maxR = Math.max(maxR, f[i]);
            if (i == curR) {
                if (i == maxR) {
                    return -1;
                }
                curR = maxR;
                step++;
            }
        }
        return step;
    }
}
/*
1326. 灌溉花园的最少水龙头数目
https://leetcode.cn/problems/minimum-number-of-taps-to-open-to-water-a-garden/

在 x 轴上有一个一维的花园。花园长度为 n，从点 0 开始，到点 n 结束。
花园里总共有 n + 1 个水龙头，分别位于 [0, 1, ..., n] 。
给你一个整数 n 和一个长度为 n + 1 的整数数组 ranges ，其中 ranges[i] （下标从 0 开始）表示：如果打开点 i 处的水龙头，可以灌溉的区域为 [i -  ranges[i], i + ranges[i]] 。
请你返回可以灌溉整个花园的 最少水龙头数目 。如果花园始终存在无法灌溉到的地方，请你返回 -1 。
提示：
1 <= n <= 10^4
ranges.length == n + 1
0 <= ranges[i] <= 100

贪心。
相似题目: 45. 跳跃游戏 II
https://leetcode.cn/problems/jump-game-ii/
1024. 视频拼接
https://leetcode.cn/problems/video-stitching/
 */