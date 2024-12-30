public class Solution765 {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        DSU unionFind = new DSU(n / 2);
        for (int i = 0; i < n; i += 2) {
            // 利用除法向下取整
            // 如 [2, 3] => [1, 1]
            unionFind.union(row[i] / 2, row[i + 1] / 2);
        }
        return n / 2 - unionFind.sz;
    }

    static class DSU {
        int[] fa;
        int sz;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
            sz = n;
        }

        int find(int x) { // 查找
            return x == fa[x] ? fa[x] : (fa[x] = find(fa[x]));
        }

        void union(int p, int q) { // 合并
            p = find(p);
            q = find(q);
            if (p == q) return;
            fa[q] = p;
            sz--;
        }
    }
}
/*
765. 情侣牵手
https://leetcode.cn/problems/couples-holding-hands/

n 对情侣坐在连续排列的 2n 个座位上，想要牵到对方的手。
人和座位由一个整数数组 row 表示，其中 row[i] 是坐在第 i 个座位上的人的 ID。情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2n-2, 2n-1)。
返回 最少交换座位的次数，以便每对情侣可以并肩坐在一起。 每次交换可选择任意两人，让他们站起来交换座位。
提示:
2n == row.length
2 <= n <= 30
n 是偶数
0 <= row[i] < 2n
row 中所有元素均无重复

并查集。
至少交换的次数 = 所有情侣的对数 - 并查集里连通分量的个数
 */