import java.util.Arrays;

public class Solution2234 {
    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        int n = flowers.length;
        Arrays.sort(flowers);

        // 前缀和
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + flowers[i];
        }

        // 完善 花园数目
        int fullNum = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (flowers[i] >= target) {
                fullNum++;
            } else {
                break;
            }
        }

        // 全为 完善 花园
        if (fullNum == n) {
            return (long) fullNum * full;
        }

        long max = 0L;
        // 剩余 不完善 花园里，花的 最少数目
        int T = target - 1;
        // 枚举 fullNum (? ~ n), 双指针 j < i
        for (int i = n - fullNum, j = i - 1; i >= 0; i--, fullNum++) {
            if (i < n) {
                newFlowers -= Math.max(0, target - flowers[i]);
            }
            // 剩余 newFlowers
            if (newFlowers < 0) {
                break;
            }

            // 存在不完善花园
            if (i > 0) {
                while (j >= i) {
                    j--;
                }
                while (T * (j + 1L) - preSum[j + 1] > newFlowers) {
                    T--;
                    while (flowers[j] > T) {
                        j--;
                    }
                }
                max = Math.max(max, (long) fullNum * full + (long) T * partial);
            } else {
                max = Math.max(max, (long) fullNum * full);
            }
        }
        return max;
    }
}
/*
2234. 花园的最大总美丽值
https://leetcode.cn/problems/maximum-total-beauty-of-the-gardens/

第 288 场周赛 T4。

Alice 是 n 个花园的园丁，她想通过种花，最大化她所有花园的总美丽值。
给你一个下标从 0 开始大小为 n 的整数数组 flowers ，其中 flowers[i] 是第 i 个花园里已经种的花的数目。已经种了的花 不能 移走。
同时给你 newFlowers ，表示 Alice 额外可以种花的 最大数目 。同时给你的还有整数 target ，full 和 partial 。
如果一个花园有 至少 target 朵花，那么这个花园称为 完善的 ，花园的 总美丽值 为以下分数之 和 ：
- 完善 花园数目乘以 full.
- 剩余 不完善 花园里，花的 最少数目 乘以 partial 。如果没有不完善花园，那么这一部分的值为 0 。
请你返回 Alice 种最多 newFlowers 朵花以后，能得到的 最大 总美丽值。
提示：
1 <= flowers.length <= 10^5
1 <= flowers[i], target <= 10^5
1 <= newFlowers <= 10^10
1 <= full, partial <= 10^5

双指针 枚举
时间复杂度 O(nlogn) 为排序的时间复杂度。
 */