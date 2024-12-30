import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution1268 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie root = new Trie();
        for (String word : products) {
            addWord(root, word);
        }

        List<List<String>> ans = new ArrayList<>();
        Trie cur = root;
        boolean flag = false;
        for (char ch : searchWord.toCharArray()) {
            if (flag || !cur.child.containsKey(ch)) {
                ans.add(new ArrayList<>());
                flag = true;
            } else {
                cur = cur.child.get(ch);
                List<String> selects = new ArrayList<>();
                while (!cur.words.isEmpty()) {
                    selects.add(cur.words.remove());
                }
                Collections.reverse(selects);
                ans.add(selects);
            }
        }
        return ans;
    }

    void addWord(Trie root, String word) {
        Trie cur = root;
        for (char ch : word.toCharArray()) {
            if (!cur.child.containsKey(ch)) {
                cur.child.put(ch, new Trie());
            }
            cur = cur.child.get(ch);
            cur.words.add(word);
            if (cur.words.size() > 3) {
                cur.words.remove();
            }
        }
    }

    static class Trie {
        Map<Character, Trie> child = new HashMap<>();
        PriorityQueue<String> words = new PriorityQueue<>(Comparator.reverseOrder());
    }
}
/*
1268. 搜索推荐系统
https://leetcode.cn/problems/search-suggestions-system/description/

给你一个产品数组 products 和一个字符串 searchWord ，products  数组中每个产品都是一个字符串。
请你设计一个推荐系统，在依次输入单词 searchWord 的每一个字母后，推荐 products 数组中前缀与 searchWord 相同的最多三个产品。如果前缀相同的可推荐产品超过三个，请按字典序返回最小的三个。
请你以二维列表的形式，返回在输入 searchWord 每个字母后相应的推荐产品的列表。
提示：
1 <= products.length <= 1000
1 <= Σ products[i].length <= 2 * 10^4
products[i] 中所有的字符都是小写英文字母。
1 <= searchWord.length <= 1000
searchWord 中所有字符都是小写英文字母。

字典树 + 优先队列。
时间复杂度 O(LS)。其中 L = sum(|products[i].length|)。
 */