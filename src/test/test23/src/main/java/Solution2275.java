public class Solution2275 {
    public int largestCombination(int[] candidates) {
        int max = 0;
        for (int i = 0; i < 30; i++) {
            int cnt = 0;
            for (int candidate : candidates) {
                if (((candidate >> i) & 1) == 1) {
                    cnt++;
                }
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}
/*
2275. 按位与结果大于零的最长组合
https://leetcode.cn/problems/largest-combination-with-bitwise-and-greater-than-zero/

第 293 场周赛 T3。

对数组 nums 执行 按位与 相当于对数组 nums 中的所有整数执行 按位与 。
- 例如，对 nums = [1, 5, 3] 来说，按位与等于 1 & 5 & 3 = 1 。
- 同样，对 nums = [7] 而言，按位与等于 7 。
给你一个正整数数组 candidates 。计算 candidates 中的数字每种组合下 按位与 的结果。 candidates 中的每个数字在每种组合中只能使用 一次 。
返回按位与结果大于 0 的 最长 组合的长度。
提示：
1 <= candidates.length <= 10^5
1 <= candidates[i] <= 10^7

贪心，二进制位由高到低，如果全为 1 的值最大。则为 最长 组合的长度。
 */