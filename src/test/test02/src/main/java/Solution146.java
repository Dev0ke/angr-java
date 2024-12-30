import java.util.LinkedHashMap;
import java.util.Map;

public class Solution146 {
    static class LRUCache {
        private final int capacity;
        private final LinkedHashMap<Integer, Integer> lruCache;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.lruCache = new LinkedHashMap<>();
        }

        public int get(int key) {
            if (!lruCache.containsKey(key)) {
                return -1;
            }
            // 将 key 变为最近使用
            makeRecently(key);
            return lruCache.get(key);
        }

        public void put(int key, int value) {
            if (lruCache.containsKey(key)) {
                // 修改 key 的值
                lruCache.put(key, value);
                // 将 key 变为最近使用
                makeRecently(key);
                return;
            }
            if (lruCache.size() >= this.capacity) {
                // 链表头部就是最久未使用的 key
                int oldestKey = lruCache.keySet().iterator().next();
                lruCache.remove(oldestKey);
            }
            // 将新的 key 添加链表尾部
            lruCache.put(key, value);
        }

        private void makeRecently(int key) {
            int val = lruCache.get(key);
            // 删除 key，重新插入到队尾
            lruCache.remove(key);
            lruCache.put(key, val);
        }
    }

    static class LRUCache2 {
        private final LinkedHashMap<Integer, Integer> linkedHashMap;

        public LRUCache2(int capacity) {
            linkedHashMap = new LinkedHashMap<>(capacity, 0.75F, true) {
                @Override
                public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    return size() > capacity;
                }
            };
        }

        public int get(int key) {
            return linkedHashMap.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            linkedHashMap.put(key, value);
        }
    }
}
/*
146. LRU 缓存机制
https://leetcode.cn/problems/lru-cache/

请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
实现 LRUCache 类：
- LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
- int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
- void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。
如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
提示：
1 <= capacity <= 3000
0 <= key <= 10000
0 <= value <= 10^5
最多调用 2 * 10^5 次 get 和 put

Google Guava 的 LocalCache 默认是一个 LRUCache, 它是基于队列实现的。
HashMap 插入和删除时间复杂度为 O(1). 但它无法找出最近最少使用的键，因此需要结合链表。
可使用 jdk 的 LinkedHashMap 进行模拟。
相似题目: 460. LFU 缓存
https://leetcode.cn/problems/lfu-cache/
 */