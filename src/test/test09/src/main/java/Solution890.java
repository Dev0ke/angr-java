import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> resList = new ArrayList<>();
        for (String word : words) {
            if (match(word, pattern) && match(pattern, word)) {
                resList.add(word);
            }
        }
        return resList;
    }

    private boolean match(String s, String t) {
        int n = s.length();
        int[] mp = new int[26];
        Arrays.fill(mp, -1);
        for (int i = 0; i < n; i++) {
            int x = s.charAt(i) - 'a';
            int y = t.charAt(i) - 'a';
            if (mp[x] == -1) {
                mp[x] = y;
            } else {
                if (mp[x] != y) {
                    return false;
                }
            }
        }
        return true;
    }
}
/*
890. 查找和替换模式
https://leetcode.cn/problems/find-and-replace-pattern/

你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
（回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
返回 words 中与给定模式匹配的单词列表。
你可以按任何顺序返回答案。
提示：
1 <= words.length <= 50
1 <= pattern.length = words[i].length <= 20

哈希表
时间复杂度 O(nm)
相似题目: $1153. 字符串转化
https://leetcode.cn/problems/string-transforms-into-another-string/
 */