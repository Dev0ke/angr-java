import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution2363 {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int[] ints : items1) {
            treeMap.put(ints[0], treeMap.getOrDefault(ints[0], 0) + ints[1]);
        }
        for (int[] ints : items2) {
            treeMap.put(ints[0], treeMap.getOrDefault(ints[0], 0) + ints[1]);
        }

        List<List<Integer>> resList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            resList.add(List.of(entry.getKey(), entry.getValue()));
        }
        return resList;
    }
}
/*
2363. 合并相似的物品
https://leetcode.cn/problems/merge-similar-items/

第 84 场双周赛 T1。

给你两个二维整数数组 items1 和 items2 ，表示两个物品集合。每个数组 items 有以下特质：
- items[i] = [valuei, weighti] 其中 valuei 表示第 i 件物品的 价值 ，weighti 表示第 i 件物品的 重量 。
- items 中每件物品的价值都是 唯一的 。
请你返回一个二维数组 ret，其中 ret[i] = [valuei, weighti]， weighti 是所有价值为 valuei 物品的 重量之和 。
注意：ret 应该按价值 升序 排序后返回。
提示：
1 <= items1.length, items2.length <= 1000
items1[i].length == items2[i].length == 2
1 <= valuei, weighti <= 1000
items1 中每个 valuei 都是 唯一的 。
items2 中每个 valuei 都是 唯一的 。

TreeMap 一次完成 合并 + 排序。
时间复杂度：O(mnlog(mn))
 */