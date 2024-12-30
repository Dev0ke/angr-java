import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionP1258 {
    private Map<String, Integer> idxMap;
    private DSU dsu;
    private List<String> ans;

    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        String[] words = text.split(" ");

        // 将 String 映射到 idx
        int idx = 0;
        idxMap = new HashMap<>();
        for (List<String> synonym : synonyms) {
            for (String s : synonym) {
                idxMap.putIfAbsent(s, idx++);
            }
        }

        // 并查集 处理 近义词
        dsu = new DSU(idx);
        for (List<String> synonym : synonyms) {
            String syn0 = synonym.get(0);
            String syn1 = synonym.get(1);
            dsu.union(idxMap.get(syn0), idxMap.get(syn1));
        }

        // 回溯 + 排序
        ans = new ArrayList<>();
        dfs(words, 0);
        ans.sort(null);
        return ans;
    }

    private void dfs(String[] words, int curI) {
        if (curI == words.length) {
            ans.add(String.join(" ", words));
        } else {
            // 存在近义词，能够交换
            if (idxMap.containsKey(words[curI])) {
                String oldWord = words[curI];
                for (Map.Entry<String, Integer> entry : idxMap.entrySet()) {
                    if (dsu.find(entry.getValue()) == dsu.find(idxMap.get(oldWord))) {
                        String newWord = entry.getKey();
                        words[curI] = newWord;
                        dfs(words.clone(), curI + 1);
                        words[curI] = oldWord;
                    }
                }
            }
            // 不存在近义词
            else {
                dfs(words.clone(), curI + 1);
            }
        }
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
$1258. 近义词句子
https://leetcode.cn/problems/synonymous-sentences/

给你一个近义词表 synonyms 和一个句子 text ， synonyms 表中是一些近义词对 ，你可以将句子 text 中每个单词用它的近义词来替换。
请你找出所有用近义词替换后的句子，按 字典序排序 后返回。
提示：
0 <= synonyms.length <= 10
synonyms[i].length == 2
synonyms[0] != synonyms[1]
所有单词仅包含英文字母，且长度最多为 10 。
text 最多包含 10 个单词，且单词间用单个空格分隔开。

并查集+回溯
并查集处理近义词，然后再跑一次 DFS 得出所有用近义词替换后的句子，排序即可。
时间复杂度 O(n*n!) 最坏情况下，text 每个单词都存在近义词。
空间复杂度 O(n)
相似题目: 46. 全排列
https://leetcode.cn/problems/permutations/
 */