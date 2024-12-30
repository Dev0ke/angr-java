import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution1202 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        DSU dsu = new DSU(n);
        for (List<Integer> pair : pairs) {
            dsu.union(pair.get(0), pair.get(1));
        }

        Map<Integer, PriorityQueue<Character>> faMinHeapMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int fa = dsu.find(i);
            faMinHeapMap.computeIfAbsent(fa, key -> new PriorityQueue<>()).add(s.charAt(i));
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int fa = dsu.find(i);
            stringBuilder.append(faMinHeapMap.get(fa).poll());
        }
        return stringBuilder.toString();
    }

    private static class DSU {
        // 父节点数组/祖先数组
        int[] fa;

        // 初始化
        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        // 查找
        int find(int x) {
            // 路径压缩
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }

        // 合并
        void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            fa[rootQ] = rootP;
        }
    }
}
/*
1202. 交换字符串中的元素
https://leetcode.cn/problems/smallest-string-with-swaps/

给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
提示：
1 <= s.length <= 10^5
0 <= pairs.length <= 10^5
0 <= pairs[i][0], pairs[i][1] < s.length
s 中只含有小写英文字母

并查集+贪心
 */