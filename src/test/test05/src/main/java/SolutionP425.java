import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SolutionP425 {
    private String[] words;
    private Map<String, List<String>> prefixMap;

    public List<List<String>> wordSquares(String[] words) {
        this.words = words;
        prefixMap = new HashMap<>();
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                String prefix = word.substring(0, i);
                prefixMap.computeIfAbsent(prefix, key -> new ArrayList<>()).add(word);
            }
        }

        List<List<String>> resList = new ArrayList<>();
        for (String word : words) {
            LinkedList<String> wordSquares = new LinkedList<>();
            wordSquares.addLast(word);
            dfs(1, wordSquares, resList);
        }
        return resList;
    }

    private void dfs(int i, LinkedList<String> wordSquares, List<List<String>> resList) {
        if (i == words[0].length()) {
            resList.add(new ArrayList<>(wordSquares));
            return;
        }
        StringBuilder prefix = new StringBuilder();
        for (String word : wordSquares) {
            prefix.append(word.charAt(i));
        }
        for (String candidate : prefixMap.getOrDefault(prefix.toString(), new ArrayList<>())) {
            wordSquares.addLast(candidate);
            dfs(i + 1, wordSquares, resList);
            wordSquares.removeLast();
        }
    }
}
/*
$425. 单词方块
https://leetcode.cn/problems/word-squares/

给定一个单词集合 words （没有重复），找出并返回其中所有的 单词方块 。 words 中的同一个单词可以被 多次 使用。你可以按 任意顺序 返回答案。
一个单词序列形成了一个有效的 单词方块 的意思是指从第 k 行和第 k 列  0 <= k < max(numRows, numColumns) 来看都是相同的字符串。
- 例如，单词序列 ["ball","area","lead","lady"] 形成了一个单词方块，因为每个单词从水平方向看和从竖直方向看都是相同的。
提示:
1 <= words.length <= 1000
1 <= words[i].length <= 4
words[i] 长度相同
words[i] 只由小写英文字母组成
words[i] 都 各不相同

使用哈希表回溯
时间复杂度 O(N·26^L) 其中 N 是输入单词列表的单词数量和 L 指的是单词的长度。
 */