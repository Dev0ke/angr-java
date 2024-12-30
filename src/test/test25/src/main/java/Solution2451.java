import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2451 {
    public String oddString(String[] words) {
        Map<String, List<Integer>> cntMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            int len = words[i].length();
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 1; j < len; j++) {
                int difference = (words[i].charAt(j) - words[i].charAt(j - 1) + 26) % 26;
                stringBuilder.append(difference).append(":");
            }
            cntMap.computeIfAbsent(stringBuilder.toString(), key -> new ArrayList<>()).add(i);
        }
        for (List<Integer> value : cntMap.values()) {
            if (value.size() == 1) {
                return words[value.get(0)];
            }
        }
        return null;
    }
}
/*
2451. 差值数组不同的字符串
https://leetcode.cn/problems/odd-string-difference/

第 90 场双周赛 T1。

给你一个字符串数组 words ，每一个字符串长度都相同，令所有字符串的长度都为 n 。
每个字符串 words[i] 可以被转化为一个长度为 n - 1 的 差值整数数组 difference[i] ，其中对于 0 <= j <= n - 2 有 difference[i][j] = words[i][j+1] - words[i][j] 。注意两个字母的差值定义为它们在字母表中 位置 之差，也就是说 'a' 的位置是 0 ，'b' 的位置是 1 ，'z' 的位置是 25 。
- 比方说，字符串 "acb" 的差值整数数组是 [2 - 0, 1 - 2] = [2, -1] 。
words 中所有字符串 除了一个字符串以外 ，其他字符串的差值整数数组都相同。你需要找到那个不同的字符串。
请你返回 words中 差值整数数组 不同的字符串。
提示：
3 <= words.length <= 100
n == words[i].length
2 <= n <= 20
words[i] 只含有小写英文字母。

HashMap 统计
 */