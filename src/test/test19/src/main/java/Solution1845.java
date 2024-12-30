import java.util.PriorityQueue;

public class Solution1845 {
    static class SeatManager {
        private final PriorityQueue<Integer> minHeap;

        public SeatManager(int n) {
            minHeap = new PriorityQueue<>();
            for (int i = 1; i <= n; i++) {
                minHeap.add(i);
            }
        }

        public int reserve() {
            // 每一次对 reserve 的调用，题目保证至少存在一个可以预约的座位。
            return minHeap.remove();
        }

        public void unreserve(int seatNumber) {
            // 每一次对 unreserve 的调用，题目保证 seatNumber 在调用函数前都是被预约状态。
            minHeap.add(seatNumber);
        }
    }
}
/*
1845. 座位预约管理系统
https://leetcode.cn/problems/seat-reservation-manager/

请你设计一个管理 n 个座位预约的系统，座位编号从 1 到 n 。
请你实现 SeatManager 类：
- SeatManager(int n) 初始化一个 SeatManager 对象，它管理从 1 到 n 编号的 n 个座位。所有座位初始都是可预约的。
- int reserve() 返回可以预约座位的 最小编号 ，此座位变为不可预约。
- void unreserve(int seatNumber) 将给定编号 seatNumber 对应的座位变成可以预约。
提示：
1 <= n <= 10^5
1 <= seatNumber <= n
每一次对 reserve 的调用，题目保证至少存在一个可以预约的座位。
每一次对 unreserve 的调用，题目保证 seatNumber 在调用函数前都是被预约状态。
对 reserve 和 unreserve 的调用 总共 不超过 10^5 次。

贪心。优先队列去最小值。
 */