import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionP2307 {
    private Map<String, List<Pair>> edges;
    private Map<String, Double> val;
    private boolean ans;

    public boolean checkContradictions(List<List<String>> equations, double[] values) {
        edges = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String x = equations.get(i).get(0), y = equations.get(i).get(1);
            edges.computeIfAbsent(x, e -> new ArrayList<>()).add(new Pair(y, values[i]));
            edges.computeIfAbsent(y, e -> new ArrayList<>()).add(new Pair(x, 1.0 / values[i]));
        }
        val = new HashMap<>();
        ans = false; // 初始默认没有矛盾
        for (List<String> eq : equations) {
            String x = eq.get(0);
            if (!val.containsKey(x)) { // 如果 x 还没有值，y 也一定没有，这时说明遇到了一个新的连通分量
                dfs(x, 1.0);
            }
        }
        return ans;
    }

    private void dfs(String node, double v) {
        if (ans) return; // 已经有矛盾就不浪费时间了
        if (val.containsKey(node)) {
            if (Math.abs(val.get(node) - v) > 1e-5) ans = true; // 题目明确说不超过 1e-5 视为相同值
            return; // 搜过的点，不管有没有矛盾，都应直接 return，否则程序就会死循环
        }
        val.put(node, v);
        for (Pair pair : edges.getOrDefault(node, new ArrayList<>())) {
            dfs(pair.nei, v / pair.rat);
        }
    }

    static class Pair {
        String nei;
        double rat;

        public Pair(String nei, double rat) {
            this.nei = nei;
            this.rat = rat;
        }
    }
}
/*
$2307. 检查方程中的矛盾之处
https://leetcode.cn/problems/check-for-contradictions-in-equations/description/

给你一个由字符串二维数组 equations 和实数数组  values ，其中 equations[i] = [Ai, Bi]，values[i] 表示 Ai / Bi = values[i].。
确定方程中是否存在矛盾。如果存在矛盾则返回 true，否则返回 false。
注意:
当检查两个数字是否相等时，检查它们的 绝对差值 是否小于 10^-5.
生成的测试用例没有针对精度的用例，即使用 double 就足以解决问题。
提示:
1 <= equations.length <= 100
equations[i].length == 2
1 <= Ai.length, Bi.length <= 5
Ai, Bi 由小写英文字母组成。
equations.length == values.length
0.0 < values[i] <= 10.0
values[i] 小数点后最多 2 位。

不考虑精度的O(n)纯DFS解法。
https://leetcode.cn/problems/check-for-contradictions-in-equations/solutions/1605187/jian-wu-xiang-tu-shen-du-you-xian-sou-su-9thq/
相似题目: 2117. 一个区间内所有数乘积的缩写
https://leetcode.cn/problems/abbreviating-the-product-of-a-range/
 */