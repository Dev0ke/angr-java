import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution828 {
    public int uniqueLetterString(String s) {
        int len = s.length();
        Map<Character, List<Integer>> idxListMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            idxListMap.computeIfAbsent(s.charAt(i), key -> new ArrayList<>()).add(i);
        }

        int res = 0;
        for (Map.Entry<Character, List<Integer>> entry : idxListMap.entrySet()) {
            List<Integer> idxList = entry.getValue();
            int size = idxList.size();
            for (int i = 0; i < size; i++) {
                int pre = -1;
                int cur = idxList.get(i);
                int next = len;
                if (i - 1 >= 0) {
                    pre = idxList.get(i - 1);
                }
                if (i + 1 < size) {
                    next = idxList.get(i + 1);
                }
                res += (cur - pre) * (next - cur);
            }
        }
        return res;
    }
}
/*
828. 统计子串中的唯一字符
https://leetcode.cn/problems/count-unique-characters-of-all-substrings-of-a-given-string/

我们定义了一个函数 countUniqueChars(s) 来统计字符串 s 中的唯一字符，并返回唯一字符的个数。
例如：s = "LEETCODE" ，则其中 "L", "T","C","O","D" 都是唯一字符，因为它们只出现一次，所以 countUniqueChars(s) = 5 。
本题将会给你一个字符串 s ，我们需要返回 countUniqueChars(t) 的总和，其中 t 是 s 的子字符串。输入用例保证返回值为 32 位整数。
注意，某些子字符串可能是重复的，但你统计时也必须算上这些重复的子字符串（也就是说，你必须统计 s 的所有子字符串中的唯一字符）。
提示：
1 <= s.length <= 10^5
s 只包含大写英文字符

分别计算每个字符的贡献
相似题目: 2262. 字符串的总引力
https://leetcode.cn/problems/total-appeal-of-a-string/
 */