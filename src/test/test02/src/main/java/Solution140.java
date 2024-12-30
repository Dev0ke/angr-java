import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution140 {
    private String s;
    private Set<String> wordDictSet;
    private Map<Integer, List<List<String>>> memoMap;

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        wordDictSet = new HashSet<>(wordDict);
        memoMap = new HashMap<>();
        List<List<String>> wordBreaks = dfs(0);

        // => List<String>
        List<String> resList = new ArrayList<>();
        for (List<String> wordBreak : wordBreaks) {
            resList.add(String.join(" ", wordBreak));
        }
        return resList;
    }

    private List<List<String>> dfs(int idx) {
        if (memoMap.containsKey(idx)) {
            return memoMap.get(idx);
        }

        List<List<String>> wordBreaks = new ArrayList<>();
        if (idx == s.length()) {
            wordBreaks.add(new ArrayList<>());
        }
        for (int i = idx + 1; i <= s.length(); i++) {
            String word = s.substring(idx, i);
            if (wordDictSet.contains(word)) {
                List<List<String>> newWordBreaks = dfs(i);
                for (List<String> newWordBreak : newWordBreaks) {
                    LinkedList<String> wordBreak = new LinkedList<>(newWordBreak);
                    wordBreak.addFirst(word);
                    wordBreaks.add(wordBreak);
                }
            }
        }
        memoMap.put(idx, wordBreaks);
        return memoMap.get(idx);
    }
}
/*
140. 单词拆分 II
https://leetcode.cn/problems/word-break-ii/

给定一个字符串 s 和一个字符串字典 wordDict ，在字符串 s 中增加空格来构建一个句子，使得句子中所有的单词都在词典中。以任意顺序 返回所有这些可能的句子。
注意：词典中的同一个单词可能在分段中被重复使用多次。
提示：
1 <= s.length <= 20
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 10
s 和 wordDict[i] 仅有小写英文字母组成
wordDict 中所有字符串都 不同

记忆化搜索
时间复杂度 O(n*2^n) 理论上界 20*2^20 = 20,971,520
空间复杂度 O(n*2^n)
相似题目: 139. 单词拆分
https://leetcode.cn/problems/word-break/
 */