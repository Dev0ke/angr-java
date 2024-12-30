import java.util.PriorityQueue;

public class Solution1792 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // pass/total (pass+1)/(total+1)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> {
            // (a+1)/(b+1) - a/b > (c+1)/(d+1) - c/d
            // (b-a)/b(b+1) > (d-c)/d(d+1)
            // (b-a)d(d+1) > (d-c)b(b+1)
            long val1 = (long) (o1[1] - o1[0]) * o2[1] * (o2[1] + 1);
            long val2 = (long) (o2[1] - o2[0]) * o1[1] * (o1[1] + 1);
            return Long.compare(val2, val1);
        });
        for (int[] cla : classes) {
            maxHeap.add(new int[]{cla[0], cla[1]});
        }

        for (int i = 0; i < extraStudents; i++) {
            int[] poll = maxHeap.remove();
            maxHeap.add(new int[]{poll[0] + 1, poll[1] + 1});
        }

        double sum = 0.0;
        while (!maxHeap.isEmpty()) {
            int[] poll = maxHeap.remove();
            sum += (double) poll[0] / poll[1];
        }
        return sum / classes.length;
    }
}
/*
1792. 最大平均通过率
https://leetcode.cn/problems/maximum-average-pass-ratio/

一所学校里有一些班级，每个班级里有一些学生，现在每个班都会进行一场期末考试。
给你一个二维数组 classes ，其中 classes[i] = [passi, totali] ，表示你提前知道了第 i 个班级总共有 totali 个学生，其中只有 passi 个学生可以通过考试。
给你一个整数 extraStudents ，表示额外有 extraStudents 个聪明的学生，他们 一定 能通过任何班级的期末考。你需要给这 extraStudents 个学生每人都安排一个班级，使得 所有 班级的 平均 通过率 最大 。
一个班级的 通过率 等于这个班级通过考试的学生人数除以这个班级的总人数。平均通过率 是所有班级的通过率之和除以班级数目。
请你返回在安排这 extraStudents 个学生去对应班级后的 最大 平均通过率。与标准答案误差范围在 10-5 以内的结果都会视为正确结果。
提示：
1 <= classes.length <= 10^5
classes[i].length == 2
1 <= passi <= totali <= 10^5
1 <= extraStudents <= 10^5

贪心 + 大顶堆
聪明的学生 优先分配给 通过率提升最大的班级
通过率提升 = (a+1)/(b+1) - a/b
 */