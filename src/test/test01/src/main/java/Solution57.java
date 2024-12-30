import java.util.ArrayList;
import java.util.List;

public class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];

        List<int[]> resList = new ArrayList<>();
        boolean placed = false;
        for (int[] interval : intervals) {
            if (right < interval[0]) {
                // 置于所有区间的左侧
                if (!placed) {
                    placed = true;
                    resList.add(new int[]{left, right});
                }
                resList.add(interval);
            } else if (interval[1] < left) {
                // 置于所有区间的右侧
                resList.add(interval);
            } else {
                // 存在交集，取并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            resList.add(new int[]{left, right});
        }

        // List<int[]> => int[][]
        return resList.toArray(int[][]::new);
    }
}
/*
57. 插入区间
https://leetcode.cn/problems/insert-interval/

给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
提示：
0 <= intervals.length <= 10^4
intervals[i].length == 2
0 <= intervals[i][0] <= intervals[i][1] <= 10^5
intervals 根据 intervals[i][0] 按 升序 排列
newInterval.length == 2
0 <= newInterval[0] <= newInterval[1] <= 10^5

区间取并集。
时间复杂度 O(n)
 */