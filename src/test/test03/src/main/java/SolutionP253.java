import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SolutionP253 {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] begin = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            begin[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(begin);
        Arrays.sort(end);

        int cnt = 0;
        int max = 0;
        // 双指针
        int p1 = 0;
        int p2 = 0;
        while (p1 < n && p2 < n) {
            if (begin[p1] < end[p2]) {
                cnt++;
                p1++;
            } else {
                cnt--;
                p2++;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }

    // 待测
    public int minMeetingRooms2(int[][] intervals) {
        List<int[]> a = new ArrayList<>();
        for (int[] p : intervals) {
            a.add(new int[]{p[0], 1});
            a.add(new int[]{p[1], -1});
        }
        a.sort(Comparator.comparingInt(o -> o[0]));
        int ans = 0, cnt = 0;
        for (int[] p : a) {
            cnt += p[1];
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
/*
$253. 会议室 II
https://leetcode.cn/problems/meeting-rooms-ii/

给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，返回 所需会议室的最小数量 。
输入：intervals = [[0,30],[5,10],[15,20]]
输出：2
提示：
1 <= intervals.length <= 10^4
0 <= starti < endi <= 10^6

扫描线技巧。
时间复杂度 O(nlogn)
空间复杂度 O(n)
 */