import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution1203 {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        // Step1: 预处理
        // 为了避免算法认为 group[i] == -1 的这些项目都在同一组，因此给这些组一个不同于 0 ~ m-1 的编号。
        for (int i = 0; i < group.length; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }

        // Step2: 建图 group
        Map<Integer, List<Integer>> groupOutGraph = new HashMap<>();
        int[] groupInDegrees = new int[m];
        for (int i = 0; i < group.length; i++) {
            int to = group[i];
            for (int beforeItem : beforeItems.get(i)) {
                int from = group[beforeItem];
                if (from == to) {
                    continue;
                }
                groupOutGraph.computeIfAbsent(from, key -> new ArrayList<>()).add(to);
                groupInDegrees[to]++;
            }
        }
        // 建图 item
        Map<Integer, List<Integer>> itemOutGraph = new HashMap<>();
        int[] itemInDegrees = new int[n];
        for (int i = 0; i < n; i++) {
            int to = i;
            for (int beforeItem : beforeItems.get(i)) {
                int from = beforeItem;
                itemOutGraph.computeIfAbsent(from, key -> new ArrayList<>()).add(to);
                itemInDegrees[to]++;
            }
        }

        // Step3: 拓扑排序
        List<Integer> groupList = topologicalSort(groupOutGraph, groupInDegrees);
        if (groupList.size() != m) {
            return new int[]{};
        }
        List<Integer> itemList = topologicalSort(itemOutGraph, itemInDegrees);
        if (itemList.size() != n) {
            return new int[]{};
        }

        // Step4: 建立 group -> item 一对多关系
        Map<Integer, List<Integer>> group2Items = new HashMap<>();
        for (int item : itemList) {
            group2Items.computeIfAbsent(group[item], key -> new ArrayList<>()).add(item);
        }

        List<Integer> resList = new ArrayList<>();
        for (int groupKey : groupList) {
            resList.addAll(group2Items.getOrDefault(groupKey, new ArrayList<>()));
        }
        return resList.stream().mapToInt(i -> i).toArray();
    }

    private List<Integer> topologicalSort(Map<Integer, List<Integer>> outGraph, int[] inDegrees) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }
        List<Integer> resList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int cur = queue.remove();
            resList.add(cur);

            for (int next : outGraph.getOrDefault(cur, new ArrayList<>())) {
                inDegrees[next]--;
                if (inDegrees[next] == 0) {
                    queue.add(next);
                }
            }
        }
        return resList;
    }
}
/*
1203. 项目管理
https://leetcode.cn/problems/sort-items-by-groups-respecting-dependencies/

有 n 个项目，每个项目或者不属于任何小组，或者属于 m 个小组之一。group[i] 表示第 i 个项目所属的小组，
如果第 i 个项目不属于任何小组，则 group[i] 等于 -1。项目和小组都是从零开始编号的。可能存在小组不负责任何项目，即没有任何项目属于这个小组。
请你帮忙按要求安排这些项目的进度，并返回排序后的项目列表：
- 同一小组的项目，排序后在列表中彼此相邻。
- 项目之间存在一定的依赖关系，我们用一个列表 beforeItems 来表示，其中 beforeItems[i] 表示在进行第 i 个项目前（位于第 i 个项目左侧）应该完成的所有项目。
如果存在多个解决方案，只需要返回其中任意一个即可。如果没有合适的解决方案，就请返回一个 空列表 。
提示：
1 <= m <= n <= 3 * 10^4
group.length == beforeItems.length == n
-1 <= group[i] <= m - 1
0 <= beforeItems[i].length <= n - 1
0 <= beforeItems[i][j] <= n - 1
i != beforeItems[i][j]
beforeItems[i] 不含重复元素

两趟拓扑排序。
如果不考虑 “同一小组的项目，排序后在列表中彼此相邻” 约束条件，只需要简单拓扑排序即可。
加上约束条件，需要将 item 分组后，组内 item 也进行一趟拓扑排序。
参考: https://leetcode.cn/problems/sort-items-by-groups-respecting-dependencies/solution/1203-xiang-mu-guan-li-by-leetcode-t63b/
 */