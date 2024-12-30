import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class SolutionP1182 {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        Map<Integer, TreeSet<Integer>> idxListMap = new HashMap<>();
        for (int i = 0; i < colors.length; i++) {
            TreeSet<Integer> idxTresSet = idxListMap.getOrDefault(colors[i], new TreeSet<>());
            idxTresSet.add(i);
            idxListMap.put(colors[i], idxTresSet);
        }

        List<Integer> resList = new ArrayList<>();
        for (int[] query : queries) {
            if (!idxListMap.containsKey(query[1])) {
                resList.add(-1);
                continue;
            }
            TreeSet<Integer> idxTresSet = idxListMap.get(query[1]);
            Integer ceiling = idxTresSet.ceiling(query[0]);
            int min = Integer.MAX_VALUE;
            if (ceiling != null) {
                min = ceiling - query[0];
            }
            Integer floor = idxTresSet.floor(query[0]);
            if (floor != null) {
                min = Math.min(min, query[0] - floor);
            }
            resList.add(min);
        }
        return resList;
    }
}
/*
$1182. 与目标颜色间的最短距离
https://leetcode.cn/problems/shortest-distance-to-target-color/

第 8 场双周赛 T3。

给你一个数组 colors，里面有  1、2、 3 三种颜色。
我们需要在 colors 上进行一些查询操作 queries，其中每个待查项都由两个整数 i 和 c 组成。
现在请你帮忙设计一个算法，查找从索引 i 到具有目标颜色 c 的元素之间的最短距离。
如果不存在解决方案，请返回 -1。
提示：
1 <= colors.length <= 5*10^4
1 <= colors[i] <= 3
1 <= queries.length <= 5*10^4
queries[i].length == 2
0 <= queries[i][0] < colors.length
1 <= queries[i][1] <= 3

二分查找
 */