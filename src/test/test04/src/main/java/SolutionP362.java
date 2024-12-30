import java.util.ArrayDeque;
import java.util.Queue;

public class SolutionP362 {
    static class HitCounter {
        private final Queue<Integer> queue;

        public HitCounter() {
            queue = new ArrayDeque<>();
        }

        public void hit(int timestamp) {
            queue.add(timestamp);
        }

        public int getHits(int timestamp) {
            while (!queue.isEmpty() && queue.peek() <= timestamp - 300) {
                queue.remove();
            }
            return queue.size();
        }
    }
}
/*
$362. 敲击计数器
https://leetcode.cn/problems/design-hit-counter/

设计一个敲击计数器，使它可以统计在过去 5 分钟内被敲击次数。（即过去 300 秒）

您的系统应该接受一个时间戳参数 timestamp (单位为 秒 )，并且您可以假定对系统的调用是按时间顺序进行的(即 timestamp 是单调递增的)。几次撞击可能同时发生。
实现 HitCounter 类:
- HitCounter() 初始化命中计数器系统。
- void hit(int timestamp) 记录在 timestamp ( 单位为秒 )发生的一次命中。在同一个 timestamp 中可能会出现几个点击。
- int getHits(int timestamp) 返回 timestamp 在过去 5 分钟内(即过去 300 秒)的命中次数。
提示:
1 <= timestamp <= 2 * 10^9
所有对系统的调用都是按时间顺序进行的（即 timestamp 是单调递增的）
hit and getHits 最多被调用 300 次
进阶: 如果每秒的敲击次数是一个很大的数字，你的计数器可以应对吗？

滑动窗口思想
 */