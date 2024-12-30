import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution493 {
    public int reversePairs(int[] nums) {
        // 离散化
        long[] yArr = getDiscrete(nums);

        Fenwick fenwick = new Fenwick(yArr.length);
        int ans = 0;
        for (long x : nums) {
            int id1 = getId(yArr, x);
            int id2 = getId(yArr, x * 2);
            ans += fenwick.getSum(yArr.length) - fenwick.getSum(id2);
            fenwick.add(id1, 1);
        }
        return ans;
    }

    private long[] getDiscrete(int[] nums) {
        Set<Long> set = new HashSet<>();
        for (long x : nums) {
            set.add(x);
            set.add(x * 2);
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
493. 翻转对
https://leetcode.cn/problems/reverse-pairs/description/

给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
你需要返回给定数组中的重要翻转对的数量。
注意:
给定数组的长度不会超过50000。
输入数组中的所有数字都在32位整数的表示范围内。

离散化 + 树状数组。
时间复杂度 O(nlogn)
相似题目: 327. 区间和的个数
https://leetcode.cn/problems/count-of-range-sum/
 */