import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Solution380 {
    static class RandomizedSet {
        private final Map<Integer, Integer> hashMap;
        private final List<Integer> list;

        public RandomizedSet() {
            hashMap = new HashMap<>();
            list = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (hashMap.containsKey(val)) {
                return false;
            }
            hashMap.put(val, list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (hashMap.containsKey(val)) {
                int idx = hashMap.get(val);
                hashMap.put(list.get(list.size() - 1), idx);
                hashMap.remove(val);
                list.set(idx, list.get(list.size() - 1));
                list.remove(list.size() - 1);
                return true;
            }
            return false;
        }

        public int getRandom() {
            Random random = new Random();
            return list.get(random.nextInt(list.size()));
        }
    }
}
/*
380. O(1) 时间插入、删除和获取随机元素
https://leetcode.cn/problems/insert-delete-getrandom-o1/

实现RandomizedSet 类：
- RandomizedSet() 初始化 RandomizedSet 对象
- bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
- bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
- int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
提示：
-2^31 <= val <= 2^31 - 1
最多调用 insert、remove 和 getRandom 函数 2 * 10^5 次
在调用 getRandom 方法时，数据结构中 至少存在一个 元素。

HashMap 插入和删除时间复杂度为 O(1).
获取随机元素需要用到数组。
HashMap + ArrayList 即可
 */