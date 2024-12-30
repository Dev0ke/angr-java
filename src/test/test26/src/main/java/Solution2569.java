import java.util.ArrayList;
import java.util.List;

public class Solution2569 {
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        long sum2 = 0L;
        for (int x : nums2) {
            sum2 += x;
        }

        SegmentTree segmentTree = new SegmentTree(nums1);
        List<Long> resList = new ArrayList<>();
        for (int[] query : queries) {
            if (query[0] == 1) {
                segmentTree.op1(query[1] + 1, query[2] + 1);
            } else if (query[0] == 2) {
                sum2 += segmentTree.getSum() * query[1];
            } else {
                resList.add(sum2);
            }
        }
        return resList.stream().mapToLong(Long::longValue).toArray();
    }

    private static class SegmentTree {
        private final int N;
        private final int[] nums;

        private final long[] sum;
        private final int[] lazy;

        public SegmentTree(int[] nums) {
            N = nums.length;
            this.nums = nums;

            sum = new long[N * 4];
            lazy = new int[N * 4];
            build(1, N, 1);
        }

        // 建树
        private void build(int s, int t, int p) {
            if (s == t) {
                sum[p] = nums[s - 1];
                return;
            }
            int mid = s + (t - s) / 2;
            build(s, mid, p * 2);
            build(mid + 1, t, p * 2 + 1);
            pushUp(p);
        }

        // 将 nums1 从下标 l 到下标 r 的所有 0 反转成 1 或将 1 反转成 0 。
        public void op1(int l, int r) {
            this.op1(l, r, 1, N, 1);
        }

        // 区间 [l,r] 求和
        public long getSum() {
            return this.getSum(1, N, 1, N, 1);
        }

        private void op1(int l, int r, int s, int t, int p) {
            if (l <= s && t <= r) {
                sum[p] = (t - s + 1L) - sum[p];
                lazy[p] ^= 1;
                return;
            }
            int mid = s + (t - s) / 2;
            pushDown(mid, s, t, p);
            if (l <= mid) {
                op1(l, r, s, mid, p * 2);
            }
            if (r > mid) {
                op1(l, r, mid + 1, t, p * 2 + 1);
            }
            pushUp(p);
        }

        private long getSum(int l, int r, int s, int t, int p) {
            if (l <= s && t <= r) {
                return sum[p];
            }
            int mid = s + (t - s) / 2;
            pushDown(mid, s, t, p);
            long sum = 0;
            if (l <= mid) {
                sum = getSum(l, r, s, mid, p * 2);
            }
            if (r > mid) {
                sum += getSum(l, r, mid + 1, t, p * 2 + 1);
            }
            return sum;
        }

        private void pushDown(int mid, int s, int t, int p) {
            if (lazy[p] > 0) {
                sum[p * 2] = (mid - s + 1L) - sum[p * 2];
                sum[p * 2 + 1] = (t - mid) - sum[p * 2 + 1];
                lazy[p * 2] ^= lazy[p];
                lazy[p * 2 + 1] ^= lazy[p];
                lazy[p] = 0;
            }
        }

        private void pushUp(int p) {
            sum[p] = sum[p * 2] + sum[p * 2 + 1];
        }
    }
}
/*
2569. 更新数组后处理求和查询
https://leetcode.cn/problems/handling-sum-queries-after-update/

第 98 场双周赛 T4。

给你两个下标从 0 开始的数组 nums1 和 nums2 ，和一个二维数组 queries 表示一些操作。总共有 3 种类型的操作：
1. 操作类型 1 为 queries[i] = [1, l, r] 。你需要将 nums1 从下标 l 到下标 r 的所有 0 反转成 1 或将 1 反转成 0 。l 和 r 下标都从 0 开始。
2. 操作类型 2 为 queries[i] = [2, p, 0] 。对于 0 <= i < n 中的所有下标，令 nums2[i] = nums2[i] + nums1[i] * p 。
3. 操作类型 3 为 queries[i] = [3, 0, 0] 。求 nums2 中所有元素的和。
请你返回一个数组，包含所有第三种操作类型的答案。
提示：
1 <= nums1.length,nums2.length <= 10^5
nums1.length = nums2.length
1 <= queries.length <= 10^5
queries[i].length = 3
0 <= l <= r <= nums1.length - 1
0 <= p <= 10^6
0 <= nums1[i] <= 1
0 <= nums2[i] <= 10^9

线段树。基于 nums1 建树，懒标记下推 pushDown
时间复杂度 O(n + qlogn)
空间复杂度 O(4n)
 */