import java.util.PriorityQueue;

public class Solution3080 {
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;

        long sum = 0;
        PriorityQueue<Node> heap = new PriorityQueue<>((o1, o2) -> {
            if (o1.val == o2.val) return Integer.compare(o1.i, o2.i);
            return Integer.compare(o1.val, o2.val);
        });
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            heap.add(new Node(nums[i], i));
        }

        long[] ans = new long[q];
        boolean[] vis = new boolean[n];
        for (int i = 0; i < q; i++) {
            int idx = queries[i][0], k = queries[i][1];
            if (!vis[idx]) {
                sum -= nums[idx];
                vis[idx] = true;
            }
            while (!heap.isEmpty() && k > 0) {
                Node top = heap.remove();
                if (!vis[top.i]) {
                    vis[top.i] = true;
                    k--;
                    sum -= top.val;
                }
            }
            ans[i] = sum;
        }
        return ans;
    }

    static class Node {
        int val, i;

        public Node(int val, int i) {
            this.val = val;
            this.i = i;
        }
    }
}
/*
3080. 执行操作标记数组中的元素
https://leetcode.cn/problems/mark-elements-on-array-by-performing-queries/description/

第 126 场双周赛 T2。

给你一个长度为 n 下标从 0 开始的正整数数组 nums 。
同时给你一个长度为 m 的二维操作数组 queries ，其中 queries[i] = [indexi, ki] 。
一开始，数组中的所有元素都 未标记 。
你需要依次对数组执行 m 次操作，第 i 次操作中，你需要执行：
- 如果下标 indexi 对应的元素还没标记，那么标记这个元素。
- 然后标记 ki 个数组中还没有标记的 最小 元素。如果有元素的值相等，那么优先标记它们中下标较小的。如果少于 ki 个未标记元素存在，那么将它们全部标记。
请你返回一个长度为 m 的数组 answer ，其中 answer[i]是第 i 次操作后数组中还没标记元素的 和 。
提示：
n == nums.length
m == queries.length
1 <= m <= n <= 10^5
1 <= n <= 10^5
queries[i].length == 2
0 <= indexi, ki <= n - 1

懒删除堆。
时间复杂度 O(nlogn)
 */