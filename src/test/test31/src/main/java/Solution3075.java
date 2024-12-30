import java.util.Arrays;

public class Solution3075 {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        Arrays.sort(happiness);
        long ans = 0;
        for (int i = 0; i < k; i++) {
            // 取最大 k 个
            int j = n - 1 - i;
            ans += Math.max(0, happiness[j] - i);
        }
        return ans;
    }
}
/*
3075. 幸福值最大化的选择方案
https://leetcode.cn/problems/maximize-happiness-of-selected-children/description/

第 388 场周赛 T2。

给你一个长度为 n 的数组 happiness ，以及一个 正整数 k 。
n 个孩子站成一队，其中第 i 个孩子的 幸福值 是 happiness[i] 。你计划组织 k 轮筛选从这 n 个孩子中选出 k 个孩子。
在每一轮选择一个孩子时，所有 尚未 被选中的孩子的 幸福值 将减少 1 。注意，幸福值 不能 变成负数，且只有在它是正数的情况下才会减少。
选择 k 个孩子，并使你选中的孩子幸福值之和最大，返回你能够得到的 最大值 。
提示：
1 <= n == happiness.length <= 2 * 10^5
1 <= happiness[i] <= 10^8
1 <= k <= n

贪心。取最大 k 个，每个的上限依次 -1，和 0 取最大值。
时间复杂度 O(nlogn)
 */