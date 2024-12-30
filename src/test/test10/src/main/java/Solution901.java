import java.util.ArrayDeque;
import java.util.Deque;

public class Solution901 {
    static class StockSpanner {
        private final Deque<Integer> priceStack;
        private final Deque<Integer> wStack;

        private int countRemove;

        public StockSpanner() {
            priceStack = new ArrayDeque<>();
            wStack = new ArrayDeque<>();
        }

        public int next(int price) {
            int w = 1;
            while (!priceStack.isEmpty() && priceStack.peek() <= price) {
                priceStack.pop();
                w += wStack.pop();
            }
            priceStack.push(price);
            wStack.push(w);
            return w;
        }
    }
}
/*
901. 股票价格跨度
https://leetcode.cn/problems/online-stock-span/

第 101 场周赛 T2。

设计一个算法收集某些股票的每日报价，并返回该股票当日价格的 跨度 。
当日股票价格的 跨度 被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
例如，如果未来 7 天股票的价格是 [100,80,60,70,60,75,85]，那么股票跨度将是 [1,1,1,2,1,4,6] 。
实现 StockSpanner 类：
- StockSpanner() 初始化类对象。
- int next(int price) 给出今天的股价 price ，返回该股票当日价格的 跨度 。
提示：
1 <= price <= 10^5
最多调用 next 方法 10^4 次

单调栈。
 */