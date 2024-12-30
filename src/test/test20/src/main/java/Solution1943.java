import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1943 {
    public List<List<Long>> splitPainting(int[][] segments) {
        // 差分 计算每个位置对应的颜色和改变量并用哈希表存储
        Map<Integer, Long> colorMap = new HashMap<>();
        for (int[] segment : segments) {
            int left = segment[0];
            int right = segment[1];
            int color = segment[2];
            colorMap.put(left, colorMap.getOrDefault(left, 0L) + color);
            colorMap.put(right, colorMap.getOrDefault(right, 0L) - color);
        }

        // 将哈希表转化为数组并按数轴坐标升序排序
        List<long[]> axis = new ArrayList<>();
        for (Map.Entry<Integer, Long> entry : colorMap.entrySet()) {
            axis.add(new long[]{entry.getKey(), entry.getValue()});
        }
        axis.sort(Comparator.comparingLong(o -> o[0]));

        // 对数组求前缀和计算对应颜色和
        int len = axis.size();
        for (int i = 1; i < len; ++i) {
            axis.get(i)[1] += axis.get(i - 1)[1];
        }

        // 遍历数组生成最终绘画结果
        List<List<Long>> res = new ArrayList<>();
        for (int i = 0; i < len - 1; ++i) {
            if (axis.get(i)[1] > 0) {
                res.add(List.of(axis.get(i)[0], axis.get(i + 1)[0], axis.get(i)[1]));
            }
        }
        return res;
    }
}
/*
1943. 描述绘画结果
https://leetcode.cn/problems/describe-the-painting/

第 57 场双周赛 T3。

给你一个细长的画，用数轴表示。这幅画由若干有重叠的线段表示，每个线段有 独一无二 的颜色。
给你二维整数数组 segments ，其中 segments[i] = [starti, endi, colori] 表示线段为 半开区间 [starti, endi) 且颜色为 colori 。
线段间重叠部分的颜色会被 混合 。如果有两种或者更多颜色混合时，它们会形成一种新的颜色，用一个 集合 表示这个混合颜色。
- 比方说，如果颜色 2 ，4 和 6 被混合，那么结果颜色为 {2,4,6} 。
为了简化题目，你不需要输出整个集合，只需要用集合中所有元素的 和 来表示颜色集合。
你想要用 最少数目 不重叠 半开区间 来 表示 这幅混合颜色的画。这些线段可以用二维数组 painting 表示，
其中 painting[j] = [leftj, rightj, mixj] 表示一个 半开区间[leftj, rightj) 的颜色 和 为 mixj 。
- 比方说，这幅画由 segments = [[1,4,5],[1,7,7]] 组成，那么它可以表示为 painting = [[1,4,12],[4,7,7]] ，因为：
  - [1,4) 由颜色 {5,7} 组成（和为 12），分别来自第一个线段和第二个线段。
  - [4,7) 由颜色 {7} 组成，来自第二个线段。
请你返回二维数组 painting ，它表示最终绘画的结果（没有 被涂色的部分不出现在结果中）。你可以按 任意顺序 返回最终数组的结果。
半开区间 [a, b) 是数轴上点 a 和点 b 之间的部分，包含 点 a 且 不包含 点 b 。
提示：
1 <= segments.length <= 2 * 10^4
segments[i].length == 3
1 <= starti < endi <= 10^5
1 <= colori <= 10^9
每种颜色 colori 互不相同。

注意 每种颜色 colori 互不相同。避免了诸如 5+7 和 7+5 合并的尴尬局面。
官方题解。差分 + 前缀和
时间复杂度 O(nlogn)
空间复杂度 O(n)
 */