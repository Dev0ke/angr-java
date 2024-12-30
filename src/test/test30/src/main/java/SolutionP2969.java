import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionP2969 {
    public int minimumCoins(int[] prices) {
        int n = prices.length;
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{n + 1, 0});
        for (int i = n; i >= 1; i--) {
            // 1、弹出离开窗口的元素
            while (q.getLast()[0] > 2 * i + 1) {
                q.removeLast();
            }
            // 2、转移
            int f = q.getLast()[1] + prices[i - 1];
            // 3、把 f 入队首
            while (f <= q.getFirst()[1]) {
                q.removeFirst();
            }
            q.addFirst(new int[]{i, f});
        }
        return q.getFirst()[1];
    }
}
/*
$2969. 购买水果需要的最少金币数 II
https://leetcode.cn/problems/minimum-number-of-coins-for-fruits-ii/description/

你在一个水果超市里，货架上摆满了玲琅满目的奇珍异果。
给你一个 下标从 1 开始 的数组 prices，其中 prices[i] 表示你购买第 i 个水果所需的硬币数量。
水果市场有以下优惠活动：
- 如果你用 prices[i] 个硬币购买第 i 个水果， 那么接下来的 i 个水果你都可以免费获得。
请注意 即使你 可以 免费获得第 j 个水果，你仍然可以用 prices[j] 个硬币来购买它，以获取新的优惠。
返回 获得所有水果所需的 最小 硬币数量。
提示：
1 <= prices.length <= 10^5
1 <= prices[i] <= 10^5

相似题目: 2944. 购买水果需要的最少金币数
https://leetcode.cn/problems/minimum-number-of-coins-for-fruits/description/
 */