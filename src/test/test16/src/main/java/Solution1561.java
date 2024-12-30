import java.util.Arrays;

public class Solution1561 {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int ans = 0;
        // bob 拿数量最少的三分之一
        for (int i = piles.length / 3; i < piles.length; i += 2) {
            ans += piles[i];
        }
        return ans;
    }
}
/*
1561. 你可以获得的最大硬币数目
https://leetcode.cn/problems/maximum-number-of-coins-you-can-get/description/

有 3n 堆数目不一的硬币，你和你的朋友们打算按以下方式分硬币：
- 每一轮中，你将会选出 任意 3 堆硬币（不一定连续）。
- Alice 将会取走硬币数量最多的那一堆。
- 你将会取走硬币数量第二多的那一堆。
- Bob 将会取走最后一堆。
- 重复这个过程，直到没有更多硬币。
给你一个整数数组 piles ，其中 piles[i] 是第 i 堆中硬币的数目。
返回你可以获得的最大硬币数目。
提示：
3 <= piles.length <= 10^5
piles.length % 3 == 0
1 <= piles[i] <= 10^4

贪心。
搞不定 Alice 就搞定 Bob。
时间复杂度 O(nlogn)。
 */