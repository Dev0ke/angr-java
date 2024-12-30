import java.util.Arrays;
import java.util.Comparator;

public class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

        int cnt = 1;
        int preR = intervals[0][1];
        for (int i = 1; i < n; i++) {
            int l = intervals[i][0], r = intervals[i][1];
            if (l >= preR) {
                cnt++;
                preR = r;
            }
        }
        return n - cnt;
    }
}
/*
435. 无重叠区间
https://leetcode.cn/problems/non-overlapping-intervals/

给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
提示:
1 <= intervals.length <= 10^5
intervals[i].length == 2
-5 * 10^4 <= starti < endi <= 5 * 10^4

贪心。按右区间升序排序，找到最小的右区间即为 第 1 个区间，余下来的区间，只要满足左区间大于当前右区间，则更新右区间。
时间复杂度 O(nlogn)
相似题目: 646. 最长数对链
https://leetcode.cn/problems/maximum-length-of-pair-chain/
 */