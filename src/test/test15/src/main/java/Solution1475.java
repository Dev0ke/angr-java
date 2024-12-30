import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1475 {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;

        int[] res = prices.clone();
        // 单调栈 右侧第一个小于等于 arr[i] 的下标
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                res[i] -= prices[stack.peek()];
            }
            stack.push(i);
        }
        return res;
    }
}
/*
1475. 商品折扣后的最终价格
https://leetcode.cn/problems/final-prices-with-a-special-discount-in-a-shop/

给你一个数组 prices ，其中 prices[i] 是商店里第 i 件商品的价格。
商店里正在进行促销活动，如果你要买第 i 件商品，那么你可以得到与 prices[j] 相等的折扣，
其中 j 是满足 j > i 且 prices[j] <= prices[i] 的 最小下标 ，如果没有满足条件的 j ，你将没有任何折扣。
请你返回一个数组，数组中第 i 个元素是折扣后你购买商品 i 最终需要支付的价格。
提示：
1 <= prices.length <= 500
1 <= prices[i] <= 10^3

单调栈。
时间复杂度 O(n)
 */