import java.util.HashMap;
import java.util.Map;

public class Solution947 {
    public int removeStones(int[][] stones) {
        DSU dsu = new DSU();
        for (int[] stone : stones) {
            // 并查集里如何区分横纵坐标 下面这三种写法任选其一
//            dsu.union(~stone[0], stone[1]);
//            dsu.union(stone[0] - 10001, stone[1]);
            dsu.union(stone[0] + 10001, stone[1]);
        }
        return stones.length - dsu.sz;
    }

    private static class DSU {
        Map<Integer, Integer> faMap;
        int sz;

        public DSU() {
            faMap = new HashMap<>();
        }

        int find(int x) {
            if (!faMap.containsKey(x)) {
                faMap.put(x, x);
                sz++;
            }
            if (x != faMap.get(x)) {
                faMap.put(x, find(faMap.get(x)));
            }
            return faMap.get(x);
        }

        void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            faMap.put(rootQ, rootP);
            sz--;
        }
    }
}
/*
947. 移除最多的同行或同列石头
https://leetcode.cn/problems/most-stones-removed-with-same-row-or-column/

n 块石头放置在二维平面中的一些整数坐标点上。每个坐标点上最多只能有一块石头。
如果一块石头的 同行或者同列 上有其他石头存在，那么就可以移除这块石头。
给你一个长度为 n 的数组 stones ，其中 stones[i] = [xi, yi] 表示第 i 块石头的位置，返回 可以移除的石子 的最大数量。
提示：
1 <= stones.length <= 1000
0 <= xi, yi <= 10^4
不会有两块石头放在同一个坐标点上

基于 HashMap 的并查集。
 */