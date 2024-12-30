public class Solution731 {
    // 43ms
    static class MyCalendarTwo {
        private final DynamicSegTreeAdd seg;

        public MyCalendarTwo() {
            seg = new DynamicSegTreeAdd();
        }

        public boolean book(int start, int end) {
            int max = seg.getMax(start, end - 1);
            if (max >= 2) {
                return false;
            }
            seg.update(start, end - 1, 1);
            return true;
        }

        private static class DynamicSegTreeAdd {
            static class Node {
                Node ls, rs;
                int max, lazy;
            }

            static final int N = (int) 1e9;
            final Node root = new Node();

            void update(int ql, int qr, int val) {
                this.update(root, 0, N, ql, qr, val);
            }

            void update(Node p, int l, int r, int ql, int qr, int val) {
                if (ql <= l && r <= qr) {
                    p.max += val;
                    p.lazy += val;
                    return;
                }
                int mid = l + (r - l) / 2;
                pushDown(p);
                if (ql <= mid) update(p.ls, l, mid, ql, qr, val);
                if (qr > mid) update(p.rs, mid + 1, r, ql, qr, val);
                pushUp(p);
            }

            int getMax(int ql, int qr) {
                return this.getMax(root, 0, N, ql, qr);
            }

            int getMax(Node p, int l, int r, int ql, int qr) {
                if (ql <= l && r <= qr) {
                    return p.max;
                }
                pushDown(p);
                int mid = l + (r - l) / 2;
                int max = 0;
                if (ql <= mid) max = Math.max(max, getMax(p.ls, l, mid, ql, qr));
                if (qr > mid) max = Math.max(max, getMax(p.rs, mid + 1, r, ql, qr));
                return max;
            }

            void pushDown(Node p) {
                if (p.ls == null) p.ls = new Node();
                if (p.rs == null) p.rs = new Node();
                if (p.lazy != 0) {
                    p.ls.max += p.lazy;
                    p.rs.max += p.lazy;
                    p.ls.lazy += p.lazy;
                    p.rs.lazy += p.lazy;
                    p.lazy = 0;
                }
            }

            void pushUp(Node p) {
                p.max = Math.max(p.ls.max, p.rs.max);
            }
        }
    }
}
/*
731. 我的日程安排表 II
https://leetcode.cn/problems/my-calendar-ii/

实现一个 MyCalendar 类来存放你的日程安排。如果要添加的时间内不会导致三重预订时，则可以存储这个新的日程安排。
MyCalendar 有一个 book(int start, int end)方法。它意味着在 start 到 end 时间内增加一个日程安排，
注意，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，start <= x < end。
当三个日程安排有一些时间上的交叉时（例如三个日程安排都在同一时间内），就会产生三重预订。
每次调用 MyCalendar.book方法时，如果可以将日程安排成功添加到日历中而不会导致三重预订，返回 true。否则，返回 false 并且不要将该日程安排添加到日历中。
请按照以下步骤调用MyCalendar 类: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
提示：
每个测试用例，调用 MyCalendar.book 函数最多不超过 1000次。
调用函数 MyCalendar.book(start, end)时， start 和 end 的取值范围为 [0, 10^9]。

动态开点线段树
 */