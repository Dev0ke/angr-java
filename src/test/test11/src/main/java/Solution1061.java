public class Solution1061 {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int len = s1.length();

        DSU dsu = new DSU(26);
        for (int i = 0; i < len; i++) {
            int idx1 = s1.charAt(i) - 'a';
            int idx2 = s2.charAt(i) - 'a';
            dsu.union(idx1, idx2);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : baseStr.toCharArray()) {
            int idx = dsu.find(ch - 'a');
            stringBuilder.append((char) (idx + 'a'));
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
            // 不按 rank，连接到字典序小的点
            if (rootP < rootQ) {
                fa[rootQ] = rootP;
            } else {
                fa[rootP] = rootQ;
            }
        }
    }
}
/*
$1061. 按字典序排列最小的等效字符串
https://leetcode.cn/problems/lexicographically-smallest-equivalent-string/

给出长度相同的两个字符串s1 和 s2 ，还有一个字符串 baseStr 。
其中  s1[i] 和 s2[i]  是一组等价字符。
- 举个例子，如果 s1 = "abc" 且 s2 = "cde"，那么就有 'a' == 'c', 'b' == 'd', 'c' == 'e'。
等价字符遵循任何等价关系的一般规则：
- 自反性 ：'a' == 'a'
- 对称性 ：'a' == 'b' 则必定有 'b' == 'a'
- 传递性 ：'a' == 'b' 且 'b' == 'c' 就表明 'a' == 'c'
例如， s1 = "abc" 和 s2 = "cde" 的等价信息和之前的例子一样，那么 baseStr = "eed" , "acd" 或 "aab"，这三个字符串都是等价的，而 "aab" 是 baseStr 的按字典序最小的等价字符串
利用 s1 和 s2 的等价信息，找出并返回 baseStr 的按字典序排列最小的等价字符串。
提示：
1 <= s1.length, s2.length, baseStr <= 1000
s1.length == s2.length
字符串s1, s2, and baseStr 仅由从 'a' 到 'z' 的小写英文字母组成。

不同于一般并查集，连接到字典序小的点
 */