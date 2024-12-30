import java.util.HashMap;
import java.util.Map;

public class SolutionP2898 {
    public long maxScore(int[] prices) {
        int n = prices.length;
        Map<Integer, Long> mp = new HashMap<>();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int diff = prices[i] - i;
            ans = Math.max(ans, mp.merge(diff, (long) prices[i], Long::sum));
        }
        return ans;
    }
}
/*
$2898. 最大线性股票得分
https://leetcode.cn/problems/maximum-linear-stock-score/description/

给定一个 1-indexed 整数数组 prices，其中 prices[i] 是第 i 天某只股票的价格。你的任务是 线性 地选择 prices 中的一些元素。
一个选择 indexes，其中 indexes 是一个 1-indexed 整数数组，长度为 k，是数组 [1, 2, ..., n] 的子序列，如果以下条件成立，那么它是 线性 的：
- 对于每个 1 < j <= k，prices[indexes[j]] - prices[indexes[j - 1]] == indexes[j] - indexes[j - 1]。
数组的 子序列 是经由原数组删除一些元素（可能不删除）而产生的新数组，且删除不改变其余元素相对顺序。
选择 indexes 的 得分 等于以下数组的总和：[prices[indexes[1]], prices[indexes[2]], ..., prices[indexes[k]]。
返回 线性选择的 最大得分。
提示：
1 <= prices.length <= 10^5
1 <= prices[i] <= 10^9

prices[indexes[j]] - prices[indexes[j - 1]] == indexes[j] - indexes[j - 1]
设 prices[x]−prices[y] = x−y
即 prices[x]−x = prices[y]−y
因此统计 prices[i]−i 即可。
 */