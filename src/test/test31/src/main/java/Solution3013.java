import java.util.TreeMap;

public class Solution3013 {
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        // 窗口大小 m，前 k-1 小的和，等价于 总和减去前 m-(k-1) 大的和
        int m = dist + 1;
        MultiSets multiSets = new MultiSets(m, m - (k - 1));
        for (int i = 1; i < m + 1; i++) {
            multiSets.add(nums[i]);
        }
        long ans = multiSets.tot - multiSets.sumX;
        for (int i = m + 1; i < n; i++) {
            multiSets.add(nums[i]);
            multiSets.del(nums[i - m]);

            ans = Math.min(ans, multiSets.tot - multiSets.sumX);
        }
        return ans + nums[0];
    }

    private static class MultiSets {
        int n, k;
        TreeMap<Integer, Integer> xMap, yMap;
        int xsz, ysz;
        long sumX, tot;

        // n:窗口大小, k:第 k 大
        public MultiSets(int n, int k) {
            this.n = n;
            this.k = k;
            this.xMap = new TreeMap<>();
            this.yMap = new TreeMap<>();
            this.xsz = 0;
            this.ysz = 0;
            sumX = 0;
        }

        private void add(int v) {
            yInsertV(v);
            balance();
            tot += v;
        }

        private void del(int v) {
            if (xMap.containsKey(v)) {
                xEraseV(v);
            } else {
                yEraseV(v);
            }
            balance();
            tot -= v;
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
            sumX += v;
        }

        private void yInsertV(int v) {
            yMap.put(v, yMap.getOrDefault(v, 0) + 1);
            ysz++;
        }

        private void xEraseV(int v) {
            xMap.put(v, xMap.getOrDefault(v, 0) - 1);
            if (xMap.get(v) == 0) xMap.remove(v);
            xsz--;
            sumX -= v;
        }

        private void yEraseV(int v) {
            yMap.put(v, yMap.getOrDefault(v, 0) - 1);
            if (yMap.get(v) == 0) yMap.remove(v);
            ysz--;
        }
    }
}
/*
3013. 将数组分成最小总代价的子数组 II
https://leetcode.cn/problems/divide-an-array-into-subarrays-with-minimum-cost-ii/description/

第 122 场双周赛 T4。

给你一个下标从 0 开始长度为 n 的整数数组 nums 和两个 正 整数 k 和 dist 。
一个数组的 代价 是数组中的 第一个 元素。比方说，[1,2,3] 的代价为 1 ，[3,4,1] 的代价为 3 。
你需要将 nums 分割成 k 个 连续且互不相交 的子数组，满足 第二 个子数组与第 k 个子数组中第一个元素的下标距离 不超过 dist 。换句话说，如果你将 nums 分割成子数组 nums[0..(i1 - 1)], nums[i1..(i2 - 1)], ..., nums[ik-1..(n - 1)] ，那么它需要满足 ik-1 - i1 <= dist 。
请你返回这些子数组的 最小 总代价。
提示：
3 <= n <= 10^5
1 <= nums[i] <= 10^9
3 <= k <= n
k - 2 <= dist <= n - 2

滑动窗口 + 双平衡树模拟 multiset。注意优先队列删除指定元素时间复杂度是 O(n)，除非用懒删除堆，不过比较复杂。
时间复杂度 O(nlogn)
rating 2537 (clist.by)
 */