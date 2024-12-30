import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        if (!wordList.contains(beginWord)) {
            wordList.add(beginWord);
        }

        // 建图1 5000*5000*10 420ms
//        int len = wordList.size();
//        Map<String, List<String>> graph = new HashMap<>();
//        for (int i = 0; i < len; i++) {
//            for (int j = i + 1; j < len; j++) {
//                String word1 = wordList.get(i);
//                String word2 = wordList.get(j);
//                if (isAdjacent(word1, word2)) {
//                    graph.computeIfAbsent(word1, key -> new ArrayList<>()).add(word2);
//                    graph.computeIfAbsent(word2, key -> new ArrayList<>()).add(word1);
//                }
//            }
//        }

        // 建图2 5000*25*10 90ms
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
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                String cur = queue.remove();
                if (cur.equals(endWord)) {
                    return step;
                }

                for (String next : graph.getOrDefault(cur, new ArrayList<>())) {
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }
        }
        return 0;
    }

    private boolean isAdjacent(String word1, String word2) {
        int cnt = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                cnt++;
                if (cnt > 1) {
                    return false;
                }
            }
        }
        return cnt == 1;
    }
}
/*
127. 单词接龙
https://leetcode.cn/problems/word-ladder/

字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
- 每一对相邻的单词只差一个字母。
- 对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
- sk == endWord
给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
提示：
1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord、endWord 和 wordList[i] 由小写英文字母组成
beginWord != endWord
wordList 中的所有字符串 互不相同

建图 + BFS 最短路
相似题目: 126. 单词接龙 II
https://leetcode.cn/problems/word-ladder-ii/
 */