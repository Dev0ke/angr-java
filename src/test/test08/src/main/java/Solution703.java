import java.util.PriorityQueue;

public class Solution703 {
    static class KthLargest {
        private final PriorityQueue<Integer> minHeap;
        private final int size;

        public KthLargest(int k, int[] nums) {
            size = k;
            minHeap = new PriorityQueue<>();
            for (int num : nums) {
                this.add(num);
            }
        }

        public int add(int val) {
            if (minHeap.size() < size) {
                minHeap.add(val);
            } else if (val > minHeap.element()) {
                minHeap.remove();
                minHeap.add(val);
            }
            return minHeap.element();
        }
    }
}
/*
703. 数据流中的第 K 大元素
https://leetcode.cn/problems/kth-largest-element-in-a-stream/

设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
请实现 KthLargest 类：
- KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
- int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
提示：
1 <= k <= 10^4
0 <= nums.length <= 10^4
-10^4 <= nums[i] <= 10^4
-10^4 <= val <= 10^4
最多调用 add 方法 10^4 次
题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素

优先队列（小顶堆）
每个 int add(int val) 时间复杂度为 O(logk)
priorityQueue 空间复杂度为 O(k)
 */