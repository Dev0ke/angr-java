import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Solution218 {
    static class V1 {
        // 28ms
        public List<List<Integer>> getSkyline(int[][] buildings) {
            // 按高度由低到高排序
            Arrays.sort(buildings, Comparator.comparingInt(o -> o[2]));

            DynamicSegTreeUpd seg = new DynamicSegTreeUpd();
            for (int[] building : buildings) {
                int left = building[0];
                int right = building[1] - 1;
                seg.update(left, right, building[2]);
            }

            // 将端点排序
            TreeSet<Integer> idxTreeSet = new TreeSet<>();
            for (int[] building : buildings) {
                idxTreeSet.add(building[0]);
                idxTreeSet.add(building[1]);
            }

            // 查询左端点最值
            List<List<Integer>> resList = new ArrayList<>();
            int pre = 0;
            while (!idxTreeSet.isEmpty()) {
                int idx = idxTreeSet.pollFirst();
                int height = (int) seg.getMax(idx, idx);
                if (height != pre) {
                    resList.add(List.of(idx, height));
                    pre = height;
                }
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

    static class V2 {
        // 15ms
        public List<List<Integer>> getSkyline(int[][] buildings) {
            Arrays.sort(buildings, Comparator.comparingInt(o -> o[2]));
            // 离散化
            int[] yArr = getDiscrete(buildings);

            int N = yArr.length;
            // 线段树
            SegmentTree seg = new SegmentTree(N);
            for (int[] building : buildings) {
                int left = getId(yArr, building[0]);
                // 左闭右开
                int right = getId(yArr, building[1]) - 1;
                seg.update(left, right, building[2]);
            }

            // 查询左端点最值
            List<List<Integer>> resList = new ArrayList<>();
            int pre = 0;
            for (int i = 1; i <= N; i++) {
                int height = (int) seg.getMax(i, i);
                if (height != pre) {
                    resList.add(List.of(yArr[i - 1], height));
                    pre = height;
                }
            }
            return resList;
        }

        private int[] getDiscrete(int[][] buildings) {
            Set<Integer> set = new HashSet<>();
            for (int[] x : buildings) {
                set.add(x[0]);
                set.add(x[1]);
            }
            int sz = set.size();
            int[] yArr = new int[sz];
            int id = 0;
            for (Integer x : set) {
                yArr[id++] = x;
            }
            Arrays.sort(yArr);
            return yArr;
        }

        private int getId(int[] yArr, int x) {
            return Arrays.binarySearch(yArr, x) + 1;
        }

        private static class SegmentTree {
            int n;
            long[] tree;
            long[] lazy;

            public SegmentTree(int n) {
                this.n = n;
                this.tree = new long[4 * n];
                this.lazy = new long[4 * n];
            }

            void update(int ql, int qr, int val) {
                update(1, 1, n, ql, qr, val);
            }

            void update(int p, int l, int r, int ql, int qr, int val) {
                if (ql <= l && r <= qr) {
                    tree[p] = val;
                    lazy[p] = val;
                    return;
                }
                pushDown(p);
                int mid = l + (r - l) / 2;
                if (ql <= mid) update(p << 1, l, mid, ql, qr, val);
                if (qr > mid) update(p << 1 | 1, mid + 1, r, ql, qr, val);
                pushUp(p);
            }

            long getMax(int ql, int qr) {
                return getMax(1, 1, n, ql, qr);
            }

            long getMax(int p, int l, int r, int ql, int qr) {
                if (ql <= l && r <= qr) {
                    return tree[p];
                }
                pushDown(p);
                int mid = l + (r - l) / 2;
                long max = 0;
                if (ql <= mid) max = Math.max(max, getMax(p << 1, l, mid, ql, qr));
                if (qr > mid) max = Math.max(max, getMax(p << 1 | 1, mid + 1, r, ql, qr));
                return max;
            }

            void pushDown(int p) {
                if (lazy[p] > 0) {
                    tree[p << 1] = lazy[p];
                    tree[p << 1 | 1] = lazy[p];
                    lazy[p << 1] = lazy[p];
                    lazy[p << 1 | 1] = lazy[p];
                    lazy[p] = 0;
                }
            }

            void pushUp(int p) {
                tree[p] = Math.max(tree[p << 1], tree[p << 1 | 1]);
            }
        }
    }
}
/*
218. 天际线问题
https://leetcode.cn/problems/the-skyline-problem/

城市的 天际线 是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。给你所有建筑物的位置和高度，请返回 由这些建筑物形成的 天际线 。
每个建筑物的几何信息由数组 buildings 表示，其中三元组 buildings[i] = [lefti, righti, heighti] 表示：
- lefti 是第 i 座建筑物左边缘的 x 坐标。
- righti 是第 i 座建筑物右边缘的 x 坐标。
- heighti 是第 i 座建筑物的高度。
你可以假设所有的建筑都是完美的长方形，在高度为 0 的绝对平坦的表面上。
天际线 应该表示为由 “关键点” 组成的列表，格式 [[x1,y1],[x2,y2],...] ，并按 x 坐标 进行 排序 。关键点是水平线段的左端点。
列表中最后一个点是最右侧建筑物的终点，y 坐标始终为 0 ，仅用于标记天际线的终点。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。
注意：输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答案；
三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]
提示：
1 <= buildings.length <= 10^4
0 <= lefti < righti <= 2^31 - 1
1 <= heighti <= 2^31 - 1
buildings 按 lefti 非递减排序

动态开点线段树 or 离散化 + 线段树
时间复杂度 O(nlogn)
相似题目: 699. 掉落的方块
https://leetcode.cn/problems/falling-squares/
 */