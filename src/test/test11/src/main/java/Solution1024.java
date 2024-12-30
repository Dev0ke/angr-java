public class Solution1024 {
    public int videoStitching(int[][] clips, int time) {
        // f[i] 表示下标 starti 对应的最长 endi
        int[] f = new int[time];
        for (int[] clip : clips) {
            int l = clip[0];
            // 防止越界
            if (l < time) {
                f[l] = Math.max(f[l], clip[1]);
            }
        }

        // 能到达的最远距离下标，当前下标，步数
        int maxR = 0, curR = 0, step = 0;
        // [1, time) 返回所需片段的最小数目
        for (int i = 0; i < time; i++) {
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
1024. 视频拼接
https://leetcode.cn/problems/video-stitching/

你将会获得一系列视频片段，这些片段来自于一项持续时长为 time 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
使用数组 clips 描述所有的视频片段，其中 clips[i] = [starti, endi] 表示：某个视频片段开始于 starti 并于 endi 结束。
甚至可以对这些片段自由地再剪辑：
例如，片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。
我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, time]）。返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。
提示：
1 <= clips.length <= 100
0 <= starti <= endi <= 100
1 <= time <= 100

针对每个起点，找到最右端点
每次尽可能找最长的区间延申，以达到所需片段的最小
时间复杂度 O(clips.length + time)
空间复杂度 O(time)
相似题目: 45. 跳跃游戏 II
https://leetcode.cn/problems/jump-game-ii/
1326. 灌溉花园的最少水龙头数目
https://leetcode.cn/problems/minimum-number-of-taps-to-open-to-water-a-garden/
 */