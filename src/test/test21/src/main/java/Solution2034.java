import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution2034 {
    static class StockPrice {
        // 时间戳:价格
        private final Map<Integer, Integer> hashMap;
        // 价格:数量
        private final TreeMap<Integer, Integer> treeMap;
        private int max;

        public StockPrice() {
            hashMap = new HashMap<>();
            treeMap = new TreeMap<>();
            max = 0;
        }

        public void update(int timestamp, int price) {
            if (hashMap.containsKey(timestamp)) {
                int oldPrice = hashMap.get(timestamp);
                int cnt = treeMap.get(oldPrice);
                if (cnt == 1) {
                    treeMap.remove(oldPrice);
                } else {
                    treeMap.put(oldPrice, cnt - 1);
                }
            }
            hashMap.put(timestamp, price);
            treeMap.put(price, treeMap.getOrDefault(price, 0) + 1);
            max = Math.max(max, timestamp);
        }

        public int current() {
            return hashMap.get(max);
        }

        public int maximum() {
            return treeMap.lastKey();
        }

        public int minimum() {
            return treeMap.firstKey();
        }
    }
}
/*
2034. 股票价格波动
https://leetcode.cn/problems/stock-price-fluctuation/

第 262 场周赛 T3。

给你一支股票价格的数据流。数据流中每一条记录包含一个 时间戳 和该时间点股票对应的 价格 。
不巧的是，由于股票市场内在的波动性，股票价格记录可能不是按时间顺序到来的。某些情况下，有的记录可能是错的。
如果两个有相同时间戳的记录出现在数据流中，前一条记录视为错误记录，后出现的记录 更正 前一条错误的记录。
请你设计一个算法，实现：
- 更新 股票在某一时间戳的股票价格，如果有之前同一时间戳的价格，这一操作将 更正 之前的错误价格。
- 找到当前记录里 最新股票价格 。最新股票价格 定义为时间戳最晚的股票价格。
- 找到当前记录里股票的 最高价格 。
- 找到当前记录里股票的 最低价格 。
请你实现 StockPrice 类：
- StockPrice() 初始化对象，当前无股票价格记录。
- void update(int timestamp, int price) 在时间点 timestamp 更新股票价格为 price 。
- int current() 返回股票 最新价格 。
- int maximum() 返回股票 最高价格 。
- int minimum() 返回股票 最低价格 。

设 key-value 为 时间戳-股票价格。
我们知道 java.util.TreeMap 默认是根据 key 升序排序的，本题题意需要根据 value 进行排序，但 java 类库中没有现成的数据结构。
可以结合 HashMap 和 TreeMap 二者的特性，将 value 放到 TreeMap 的 key 上，再用 HashMap 维护 key-value 的关系
相似题目: $1244. 力扣排行榜
https://leetcode.cn/problems/design-a-leaderboard/
 */