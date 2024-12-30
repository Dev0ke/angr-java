public class Solution3185 {
    public long countCompleteDayPairs(int[] hours) {
        int[] cnt = new int[24];
        long ans = 0;
        for (int h : hours) {
            h %= 24;
            ans += cnt[(24 - h) % 24];
            cnt[h]++;
        }
        return ans;
    }
}
/*
3185. 构成整天的下标对数目 II
https://leetcode.cn/problems/count-pairs-that-form-a-complete-day-ii/description/

第 402 场周赛 T2。

给你一个整数数组 hours，表示以 小时 为单位的时间，返回一个整数，表示满足 i < j 且 hours[i] + hours[j] 构成 整天 的下标对 i, j 的数目。
整天 定义为时间持续时间是 24 小时的 整数倍 。
例如，1 天是 24 小时，2 天是 48 小时，3 天是 72 小时，以此类推。
提示：
1 <= hours.length <= 5 * 10^5
1 <= hours[i] <= 10^9

取模 + 两数之和。
相似题目: 1010. 总持续时间可被 60 整除的歌曲
https://leetcode.cn/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 */