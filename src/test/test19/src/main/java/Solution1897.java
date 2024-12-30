import java.util.HashMap;
import java.util.Map;

public class Solution1897 {
    public boolean makeEqual(String[] words) {
        int len = words.length;
        Map<Character, Integer> cntMap = new HashMap<>();
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                cntMap.put(ch, cntMap.getOrDefault(ch, 0) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : cntMap.entrySet()) {
            if (entry.getValue() % len != 0) {
                return false;
            }
        }
        return true;
    }
}
/*
1897. 重新分配字符使所有字符串都相等
https://leetcode.cn/problems/redistribute-characters-to-make-all-strings-equal/

第 245 场周赛 T1。

给你一个字符串数组 words（下标 从 0 开始 计数）。
在一步操作中，需先选出两个 不同 下标 i 和 j，其中 words[i] 是一个非空字符串，接着将 words[i] 中的 任一 字符移动到 words[j] 中的 任一 位置上。
如果执行任意步操作可以使 words 中的每个字符串都相等，返回 true ；否则，返回 false 。
提示：
1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] 由小写英文字母组成

各个小写英文字母的总数能整除数组长度即可。
 */
