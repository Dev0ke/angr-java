import java.util.ArrayList;
import java.util.List;

public class Solution1627 {
    /**
     * 暴力法
     * O(n^2) - TLE
     */
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        // 编号 1 到 n
        DSU dsu = new DSU(n + 1);
        for (int i = threshold + 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (getGCD(i, j) > threshold) {
                    dsu.union(i, j);
                }
            }
        }

        List<Boolean> ans = new ArrayList<>();
        for (int[] p : queries) {
            int a = p[0], b = p[1];
            boolean connected = dsu.find(a) == dsu.find(b);
            ans.add(connected);
        }
        return ans;
    }

    private int getGCD(int num1, int num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }

    /**
     * 调和级数
     * O(nlogn) - AC
     */
    public List<Boolean> areConnected2(int n, int threshold, int[][] queries) {
        // 编号 1 到 n
        DSU dsu = new DSU(n + 1);
        for (int i = threshold + 1; i <= n; i++) {
            for (int p = i, q = i * 2; q <= n; p += i, q += i) {
                dsu.union(p, q);
            }
        }

        List<Boolean> ans = new ArrayList<>();
        for (int[] p : queries) {
            int a = p[0], b = p[1];
            boolean connected = dsu.find(a) == dsu.find(b);
            ans.add(connected);
        }
        return ans;
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
1627. 带阈值的图连通性
https://leetcode.cn/problems/graph-connectivity-with-threshold/

有 n 座城市，编号从 1 到 n 。编号为 x 和 y 的两座城市直接连通的前提是： x 和 y 的公因数中，至少有一个 严格大于 某个阈值 threshold 。
更正式地说，如果存在整数 z ，且满足以下所有条件，则编号 x 和 y 的城市之间有一条道路：
- x % z == 0
- y % z == 0
- z > threshold
给你两个整数 n 和 threshold ，以及一个待查询数组，请你判断每个查询 queries[i] = [ai, bi] 指向的城市 ai 和 bi 是否连通（即，它们之间是否存在一条路径）。
返回数组 answer ，其中answer.length == queries.length 。如果第 i 个查询中指向的城市 ai 和 bi 连通，则 answer[i] 为 true ；如果不连通，则 answer[i] 为 false 。
提示：
2 <= n <= 10^4
0 <= threshold <= n
1 <= queries.length <= 10^5
queries[i].length == 2
1 <= ai, bi <= cities
ai != bi

并查集。
难点是使用调和级数将时间复杂度由 O(n^2) 优化至 O(nlogn)
 */