import java.util.HashMap;
import java.util.Map;

public class Solution2131 {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> cntMap = new HashMap<>();
        for (String word : words) {
            cntMap.put(word, cntMap.getOrDefault(word, 0) + 1);
        }

        // 分类讨论
        int maxLen = 0;
        boolean pickXx = false;
        for (Map.Entry<String, Integer> entry : cntMap.entrySet()) {
            String key = entry.getKey();
            String reverseKey = new StringBuilder(key).reverse().toString();
            // xy - yx
            if (!key.equals(reverseKey)) {
                int val = Math.min(entry.getValue(), cntMap.getOrDefault(reverseKey, 0));
                maxLen += val * 2;
            }
            // xx - xx
            else {
                maxLen += entry.getValue() / 2 * 4;
                if (entry.getValue() % 2 == 1) {
                    if (!pickXx) {
                        pickXx = true;
                        maxLen += 2;
                    }
                }
            }
        }
        return maxLen;
    }
}
/*
2131. 连接两字母单词得到的最长回文串
https://leetcode.cn/problems/longest-palindrome-by-concatenating-two-letter-words/

第 69 场双周赛 T3。

给你一个字符串数组 words 。words 中每个元素都是一个包含 两个 小写英文字母的单词。
请你从 words 中选择一些元素并按 任意顺序 连接它们，并得到一个 尽可能长的回文串 。每个元素 至多 只能使用一次。
请你返回你能得到的最长回文串的 长度 。如果没办法得到任何一个回文串，请你返回 0 。
回文串 指的是从前往后和从后往前读一样的字符串。
提示：
1 <= words.length <= 10^5
words[i].length == 2
words[i] 仅包含小写英文字母。

分类讨论。
如果有奇数个对称（如 xx），贡献值 2
其余情况 xy-yx 或者 xx-xx，一对贡献值 4。
时间复杂度 O(n)
 */