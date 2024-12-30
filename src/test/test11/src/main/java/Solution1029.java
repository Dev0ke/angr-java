import java.util.Arrays;
import java.util.Comparator;

public class Solution1029 {
    public int twoCitySchedCost(int[][] costs) {
        // a 市比 b 市费用高多少
        Arrays.sort(costs, Comparator.comparingInt(o -> o[0] - o[1]));
        // 2n 人
        int n = costs.length / 2;
        int res = 0;
        // 贪心。前 n 个去 a 市，后 n 个去 b 市
        for (int i = 0; i < n; i++) {
            res += costs[i][0] + costs[i + n][1];
        }
        return res;
    }
}
/*
1029. 两地调度
https://leetcode.cn/problems/two-city-scheduling/

第 133 场周赛 T1。

公司计划面试 2n 人。给你一个数组 costs ，其中 costs[i] = [aCosti, bCosti] 。第 i 人飞往 a 市的费用为 aCosti ，飞往 b 市的费用为 bCosti 。
返回将每个人都飞到 a 、b 中某座城市的最低费用，要求每个城市都有 n 人抵达。
提示：
2 * n == costs.length
2 <= costs.length <= 100
costs.length 为偶数
1 <= aCosti, bCosti <= 1000

贪心。
 */