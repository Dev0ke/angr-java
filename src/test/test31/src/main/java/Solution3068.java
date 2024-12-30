import java.util.Arrays;
import java.util.Comparator;

public class Solution3068 {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;

        Node[] a = new Node[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Node(nums[i], nums[i] ^ k, i);
        }
        Arrays.sort(a, Comparator.comparingInt(o -> o.delta));

        long ans = n % 2 > 0 ? a[n - 1].v : 0;
        for (int i = 0; i + 1 < n; i += 2) {
            if (a[i + 1].delta < 0) {
                ans += a[i].xor;
                ans += a[i + 1].xor;
            } else {
                if (a[i].delta + a[i + 1].delta < 0) {
                    ans += a[i].xor;
                    ans += a[i + 1].xor;
                } else {
                    ans += a[i].v;
                    ans += a[i + 1].v;
                }
            }
        }
        return ans;
    }

    static class Node {
        int v, xor, delta, i;

        public Node(int v, int xor, int i) {
            this.v = v;
            this.xor = xor;
            this.delta = v - xor;
            this.i = i;
        }
    }
}
/*
3068. 最大节点价值之和
https://leetcode.cn/problems/find-the-maximum-sum-of-node-values/description/

第 125 场双周赛 T4。

给你一棵 n 个节点的 无向 树，节点从 0 到 n - 1 编号。树以长度为 n - 1 下标从 0 开始的二维整数数组 edges 的形式给你，其中 edges[i] = [ui, vi] 表示树中节点 ui 和 vi 之间有一条边。同时给你一个 正 整数 k 和一个长度为 n 下标从 0 开始的 非负 整数数组 nums ，其中 nums[i] 表示节点 i 的 价值 。
日增哥哥想 最大化 树中所有节点价值之和。为了实现这一目标，日增哥哥可以执行以下操作 任意 次（包括 0 次）：
- 选择连接节点 u 和 v 的边 [u, v] ，并将它们的值更新为：
  - nums[u] = nums[u] XOR k
  - nums[v] = nums[v] XOR k
请你返回日增哥哥通过执行以上操作 任意次 后，可以得到所有节点 价值之和 的 最大值 。
提示：
2 <= n == nums.length <= 2 * 10^4
1 <= k <= 10^9
0 <= nums[i] <= 10^9
edges.length == n - 1
edges[i].length == 2
0 <= edges[i][0], edges[i][1] <= n - 1
输入保证 edges 构成一棵合法的树。

脑筋急转弯。
根据异或运算性质。k 次操作可使距离为 k 的两个点 xor k。因此将差值算出来，贪心即可。
时间复杂度 O(nlogn)
 */