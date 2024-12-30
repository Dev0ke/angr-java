import java.util.Comparator;
import java.util.PriorityQueue;

public class SolutionP1058 {
    public String minimizeError(String[] prices, int target) {
        int floorSum = 0;
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (String s : prices) {
            double price = Double.parseDouble(s);
            int floor = (int) Math.floor(price);
            floorSum += floor;
            if (price - floor > 0) {
                // 小数部分
                maxHeap.add(price - floor);
            }
        }

        // 无法达到目标值 target，就返回字符串 "-1"。
        if (target < floorSum || target > floorSum + maxHeap.size()) {
            return "-1";
        }

        // 需要向上取整的数量
        int ceilNum = target - floorSum;
        double res = 0;
        for (int i = 0; i < ceilNum; i++) {
            res += (1.0 - maxHeap.remove());
        }
        while (!maxHeap.isEmpty()) {
            res += maxHeap.remove();
        }
        return String.format("%.3f", res);
    }
}
/*
$1058. 最小化舍入误差以满足目标
https://leetcode.cn/problems/minimize-rounding-error-to-meet-target/

给定一系列价格 [p1,p2...,pn] 和一个目标 target，将每个价格 pi 舍入为 Roundi(pi) 以使得舍入数组 [Round1(p1),Round2(p2)...,Roundn(pn)] 之和达到给定的目标值 target。
每次舍入操作 Roundi(pi) 可以是向下舍 Floor(pi) 也可以是向上入 Ceil(pi)。
如果舍入数组之和无论如何都无法达到目标值 target，就返回字符串 "-1"。否则，以保留到小数点后三位的字符串格式返回最小的舍入误差，其定义为 Σ |Roundi(pi) - (pi)|（ i 从 1 到 n ）。
提示：
1 <= prices.length <= 500
表示价格的每个字符串 prices[i] 都代表一个介于 [0.0, 1000.0] 之间的实数，并且正好有 3 个小数位。
target 介于 0 和 1000000 之间。

贪心，优先队列
 */