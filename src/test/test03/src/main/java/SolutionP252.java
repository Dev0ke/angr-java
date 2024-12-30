import java.util.Arrays;
import java.util.Comparator;

public class SolutionP252 {
    public boolean canAttendMeetings(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        for (int i = 1; i < n; i++) {
            if (intervals[i - 1][1] > intervals[i][0]) {
                return false;
            }
        }
        return true;
    }
}
/*
$252. 会议室
https://leetcode.cn/problems/meeting-rooms/

给定一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，
请你判断一个人是否能够参加这里面的全部会议。
提示：
0 <= intervals.length <= 10^4
intervals[i].length == 2
0 <= starti < endi <= 10^6

扫描线？
时间复杂度 O(nlogn)
 */