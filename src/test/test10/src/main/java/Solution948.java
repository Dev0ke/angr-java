import java.util.Arrays;

public class Solution948 {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length;
        Arrays.sort(tokens);
        int l = 0, r = n - 1;
        int points = 0;
        int max = 0;
        while (l <= r && (power >= tokens[l] || points > 0)) {
            while (l <= r && power >= tokens[l]) {
                power -= tokens[l];
                l++;
                points++;
            }

            max = Math.max(max, points);
            if (l <= r && points > 0) {
                power += tokens[r];
                r--;
                points--;
            }
        }
        return max;
    }
}
/*
948. 令牌放置
https://leetcode.cn/problems/bag-of-tokens/

你的初始 能量 为 power，初始 分数 为 0，只有一包令牌 tokens 。其中 tokens[i] 是第 i 个令牌的值（下标从 0 开始）。
令牌可能的两种使用方法如下：
- 如果你至少有 token[i] 点 能量 ，可以将令牌 i 置为正面朝上，失去 token[i] 点 能量 ，并得到 1 分 。
- 如果我们至少有 1 分 ，可以将令牌 i 置为反面朝上，获得 token[i] 点 能量 ，并失去 1 分 。
每个令牌 最多 只能使用一次，使用 顺序不限 ，不需 使用所有令牌。
在使用任意数量的令牌后，返回我们可以得到的最大 分数 。
提示：
0 <= tokens.length <= 1000
0 <= tokens[i], power < 10^4

贪心。选最小的令牌正面朝上，选最大的令牌反面朝上。实现时采用 双指针。
时间复杂度 O(nlogn)
 */