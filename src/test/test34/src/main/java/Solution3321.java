import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Solution3321 {
    // 568ms
    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < k; i++) {
            cnt.merge(nums[i], 1, Integer::sum);
        }
        MultiSets multiSets = new MultiSets(x, x);
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            multiSets.add(new Node(entry.getKey(), entry.getValue()));
        }

        long[] ans = new long[n - k + 1];
        ans[0] = multiSets.xsz == 0 ? multiSets.sumY : multiSets.sumX;
        for (int i = k; i < n; i++) {
            Integer newcnt = cnt.merge(nums[i], 1, Integer::sum);
            multiSets.del(new Node(nums[i], newcnt - 1));
            multiSets.add(new Node(nums[i], newcnt));

            newcnt = cnt.merge(nums[i - k], -1, Integer::sum);
            multiSets.del(new Node(nums[i - k], newcnt + 1));
            multiSets.add(new Node(nums[i - k], newcnt));

            ans[i - k + 1] = multiSets.xsz == 0 ? multiSets.sumY : multiSets.sumX;
        }
        return ans;
    }

    static class Node implements Comparable<Node> {
        int val, cnt;

        public Node(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return val == node.val && cnt == node.cnt;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, cnt);
        }

        @Override
        public int compareTo(Node node) {
            if (cnt == node.cnt) {
                return Integer.compare(val, node.val);
            }
            return Integer.compare(cnt, node.cnt);
        }
    }

    static class MultiSets {
        int n, k;
        TreeMap<Node, Integer> xMap, yMap;
        int xsz, ysz;
        long sumX, sumY;

        // n:窗口大小, k:第 k 大
        public MultiSets(int n, int k) {
            this.n = n;
            this.k = k;
            this.xMap = new TreeMap<>();
            this.yMap = new TreeMap<>();
            this.xsz = 0;
            this.ysz = 0;
            sumX = 0;
            sumY = 0;
        }

        void add(Node v) {
            if (v.cnt == 0) return;
            yInsertV(v);
            balance();
        }

        void del(Node v) {
            if (v.cnt == 0) return;
            if (xMap.containsKey(v)) xEraseV(v);
            else yEraseV(v);
            balance();
        }

        void balance() {
            while (xsz < k && ysz != 0) {
                Node iy = yMap.lastKey();
                xInsertV(iy);
                yEraseV(iy);
            }
            if (xsz == 0 || ysz == 0) return;
            while (true) {
                Node ix = xMap.firstKey();
                Node iy = yMap.lastKey();
                if (ix.compareTo(iy) >= 0) break;
                xEraseV(ix);
                yEraseV(iy);
                xInsertV(iy);
                yInsertV(ix);
            }
        }

        void xInsertV(Node v) {
            xMap.merge(v, 1, Integer::sum);
            xsz++;
            sumX += (long) v.val * v.cnt;
        }

        void yInsertV(Node v) {
            yMap.merge(v, 1, Integer::sum);
            ysz++;
            sumY += (long) v.val * v.cnt;
        }

        void xEraseV(Node v) {
            if (xMap.merge(v, -1, Integer::sum) == 0) xMap.remove(v);
            xsz--;
            sumX -= (long) v.val * v.cnt;
        }

        void yEraseV(Node v) {
            if (yMap.merge(v, -1, Integer::sum) == 0) yMap.remove(v);
            ysz--;
            sumY -= (long) v.val * v.cnt;
        }
    }
}
/*
3321. 计算子数组的 x-sum II
https://leetcode.cn/problems/find-x-sum-of-all-k-long-subarrays-ii/description/

第 419 场周赛 T4。

给你一个由 n 个整数组成的数组 nums，以及两个整数 k 和 x。
数组的 x-sum 计算按照以下步骤进行：
- 统计数组中所有元素的出现次数。
- 仅保留出现次数最多的前 x 个元素的每次出现。如果两个元素的出现次数相同，则数值 较大 的元素被认为出现次数更多。
- 计算结果数组的和。
注意，如果数组中的不同元素少于 x 个，则其 x-sum 是数组的元素总和。
返回一个长度为 n - k + 1 的整数数组 answer，其中 answer[i] 是 子数组 nums[i..i + k - 1] 的 x-sum。
子数组 是数组内的一个连续 非空 的元素序列。
提示：
nums.length == n
1 <= n <= 10^5
1 <= nums[i] <= 10^9
1 <= x <= k <= nums.length

对顶堆。注意存一个自定义 Node 对象。及 v.cnt = 0 时的处理。
rating 2595 (clist.by)
 */