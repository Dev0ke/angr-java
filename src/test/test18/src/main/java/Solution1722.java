import java.util.HashMap;
import java.util.Map;

public class Solution1722 {
    // 1202
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        DSU dsu = new DSU(n);
        for (int[] p : allowedSwaps) {
            dsu.union(p[0], p[1]);
        }

        Map<Integer, Map<Integer, Integer>> faMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int fa = dsu.find(i);
            faMap.computeIfAbsent(fa, e -> new HashMap<>()).merge(source[i], 1, Integer::sum);
            faMap.computeIfAbsent(fa, e -> new HashMap<>()).merge(target[i], -1, Integer::sum);
        }
        int ans = 0;
        for (Map<Integer, Integer> mps : faMap.values()) {
            for (Integer c : mps.values()) {
                ans += Math.abs(c);
            }
        }
        return ans / 2;
    }

    static class DSU {
        int[] fa;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        int find(int x) { // 查找
            return x == fa[x] ? fa[x] : (fa[x] = find(fa[x]));
        }

        void union(int p, int q) { // 合并
            p = find(p);
            q = find(q);
            if (p == q) return;
            fa[q] = p;
        }
    }
}
/*
1722. 执行交换操作后的最小汉明距离
https://leetcode.cn/problems/minimize-hamming-distance-after-swap-operations/description/

给你两个整数数组 source 和 target ，长度都是 n 。还有一个数组 allowedSwaps ，其中每个 allowedSwaps[i] = [ai, bi] 表示你可以交换数组 source 中下标为 ai 和 bi（下标从 0 开始）的两个元素。注意，你可以按 任意 顺序 多次 交换一对特定下标指向的元素。
相同长度的两个数组 source 和 target 间的 汉明距离 是元素不同的下标数量。形式上，其值等于满足 source[i] != target[i] （下标从 0 开始）的下标 i（0 <= i <= n-1）的数量。
在对数组 source 执行 任意 数量的交换操作后，返回 source 和 target 间的 最小汉明距离 。
提示：
n == source.length == target.length
1 <= n <= 10^5
1 <= source[i], target[i] <= 10^5
0 <= allowedSwaps.length <= 10^5
allowedSwaps[i].length == 2
0 <= ai, bi <= n - 1
ai != bi

并查集分组。每个组看成两个集合。要使汉明距离最小，相同元素抵消，然后不同元素两两配对。
时间复杂度 O(nlogn)。
 */