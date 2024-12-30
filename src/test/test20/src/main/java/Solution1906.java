import java.util.Arrays;
import java.util.Comparator;

public class Solution1906 {
    public int[] minDifference(int[] nums, int[][] queries) {
        int n = nums.length;
        int[][] sum = new int[n + 1][101];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i].clone();
            sum[i + 1][nums[i]]++;
        }
        int q = queries.length;
        int[] ans = new int[q];
        label:
        for (int i = 0; i < q; i++) {
            int[] p = queries[i];
            int l = p[0], r = p[1] + 1, d = (int) 1e9, pre = (int) -1e9;
            for (int v = 1; v <= 100; v++) {
                int cnt = sum[r][v] - sum[l][v]; // v 的个数
                if (cnt == r - l) { // 所有元素相同
                    ans[i] = -1;
                    continue label;
                }
                if (cnt > 0) { // 子数组包含元素 v
                    d = Math.min(d, v - pre);
                    pre = v;
                }
            }
            ans[i] = d;
        }
        return ans;
    }

    // 灵茶山艾府：这做法我之前试过，力扣上计算时间限制是所有数据之和，本题数据多，这做法会超时。
    static class V2 {

        static final int inf = 200;

        // CF765F
        // https://codeforces.com/contest/765/submission/120279828
        public int[] minDifference(int[] nums, int[][] queries) {
            int n = nums.length;
            int q = queries.length;

            int[][] qs = new int[q][3];
            for (int i = 0; i < q; i++) {
                qs[i] = new int[]{queries[i][0] + 1, queries[i][1] + 1, i};
            }
            Arrays.sort(qs, Comparator.comparingInt(o -> o[1]));

            int[] ans = new int[q];

            this.a = nums;
            this.n = a.length;
            t = new Node[4 * n];
            build(a, 1, 1, n);
            int qi = 0;
            for (int r = 2; r <= n; r++) {
                allMin = inf;
                update(1, r - 1, nums[r - 1]);
                for (; qi < q && qs[qi][1] == r; qi++) {
                    ans[qs[qi][2]] = query(1, qs[qi][0]);
                }
            }
            for (int i = 0; i < q; i++) {
                if (ans[i] == inf) ans[i] = -1;
            }
            return ans;
        }

        int allMin;

        static class Node {
            int l, r, min;
            int[] a;

            public Node(int l, int r, int min) {
                this.l = l;
                this.r = r;
                this.min = min;
            }
        }

        int[] a;
        int n;
        Node[] t;

        void build(int[] a, int o, int l, int r) {
            t[o] = new Node(l, r, inf);
            t[o].a = Arrays.copyOfRange(a, l - 1, r);
            Arrays.sort(t[o].a);
            if (l == r) return;
            int m = l + (r - l) / 2;
            build(a, o << 1, l, m);
            build(a, o << 1 | 1, m + 1, r);
        }

        void update(int o, int i, int val) {
            if (t[o].l == t[o].r) {
                if (val == t[o].a[0] && val == t[o].a[t[o].a.length - 1]) return; // 注意答案不为 0 ，因为 a[i] 和 a[j] 必须不相等。
                t[o].min = Math.min(t[o].min, Math.abs(val - t[o].a[0]));
                allMin = Math.min(allMin, t[o].min);
                return;
            }
            if (t[o].r <= i) {
                int[] a = t[o].a;
                int p = searchInts(a, val);
                if ((p == 0 || val - a[p - 1] >= allMin) && (p == a.length || a[p] - val >= allMin)) {
                    allMin = Math.min(allMin, t[o].min);
                    return;
                }
            }
            int m = t[o].l + (t[o].r - t[o].l) / 2;
            if (i > m) {
                update(o << 1 | 1, i, val);
            }
            update(o << 1, i, val);
            t[o].min = Math.min(t[o << 1].min, t[o << 1 | 1].min);
        }

        int searchInts(int[] a, int key) {
            int l = 0, r = a.length;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (a[m] >= key) r = m;
                else l = m + 1;
            }
            return l;
        }

        int query(int o, int l) {
            if (l <= t[o].l) {
                return t[o].min;
            }
            int m = t[o].l + (t[o].r - t[o].l) / 2;
            if (m < l) {
                return query(o << 1 | 1, l);
            }
            return Math.min(query(o << 1, l), t[o << 1 | 1].min);
        }
    }
}
/*
1906. 查询差绝对值的最小值
https://leetcode.cn/problems/minimum-absolute-difference-queries/description/

一个数组 a 的 差绝对值的最小值 定义为：0 <= i < j < a.length 且 a[i] != a[j] 的 |a[i] - a[j]| 的 最小值。如果 a 中所有元素都 相同 ，那么差绝对值的最小值为 -1 。
- 比方说，数组 [5,2,3,7,2] 差绝对值的最小值是 |2 - 3| = 1 。注意答案不为 0 ，因为 a[i] 和 a[j] 必须不相等。
给你一个整数数组 nums 和查询数组 queries ，其中 queries[i] = [li, ri] 。对于每个查询 i ，计算 子数组 nums[li...ri] 中 差绝对值的最小值 ，子数组 nums[li...ri] 包含 nums 数组（下标从 0 开始）中下标在 li 和 ri 之间的所有元素（包含 li 和 ri 在内）。
请你返回 ans 数组，其中 ans[i] 是第 i 个查询的答案。
子数组 是一个数组中连续的一段元素。
|x| 的值定义为：
- 如果 x >= 0 ，那么值为 x 。
- 如果 x < 0 ，那么值为 -x 。
提示：
2 <= nums.length <= 10^5
1 <= nums[i] <= 100
1 <= queries.length <= 2 * 10^4
0 <= li < ri < nums.length

个数前缀和。
时间复杂度 O((n+q)*100)
https://leetcode.cn/problems/minimum-absolute-difference-queries/solutions/836317/er-fen-wei-zhi-by-endlesscheng-zxky
 */