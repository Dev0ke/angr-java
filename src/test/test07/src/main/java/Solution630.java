import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution630 {
    public int scheduleCourse(int[][] courses) {
        // 先按 lastDay 升序排序
        Arrays.sort(courses, Comparator.comparingInt(o -> o[1]));

        int curDuration = 0;
        // 优先队列 按 duration 降序排列
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[0], o1[0]));
        for (int[] course : courses) {
            // 排除 durationi > lastDayi 的
            if (course[0] > course[1]) {
                continue;
            }
            // 尝试加
            if (curDuration + course[0] <= course[1]) {
                curDuration += course[0];
                maxHeap.add(course);
            } else {
                if (!maxHeap.isEmpty()) {
                    int[] peek = maxHeap.peek();
                    // 贪心。
                    // 看当前的课程能否与已选 duration 最长的课程交换，注意当前的课程 duration 需小于已选 duration 最长的课程
                    // 不行就继续看下一门
                    if (curDuration + course[0] - peek[0] <= course[1] && course[0] < peek[0]) {
                        curDuration += course[0] - peek[0];
                        maxHeap.poll();
                        maxHeap.add(course);
                    }
                }
            }
        }
        return maxHeap.size();
    }
}
/*
630. 课程表 III
https://leetcode.cn/problems/course-schedule-iii/

这里有 n 门不同的在线课程，按从 1 到 n 编号。给你一个数组 courses ，其中 courses[i] = [durationi, lastDayi]
表示第 i 门课将会 持续 上 durationi 天课，并且必须在不晚于 lastDayi 的时候完成。
你的学期从第 1 天开始。且不能同时修读两门及两门以上的课程。
返回你最多可以修读的课程数目。
提示:
1 <= courses.length <= 10^4
1 <= durationi, lastDayi <= 10^4

贪心。
sorted [[9, 10], [3, 12], [7, 17], [4, 18], [10, 19], [10, 20], [5, 20]]
expected [3, 12], [7, 17], [4, 18], [5, 20]
不判断 course[0] < peek[0] 场景:
[9, 10]
[9+3, 12]
[7+3, 17]
[7+3+4, 18]
[10+3+4, 19]
[10+3+4, 20]
[3+4+5, 20] 即 [3, 12], [4, 18], [5, 20] wrong
 */