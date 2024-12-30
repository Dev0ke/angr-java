import java.util.ArrayDeque;
import java.util.Queue;

public class Solution933 {
    static class RecentCounter {
        private final Queue<Integer> queue;

        public RecentCounter() {
            queue = new ArrayDeque<>();
        }

        public int ping(int t) {
            queue.add(t);
            while (queue.element() + 3000 < t) {
                queue.remove();
            }
            return queue.size();
        }
    }
}
/*
933. 最近的请求次数
https://leetcode.cn/problems/number-of-recent-calls/

第 109 场周赛 T1。

写一个 RecentCounter 类来计算特定时间范围内最近的请求。
请你实现 RecentCounter 类：
- RecentCounter() 初始化计数器，请求数为 0 。
- int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。
确切地说，返回在 [t-3000, t] 内发生的请求数。
保证 每次对 ping 的调用都使用比之前更大的 t 值。
提示：
1 <= t <= 10^9
保证每次对 ping 调用所使用的 t 值都 严格递增
至多调用 ping 方法 10^4 次

“固定大小的队列”
 */