import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution3169 {
    public int countDays(int days, int[][] meetings) {
        DynamicSegTreeUpd_sum seg = new DynamicSegTreeUpd_sum();
        for (int[] p : meetings) {
            int st = p[0], end = p[1];
            seg.update(st, end, 1);
        }
        return (int) (days - seg.getSum(1, days));
    }

    static class DynamicSegTreeUpd_sum {
        static final int N = Integer.MAX_VALUE;
        final Node root = new Node();

        private static class Node {
            Node ls, rs;
            long sum, lazy;
        }

        void update(int ql, int qr, int val) {
            this.update(root, 0, N, ql, qr, val);
        }

        void update(Node p, int l, int r, int ql, int qr, int val) {
            if (ql <= l && r <= qr) {
                p.sum = (r - l + 1L) * val;
                p.lazy = val;
                return;
            }
            pushDown(p, l, r);
            int mid = l + (r - l) / 2;
            if (ql <= mid) update(p.ls, l, mid, ql, qr, val);
            if (qr > mid) update(p.rs, mid + 1, r, ql, qr, val);
            pushUp(p);
        }

        long getSum(int ql, int qr) {
            return this.getSum(root, 0, N, ql, qr);
        }

        long getSum(Node p, int l, int r, int ql, int qr) {
            if (ql <= l && r <= qr) {
                return p.sum;
            }
            pushDown(p, l, r);
            int mid = l + (r - l) / 2;
            long sum = 0;
            if (ql <= mid) sum = getSum(p.ls, l, mid, ql, qr);
            if (qr > mid) sum += getSum(p.rs, mid + 1, r, ql, qr);
            return sum;
        }

        void pushDown(Node p, int l, int r) {
            if (p.ls == null) p.ls = new Node();
            if (p.rs == null) p.rs = new Node();
            if (p.lazy != 0) {
                int mid = l + (r - l) / 2;
                p.ls.sum = p.lazy * (mid - l + 1L);
                p.rs.sum = p.lazy * (r - mid);
                p.ls.lazy = p.lazy;
                p.rs.lazy = p.lazy;
                p.lazy = 0;
            }
        }

        void pushUp(Node p) {
            p.sum = p.ls.sum + p.rs.sum;
        }
    }

    public int countDays2(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(o -> o[0]));
        List<int[]> st = new ArrayList<>();
        for (int[] p : meetings) {
            int l = p[0], r = p[1];
            if (!st.isEmpty() && l <= st.get(st.size() - 1)[1]) {
                st.get(st.size() - 1)[1] = Math.max(st.get(st.size() - 1)[1], r);
            } else {
                st.add(new int[]{l, r});
            }
        }
        int ans = days;
        for (int[] p : st) {
            ans -= p[1] - p[0] + 1;
        }
        return ans;
    }
}
/*
3169. 无需开会的工作日
https://leetcode.cn/problems/count-days-without-meetings/description/

第 400 场周赛 T2。

给你一个正整数 days，表示员工可工作的总天数（从第 1 天开始）。另给你一个二维数组 meetings，长度为 n，其中 meetings[i] = [start_i, end_i] 表示第 i 次会议的开始和结束天数（包含首尾）。
返回员工可工作且没有安排会议的天数。
注意：会议时间可能会有重叠。
提示：
1 <= days <= 10^9
1 <= meetings.length <= 10^5
meetings[i].length == 2
1 <= meetings[i][0] <= meetings[i][1] <= days

合并区间后，再统计即可。
赛时想用差分解决，但并不顺利，用动态开点线段树水过。。
时间复杂度 O(nlogn)。
 */