public class Solution2528 {
    private int r, k, n;

    public long maxPower(int[] stations, int r, int k) {
        this.r = r;
        this.k = k;
        this.n = stations.length;

        // 前缀和
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + stations[i];
        }

        // 初始电量
        long[] init = new long[n];
        for (int i = 0; i < n; i++) {
            int l1 = Math.max(0, i - r);
            int r1 = Math.min(n - 1, i + r);
            init[i] = preSum[r1 + 1] - preSum[l1];
        }

        long left = 1;
        long right = (long) 2e10;
        while (left < right) {
            long mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!checkMid(init, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    // 最小供电站数目的最大值能否达到 mid
    private boolean checkMid(long[] init, long mid) {
        long[] diff = new long[n];
        long sumD = 0;
        long need = 0;
        for (int i = 0; i < n; i++) {
            sumD += diff[i];
            long delta = mid - init[i] - sumD;
            if (delta > 0) {
                need += delta;
                if (need > k) {
                    return false;
                }
                sumD += delta;
                if (i + r + r + 1 < n) {
                    diff[i + r + r + 1] -= delta;
                }
            }
        }
        return true;
    }

    // TLE
    public long maxPower2(int[] stations, int r, int k) {
        n = stations.length;

        SegmentTreeAdd dynamicSegTreeAdd = new SegmentTreeAdd(n);
        for (int i = 0; i < n; i++) {
            int l1 = Math.max(0, i - r) + 1;
            int r1 = Math.min(n - 1, i + r) + 1;
            dynamicSegTreeAdd.add(l1, r1, stations[i]);
        }
        long min = dynamicSegTreeAdd.getMin(1, n);

        // logk
        long left = min + 1;
        long right = left + k + 1;
        while (left < right) {
            long mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!checkMid(stations, r, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    // nlogn
    // 最小供电站数目的最大值能否达到 mid
    private boolean checkMid(int[] stations, int r, int k, long mid) {
        SegmentTreeAdd dynamicSegTreeAdd = new SegmentTreeAdd(n);
        for (int i = 0; i < n; i++) {
            int l1 = Math.max(0, i - r) + 1;
            int r1 = Math.min(n - 1, i + r) + 1;
            dynamicSegTreeAdd.add(l1, r1, stations[i]);
        }

        for (int i = 0; i < n; i++) {
            if (k == 0) {
                break;
            }
            long cur = dynamicSegTreeAdd.getMin(i + 1, i + 1);
            if (cur < mid) {
                long diff = mid - cur;
                int add = (int) Math.min(k, diff);
                k -= add;
                int l1 = i + 1;
                int r1 = Math.min(n - 1, i + r + r) + 1;
                dynamicSegTreeAdd.add(l1, r1, add);

                long min = dynamicSegTreeAdd.getMin(1, n);
                if (min >= mid) {
                    return true;
                }
            }
        }
        return false;
    }

    private static class SegmentTreeAdd {
        private final int N;
        private final long[] min;
        private final long[] lazy;

        public SegmentTreeAdd(int n) {
            N = n;
            min = new long[n * 4];
            lazy = new long[n * 4];
        }

        // 区间 [l,r] 置为 val
        public void add(int l, int r, int val) {
            this.add(l, r, val, 1, N, 1);
        }

        // 区间 [l,r] 最大值
        public long getMin(int l, int r) {
            return this.getMin(l, r, 1, N, 1);
        }

        private void add(int l, int r, int val, int s, int t, int p) {
            if (l <= s && t <= r) {
                min[p] += val;
                lazy[p] += val;
                return;
            }
            int mid = s + (t - s) / 2;
            pushDown(p, s, t, mid);
            if (l <= mid) {
                add(l, r, val, s, mid, p * 2);
            }
            if (r > mid) {
                add(l, r, val, mid + 1, t, p * 2 + 1);
            }
            pushUp(p);
        }

        private long getMin(int l, int r, int s, int t, int p) {
            if (l <= s && t <= r) {
                return min[p];
            }
            int mid = s + (t - s) / 2;
            pushDown(p, s, t, mid);
            long min = Long.MAX_VALUE;
            if (l <= mid) {
                min = getMin(l, r, s, mid, p * 2);
            }
            if (r > mid) {
                min = Math.min(min, getMin(l, r, mid + 1, t, p * 2 + 1));
            }
            return min;
        }

        private void pushDown(int p, int s, int t, int mid) {
            if (lazy[p] > 0) {
                min[p * 2] += lazy[p];
                min[p * 2 + 1] += lazy[p];
                lazy[p * 2] += lazy[p];
                lazy[p * 2 + 1] += lazy[p];
                lazy[p] = 0;
            }
        }

        private void pushUp(int p) {
            min[p] = Math.min(min[p * 2], min[p * 2 + 1]);
        }
    }
}
/*
2528. 最大化城市的最小供电站数目
https://leetcode.cn/problems/maximize-the-minimum-powered-city/

第 95 场双周赛 T4。

给你一个下标从 0 开始长度为 n 的整数数组 stations ，其中 stations[i] 表示第 i 座城市的供电站数目。
每个供电站可以在一定 范围 内给所有城市提供电力。换句话说，如果给定的范围是 r ，在城市 i 处的供电站可以给所有满足 |i - j| <= r 且 0 <= i, j <= n - 1 的城市 j 供电。
- |x| 表示 x 的 绝对值 。比方说，|7 - 5| = 2 ，|3 - 10| = 7 。
一座城市的 电量 是所有能给它供电的供电站数目。
政府批准了可以额外建造 k 座供电站，你需要决定这些供电站分别应该建在哪里，这些供电站与已经存在的供电站有相同的供电范围。
给你两个整数 r 和 k ，如果以最优策略建造额外的发电站，返回所有城市中，最小供电站数目的最大值是多少。
这 k 座供电站可以建在多个城市。
提示：
n == stations.length
1 <= n <= 10^5
0 <= stations[i] <= 10^5
0 <= r <= n - 1
0 <= k <= 10^9

二分 + 前缀和 + 差分
线段树做法惨遭 TLE
 */