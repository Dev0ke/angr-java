import java.util.ArrayList;
import java.util.List;

public class SolutionP1272 {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        int toL = toBeRemoved[0], toR = toBeRemoved[1];
        List<List<Integer>> resList = new ArrayList<>();
        for (int[] interval : intervals) {
            int x = interval[0], y = interval[1];
            if (x >= toR || y <= toL) {
                resList.add(List.of(x, y));
            } else {
                if (x < toL) {
                    resList.add(List.of(x, toL));
                }
                if (y > toR) {
                    resList.add(List.of(toR, y));
                }
            }
        }
        return resList;
    }
}
/*
$1272. 删除区间
https://leetcode.cn/problems/remove-interval/

实数集合可以表示为若干不相交区间的并集，其中每个区间的形式为 [a, b)（左闭右开），表示满足 a <= x < b 的所有实数  x 的集合。
如果某个区间 [a, b) 中包含实数 x ，则称实数 x 在集合中。
给你一个 有序的 不相交区间列表 intervals 。intervals 表示一个实数集合，其中每一项 intervals[i] = [ai, bi] 都表示一个区间 [ai, bi) 。再给你一个要删除的区间 toBeRemoved 。
返回 一组实数，该实数表示intervals 中 删除 了 toBeRemoved 的部分 。
换句话说，返回实数集合，并满足集合中的每个实数 x 都在 intervals 中，但不在 toBeRemoved 中。你的答案应该是一个如上所述的 有序的 不相连的间隔列表 。
提示：
1 <= intervals.length <= 10^4
-10^9 <= ai < bi <= 10^9

分类讨论
时间复杂度 O(n)
 */