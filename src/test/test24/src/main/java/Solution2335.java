import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2335 {
    public int fillCups(int[] amount) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int am : amount) {
            if (am > 0) {
                maxHeap.add(am);
            }
        }
        int cnt = 0;
        while (!maxHeap.isEmpty()) {
            int top1 = maxHeap.remove();
            if (!maxHeap.isEmpty()) {
                int top2 = maxHeap.remove();
                if (top2 - 1 > 0) {
                    maxHeap.add(top2 - 1);
                }
            }
            if (top1 - 1 > 0) {
                maxHeap.add(top1 - 1);
            }
            cnt++;
        }
        return cnt;
    }
}
/*
2335. 装满杯子需要的最短总时长
https://leetcode.cn/problems/minimum-amount-of-time-to-fill-cups/

第 301 场周赛 T1。

现有一台饮水机，可以制备冷水、温水和热水。每秒钟，可以装满 2 杯 不同 类型的水或者 1 杯任意类型的水。
给你一个下标从 0 开始、长度为 3 的整数数组 amount ，其中 amount[0]、amount[1] 和 amount[2] 分别表示需要装满冷水、温水和热水的杯子数量。返回装满所有杯子所需的 最少 秒数。
提示：
amount.length == 3
0 <= amount[i] <= 100

优先队列模拟
 */