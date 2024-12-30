import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionP737 {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        // 预处理，将 String 映射成 idx 编号
        Map<String, Integer> mp = new HashMap<>();
        int idx = 0;
        for (String s : sentence1) {
            mp.putIfAbsent(s, idx++);
        }
        for (String s : sentence2) {
            mp.putIfAbsent(s, idx++);
        }
        for (List<String> similarPair : similarPairs) {
            for (String s : similarPair) {
                mp.putIfAbsent(s, idx++);
            }
        }

        // 并查集
        DSU dsu = new DSU(idx);
        for (List<String> similarPair : similarPairs) {
            int idx0 = mp.get(similarPair.get(0));
            for (int i = 1; i < similarPair.size(); i++) {
                int idxi = mp.get(similarPair.get(i));
                dsu.union(idx0, idxi);
            }
        }

        // 判等
        if (sentence1.length != sentence2.length) return false;
        for (int i = 0; i < sentence1.length; i++) {
            int idx1 = mp.get(sentence1[i]);
            int idx2 = mp.get(sentence2[i]);
            if (dsu.find(idx1) != dsu.find(idx2)) {
                return false;
            }
        }
        return true;
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
$737. 句子相似性 II
https://leetcode.cn/problems/sentence-similarity-ii/

我们可以将一个句子表示为一个单词数组，例如，句子 I am happy with leetcode"可以表示为 arr = ["I","am",happy","with","leetcode"]
给定两个句子 sentence1 和 sentence2 分别表示为一个字符串数组，并给定一个字符串对 similarPairs ，其中 similarPairs[i] = [xi, yi] 表示两个单词 xi 和 yi 是相似的。
如果 sentence1 和 sentence2 相似则返回 true ，如果不相似则返回 false 。
两个句子是相似的，如果:
- 它们具有 相同的长度 (即相同的字数)
- sentence1[i] 和 sentence2[i] 是相似的
请注意，一个词总是与它自己相似，也请注意，相似关系是可传递的。例如，如果单词 a 和 b 是相似的，单词 b 和 c 也是相似的，那么 a 和 c 也是 相似 的。
提示:
1 <= sentence1.length, sentence2.length <= 1000
1 <= sentence1[i].length, sentence2[i].length <= 20
sentence1[i] 和 sentence2[i] 只包含大小写英文字母
0 <= similarPairs.length <= 2000
similarPairs[i].length == 2
1 <= xi.length, yi.length <= 20
xi 和 yi 只含英文字母

并查集。
 */