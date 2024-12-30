import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Solution2349 {
    static class NumberContainers {
        // num -> idx[]
        private final Map<Integer, TreeSet<Integer>> numIdxSetMap;
        // idx -> num
        private final Map<Integer, Integer> idxNumMap;

        public NumberContainers() {
            numIdxSetMap = new HashMap<>();
            idxNumMap = new HashMap<>();
        }

        public void change(int index, int number) {
            if (idxNumMap.containsKey(index)) {
                int oldNumber = idxNumMap.get(index);
                numIdxSetMap.get(oldNumber).remove(index);
            }
            idxNumMap.put(index, number);
            numIdxSetMap.computeIfAbsent(number, key -> new TreeSet<>()).add(index);
        }

        public int find(int number) {
            TreeSet<Integer> treeSet = numIdxSetMap.getOrDefault(number, new TreeSet<>());
            if (treeSet.isEmpty()) {
                return -1;
            }
            return treeSet.first();
        }
    }
}
/*
2349. 设计数字容器系统
https://leetcode.cn/problems/design-a-number-container-system/

第 83 场双周赛 T3。

设计一个数字容器系统，可以实现以下功能：
- 在系统中给定下标处 插入 或者 替换 一个数字。
- 返回 系统中给定数字的最小下标。
请你实现一个 NumberContainers 类：
- NumberContainers() 初始化数字容器系统。
- void change(int index, int number) 在下标 index 处填入 number 。如果该下标 index 处已经有数字了，那么用 number 替换该数字。
- int find(int number) 返回给定数字 number 在系统中的最小下标。如果系统中没有 number ，那么返回 -1 。
提示：
1 <= index, number <= 10^9
调用 change 和 find 的 总次数 不超过 10^5 次。

模拟。利用 TreeSet 返回最小下标。
因为涉及通过下标更新，因此用 TreeSet 而不用 PriorityQueue，以达到 O(1) 删除元素。
 */