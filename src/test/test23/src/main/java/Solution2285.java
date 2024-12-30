import java.util.Arrays;

public class Solution2285 {
    public long maximumImportance(int n, int[][] roads) {
        int[] degrees = new int[n];
        for (int[] road : roads) {
            degrees[road[0]]++;
            degrees[road[1]]++;
        }

        long sum = 0;
        Arrays.sort(degrees);
        for (int i = 0; i < n; i++) {
            sum += degrees[i] * (i + 1L);
        }
        return sum;
    }
}
/*
2285. 道路的最大总重要性
https://leetcode.cn/problems/maximum-total-importance-of-roads/

第 79 场双周赛 T3。

给你一个整数 n ，表示一个国家里的城市数目。城市编号为 0 到 n - 1 。
给你一个二维整数数组 roads ，其中 roads[i] = [ai, bi] 表示城市 ai 和 bi 之间有一条 双向 道路。
你需要给每个城市安排一个从 1 到 n 之间的整数值，且每个值只能被使用 一次 。道路的 重要性 定义为这条道路连接的两座城市数值 之和 。
请你返回在最优安排下，所有道路重要性 之和 最大 为多少。
提示：
2 <= n <= 5 * 10^4
1 <= roads.length <= 5 * 10^4
roads[i].length == 2
0 <= ai, bi <= n - 1
ai != bi
没有重复道路。

邻项交换法
贪心，"度" 越大的节点，整数值尽可能大。
 */