import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution295 {
    static class MedianFinder {
        // 小顶堆
        private final PriorityQueue<Integer> minHeap;
        // 大顶堆
        private final PriorityQueue<Integer> maxHeap;

        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        }

        public void addNum(int num) {
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.add(num);
                if (minHeap.size() + 1 < maxHeap.size()) {
                    minHeap.add(maxHeap.poll());
                }
            } else {
                minHeap.add(num);
                if (minHeap.size() > maxHeap.size()) {
                    maxHeap.add(minHeap.poll());
                }
            }
        }

        public double findMedian() {
            if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            }
            return (maxHeap.element() + minHeap.element()) / 2.0;
        }
    }
}
/*
295. 数据流的中位数
https://leetcode.cn/problems/find-median-from-data-stream/

中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
例如，
[2,3,4] 的中位数是 3
[2,3] 的中位数是 (2 + 3) / 2 = 2.5
设计一个支持以下两种操作的数据结构：
- void addNum(int num) - 从数据流中添加一个整数到数据结构中。
- double findMedian() - 返回目前所有元素的中位数。
进阶:
如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？

小顶堆 + 大顶堆。
时间复杂度：
addNum: O(logn)，其中 n 为累计添加的数的数量。
findMedian O(1)
空间复杂度 O(n) 主要为优先队列的开销。
 */