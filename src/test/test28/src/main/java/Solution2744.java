import java.util.HashMap;
import java.util.Map;

public class Solution2744 {
    public int maximumNumberOfStringPairs(String[] words) {
        Map<String, Integer> cntMap = new HashMap<>();
        int ans = 0;
        for (String word : words) {
            String revWord = new StringBuilder(word).reverse().toString();
            Integer cnt = cntMap.getOrDefault(revWord, 0);
            if (cnt > 0) {
                ans++;
                cntMap.put(revWord, cnt - 1);
            } else {
                cntMap.put(word, cntMap.getOrDefault(word, 0) + 1);
            }
        }
        return ans;
    }
}
/*
2744. 最大字符串配对数目
https://leetcode.cn/problems/find-maximum-number-of-string-pairs/

第 107 场双周赛 T1。

给你一个下标从 0 开始的数组 words ，数组中包含 互不相同 的字符串。
如果字符串 words[i] 与字符串 words[j] 满足以下条件，我们称它们可以匹配：
- 字符串 words[i] 等于 words[j] 的反转字符串。
- 0 <= i < j < words.length
请你返回数组 words 中的 最大 匹配数目。
注意，每个字符串最多匹配一次。
提示：
1 <= words.length <= 50
words[i].length == 2
words 包含的字符串互不相同。
words[i] 只包含小写英文字母。

哈希表
 */