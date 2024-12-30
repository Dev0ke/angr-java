public class Solution1578 {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();

        int res = 0;
        int i = 0;
        while (i < n) {
            char ch = colors.charAt(i);
            int sum = 0;
            int max = 0;
            while (i < n && colors.charAt(i) == ch) {
                sum += neededTime[i];
                max = Math.max(max, neededTime[i]);
                i++;
            }
            res += sum - max;
        }
        return res;
    }
}
/*
1578. 使绳子变成彩色的最短时间
https://leetcode.cn/problems/minimum-time-to-make-rope-colorful/

Alice 把 n 个气球排列在一根绳子上。给你一个下标从 0 开始的字符串 colors ，其中 colors[i] 是第 i 个气球的颜色。
Alice 想要把绳子装扮成 彩色 ，且她不希望两个连续的气球涂着相同的颜色，所以她喊来 Bob 帮忙。Bob 可以从绳子上移除一些气球使绳子变成 彩色 。
给你一个下标从 0 开始的整数数组 neededTime ，其中 neededTime[i] 是 Bob 从绳子上移除第 i 个气球需要的时间（以秒为单位）。
返回 Bob 使绳子变成 彩色 需要的 最少时间 。
提示：
n == colors.length == neededTime.length
1 <= n <= 10^5
1 <= neededTime[i] <= 10^4
colors 仅由小写英文字母组成

贪心。
在相邻相同颜色的气球中，保留耗时最大的，删除剩余的即可。
时间复杂度 O(n)
空间复杂度 O(1)
 */