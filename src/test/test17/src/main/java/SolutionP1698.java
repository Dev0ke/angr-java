import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionP1698 {
    // 后缀数组
    static class V1 {
        public int countDistinct(String s) {
            int n = s.length();
            SuffixArray suffixArray = new SuffixArray(s);
            int[] height = suffixArray.height;
            int ans = n * (n + 1) / 2;
            return ans - Arrays.stream(height).sum();
        }

        // https://oi-wiki.org/string/sa/
        static class SuffixArray {
            String data;
            int[] rk, old_rk, sa, id, cnt;
            int[] sa0; // 下标从 0 开始
            int[] height;

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
                // height
                height = new int[n + 1];
                int k = 0;
                for (int i = 1; i <= n; i++) {
                    if (rk[i] == 1) continue;
                    if (k > 0) --k;
                    int j = sa[rk[i] - 1];
                    while (i + k <= n && j + k <= n && s[i + k] == s[j + k]) k++;
                    height[rk[i]] = k;
                }
            }
        }
    }

    // 后缀自动机
    static class V2 {
        public int countDistinct(String s) {
            Sam sam = new Sam();
            sam.buildSam(s);
            int ans = 0;
            for (int i = 1; i < sam.nodes.size(); i++) {
                Node o = sam.nodes.get(i);
                ans += o.len - o.fa.len;
            }
            return ans;
        }

        static class Node {
            Node fa;
            Node[] ch = new Node[26];
            int len;

            public Node(Node fa, int len) {
                this.fa = fa;
                this.len = len;
            }
        }

        static class Sam {
            List<Node> nodes = new ArrayList<>();
            Node last;

            public Sam() {
                last = new Node(null, 0);
                nodes.add(last);
            }

            private Node newNode(Node fa, int len) {
                Node newNode = new Node(fa, len);
                nodes.add(newNode);
                return newNode;
            }

            public void append(char c) {
                int index = c - 'a';
                Node last = newNode(nodes.get(0), this.last.len + 1);
                for (Node o = this.last; o != null; o = o.fa) {
                    Node p = o.ch[index];
                    if (p == null) {
                        o.ch[index] = last;
                        continue;
                    }
                    if (o.len + 1 == p.len) {
                        last.fa = p;
                    } else {
                        Node np = newNode(p.fa, o.len + 1);
                        np.ch = p.ch.clone(); // Assuming shallow copy is enough for this problem
                        p.fa = np;
                        for (; o != null && o.ch[index] == p; o = o.fa) {
                            o.ch[index] = np;
                        }
                        last.fa = np;
                    }
                    break;
                }
                this.last = last;
            }

            public void buildSam(String s) {
                for (char c : s.toCharArray()) {
                    append(c);
                }
            }
        }
    }
}
/*
$1698. 字符串的不同子字符串个数
https://leetcode.cn/problems/number-of-distinct-substrings-in-a-string/description/

给定一个字符串 s，返回 s 的不同子字符串的个数。
字符串的 子字符串 是由原字符串删除开头若干个字符（可能是 0 个）并删除结尾若干个字符（可能是 0 个）形成的字符串。
提示：
1 <= s.length <= 500
s 由小写英文字母组成。
进阶：你可以以 O(n) 时间复杂度解决此问题吗？

https://leetcode.cn/problems/number-of-distinct-substrings-in-a-string/solutions/866306/on-hou-zhui-shu-zu-by-endlesscheng-jo3p/
方法一：后缀数组
用所有子串的个数，减去相同子串的个数，就可以得到不同子串的个数。
计算后缀数组和高度数组。根据高度数组的定义，所有高度之和就是相同子串的个数。
方法二：后缀自动机
后缀自动机每个节点都存储着该等价类中的子串，且所有子串互不相同，因此累加节点等价类的大小即为答案。
 */