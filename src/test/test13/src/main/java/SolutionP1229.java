import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SolutionP1229 {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        int len1 = slots1.length;
        int len2 = slots2.length;
        Arrays.sort(slots1, Comparator.comparingInt(o -> o[1]));
        Arrays.sort(slots2, Comparator.comparingInt(o -> o[1]));

        // 双指针
        int p1 = 0;
        int p2 = 0;
        while (p1 < len1 && p2 < len2) {
            int end1 = slots1[p1][1];
            int end2 = slots2[p2][1];
            int start = Math.max(slots1[p1][0], slots2[p2][0]);
            if (end1 > end2) {
                if (end2 - start >= duration) {
                    return List.of(start, start + duration);
                }
                p2++;
            } else {
                if (end1 - start >= duration) {
                    return List.of(start, start + duration);
                }
                p1++;
            }
        }
        return new ArrayList<>();
    }
}
/*
$1229. 安排会议日程
https://leetcode.cn/problems/meeting-scheduler/

给定两个人的空闲时间表：slots1 和 slots2，以及会议的预计持续时间 duration，请你为他们安排 时间段最早 且合适的会议时间。
如果没有满足要求的会议时间，就请返回一个 空数组。
「空闲时间」的格式是 [start, end]，由开始时间 start 和结束时间 end 组成，表示从 start 开始，到 end 结束。
题目保证数据有效：同一个人的空闲时间不会出现交叠的情况，也就是说，对于同一个人的两个空闲时间 [start1, end1] 和 [start2, end2]，要么 start1 > end2，要么 start2 > end1。
提示：
1 <= slots1.length, slots2.length <= 10^4
slots1[i].length, slots2[i].length == 2
slots1[i][0] < slots1[i][1]
slots2[i][0] < slots2[i][1]
0 <= slots1[i][j], slots2[i][j] <= 10^9
1 <= duration <= 10^6

排序 + 双指针
时间复杂度 O(nlogn)
 */