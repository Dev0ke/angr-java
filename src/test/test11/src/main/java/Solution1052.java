public class Solution1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        // grumpy[i] = 0 全加到答案
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) sum += customers[i];
        }

        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) sum += customers[i];
        }
        int ans = sum;
        for (int i = minutes; i < n; i++) {
            if (grumpy[i - minutes] == 1) sum -= customers[i - minutes];
            if (grumpy[i] == 1) sum += customers[i];
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
/*
1052. 爱生气的书店老板
https://leetcode.cn/problems/grumpy-bookstore-owner/

有一个书店老板，他的书店开了 n 分钟。每分钟都有一些顾客进入这家商店。
给定一个长度为 n 的整数数组 customers ，其中 customers[i] 是在第 i 分钟开始时进入商店的顾客数量，所有这些顾客在第 i 分钟结束后离开。
在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。
当书店老板生气时，那一分钟的顾客就会不满意，若老板不生气则顾客是满意的。
书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 minutes 分钟不生气，但却只能使用一次。
请你返回 这一天营业下来，最多有多少客户能够感到满意 。
提示：
n == customers.length == grumpy.length
1 <= minutes <= n <= 2 * 10^4
0 <= customers[i] <= 1000
grumpy[i] == 0 or 1

定长滑动窗口。
grumpy[i] = 0 全加到答案。grumpy[i] = 1 定长滑动窗口取最大值。
时间复杂度 O(n)
 */