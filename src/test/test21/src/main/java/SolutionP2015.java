import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SolutionP2015 {
    public int[][] averageHeightOfBuildings(int[][] buildings) {
        TreeMap<Integer, Integer> diff = new TreeMap<>();
        Map<Integer, Integer> cnts = new HashMap<>();
        for (int[] p : buildings) {
            int st = p[0], end = p[1], hi = p[2];
            diff.merge(st, hi, Integer::sum);
            diff.merge(end, -hi, Integer::sum);
            cnts.merge(st, 1, Integer::sum);
            cnts.merge(end, -1, Integer::sum);
        }

        int sumD = 0, cnt = 0;
        int last = 0, last_p = 0;
        List<int[]> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : diff.entrySet()) {
            int k = entry.getKey();
            sumD += entry.getValue();
            if (last != 0) {
                if (!ans.isEmpty() && ans.get(ans.size() - 1)[1] == last_p && ans.get(ans.size() - 1)[2] == last / cnt) {
                    ans.get(ans.size() - 1)[1] = k;
                } else {
                    ans.add(new int[]{last_p, k, last / cnt});
                }
            }
            cnt += cnts.get(k);
            last = sumD;
            last_p = k;
        }
        return ans.toArray(int[][]::new);
    }
}
/*
$2015. 每段建筑物的平均高度
https://leetcode.cn/problems/average-height-of-buildings-in-each-segment/description/

一条完全笔直的街道由一条数字线表示。街道上有建筑物，由二维整数阵列 buildings 表示，其中 buildings[i] = [starti, endi, heighti]。这意味着在 半封闭的位置[starti，endi) 有一座高度为 heighti 的建筑。
你想用 最少 数量的非重叠 部分 来 描述 街道上建筑物的高度。街道可以用2D整数数组 street 来表示，其中 street[j] = [leftj, rightj, averagej] 描述了道路的 半封闭区域 [leftj, rightj) ，该段中建筑物的 平均 高度为 averagej 。
- 例如，如果 buildings = [[1,5,2],[3,10,4]] ， street = [[1,3,2],[3,5,3],[5,10,4]] 可以表示街道，因为：
  - 从 1 到 3 ，只有第一栋建筑的平均高度为 2 / 1 = 2 。
  - 从 3 到 5 ，第一和第二栋建筑的平均高度均为 （2+4） / 2 = 3 。
  - 从 5 到 10 ，只有第二栋建筑的平均高度为 4 / 1 = 4 。
给定 buildings ，返回如上所述的二维整数矩阵 street （ 不包括 街道上没有建筑物的任何区域）。您可以按 任何顺序 返回数组。
n 个元素的 平均值 是 n 个元素除以 n 的 总和 （整数除法）。
半闭合段 [a, b) 是点 a 和 b 之间的数字线的截面，包括 点 a ，不包括 点 b 。
提示:
1 <= buildings.length <= 10^5
buildings[i].length == 3
0 <= starti < endi <= 10^8
1 <= heighti <= 10^5

差分数组。
相似题目: $2021. 街上最亮的位置
https://leetcode.cn/problems/brightest-position-on-street/description/
 */