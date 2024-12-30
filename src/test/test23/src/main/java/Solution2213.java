import java.util.Arrays;

public class Solution2213 {
    // 120ms
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        char[] cs = s.toCharArray();
        int n = s.length();
        int k = queryCharacters.length();

        int[] res = new int[k];
        SegmentTree seg = new SegmentTree(cs);
        for (int i = 0; i < k; i++) {
            int idx = queryIndices[i];
            seg.cs[idx] = queryCharacters.charAt(i);
            seg.update(1, 1, n, idx + 1);
            res[i] = seg.tree[1].max;
        }
        return res;
    }

    private static class SegmentTree {
        Node[] tree;

        static class Node {
            int pre, suf, max;

            public Node(int pre, int suf, int max) {
                this.pre = pre;
                this.suf = suf;
                this.max = max;
            }
        }

        char[] cs;

        public SegmentTree(char[] cs) {
            int n = cs.length;
            this.cs = cs;
            tree = new Node[4 * n];
            Arrays.setAll(tree, e -> new Node(0, 0, 0));

            build(1, 1, n);
        }

        void build(int p, int l, int r) {
            if (l == r) {
                tree[p].pre = 1;
                tree[p].suf = 1;
                tree[p].max = 1;
                return;
            }
            int mid = l + (r - l) / 2;
            build(p << 1, l, mid);
            build(p << 1 | 1, mid + 1, r);
            maintain(l, r, p);
        }

        private void maintain(int l, int r, int p) {
            Node ls = tree[p << 1];
            Node rs = tree[p << 1 | 1];

            tree[p].pre = ls.pre;
            tree[p].suf = rs.suf;
            tree[p].max = Math.max(ls.max, rs.max);
            int mid = l + (r - l) / 2;
            // 中间字符相同，可以合并
            if (cs[mid - 1] == cs[mid]) {
                if (ls.suf == mid - l + 1) {
                    tree[p].pre += rs.pre;
                }
                if (rs.suf == r - mid) {
                    tree[p].suf += ls.suf;
                }
                tree[p].max = Math.max(tree[p].max, ls.suf + rs.pre);
            }
        }

        private void update(int p, int l, int r, int i) {
            if (l == r) {
                return;
            }
            int mid = l + (r - l) / 2;
            if (i <= mid) {
                update(p << 1, l, mid, i);
            } else {
                update(p << 1 | 1, mid + 1, r, i);
            }
            maintain(l, r, p);
        }
    }
}
/*
2213. 由单个字符重复的最长子字符串
https://leetcode.cn/problems/longest-substring-of-one-repeating-character/

第 285 场周赛 T4。

给你一个下标从 0 开始的字符串 s 。另给你一个下标从 0 开始、长度为 k 的字符串 queryCharacters ，一个下标从 0 开始、长度也是 k 的整数 下标 数组 queryIndices ，这两个都用来描述 k 个查询。
第 i 个查询会将 s 中位于下标 queryIndices[i] 的字符更新为 queryCharacters[i] 。
返回一个长度为 k 的数组 lengths ，其中 lengths[i] 是在执行第 i 个查询 之后 s 中仅由 单个字符重复 组成的 最长子字符串 的 长度 。
提示：
1 <= s.length <= 10^5
s 由小写英文字母组成
k == queryCharacters.length == queryIndices.length
1 <= k <= 10^5
queryCharacters 由小写英文字母组成
0 <= queryIndices[i] < s.length

和字符集大小无关的线段树做法。主要逻辑是 maintain 的写法。
https://leetcode.cn/problems/longest-substring-of-one-repeating-character/solution/by-endlesscheng-qpbw/
 */