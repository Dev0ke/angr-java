import java.util.HashMap;
import java.util.Map;

public class Solution706 {
    static class MyHashMap {
        private final Map<Integer, Integer> hashMap;

        public MyHashMap() {
            hashMap = new HashMap<>();
        }

        public void put(int key, int value) {
            hashMap.put(key, value);
        }

        public int get(int key) {
            return hashMap.getOrDefault(key, -1);
        }

        public void remove(int key) {
            hashMap.remove(key);
        }
    }
}
/*
706. 设计哈希映射
https://leetcode.cn/problems/design-hashmap/

不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
实现 MyHashMap 类：
- MyHashMap() 用空映射初始化对象
- void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value 。
- int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
- void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
提示：
0 <= key, value <= 10^6
最多调用 10^4 次 put、get 和 remove 方法

实际工程意义不大。可以参考 HashMap 源码。
 */