import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SolutionP288 {
    static class ValidWordAbbr {
        // abbr, [words]
        private final Map<String, Set<String>> map;

        public ValidWordAbbr(String[] dictionary) {
            map = new HashMap<>();
            for (String word : dictionary) {
                String abbr = abbreviation(word);
                map.computeIfAbsent(abbr, key -> new HashSet<>()).add(word);
            }
        }

        public boolean isUnique(String word) {
            String abbr = abbreviation(word);
            if (!map.containsKey(abbr)) {
                // 字典 dictionary 中没有任何其他单词的 缩写 与该单词 word 的 缩写 相同。
                return true;
            }
            Set<String> words = map.get(abbr);
            // 字典 dictionary 中的所有 缩写 与该单词 word 的 缩写 相同的单词都与 word 相同 。
            return words.size() == 1 && words.contains(word);
        }

        private String abbreviation(String word) {
            int len = word.length();
            if (len > 2) {
                return "" + word.charAt(0) + (len - 2) + word.charAt(len - 1);
            }
            return word;
        }
    }
}
/*
$288. 单词的唯一缩写
https://leetcode.cn/problems/unique-word-abbreviation/

单词的 缩写 需要遵循 <起始字母><中间字母数><结尾字母> 这样的格式。如果单词只有两个字符，那么它就是它自身的 缩写 。
以下是一些单词缩写的范例：
- dog --> d1g 因为第一个字母 'd' 和最后一个字母 'g' 之间有 1 个字母
- internationalization --> i18n 因为第一个字母 'i' 和最后一个字母 'n' 之间有 18 个字母
- it --> it 单词只有两个字符，它就是它自身的 缩写
实现 ValidWordAbbr 类：
- ValidWordAbbr(String[] dictionary) 使用单词字典 dictionary 初始化对象
- boolean isUnique(string word) 如果满足下述任意一个条件，返回 true ；否则，返回 false ：
  - 字典 dictionary 中没有任何其他单词的 缩写 与该单词 word 的 缩写 相同。
  - 字典 dictionary 中的所有 缩写 与该单词 word 的 缩写 相同的单词都与 word 相同 。
提示：
1 <= dictionary.length <= 3 * 10^4
1 <= dictionary[i].length <= 20
dictionary[i] 由小写英文字母组成
1 <= word <= 20
word 由小写英文字母组成
最多调用 5000 次 isUnique

模拟。
 */