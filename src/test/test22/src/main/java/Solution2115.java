import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution2115 {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> g = new HashMap<>();
        Map<String, Integer> inDeg = new HashMap<>();
        int n = recipes.length;
        for (int i = 0; i < n; i++) {
            List<String> xList = ingredients.get(i);
            String y = recipes[i];
            for (String x : xList) {
                g.computeIfAbsent(x, e -> new ArrayList<>()).add(y);
            }
            inDeg.put(y, inDeg.getOrDefault(y, 0) + xList.size());
        }

        // 拓扑排序
        Queue<String> q = new ArrayDeque<>(List.of(supplies));
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String x = q.remove();
                for (String y : g.getOrDefault(x, new ArrayList<>())) {
                    inDeg.put(y, inDeg.get(y) - 1);
                    if (inDeg.get(y) == 0) {
                        q.add(y);
                    }
                }
            }
        }
        // 入度为 0 的菜才能做出来
        List<String> ans = new ArrayList<>();
        for (String v : recipes) {
            if (inDeg.get(v) == 0) {
                ans.add(v);
            }
        }
        return ans;
    }
}
/*
2115. 从给定原材料中找到所有可以做出的菜
https://leetcode.cn/problems/find-all-possible-recipes-from-given-supplies/

第 68 场双周赛 T2。

你有 n 道不同菜的信息。给你一个字符串数组 recipes 和一个二维字符串数组 ingredients 。第 i 道菜的名字为 recipes[i] ，
如果你有它 所有 的原材料 ingredients[i] ，那么你可以 做出 这道菜。一道菜的原材料可能是 另一道 菜，也就是说 ingredients[i] 可能包含 recipes 中另一个字符串。
同时给你一个字符串数组 supplies ，它包含你初始时拥有的所有原材料，每一种原材料你都有无限多。
请你返回你可以做出的所有菜。你可以以 任意顺序 返回它们。
注意两道菜在它们的原材料中可能互相包含。

拓扑排序。入度为 0 的菜才能做出来。
时间复杂度 O(dn + m)。其中 m = supplies.length, d = max(recipe[i].length)
空间复杂度 O(dn + m)。
 */