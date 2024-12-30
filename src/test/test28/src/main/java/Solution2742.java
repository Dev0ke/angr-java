import java.util.Arrays;

public class Solution2742 {
    private static final int INF = (int) 1e9;

    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;

        // 0-1 背包
        int[] f = new int[n + 1];
        Arrays.fill(f, INF);
        f[0] = 0;
        for (int i = 0; i < n; i++) {
            int wi = time[i];
            int vi = cost[i];
//            for (int j = n; j - wi - 1 >= 0; j--) {
//                f[j] = Math.min(f[j], f[j - wi - 1] + vi);
//            }
            for (int j = n; j >= 0; j--) {
                f[j] = Math.min(f[j], f[Math.max(0, j - wi - 1)] + vi);
            }
        }
        return f[n];
    }
}
/*
2742. 给墙壁刷油漆
https://leetcode.cn/problems/painting-the-walls/

第 350 场周赛 T4。

给你两个长度为 n 下标从 0 开始的整数数组 cost 和 time ，分别表示给 n 堵不同的墙刷油漆需要的开销和时间。你有两名油漆匠：
- 一位需要 付费 的油漆匠，刷第 i 堵墙需要花费 time[i] 单位的时间，开销为 cost[i] 单位的钱。
- 一位 免费 的油漆匠，刷 任意 一堵墙的时间为 1 单位，开销为 0 。但是必须在付费油漆匠 工作 时，免费油漆匠才会工作。
请你返回刷完 n 堵墙最少开销为多少。
提示：
1 <= cost.length <= 500
cost.length == time.length
1 <= cost[i] <= 10^6
1 <= time[i] <= 500

0-1 背包 变种
时间复杂度 O(n^2)
 */