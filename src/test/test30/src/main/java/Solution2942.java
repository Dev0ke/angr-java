import java.util.ArrayList;
import java.util.List;

public class Solution2942 {
    public List<Integer> findWordsContaining(String[] words, char x) {
        int n = words.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (words[i].contains("" + x)) {
                ans.add(i);
            }
        }
        return ans;
    }
}
/*
2942. 查找包含给定字符的单词
https://leetcode.cn/problems/find-words-containing-character/description/

第 118 场双周赛 T1。

给你一个下标从 0 开始的字符串数组 words 和一个字符 x 。
请你返回一个 下标数组 ，表示下标在数组中对应的单词包含字符 x 。
注意 ，返回的数组可以是 任意 顺序。
提示：
1 <= words.length <= 50
1 <= words[i].length <= 50
x 是一个小写英文字母。
words[i] 只包含小写英文字母。

模拟。
 */