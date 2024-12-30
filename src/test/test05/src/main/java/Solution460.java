import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution460 {
    static class LFUCache {
        private int minFrequency;
        private final int capacity;
        private final Map<Integer, Node> keyMap;
        private final Map<Integer, LinkedList<Node>> frequencyMap;

        public LFUCache(int capacity) {
            this.minFrequency = 0;
            this.capacity = capacity;
            this.keyMap = new HashMap<>();
            this.frequencyMap = new HashMap<>();
        }

        public int get(int key) {
            if (capacity == 0) {
                return -1;
            }
            if (!keyMap.containsKey(key)) {
                return -1;
            }
            Node node = keyMap.get(key);
            int value = node.value;
            int freq = node.frequency;

            frequencyMap.get(freq).remove(node);
            // 如果当前链表为空，我们需要在哈希表中删除，且更新 minFrequency
            if (frequencyMap.get(freq).size() == 0) {
                frequencyMap.remove(freq);
                if (minFrequency == freq) {
                    minFrequency += 1;
                }
            }
            // 插入到 freq + 1 中
            LinkedList<Node> list = frequencyMap.getOrDefault(freq + 1, new LinkedList<>());
            list.offerFirst(new Node(key, value, freq + 1));
            frequencyMap.put(freq + 1, list);
            keyMap.put(key, frequencyMap.get(freq + 1).peekFirst());
            return value;
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            if (!keyMap.containsKey(key)) {
                // 缓存已满，需要进行删除操作
                if (keyMap.size() == capacity) {
                    // 通过 minFrequency 拿到 frequencyMap[minFrequency] 链表的末尾节点
                    Node node = frequencyMap.get(minFrequency).peekLast();
                    keyMap.remove(node.key);
                    frequencyMap.get(minFrequency).pollLast();
                    if (frequencyMap.get(minFrequency).size() == 0) {
                        frequencyMap.remove(minFrequency);
                    }
                }
                LinkedList<Node> list = frequencyMap.getOrDefault(1, new LinkedList<>());
                list.offerFirst(new Node(key, value, 1));
                frequencyMap.put(1, list);
                keyMap.put(key, frequencyMap.get(1).peekFirst());
                minFrequency = 1;
            } else {
                // 与 get 操作基本一致，除了需要更新缓存的值
                Node node = keyMap.get(key);
                int freq = node.frequency;
                frequencyMap.get(freq).remove(node);
                if (frequencyMap.get(freq).size() == 0) {
                    frequencyMap.remove(freq);
                    if (minFrequency == freq) {
                        minFrequency += 1;
                    }
                }
                LinkedList<Node> list = frequencyMap.getOrDefault(freq + 1, new LinkedList<>());
                list.offerFirst(new Node(key, value, freq + 1));
                frequencyMap.put(freq + 1, list);
                keyMap.put(key, frequencyMap.get(freq + 1).peekFirst());
            }
        }

        private static class Node {
            int key;
            int value;
            int frequency;

            public Node(int key, int value, int frequency) {
                this.key = key;
                this.value = value;
                this.frequency = frequency;
            }
        }
    }
}
/*
460. LFU 缓存
https://leetcode.cn/problems/lfu-cache/

请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。
实现 LFUCache 类：
- LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象
- int get(int key) - 如果键 key 存在于缓存中，则获取键的值，否则返回 -1 。
- void put(int key, int value) - 如果键 key 已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量 capacity 时，
则应该在插入新项之前，移除最不经常使用的项。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。
为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。
当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。
函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
提示：
0 <= capacity <= 10^4
0 <= key <= 10^5
0 <= value <= 10^9
最多调用 2 * 10^5 次 get 和 put 方法

Redis 到 4.0 版本才支持 LFU 淘汰策略，说明 LFU 实现较 LRU 复杂且使用场景不如 LRU 广。
Redis 在使用 LFU 淘汰策略下，可以分析 热key。
双哈希表。
官方题解: https://leetcode.cn/problems/lfu-cache/solution/lfuhuan-cun-by-leetcode-solution/
相似题目: 146. LRU 缓存机制
https://leetcode.cn/problems/lru-cache/
 */