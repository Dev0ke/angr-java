public class Solution1854 {
    public int maximumPopulation(int[][] logs) {
        // 1950 <= birthi < deathi <= 2050
        int len = 2050 - 1950 + 1;
        // 差分数组
        int[] diff = new int[len + 1];
        for (int[] log : logs) {
            int i = log[0] - 1950;
            // 人不应当计入他们死亡当年的人口中
            int j = log[1] - 1950 - 1;
            int change = 1;
            diff[i] += change;
            diff[j + 1] -= change;
        }
        // 还原数组
        int[] res = new int[len];
        res[0] = diff[0];
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        // 统计最值
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < len; i++) {
            if (res[i] > max) {
                max = res[i];
                maxIndex = i;
            }
        }
        return maxIndex + 1950;
    }
}
/*
1854. 人口最多的年份
https://leetcode.cn/problems/maximum-population-year/

第 240 场周赛 T1。

给你一个二维整数数组 logs ，其中每个 logs[i] = [birthi, deathi] 表示第 i 个人的出生和死亡年份。
年份 x 的 人口 定义为这一年期间活着的人的数目。第 i 个人被计入年份 x 的人口需要满足：x 在闭区间 [birthi, deathi - 1] 内。注意，人不应当计入他们死亡当年的人口中。
返回 人口最多 且 最早 的年份。
提示：
1 <= logs.length <= 100
1950 <= birthi < deathi <= 2050

差分数组。区间为 100，暴力也是可以的。
 */