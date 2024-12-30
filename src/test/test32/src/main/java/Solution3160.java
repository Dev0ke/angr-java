import java.util.HashMap;
import java.util.Map;

public class Solution3160 {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> ballColorMap = new HashMap<>();
        Map<Integer, Integer> colorCntMap = new HashMap<>();
        int n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int x = queries[i][0], y = queries[i][1];
            if (ballColorMap.containsKey(x)) { // 已染色
                Integer old = ballColorMap.get(x);
                if (colorCntMap.merge(old, -1, Integer::sum) == 0) {
                    colorCntMap.remove(old);
                }
            }
            ballColorMap.put(x, y);
            colorCntMap.merge(y, 1, Integer::sum);
            ans[i] = colorCntMap.size();
        }
        return ans;
    }
}
/*
3160. 所有球里面不同颜色的数目
https://leetcode.cn/problems/find-the-number-of-distinct-colors-among-the-balls/description/

第 131 场双周赛 T3。

给你一个整数 limit 和一个大小为 n x 2 的二维数组 queries 。
总共有 limit + 1 个球，每个球的编号为 [0, limit] 中一个 互不相同 的数字。一开始，所有球都没有颜色。queries 中每次操作的格式为 [x, y] ，你需要将球 x 染上颜色 y 。每次操作之后，你需要求出所有球中 不同 颜色的数目。
请你返回一个长度为 n 的数组 result ，其中 result[i] 是第 i 次操作以后不同颜色的数目。
注意 ，没有染色的球不算作一种颜色。
提示：
1 <= limit <= 10^9
1 <= n == queries.length <= 10^5
queries[i].length == 2
0 <= queries[i][0] <= limit
1 <= queries[i][1] <= 10^9

双哈希表，一个记录 每个球是什么颜色，一个记录颜色数量。
时间复杂度 O(n)。
 */