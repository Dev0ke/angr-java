import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2830 {
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        // 右端点排序
        offers.sort(Comparator.comparingInt(o -> o.get(1)));

        // f[i] 表示以 i 为右端点的最大值
        int[] f = new int[n + 1];
        DynamicSegTreeUpd seg = new DynamicSegTreeUpd();
        for (List<Integer> offer : offers) {
            int l = offer.get(0) + 1, r = offer.get(1) + 1, gold = offer.get(2);
            long leftMax = seg.getMax(0, Math.max(0, l - 1));
            f[r] = (int) Math.max(f[r], leftMax + gold);
            seg.update(r, r, f[r]);
        }
        return Arrays.stream(f).max().orElseThrow();
    }

    private static class DynamicSegTreeUpd {
        private static final int N = Integer.MAX_VALUE;
        private final Node root = new Node();

        private static class Node {
            Node ls, rs;
            long sum, max, lazy;
        }

        // 区间 [l,r] 置为 val
        public void update(int l, int r, int val) {
            this.update(l, r, val, 0, N, root);
        }

        // 区间 [l,r] 最大值
        public long getMax(int l, int r) {
            return this.getMax(l, r, 0, N, root);
        }

        private void update(int l, int r, int val, int s, int t, Node node) {
            if (l <= s && t <= r) {
                node.sum = (t - s + 1L) * val;
                node.max = val;
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

        private long getMax(int l, int r, int s, int t, Node node) {
            if (l <= s && t <= r) {
                return node.max;
            }
            int mid = s + (t - s) / 2;
            pushDown(node, s, t, mid);
            long max = 0;
            if (l <= mid) {
                max = getMax(l, r, s, mid, node.ls);
            }
            if (r > mid) {
                max = Math.max(max, getMax(l, r, mid + 1, t, node.rs));
            }
            return max;
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
                node.ls.max = node.lazy;
                node.rs.max = node.lazy;
                node.ls.lazy = node.lazy;
                node.rs.lazy = node.lazy;
                node.lazy = 0;
            }
        }

        private void pushUp(Node node) {
            node.sum = node.ls.sum + node.rs.sum;
            node.max = Math.max(node.ls.max, node.rs.max);
        }
    }

    // 时间复杂度 O(n)
    public int maximizeTheProfit2(int n, List<List<Integer>> offers) {
        // 按右端点分组
        Map<Integer, List<int[]>> groups = new HashMap<>();
        for (List<Integer> offer : offers) {
            groups.computeIfAbsent(offer.get(1), key -> new ArrayList<>()).add(new int[]{offer.get(0), offer.get(2)});
        }

        // f[i+1] 表示销售编号不超过 i 的房屋的最大的盈利
        int[] f = new int[n + 1];
        for (int end = 0; end < n; end++) {
            f[end + 1] = f[end];
            for (int[] p : groups.getOrDefault(end, new ArrayList<>())) {
                f[end + 1] = Math.max(f[end + 1], f[p[0]] + p[1]);
            }
        }
        return f[n];
    }
}
/*
2830. 销售利润最大化
https://leetcode.cn/problems/maximize-the-profit-as-the-salesman/

第 359 场周赛 T3。

给你一个整数 n 表示数轴上的房屋数量，编号从 0 到 n - 1 。
另给你一个二维整数数组 offers ，其中 offers[i] = [starti, endi, goldi] 表示第 i 个买家想要以 goldi 枚金币的价格购买从 starti 到 endi 的所有房屋。
作为一名销售，你需要有策略地选择并销售房屋使自己的收入最大化。
返回你可以赚取的金币的最大数目。
注意 同一所房屋不能卖给不同的买家，并且允许保留一些房屋不进行出售。
提示：
1 <= n <= 10^5
1 <= offers.length <= 10^5
offers[i].length == 3
0 <= starti <= endi <= n - 1
1 <= goldi <= 10^3

动态规划。比赛时候写了 线段树 的 O(nlogn) 解法。记录一种 O(n) 的 DP 解法。
相似题目: 1235. 规划兼职工作
https://leetcode.cn/problems/maximum-profit-in-job-scheduling/
1751. 最多可以参加的会议数目 II
https://leetcode.cn/problems/maximum-number-of-events-that-can-be-attended-ii/
2008. 出租车的最大盈利
https://leetcode.cn/problems/maximum-earnings-from-taxi/
2054. 两个最好的不重叠活动
https://leetcode.cn/problems/two-best-non-overlapping-events/
 */