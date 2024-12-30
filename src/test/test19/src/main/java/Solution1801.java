import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1801 {
    private static final int MOD = (int) (1e9 + 7);

    public int getNumberOfBacklogOrders(int[][] orders) {
        // 价格, 数量
        PriorityQueue<int[]> buy = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[0], o1[0]));
        // 价格, 数量（查看积压订单中价格 最低 的销售订单 sell）
        PriorityQueue<int[]> sell = new PriorityQueue<>(Comparator.comparing(o -> o[0]));

        for (int[] p : orders) {
            int price = p[0], amount = p[1], orderType = p[2];
            if (orderType == 0) { // 0 表示这是一批采购订单 buy
                // 如果该销售订单 sell 的价格 低于或等于 当前采购订单 buy 的价格，则匹配并执行这两笔订单
                while (amount > 0 && !sell.isEmpty() && sell.peek()[0] <= price) {
                    int[] top = sell.remove();
                    int match = Math.min(amount, top[1]);
                    amount -= match;
                    top[1] -= match;
                    if (top[1] > 0) sell.add(top);
                }
                if (amount > 0) buy.add(new int[]{price, amount});
            } else { // 1 表示这是一批销售订单 sell
                // 如果该采购订单 buy 的价格 高于或等于 当前销售订单 sell 的价格，则匹配并执行这两笔订单
                while (amount > 0 && !buy.isEmpty() && buy.peek()[0] >= price) {
                    int[] top = buy.remove();
                    int match = Math.min(amount, top[1]);
                    amount -= match;
                    top[1] -= match;
                    if (top[1] > 0) buy.add(top);
                }
                if (amount > 0) sell.add(new int[]{price, amount});
            }
        }

        long ans = 0;
        for (int[] p : buy) ans += p[1];
        for (int[] p : sell) ans += p[1];
        return (int) (ans % MOD);
    }
}
/*
1801. 积压订单中的订单总数
https://leetcode.cn/problems/number-of-orders-in-the-backlog/

给你一个二维整数数组 orders ，其中每个 orders[i] = [pricei, amounti, orderTypei] 表示有 amounti 笔类型为 orderTypei 、价格为 pricei 的订单。
订单类型 orderTypei 可以分为两种：
- 0 表示这是一批采购订单 buy
- 1 表示这是一批销售订单 sell
注意，orders[i] 表示一批共计 amounti 笔的独立订单，这些订单的价格和类型相同。对于所有有效的 i ，由 orders[i] 表示的所有订单提交时间均早于 orders[i+1] 表示的所有订单。
存在由未执行订单组成的 积压订单 。积压订单最初是空的。提交订单时，会发生以下情况：
- 如果该订单是一笔采购订单 buy ，则可以查看积压订单中价格 最低 的销售订单 sell 。
  如果该销售订单 sell 的价格 低于或等于 当前采购订单 buy 的价格，则匹配并执行这两笔订单，并将销售订单 sell 从积压订单中删除。
  否则，采购订单 buy 将会添加到积压订单中。
- 反之亦然，如果该订单是一笔销售订单 sell ，则可以查看积压订单中价格 最高 的采购订单 buy 。
  如果该采购订单 buy 的价格 高于或等于 当前销售订单 sell 的价格，则匹配并执行这两笔订单，并将采购订单 buy 从积压订单中删除。
  否则，销售订单 sell 将会添加到积压订单中。
输入所有订单后，返回积压订单中的 订单总数 。由于数字可能很大，所以需要返回对 10^9 + 7 取余的结果。
提示：
1 <= orders.length <= 10^5
orders[i].length == 3
1 <= pricei, amounti <= 10^9
orderTypei 为 0 或 1

双堆模拟
 */