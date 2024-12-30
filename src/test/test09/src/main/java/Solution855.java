import java.util.TreeSet;

public class Solution855 {
    static class ExamRoom {
        private final int n;
        // 被学生坐了的位置
        private final TreeSet<Integer> treeSet;

        public ExamRoom(int n) {
            this.n = n;
            treeSet = new TreeSet<>();
        }

        public int seat() {
            // 学生将要坐的位置
            int idx = 0;
            if (treeSet.size() > 0) {
                // 假设坐在最左侧
                int dist = treeSet.first();
                Integer pre = null;
                for (Integer i : treeSet) {
                    if (pre != null) {
                        // 坐在两个人中间
                        int d = (i - pre) / 2;
                        if (d > dist) {
                            dist = d;
                            idx = pre + d;
                        }
                    }
                    pre = i;
                }
                // 坐最右侧的情况
                if (n - 1 - treeSet.last() > dist) {
                    idx = n - 1;
                }
            }
            treeSet.add(idx);
            return idx;
        }

        public void leave(int p) {
            treeSet.remove(p);
        }
    }
}
/*
855. 考场就座
https://leetcode.cn/problems/exam-room/

在考场里，一排有 N 个座位，分别编号为 0, 1, 2, ..., N-1 。
当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。
如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，那么学生就坐在 0 号座位上。)
返回 ExamRoom(int N) 类，它有两个公开的函数：其中，函数 ExamRoom.seat() 会返回一个 int （整型数据），代表学生坐的位置；
函数 ExamRoom.leave(int p) 代表坐在座位 p 上的学生现在离开了考场。每次调用 ExamRoom.leave(p) 时都保证有学生坐在座位 p 上。
提示：
1 <= N <= 10^9
在所有的测试样例中 ExamRoom.seat() 和 ExamRoom.leave() 最多被调用 10^4 次。
保证在调用 ExamRoom.leave(p) 时有学生正坐在座位 p 上。

有序集合 TreeSet
 */