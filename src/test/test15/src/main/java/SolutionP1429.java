import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class SolutionP1429 {
    static class FirstUnique {
        private final Queue<Integer> queue;
        private final Map<Integer, Integer> cntMap;

        public FirstUnique(int[] nums) {
            queue = new ArrayDeque<>();
            cntMap = new HashMap<>();
            for (int x : nums) {
                queue.add(x);
                cntMap.put(x, cntMap.getOrDefault(x, 0) + 1);
            }
        }

        public int showFirstUnique() {
            while (!queue.isEmpty() && cntMap.get(queue.peek()) > 1) {
                queue.remove();
            }
            return queue.isEmpty() ? -1 : queue.peek();
        }

        public void add(int value) {
            queue.add(value);
            cntMap.put(value, cntMap.getOrDefault(value, 0) + 1);
        }
    }
}
/*
$1429. 第一个唯一数字
https://leetcode.cn/problems/first-unique-number/

给定一系列整数，插入一个队列中，找出队列中第一个唯一整数。
实现 FirstUnique 类：
- FirstUnique(int[] nums) 用数组里的数字初始化队列。
- int showFirstUnique() 返回队列中的 第一个唯一 整数的值。如果没有唯一整数，返回 -1。（译者注：此方法不移除队列中的任何元素）
- void add(int value) 将 value 插入队列中。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^8
1 <= value <= 10^8
最多调用 5000 次 showFirstUnique 和 add 。

哈希 + 队列 模拟
 */