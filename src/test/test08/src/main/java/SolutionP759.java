import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SolutionP759 {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<int[]> list = new ArrayList<>();

        for (List<Interval> intervals : schedule) {
            for (Interval interval : intervals) {
                list.add(new int[]{interval.start, 1});
                list.add(new int[]{interval.end, -1});
            }
        }

        list.sort(Comparator.comparingInt(o -> o[0]));

        int cur = 0;
        List<Interval> resList = new ArrayList<>();
        for (int i = 0; i + 1 < list.size(); i++) {
            cur += list.get(i)[1];
            if (cur == 0 && list.get(i)[0] < list.get(i + 1)[0]) {
                resList.add(new Interval(list.get(i)[0], list.get(i + 1)[0]));
            }
        }
        return resList;
    }

    static class Interval {
        public int start;
        public int end;

        public Interval() {
        }

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }
}
/*
$759. 员工空闲时间
https://leetcode.cn/problems/employee-free-time/

给定员工的 schedule 列表，表示每个员工的工作时间。
每个员工都有一个非重叠的时间段  Intervals 列表，这些时间段已经排好序。
返回表示 所有 员工的 共同，正数长度的空闲时间 的有限时间段的列表，同样需要排好序。
（尽管我们用 [x, y] 的形式表示 Intervals ，内部的对象是 Intervals 而不是列表或数组。
例如，schedule[0][0].start = 1, schedule[0][0].end = 2，并且 schedule[0][0][0] 是未定义的）
而且，答案中不包含 [5, 5] ，因为长度为 0。
注：
schedule 和 schedule[i] 为长度范围在 [1, 50]的列表。
0 <= schedule[i].start < schedule[i].end <= 10^8。
注：输入类型于 2019 年 4 月 15 日 改变。请重置为默认代码的定义以获取新方法。

扫描线
 */