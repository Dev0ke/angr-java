import java.util.ArrayList;
import java.util.List;

public class Solution2452 {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> resList = new ArrayList<>();
        for (String query : queries) {
            if (check(query, dictionary)) {
                resList.add(query);
            }
        }
        return resList;
    }

    private boolean check(String query, String[] dictionary) {
        int n = query.length();
        for (String dict : dictionary) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (query.charAt(i) != dict.charAt(i)) {
                    cnt++;
                }
            }
            if (cnt <= 2) {
                return true;
            }
        }
        return false;
    }
}
/*
2452. 距离字典两次编辑以内的单词
https://leetcode.cn/problems/words-within-two-edits-of-dictionary/

第 90 场双周赛 T2。

给你两个字符串数组 queries 和 dictionary 。数组中所有单词都只包含小写英文字母，且长度都相同。
一次 编辑 中，你可以从 queries 中选择一个单词，将任意一个字母修改成任何其他字母。
从 queries 中找到所有满足以下条件的字符串：不超过 两次编辑内，字符串与 dictionary 中某个字符串相同。
请你返回 queries 中的单词列表，这些单词距离 dictionary 中的单词 编辑次数 不超过 两次 。单词返回的顺序需要与 queries 中原本顺序相同。
提示：
1 <= queries.length, dictionary.length <= 100
n == queries[i].length == dictionary[j].length
1 <= n <= 100
所有 queries[i] 和 dictionary[j] 都只包含小写英文字母。

暴力模拟。
时间复杂度 O(n^2)
 */