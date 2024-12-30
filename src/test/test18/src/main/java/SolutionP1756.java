import java.util.ArrayList;
import java.util.List;

public class SolutionP1756 {
    static class MRUQueue {
        private final List<Integer> list;

        public MRUQueue(int n) {
            list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(i + 1);
            }
        }

        public int fetch(int k) {
            int num = list.get(k - 1);
            list.remove(k - 1);
            list.add(num);
            return num;
        }
    }
}
/*
$1756. 设计最近使用（MRU）队列
https://leetcode.cn/problems/design-most-recently-used-queue/

设计一种类似队列的数据结构，该数据结构将最近使用的元素移到队列尾部。
实现 MRUQueue 类：
- MRUQueue(int n)  使用 n 个元素： [1,2,3,...,n] 构造 MRUQueue 。
- fetch(int k) 将第 k 个元素（从 1 开始索引）移到队尾，并返回该元素。
提示：
1 <= n <= 2000
1 <= k <= n
最多调用 2000 次 fetch
进阶：找到每次 fetch 的复杂度为 O(n) 的算法比较简单。你可以找到每次 fetch 的复杂度更佳的算法吗？

数据量较小，库函数模拟。
 */