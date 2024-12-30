import java.util.Arrays;

public class Solution1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        // 左端点升序，右端点降序
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) return Integer.compare(o2[1], o1[1]);
            return Integer.compare(o1[0], o2[0]);
        });
        int ans = n;
        int rmax = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][1] <= rmax) {
                ans--;
            } else {
                rmax = intervals[i][1];
            }
        }
        return ans;
    }
}
/*
1288. 删除被覆盖区间
https://leetcode.cn/problems/remove-covered-intervals/description/

给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。
在完成所有删除操作后，请你返回列表中剩余区间的数目。
提示：
1 <= intervals.length <= 1000
0 <= intervals[i][0] < intervals[i][1] <= 10^5
对于所有的 i != j：intervals[i] != intervals[j]

一般区间题目是按右端点升序排序，不过这一题的覆盖判定比较特殊，需要完全覆盖，因此按左端点升序排序较好
否则需要用到左端点二分
时间复杂度 O(nlogn)
 */