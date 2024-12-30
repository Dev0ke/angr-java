public class SolutionP2158 {
    public int[] amountPainted(int[][] paint) {
        int len = paint.length;

        DynamicSegTreeUpd dynamicSegTreeUpd = new DynamicSegTreeUpd();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            // 左闭右开
            int l = paint[i][0];
            int r = paint[i][1] - 1;
            res[i] = (r - l + 1) - (int) dynamicSegTreeUpd.getSum(l, r);
            dynamicSegTreeUpd.update(l, r, 1);
        }
        return res;
    }

    private static class DynamicSegTreeUpd {
        private static final int N = Integer.MAX_VALUE;
        private final Node root = new Node();

        private static class Node {
            Node ls, rs;
            long sum, lazy;
        }

        // 区间 [l,r] 置为 val
        public void update(int l, int r, int val) {
            this.update(l, r, val, 0, N, root);
        }

        // 区间 [l,r] 求和
        public long getSum(int l, int r) {
            return this.getSum(l, r, 0, N, root);
        }

        private void update(int l, int r, int val, int s, int t, Node node) {
            if (l <= s && t <= r) {
                node.sum = (t - s + 1L) * val;
                node.lazy = val;
                return;
            }
            int mid = s + (t - s) / 2;
            pushDown(node, s, t, mid);
            if (l <= mid) {
                update(l, r, val, s, mid, node.ls);
            }
            if (r > mid) {
                update(l, r, val, mid + 1, t, node.rs);
            }
            pushUp(node);
        }

        private long getSum(int l, int r, int s, int t, Node node) {
            if (l <= s && t <= r) {
                return node.sum;
            }
            int mid = s + (t - s) / 2;
            pushDown(node, s, t, mid);
            long sum = 0;
            if (l <= mid) {
                sum = getSum(l, r, s, mid, node.ls);
            }
            if (r > mid) {
                sum += getSum(l, r, mid + 1, t, node.rs);
            }
            return sum;
        }

        private void pushDown(Node node, int s, int t, int mid) {
            if (node.ls == null) {
                node.ls = new Node();
            }
            if (node.rs == null) {
                node.rs = new Node();
            }
            if (node.lazy > 0) {
                node.ls.sum = node.lazy * (mid - s + 1L);
                node.rs.sum = node.lazy * (t - mid);
                node.ls.lazy = node.lazy;
                node.rs.lazy = node.lazy;
                node.lazy = 0;
            }
        }

        private void pushUp(Node node) {
            node.sum = node.ls.sum + node.rs.sum;
        }
    }
}
/*
$2158. 每天绘制新区域的数量
https://leetcode.cn/problems/amount-of-new-area-painted-each-day/

有一幅细长的画，可以用数轴来表示。 给你一个长度为 n 、下标从 0 开始的二维整数数组 paint ，其中 paint[i] = [starti, endi] 表示在第 i 天你需要绘制 starti 和 endi 之间的区域。
多次绘制同一区域会导致不均匀，因此每个区域最多只能绘制 一次 。
返回一个长度为 n 的整数数组 worklog，其中 worklog[i] 是你在第 i 天绘制的 新 区域的数量。
提示：
1 <= paint.length <= 10^5
paint[i].length == 2
0 <= starti < endi <= 5 * 10^4

线段树
区间并查集 https://leetcode.cn/problems/amount-of-new-area-painted-each-day/solution/qu-jian-bing-cha-ji-by-981377660lmt-p1zl/
 */
