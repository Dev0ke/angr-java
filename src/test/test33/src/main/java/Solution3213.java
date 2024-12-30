import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.function.Function;

public class Solution3213 {
    // 后缀数组
    static class V1 {
        private static final int INF = (int) 1e9;

        public int minimumCost(String target, String[] words, int[] costs) {
            int m = words.length;
            Map<String, Integer> minCost = new HashMap<>();
            for (int i = 0; i < m; i++) {
                minCost.merge(words[i], costs[i], Integer::min);
            }
            int n = target.length();
            idx = 0;
            Arrays.fill(he, -1);

            SuffixArray suffixArray = new SuffixArray(target);
            int[] sa = suffixArray.sa0;
            for (Map.Entry<String, Integer> entry : minCost.entrySet()) {
                String word = entry.getKey();
                int cost = entry.getValue();
                int[] lr = suffixArray.lookupAll(word);
                for (int i = lr[0]; i < lr[1]; i++) {
                    int l = sa[i];
                    int r = l + word.length();
                    add(r, l, cost);
                }
            }

            int[] f = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                f[i] = INF;
                for (int j = he[i]; j != -1; j = ne[j]) {
                    int p_l = ed[j], p_cost = we[j];
                    f[i] = Math.min(f[i], f[p_l] + p_cost);
                }
            }
            if (f[n] == INF) return -1;
            return f[n];
        }

        // 链式前向星
        // 最坏情况：target 有 50000 个 a，words=[a,aa,aaa,...]，有 315 项， 总长 L 为 (1+315)*315/2=49770，
        // 匹配次数为 (50000+(50000-314))*315/2 = 15700545
        static int N = (int) (5e4 + 5), M = 15700545 + 5;
        static int[] he = new int[N], ne = new int[M], ed = new int[M], we = new int[M];
        static int idx = 0;

        static void add(int u, int v, int w) {
            ed[idx] = v;
            ne[idx] = he[u];
            he[u] = idx;
            we[idx] = w;
            idx++;
        }

        // O(nlogn) 后缀数组 https://oi-wiki.org/string/sa/
        static class SuffixArray {
            String data;
            int[] rk, old_rk, sa, id, cnt;
            int[] sa0; // 下标从 0 开始

            public SuffixArray(String S) {
                data = S;
                int n = S.length(), m = 128, p;
                rk = new int[n * 2 + 1];
                old_rk = new int[n * 2 + 1];
                id = new int[n + 1];
                cnt = new int[Math.max(n + 1, m + 1)];
                sa = new int[n + 1];
                S = " " + S;
                char[] s = S.toCharArray();
                for (int i = 1; i <= n; i++) cnt[rk[i] = s[i]]++;
                for (int i = 1; i <= m; i++) cnt[i] += cnt[i - 1];
                for (int i = n; i >= 1; i--) sa[cnt[rk[i]]--] = i;
                for (int w = 1; ; w <<= 1, m = p) { // m = p 即为值域优化
                    int cur = 0;
                    for (int i = n - w + 1; i <= n; i++) id[++cur] = i;
                    for (int i = 1; i <= n; i++) {
                        if (sa[i] > w) id[++cur] = sa[i] - w;
                    }
                    Arrays.fill(cnt, 0);
                    for (int i = 1; i <= n; i++) cnt[rk[i]]++;
                    for (int i = 1; i <= m; i++) cnt[i] += cnt[i - 1];
                    for (int i = n; i >= 1; i--) sa[cnt[rk[id[i]]]--] = id[i];
                    p = 0;
                    System.arraycopy(rk, 0, old_rk, 0, old_rk.length);
                    for (int i = 1; i <= n; i++) {
                        if (old_rk[sa[i]] == old_rk[sa[i - 1]] && old_rk[sa[i] + w] == old_rk[sa[i - 1] + w])
                            rk[sa[i]] = p;
                        else rk[sa[i]] = ++p;
                    }
                    if (p == n) break; // p = n 时无需再排序
                }
                sa0 = new int[n];
                for (int i = 0; i < n; i++) sa0[i] = sa[i + 1] - 1;
            }

            // src/index/suffixarray/suffixarray.go:242
            // func (x *Index) lookupAll(s []byte) ints { ... }
            // O(log(N)*len(s)) 优化：1、避免 String#substring 带来的额外开销
            // 2、避免 Arrays.copyOfRange(sa0, i, j) 带来的额外开销，仅返回 i 和 j
            int[] lookupAll(String s) {
//                int i = sortSearch(sa0.length, m -> at(m).compareTo(s) >= 0);
//                int j = i + sortSearch(sa0.length - i, m -> !at(m + i).startsWith(s));
                int i = sortSearch(sa0.length, m -> compareTo(data, sa0[m], s) >= 0);
                int j = i + sortSearch(sa0.length - i, m -> !data.startsWith(s, sa0[m + i]));
                return new int[]{i, j};
            }

            // x.data[x.sa.get(i):]
            private String at(int i) {
                return data.substring(sa0[i]);
            }

            // func Search(n int, f func(int) bool) int { ... }
            private int sortSearch(int n, Function<Integer, Boolean> f) {
                int l = 0, r = n;
                while (l < r) {
                    int mid = l + (r - l) / 2;
                    if (f.apply(mid)) r = mid;
                    else l = mid + 1;
                }
                return l;
            }

            // 等价于 s.substring(beginIndex).compareTo(t)
            private int compareTo(String s, int beginIndex, String t) {
                int len1 = s.length() - beginIndex, len2 = t.length();
                int lim = Math.min(len1, len2);
                for (int k = 0; k < lim; k++) {
                    char c1 = s.charAt(k + beginIndex), c2 = t.charAt(k);
                    if (c1 != c2) return c1 - c2;
                }
                return len1 - len2;
            }
        }
    }

    // AC自动机优化dp O(n√L)解法
    // https://leetcode.cn/problems/construct-string-with-minimum-cost/solutions/2833826/aczi-dong-ji-you-hua-dp-onljie-fa-by-vcl-t6fx/
    static class V2 {
        private static final int INF = (int) 1e9;

        public int minimumCost(String target, String[] words, int[] costs) {
            int n = target.length();
            int m = words.length;

            Node root = new Node(0);
            for (int i = 0; i < m; i++) {
                Node cur = root;
                for (char c : words[i].toCharArray()) {
                    if (cur.next[c - 'a'] == null) {
                        cur.next[c - 'a'] = new Node(cur.len + 1);
                    }
                    cur = cur.next[c - 'a'];
                }
                cur.len = words[i].length();
                cur.cost = Math.min(cur.cost, costs[i]);
            }
            Queue<Node> q = new ArrayDeque<>();
            for (int i = 0; i < 26; i++) {
                if (root.next[i] == null) {
                    root.next[i] = root;
                } else {
                    root.next[i].fail = root;
                    root.next[i].sup_fail = root;
                    q.add(root.next[i]);
                }
            }
            for (; !q.isEmpty(); q.remove()) {
                Node u = q.peek();
                for (int i = 0; i < 26; i++) {
                    if (u.next[i] == null) {
                        u.next[i] = u.fail.next[i];
                    } else {
                        u.next[i].fail = u.fail.next[i];
                        if (u.next[i].fail.cost == INF) {
                            u.next[i].sup_fail = u.next[i].fail.sup_fail;
                        } else {
                            u.next[i].sup_fail = u.next[i].fail;
                        }
                        q.add(u.next[i]);
                    }
                }
            }

            int[] dp = new int[n + 1];
            Node cur = root;
            for (int i = 0; i < n; i++) {
                cur = cur.next[target.charAt(i) - 'a'];
                int min_cost = INF;
                for (Node j = cur; j != null; j = j.sup_fail) {
                    min_cost = Math.min(min_cost, dp[i + 1 - j.len] + j.cost);
                }
                dp[i + 1] = min_cost;
            }
            return dp[n] < INF ? dp[n] : -1;
        }

        static class Node {
            int len, cost;
            Node fail, sup_fail;
            Node[] next;

            public Node(int len) {
                this.len = len;
                cost = INF;
                next = new Node[26];
            }
        }
    }
}
/*
3213. 最小代价构造字符串
https://leetcode.cn/problems/construct-string-with-minimum-cost/description/

第 405 场周赛 T4。

给你一个字符串 target、一个字符串数组 words 以及一个整数数组 costs，这两个数组长度相同。
设想一个空字符串 s。
你可以执行以下操作任意次数（包括零次）：
- 选择一个在范围  [0, words.length - 1] 的索引 i。
- 将 words[i] 追加到 s。
- 该操作的成本是 costs[i]。
返回使 s 等于 target 的 最小 成本。如果不可能，返回 -1。
提示：
1 <= target.length <= 5 * 10^4
1 <= words.length == costs.length <= 5 * 10^4
1 <= words[i].length <= target.length
所有 words[i].length 的总和小于或等于 5 * 10^4
target 和 words[i] 仅由小写英文字母组成。
1 <= costs[i] <= 10^4

字符串哈希 / 后缀数组 / AC 自动机
https://leetcode.cn/problems/construct-string-with-minimum-cost/solutions/2833949/hou-zhui-shu-zu-by-endlesscheng-32h9/
首先，赛时一头扎进 KMP 了，KMP 单次匹配的复杂度是 O(n+m)。因此总体复杂度会变为 O(nL)。
rating 2923 (clist.by)
相似题目: 1044. 最长重复子串
https://leetcode.cn/problems/longest-duplicate-substring/
3008. 找出数组中的美丽下标 II
https://leetcode.cn/problems/find-beautiful-indices-in-the-given-array-ii/description/
3292. 形成目标字符串需要的最少字符串数 II
https://leetcode.cn/problems/minimum-number-of-valid-strings-to-form-target-ii/description/
 */