import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionP734 {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        int n = sentence1.length;
        int m = sentence2.length;
        if (n != m) {
            return false;
        }
        Map<String, Set<String>> similarMap = new HashMap<>();
        for (List<String> similarPair : similarPairs) {
            String u = similarPair.get(0);
            String v = similarPair.get(1);
            similarMap.computeIfAbsent(u, key -> new HashSet<>()).add(v);
            similarMap.computeIfAbsent(v, key -> new HashSet<>()).add(u);
        }
        for (int i = 0; i < n; i++) {
            if (!sentence1[i].equals(sentence2[i])
                    && !similarMap.getOrDefault(sentence1[i], new HashSet<>()).contains(sentence2[i])) {
                return false;
            }
        }
        return true;
    }
}
/*
$734. 句子相似性
https://leetcode.cn/problems/sentence-similarity/

我们可以将一个句子表示为一个单词数组，例如，句子 "I am happy with leetcode" 可以表示为 arr = ["I","am",happy","with","leetcode"]
给定两个句子 sentence1 和 sentence2 分别表示为一个字符串数组，并给定一个字符串对 similarPairs ，其中 similarPairs[i] = [xi, yi] 表示两个单词 xi and yi 是相似的。
如果 sentence1 和 sentence2 相似则返回 true ，如果不相似则返回 false 。
两个句子是相似的，如果:
- 它们具有 相同的长度 (即相同的字数)
- sentence1[i] 和 sentence2[i] 是相似的
请注意，一个词总是与它自己相似，也请注意，相似关系是不可传递的。例如，如果单词 a 和 b 是相似的，单词 b 和 c 也是相似的，那么 a 和 c  不一定相似 。
提示:
1 <= sentence1.length, sentence2.length <= 1000
1 <= sentence1[i].length, sentence2[i].length <= 20
sentence1[i] 和 sentence2[i] 只包含大小写英文字母
0 <= similarPairs.length <= 2000
similarPairs[i].length == 2
1 <= xi.length, yi.length <= 20
所有对 (xi, yi) 都是 不同 的

HashMap模拟。
可以转化为无向图模型，由于 相似关系不可传递，因此 遍历深度为 1 即可。
 */