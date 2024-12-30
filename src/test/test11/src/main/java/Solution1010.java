public class Solution1010 {
    public int numPairsDivisibleBy60(int[] time) {
        long[] remainCnt = new long[60];
        for (int t : time) {
            remainCnt[t % 60]++;
        }

        long ans = 0;
        // 1-29
        for (int t = 1; t <= 29; t++) {
            ans += remainCnt[t] * remainCnt[60 - t];
        }
        // 0 / 30
        ans += remainCnt[0] * (remainCnt[0] - 1) / 2;
        ans += remainCnt[30] * (remainCnt[30] - 1) / 2;
        return (int) ans;
    }
}
/*
1010. 总持续时间可被 60 整除的歌曲
https://leetcode.cn/problems/pairs-of-songs-with-total-durations-divisible-by-60/

在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望下标数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。
提示：
1 <= time.length <= 6 * 10^4
1 <= time[i] <= 500

同余 + 乘法原理
时间复杂度 O(n)
 */