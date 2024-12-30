public class Solution2286 {
    // 线段树
    static class BookMyShow {
        private final int n;
        private final int m;
        private final long[] tree;
        private final int[] min;

        public BookMyShow(int n, int m) {
            this.n = n;
            this.m = m;
            tree = new long[4 * n];
            min = new int[4 * n];
        }

        // 单点修改，给 idx 加上 inc
        // 函数入口: add(idx, inc, 1, n, 1)
        private void add(int idx, int inc, int s, int t, int p) {
            if (s == t) {
                tree[p] += inc;
                // 区间最值
                min[p] += inc;
                return;
            }
            int mid = s + (t - s) / 2;
            if (idx <= mid) {
                add(idx, inc, s, mid, p * 2);
            }
            if (idx > mid) {
                add(idx, inc, mid + 1, t, p * 2 + 1);
            }
            // 区间最值
            min[p] = Math.min(min[p * 2], min[p * 2 + 1]);
            tree[p] = tree[p * 2] + tree[p * 2 + 1];
        }

        // 区间查询，返回 [l,r] 区间内元素和
        // 函数入口: getSum(l, r, 1, n, 1)
        private long getSum(int l, int r, int s, int t, int p) {
            if (l <= s && t <= r) {
                return tree[p];
            }
            int mid = s + (t - s) / 2;
            long sum = 0L;
            if (l <= mid) {
                sum += getSum(l, r, s, mid, p * 2);
            }
            if (r > mid) {
                sum += getSum(l, r, mid + 1, t, p * 2 + 1);
            }
            return sum;
        }

        // 返回区间 [1,R] 中 <= val 的最靠左的位置，不存在时返回 0
        // 函数入口: index(R, val, 1, n, 1)
        private int index(int R, int val, int s, int t, int p) {
            if (min[p] > val) {
                // 说明整个区间的元素都大于 val
                return 0;
            }
            if (s == t) {
                return s;
            }
            int mid = s + (t - s) / 2;
            if (min[p * 2] <= val) {
                return index(R, val, s, mid, p * 2);
            }
            if (mid < R) {
                return index(R, val, mid + 1, t, p * 2 + 1);
            }
            return 0;
        }

        // 时间复杂度 O(log n)
        public int[] gather(int k, int maxRow) {
            int minRow = index(maxRow + 1, m - k, 1, n, 1);
            if (minRow == 0) {
                return new int[0];
            }
            int sum = (int) getSum(minRow, minRow, 1, n, 1);
            add(minRow, k, 1, n, 1);
            return new int[]{minRow - 1, sum};
        }

        // 整体时间复杂度 O((n+q) log n)
        public boolean scatter(int k, int maxRow) {
            if ((maxRow + 1L) * m - getSum(1, maxRow + 1, 1, n, 1) >= k) {
                int minRow = index(maxRow + 1, m - 1, 1, n, 1);
                while (minRow <= maxRow + 1) {
                    // 剩余座位
                    int remain = (int) (m - getSum(minRow, minRow, 1, n, 1));
                    if (k <= remain) {
                        add(minRow, k, 1, n, 1);
                        return true;
                    }
                    k -= remain;
                    add(minRow, remain, 1, n, 1);
                    minRow++;
                }
            }
            return false;
        }
    }

    // 树状数组
    static class BookMyShow2 {
        private final int m;
        private final BIT bit;
        private int minRow;

        public BookMyShow2(int n, int m) {
            this.m = m;
            this.bit = new BIT(n);
            this.minRow = 1;
        }

        // O(logn)
        public int[] gather(int k, int maxRow) {
            for (int i = minRow; i <= maxRow + 1; i++) {
                long cursor = bit.getsum(i, i);
                if (cursor + k <= m) {
                    int from = (int) cursor;
                    bit.add(i, k);
                    return new int[]{i - 1, from};
                }
            }
            return new int[0];
        }

        // O(nlogn)
        public boolean scatter(int k, int maxRow) {
            if ((maxRow + 1L) * m - bit.getsum(maxRow + 1) >= k) {
                for (int i = minRow; i <= maxRow + 1; i++) {
                    int maxAdd = (int) (m - bit.getsum(i, i));
                    int toAdd = Math.min(k, maxAdd);
                    bit.add(i, toAdd);
                    minRow = i;
                    k -= toAdd;
                    if (k == 0) {
                        break;
                    }
                }
                return true;
            }
            return false;
        }

        private static class BIT {
            private final int N;
            private final long[] tree;

            public BIT(int n) {
                this.N = n;
                this.tree = new long[N + 1];
            }

            public int lowbit(int x) {
                return x & (-x);
            }

            // nums[x] add k
            public void add(int x, int k) {
                while (x <= N) {
                    tree[x] += k;
                    x += lowbit(x);
                }
            }

            // nums [1,x] 的和
            public long getsum(int x) {
                long ans = 0;
                while (x >= 1) {
                    ans += tree[x];
                    x -= lowbit(x);
                }
                return ans;
            }

            // nums [l,r] 的和
            public long getsum(int l, int r) {
                return getsum(r) - getsum(l - 1);
            }
        }

    }
}
/*
2286. 以组为单位订音乐会的门票
https://leetcode.cn/problems/booking-concert-tickets-in-groups/

第 79 场双周赛 T4。

一个音乐会总共有 n 排座位，编号从 0 到 n - 1 ，每一排有 m 个座椅，编号为 0 到 m - 1 。你需要设计一个买票系统，针对以下情况进行座位安排：
- 同一组的 k 位观众坐在 同一排座位，且座位连续 。
- k 位观众中 每一位 都有座位坐，但他们 不一定 坐在一起。
由于观众非常挑剔，所以：
- 只有当一个组里所有成员座位的排数都 小于等于 maxRow ，这个组才能订座位。每一组的 maxRow 可能 不同 。
- 如果有多排座位可以选择，优先选择 最小 的排数。如果同一排中有多个座位可以坐，优先选择号码 最小 的。
请你实现 BookMyShow 类：
- BookMyShow(int n, int m) ，初始化对象，n 是排数，m 是每一排的座位数。
- int[] gather(int k, int maxRow) 返回长度为 2 的数组，表示 k 个成员中 第一个座位 的排数和座位编号，这 k 位成员必须坐在 同一排座位，且座位连续 。
换言之，返回最小可能的 r 和 c 满足第 r 排中 [c, c + k - 1] 的座位都是空的，且 r <= maxRow 。如果 无法 安排座位，返回 [] 。
- boolean scatter(int k, int maxRow) 如果组里所有 k 个成员 不一定 要坐在一起的前提下，都能在第 0 排到第 maxRow 排之间找到座位，那么请返回 true 。
这种情况下，每个成员都优先找排数 最小 ，然后是座位编号最小的座位。如果不能安排所有 k 个成员的座位，请返回 false 。
提示：
1 <= n <= 5 * 10^4
1 <= m, k <= 10^9
0 <= maxRow <= n - 1
gather 和 scatter 总 调用次数不超过 5 * 10^4 次。

线段树二分。
本题需要用到 单点修改 和 区间查询，乍一看好像树状数组也可以，实际上还需要用到 二分 找最小满足的行，因此需要用到线段树。
本题数据会爆int
 */