import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution857 {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;

        // 按照 r 值排序（r = wage[i]/quality[i]）
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) ids[i] = i;
        Arrays.sort(ids, (i, j) -> Integer.compare(wage[i] * quality[j], wage[j] * quality[i]));

        int sumQ = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < k; i++) {
            int q = quality[ids[i]];
            sumQ += q;
            maxHeap.add(q);
        }
        // 选 r 值最小的 k 名工人组成当前的最优解
        double ans = sumQ * ((double) wage[ids[k - 1]] / quality[ids[k - 1]]);
        for (int i = k; i < n; i++) {
            int q = quality[ids[i]];
            if (q < maxHeap.peek()) {
                sumQ -= maxHeap.remove() - q;
                maxHeap.add(q);
                ans = Math.min(ans, sumQ * ((double) wage[ids[i]] / quality[ids[i]]));
            }
        }
        return ans;
    }
}
/*
857. 雇佣 K 名工人的最低成本
https://leetcode.cn/problems/minimum-cost-to-hire-k-workers/description/

有 n 名工人。 给定两个数组 quality 和 wage ，其中，quality[i] 表示第 i 名工人的工作质量，其最低期望工资为 wage[i] 。
现在我们想雇佣 k 名工人组成一个工资组。在雇佣 一组 k 名工人时，我们必须按照下述规则向他们支付工资：
1.对工资组中的每名工人，应当按其工作质量与同组其他工人的工作质量的比例来支付工资。
2.工资组中的每名工人至少应当得到他们的最低期望工资。
给定整数 k ，返回 组成满足上述条件的付费群体所需的最小金额 。在实际答案的 10-5 以内的答案将被接受。。
提示：
n == quality.length == wage.length
1 <= k <= n <= 10^4
1 <= quality[i], wage[i] <= 10^4

反悔贪心。
最大堆维护 r 值，r = wage[i]/quality[i]。
时间复杂度 O(nlogn)。
 */