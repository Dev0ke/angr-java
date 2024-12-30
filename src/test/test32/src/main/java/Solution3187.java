import java.util.ArrayList;
import java.util.List;

public class Solution3187 {
    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        int n = nums.length;
        // 下标从 1 开始
        int[] a = new int[n + 1];
        System.arraycopy(nums, 0, a, 1, n);
        for (int[] p : queries) {
            p[1]++;
            if (p[0] == 1) p[2]++;
        }
        Fenwick fenwick = new Fenwick(a.length);
        for (int i = 2; i <= n - 1; i++) {
            if (a[i - 1] < a[i] && a[i] > a[i + 1]) {
                fenwick.add(i, 1);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int[] p : queries) {
            if (p[0] == 1) {
                // 子数组中 第一个 和 最后一个 元素都 不是 峰值元素
                int l = p[1] + 1, r = p[2] - 1;
                ans.add(fenwick.getSum(l, r));
            } else {
                int ind = p[1], val = p[2];
                a[ind] = val;
                for (int i = ind - 1; i <= ind + 1; i++) {
                    if (2 <= i && i <= n - 1) {
                        boolean cur = a[i - 1] < a[i] && a[i] > a[i + 1];
                        int old = fenwick.getSum(i, i);
                        fenwick.add(i, -old + (cur ? 1 : 0));
                    }
                }
            }
        }
        return ans;
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

        // nums[x] add k
        void add(int x, int k) {
            while (x <= n) {
                tree[x] += k;
                x += lowbit(x);
            }
        }

        // nums [1,x] 的和
        int getSum(int x) {
            int ans = 0;
            while (x > 0) {
                ans += tree[x];
                x -= lowbit(x);
            }
            return ans;
        }

        int getSum(int l, int r) {
            if (l > r) return 0;
            return getSum(r) - getSum(l - 1);
        }
    }
}
/*
3187. 数组中的峰值
https://leetcode.cn/problems/peaks-in-array/description/

第 402 场周赛 T4。

数组 arr 中 大于 前面和后面相邻元素的元素被称为 峰值 元素。
给你一个整数数组 nums 和一个二维整数数组 queries 。
你需要处理以下两种类型的操作：
- queries[i] = [1, li, ri] ，求出子数组 nums[li..ri] 中 峰值 元素的数目。
- queries[i] = [2, indexi, vali] ，将 nums[indexi] 变为 vali 。
请你返回一个数组 answer ，它依次包含每一个第一种操作的答案。
注意：
- 子数组中 第一个 和 最后一个 元素都 不是 峰值元素。
提示：
3 <= nums.length <= 10^5
1 <= nums[i] <= 10^5
1 <= queries.length <= 10^5
queries[i][0] == 1 或者 queries[i][0] == 2
对于所有的 i ，都有：
queries[i][0] == 1 ：0 <= queries[i][1] <= queries[i][2] <= nums.length - 1
queries[i][0] == 2 ：0 <= queries[i][1] <= nums.length - 1, 1 <= queries[i][2] <= 10^5

树状数组。单点修改，区间求和。
时间复杂度 O((n+q)logn)。
 */