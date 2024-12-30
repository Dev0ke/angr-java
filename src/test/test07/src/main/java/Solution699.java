import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution699 {
    // 21ms
    public List<Integer> fallingSquares(int[][] positions) {
        // 目前所有已经落稳的 方块堆叠的最高高度 。
        int highest = 0;
        List<Integer> resList = new ArrayList<>();
        // 线段树
        DynamicSegTreeUpd seg = new DynamicSegTreeUpd();
        for (int[] position : positions) {
            // 左闭右开
            int left = position[0];
            int right = position[0] + position[1] - 1;

            int newHeight = (int) (seg.getMax(left, right) + position[1]);
            highest = Math.max(highest, newHeight);
            seg.update(left, right, newHeight);
            resList.add(highest);
        }
        return resList;
    }

    private static class DynamicSegTreeUpd {
        static class Node {
            Node ls, rs;
            long max, lazy;
        }

        static final int N = Integer.MAX_VALUE;
        final Node root = new Node();

        void update(int ql, int qr, int val) {
            this.update(root, 0, N, ql, qr, val);
        }

        void update(Node p, int l, int r, int ql, int qr, int val) {
            if (ql <= l && r <= qr) {
                p.max = val;
                p.lazy = val;
                return;
            }
            int mid = l + (r - l) / 2;
            pushDown(p);
            if (ql <= mid) update(p.ls, l, mid, ql, qr, val);
            if (qr > mid) update(p.rs, mid + 1, r, ql, qr, val);
            pushUp(p);
        }

        long getMax(int ql, int qr) {
            return this.getMax(root, 0, N, ql, qr);
        }

        long getMax(Node p, int l, int r, int ql, int qr) {
            if (ql <= l && r <= qr) {
                return p.max;
            }
            pushDown(p);
            int mid = l + (r - l) / 2;
            long max = 0;
            if (ql <= mid) max = getMax(p.ls, l, mid, ql, qr);
            if (qr > mid) max = Math.max(max, getMax(p.rs, mid + 1, r, ql, qr));
            return max;
        }

        void pushDown(Node p) {
            if (p.ls == null) p.ls = new Node();
            if (p.rs == null) p.rs = new Node();
            if (p.lazy != 0) {
                p.ls.max = p.lazy;
                p.rs.max = p.lazy;
                p.ls.lazy = p.lazy;
                p.rs.lazy = p.lazy;
                p.lazy = 0;
            }
        }

        void pushUp(Node node) {
            node.max = Math.max(node.ls.max, node.rs.max);
        }
    }
}
/*
699. 掉落的方块
https://leetcode.cn/problems/falling-squares/

在无限长的数轴（即 x 轴）上，我们根据给定的顺序放置对应的正方形方块。
第 i 个掉落的方块（positions[i] = (left, side_length)）是正方形，其中 left 表示该方块最左边的点位置(positions[i][0])，side_length 表示该方块的边长(positions[i][1])。
每个方块的底部边缘平行于数轴（即 x 轴），并且从一个比目前所有的落地方块更高的高度掉落而下。在上一个方块结束掉落，并保持静止后，才开始掉落新方块。
方块的底边具有非常大的粘性，并将保持固定在它们所接触的任何长度表面上（无论是数轴还是其他方块）。邻接掉落的边不会过早地粘合在一起，因为只有底边才具有粘性。
返回一个堆叠高度列表 ans 。每一个堆叠高度 ans[i] 表示在通过 positions[0], positions[1], ..., positions[i] 表示的方块掉落结束后，目前所有已经落稳的方块堆叠的最高高度。
注意:
1 <= positions.length <= 1000.
1 <= positions[i][0] <= 10^8.
1 <= positions[i][1] <= 10^6.

离散化线段树，区间修改 + 区间查询最值。
需要实现带 懒惰标记 的线段树，从而确保在 区间修改 时复杂度仍为 O(log n)
相似题目: 218. 天际线问题
https://leetcode.cn/problems/the-skyline-problem/
 */