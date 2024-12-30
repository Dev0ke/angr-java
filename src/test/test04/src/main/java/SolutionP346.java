import java.util.ArrayDeque;
import java.util.Queue;

public class SolutionP346 {
    /**
     * 剑指 Offer II 041. 滑动窗口的平均值
     * https://leetcode.cn/problems/qIsx9U/
     */
    static class MovingAverage {
        private final Queue<Integer> queue;
        private final int capacity;
        private int sum = 0;

        public MovingAverage(int size) {
            this.capacity = size;
            this.queue = new ArrayDeque<>();
        }

        public double next(int val) {
            if (queue.size() == this.capacity) {
                sum -= queue.remove();
            }
            queue.add(val);
            sum += val;
            return sum / (double) queue.size();
        }
    }
}
/*
$346. 数据流中的移动平均值
https://leetcode.cn/problems/moving-average-from-data-stream/

给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算其所有整数的移动平均值。
实现 MovingAverage 类：
- MovingAverage(int size) 用窗口大小 size 初始化对象。
- double next(int val) 计算并返回数据流中最后 size 个值的移动平均值。
提示：
1 <= size <= 1000
-10^5 <= val <= 10^5
最多调用 next 方法 10^4 次

队列
滑动窗口的平均值
 */