import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2558 {
    public long pickGifts(int[] gifts, int k) {
        long sum = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int x : gifts) {
            sum += x;
            maxHeap.add(x);
        }
        for (int i = 0; i < k; i++) {
            int pop = maxHeap.remove();
            int sqrt = (int) Math.sqrt(pop);
            maxHeap.add(sqrt);
            sum -= pop - sqrt;
        }
        return sum;
    }
}
/*
2558. 从数量最多的堆取走礼物
https://leetcode.cn/problems/take-gifts-from-the-richest-pile/

第 331 场周赛 T1。

给你一个整数数组 gifts ，表示各堆礼物的数量。每一秒，你需要执行以下操作：
- 选择礼物数量最多的那一堆。
- 如果不止一堆都符合礼物数量最多，从中选择任一堆即可。
- 选中的那一堆留下平方根数量的礼物（向下取整），取走其他的礼物。
返回在 k 秒后剩下的礼物数量。
提示：
1 <= gifts.length <= 10^3
1 <= gifts[i] <= 10^9
1 <= k <= 10^3

模拟/优先队列
 */