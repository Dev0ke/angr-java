import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> resList = new ArrayList<>();

        if (!wordList.contains(endWord)) {
            return resList;
        }

        if (!wordList.contains(beginWord)) {
            wordList.add(beginWord);
        }

        // 建图2 5000*25*5
        Set<String> wordSet = new HashSet<>(wordList);
        Map<String, List<String>> graph = new HashMap<>();
        for (String word1 : wordList) {
            char[] chars = word1.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char old = chars[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (old != ch) {
                        chars[i] = ch;
                        String word2 = new String(chars);
                        if (wordSet.contains(word2)) {
                            graph.computeIfAbsent(word1, key -> new ArrayList<>()).add(word2);
                            graph.computeIfAbsent(word2, key -> new ArrayList<>()).add(word1);
                            wordSet.remove(word1);
                        }
                    }
                }
                chars[i] = old;
            }
        }

        // BFS
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(beginWord, new ArrayList<>()));
        // 记录到该点的最短步数
        Map<String, Integer> distMap = new HashMap<>();
        // 步数
        int step = 0;
        int minStep = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                Node cur = queue.remove();
                if (step > minStep) {
                    return resList;
                }
                if (cur.word.equals(endWord)) {
                    resList.add(cur.memoList);
                    minStep = Math.min(minStep, step);
                }

                for (String next : graph.getOrDefault(cur.word, new ArrayList<>())) {
                    if (distMap.getOrDefault(next, Integer.MAX_VALUE) >= step) {
                        distMap.put(next, step);
                        queue.add(new Node(next, cur.memoList));
                    }
                }
            }
        }
        return resList;
    }

    private static class Node {
        String word;
        List<String> memoList;

        public Node(String str, List<String> memo) {
            this.word = str;
            this.memoList = new ArrayList<>(memo);
            this.memoList.add(str);
        }
    }
}
/*
126. 单词接龙 II
https://leetcode.cn/problems/word-ladder-ii/

按字典 wordList 完成从单词 beginWord 到单词 endWord 转化，一个表示此过程的 转换序列 是形式上像 beginWord -> s1 -> s2 -> ... -> sk 这样的单词序列，并满足：
- 每对相邻的单词之间仅有单个字母不同。
- 转换过程中的每个单词 si（1 <= i <= k）必须是字典 wordList 中的单词。注意，beginWord 不必是字典 wordList 中的单词。
- sk == endWord
给你两个单词 beginWord 和 endWord ，以及一个字典 wordList 。请你找出并返回所有从 beginWord 到 endWord 的 最短转换序列 ，
如果不存在这样的转换序列，返回一个空列表。每个序列都应该以单词列表 [beginWord, s1, s2, ..., sk] 的形式返回。
提示：
1 <= beginWord.length <= 5
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord、endWord 和 wordList[i] 由小写英文字母组成
beginWord != endWord
wordList 中的所有单词 互不相同

建图 + BFS 最短路（带回溯）
相似题目: 127. 单词接龙
https://leetcode.cn/problems/word-ladder/
 */