import java.util.HashSet;
import java.util.Set;

public class Solution705 {
    static class MyHashSet {
        private final Set<Integer> hashset;

        public MyHashSet() {
            hashset = new HashSet<>();
        }

        public void add(int key) {
            hashset.add(key);
        }

        public void remove(int key) {
            hashset.remove(key);
        }

        public boolean contains(int key) {
            return hashset.contains(key);
        }
    }
}
/*
705. 设计哈希集合
https://leetcode.cn/problems/design-hashset/

不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
实现 MyHashSet 类：
- void add(key) 向哈希集合中插入值 key 。
- bool contains(key) 返回哈希集合中是否存在这个值 key 。
- void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
提示：
0 <= key <= 10^6
最多调用 10^4 次 add、remove 和 contains

可以参考 Java 源码实现，在 Java 中，HashSet 是由 HashMap 实现的。
 */