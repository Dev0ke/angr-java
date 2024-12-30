import java.util.TreeMap;

public class Solution2653 {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        // 转换成从 0 开始的下标
        x--;
        // 第x小 等价于 第k-x大
        MultiSets multiSets = new MultiSets(k, k - x);
        for (int i = 0; i < k; i++) {
            multiSets.add(nums[i]);
        }
        ans[0] = Math.min(0, multiSets.xMap.firstKey());

        for (int i = k; i < n; i++) {
            multiSets.add(nums[i]);
            multiSets.del(nums[i - k]);

            ans[i - k + 1] = Math.min(0, multiSets.xMap.firstKey());
        }
        return ans;
    }

    private static class MultiSets {
        int n, k;
        TreeMap<Integer, Integer> xMap, yMap;
        int xsz, ysz;

        // n:窗口大小, k:第 k 大
        public MultiSets(int n, int k) {
            this.n = n;
            this.k = k;
            this.xMap = new TreeMap<>();
            this.yMap = new TreeMap<>();
            this.xsz = 0;
            this.ysz = 0;
        }

        private void add(int v) {
            yInsertV(v);
            balance();
        }

        private void del(int v) {
            if (xMap.containsKey(v)) {
                xEraseV(v);
            } else {
                yEraseV(v);
            }
            balance();
        }

        private void balance() {
            if (xsz + ysz < n) return;
            while (xsz < k) {
                int iy = yMap.lastKey();
                yEraseV(iy);
                xInsertV(iy);
            }
            if (xsz == 0 || ysz == 0) return;
            while (true) {
                int ix = xMap.firstKey();
                int iy = yMap.lastKey();
                if (ix >= iy) break;
                xEraseV(ix);
                yEraseV(iy);
                xInsertV(iy);
                yInsertV(ix);
            }
        }

        private void xInsertV(int v) {
            xMap.put(v, xMap.getOrDefault(v, 0) + 1);
            xsz++;
        }

        private void yInsertV(int v) {
            yMap.put(v, yMap.getOrDefault(v, 0) + 1);
            ysz++;
        }

        private void xEraseV(int v) {
            xMap.put(v, xMap.getOrDefault(v, 0) - 1);
            if (xMap.get(v) == 0) xMap.remove(v);
            xsz--;
        }

        private void yEraseV(int v) {
            yMap.put(v, yMap.getOrDefault(v, 0) - 1);
            if (yMap.get(v) == 0) yMap.remove(v);
            ysz--;
        }
    }
}
/*
2653. 滑动子数组的美丽值
https://leetcode.cn/problems/sliding-subarray-beauty/

第 342 场周赛 T3。

给你一个长度为 n 的整数数组 nums ，请你求出每个长度为 k 的子数组的 美丽值 。
一个子数组的 美丽值 定义为：如果子数组中第 x 小整数 是 负数 ，那么美丽值为第 x 小的数，否则美丽值为 0 。
请你返回一个包含 n - k + 1 个整数的数组，依次 表示数组中从第一个下标开始，每个长度为 k 的子数组的 美丽值 。
- 子数组指的是数组中一段连续 非空 的元素序列。
提示：
n == nums.length 
1 <= n <= 10^5
1 <= k <= n
1 <= x <= k 
-50 <= nums[i] <= 50

双堆/对顶堆/平衡树
如果 nums[i] 值域范围扩展到更大的做法。
时间复杂度 O(n)
相似题目: E - Least Elements
https://atcoder.jp/contests/abc281/tasks/abc281_e
 */