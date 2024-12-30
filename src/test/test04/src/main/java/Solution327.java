import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution327 {
    // 424ms
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] ps = new long[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + nums[i];
        }

        // 离散化
        long[] yArr = getDiscrete(lower, upper, ps);

        int ans = 0;
        Fenwick fenwick = new Fenwick(yArr.length);
        for (long x : ps) {
            int l = getId(yArr, x - upper);
            int r = getId(yArr, x - lower);
            ans += fenwick.getSum(r) - fenwick.getSum(l - 1);
            fenwick.add(getId(yArr, x), 1);
        }
        return ans;
    }

    private long[] getDiscrete(int lower, int upper, long[] preSum) {
        Set<Long> set = new HashSet<>();
        for (long x : preSum) {
            set.add(x);
            set.add(x - lower);
            set.add(x - upper);
        }
        int sz = set.size();
        long[] yArr = new long[sz];
        int id = 0;
        for (long x : set) {
            yArr[id++] = x;
        }
        Arrays.sort(yArr);
        return yArr;
    }

    private int getId(long[] yArr, long x) {
        return Arrays.binarySearch(yArr, x) + 1;
    }

    static class Fenwick {
        private final int n;
        private final int[] tree;

        public Fenwick(int n) {
            this.n = n;
            this.tree = new int[n + 1];
        }

        int lowbit(int x) {
            return x & -x;
        }

        void add(int x, int k) {
            while (x <= n) {
                tree[x] += k;
                x += lowbit(x);
            }
        }

        int getSum(int x) {
            int ans = 0;
            while (x > 0) {
                ans += tree[x];
                x -= lowbit(x);
            }
            return ans;
        }
    }
}
/*
327. 区间和的个数
https://leetcode.cn/problems/count-of-range-sum/

给你一个整数数组 nums 以及两个整数 lower 和 upper 。求数组中，值位于范围 [lower, upper] （包含 lower 和 upper）之内的 区间和的个数 。
区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
提示：
1 <= nums.length <= 10^5
-2^31 <= nums[i] <= 2^31 - 1
-10^5 <= lower <= upper <= 10^5
题目数据保证答案是一个 32 位 的整数

离散化树状数组
时间复杂度 O(nlogn)
空间复杂度 O(n)
相似题目: 493. 翻转对
https://leetcode.cn/problems/reverse-pairs/description/
 */