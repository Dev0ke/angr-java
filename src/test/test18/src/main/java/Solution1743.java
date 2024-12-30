import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1743 {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] p : adjacentPairs) {
            g.computeIfAbsent(p[0], e -> new ArrayList<>()).add(p[1]);
            g.computeIfAbsent(p[1], e -> new ArrayList<>()).add(p[0]);
        }

        int n = g.size();
        int[] ans = new int[n];
        for (Map.Entry<Integer, List<Integer>> entry : g.entrySet()) {
            if (entry.getValue().size() == 1) {
                ans[0] = entry.getKey();
                ans[1] = entry.getValue().get(0);
                break;
            }
        }

        for (int i = 2; i < n; i++) {
            List<Integer> p = g.get(ans[i - 1]);
            ans[i] = (p.get(0) == ans[i - 2] ? p.get(1) : p.get(0));
        }
        return ans;
    }
}
/*
1743. 从相邻元素对还原数组
https://leetcode.cn/problems/restore-the-array-from-adjacent-pairs/description/

存在一个由 n 个不同元素组成的整数数组 nums ，但你已经记不清具体内容。好在你还记得 nums 中的每一对相邻元素。
给你一个二维整数数组 adjacentPairs ，大小为 n - 1 ，其中每个 adjacentPairs[i] = [ui, vi] 表示元素 ui 和 vi 在 nums 中相邻。
题目数据保证所有由元素 nums[i] 和 nums[i+1] 组成的相邻元素对都存在于 adjacentPairs 中，存在形式可能是 [nums[i], nums[i+1]] ，也可能是 [nums[i+1], nums[i]] 。这些相邻元素对可以 按任意顺序 出现。
返回 原始数组 nums 。如果存在多种解答，返回 其中任意一个 即可。
提示：
nums.length == n
adjacentPairs.length == n - 1
adjacentPairs[i].length == 2
2 <= n <= 10^5
-10^5 <= nums[i], ui, vi <= 10^5
题目数据保证存在一些以 adjacentPairs 作为元素对的数组 nums

拓扑排序。
由于度最大为 2，因此有非 BFS 的简易写法。
时间复杂度 O(n)
 */