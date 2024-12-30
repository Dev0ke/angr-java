import java.util.Arrays;

public class Solution2136 {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        // 贪心。生长时间久的 早种
        int n = plantTime.length;
        int[][] plantGrow = new int[n][2];
        for (int i = 0; i < n; i++) {
            plantGrow[i][0] = plantTime[i];
            plantGrow[i][1] = growTime[i];
        }
        Arrays.sort(plantGrow, (o1, o2) -> Integer.compare(o2[1], o1[1]));

        int max = plantGrow[0][0] + plantGrow[0][1];
        int startPlant = plantGrow[0][0] - 1;
        for (int i = 1; i < n; i++) {
            startPlant += plantGrow[i][0];
            max = Math.max(max, startPlant + plantGrow[i][1] + 1);
        }
        return max;
    }
}
/*
2136. 全部开花的最早一天
https://leetcode.cn/problems/earliest-possible-day-of-full-bloom/

第 275 场周赛 T4。

你有 n 枚花的种子。每枚种子必须先种下，才能开始生长、开花。播种需要时间，种子的生长也是如此。
给你两个下标从 0 开始的整数数组 plantTime 和 growTime ，每个数组的长度都是 n ：
- plantTime[i] 是 播种 第 i 枚种子所需的 完整天数 。每天，你只能为播种某一枚种子而劳作。无须 连续几天都在种同一枚种子，
但是种子播种必须在你工作的天数达到 plantTime[i] 之后才算完成。
- growTime[i] 是第 i 枚种子完全种下后生长所需的 完整天数 。在它生长的最后一天 之后 ，将会开花并且永远 绽放 。
从第 0 开始，你可以按 任意 顺序播种种子。
返回所有种子都开花的 最早 一天是第几天。

贪心，plantTime 是硬开销，为所需天数下界，无法优化。因此只考虑 growTime，生长时间越久的越需早种。

输入：plantTime = [1,4,3], growTime = [2,3,1]
输出：9
0 1 2 3 4 5 6 7 8 9 10
1 1 1 1 2 2 2 3
        1 1 1 2 3
              1 2 2 3

0 1 2 3 4 5 6 7 8 9 10
1 1 1 1 2 2 2 3
        1 2 2 3
          1 1 1 2 3

输入：plantTime = [1,2,3,2], growTime = [2,1,2,1]
输出：9
0 1 2 3 4 5 6 7 8 9 10
1 1 1 2 2 3
      1 2 2 3
        1 1 2 3
            1 1 2 3

输入：plantTime = [1], growTime = [1]
输出：2
0 1 2 3 4 5 6 7 8 9 10
1 2 3
 */
