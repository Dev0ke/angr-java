import java.util.Arrays;

public class SolutionP2548 {
    public double maxPrice(int[][] items, int capacity) {
        double totalPrice = 0;
        Arrays.sort(items, (o1, o2) -> Integer.compare(o2[0] * o1[1], o1[0] * o2[1]));
        int remain = capacity;
        int n = items.length;
        for (int i = 0; i < n && remain > 0; i++) {
            double price = items[i][0];
            int weight = items[i][1];
            int currWeight = Math.min(weight, remain);
            if (currWeight == weight) {
                totalPrice += price;
            } else {
                totalPrice += price / weight * currWeight;
            }
            remain -= currWeight;
        }
        return remain == 0 ? totalPrice : -1;
    }
}
/*
$2548. 填满背包的最大价格
https://leetcode.cn/problems/maximum-price-to-fill-a-bag/description/

给定一个二维整数数组 items ，其中 items[i] = [pricei, weighti] 表示第 i 个物品的价格和重量。
还给定一个 正 整数容量 capacity 。
每个物品可以分成两个部分，比率为 part1 和 part2 ，其中 part1 + part2 == 1 。
- 第一个物品的重量是 weighti * part1 ，价格是 pricei * part1 。
- 同样，第二个物品的重量是 weighti * part2 ，价格是 pricei * part2 。
使用给定的物品，返回填满容量为 capacity 的背包所需的 最大总价格 。如果无法填满背包，则返回 -1 。与实际答案的差距在 10^-5 以内的 实际答案 将被视为接受。
提示：
1 <= items.length <= 10^5
items[i].length == 2
1 <= pricei, weighti <= 10^4
1 <= capacity <= 10^9

贪心。
根据贪心策略，为了使总价格最大，应考虑每个物品的单位重量价格，按照单位重量价格降序选择物品。
时间复杂度 O(nlogn)。
 */