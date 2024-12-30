import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1807 {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> kv : knowledge) {
            map.put(kv.get(0), kv.get(1));
        }

        boolean inBlock = false;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder block = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                inBlock = true;
            } else if (ch == ')') {
                inBlock = false;
                String key = block.toString();
                stringBuilder.append(map.getOrDefault(key, "?"));
                block.delete(0, block.length());
            } else {
                if (inBlock) {
                    block.append(ch);
                } else {
                    stringBuilder.append(ch);
                }
            }
        }
        return stringBuilder.toString();
    }
}
/*
1807. 替换字符串中的括号内容
https://leetcode.cn/problems/evaluate-the-bracket-pairs-of-a-string/

给你一个字符串 s ，它包含一些括号对，每个括号中包含一个 非空 的键。
- 比方说，字符串 "(name)is(age)yearsold" 中，有 两个 括号对，分别包含键 "name" 和 "age" 。
你知道许多键对应的值，这些关系由二维字符串数组 knowledge 表示，其中 knowledge[i] = [keyi, valuei] ，表示键 keyi 对应的值为 valuei 。
你需要替换 所有 的括号对。当你替换一个括号对，且它包含的键为 keyi 时，你需要：
- 将 keyi 和括号用对应的值 valuei 替换。
- 如果从 knowledge 中无法得知某个键对应的值，你需要将 keyi 和括号用问号 "?" 替换（不需要引号）。
knowledge 中每个键最多只会出现一次。s 中不会有嵌套的括号。
请你返回替换 所有 括号对后的结果字符串。
提示：
1 <= s.length <= 10^5
0 <= knowledge.length <= 10^5
knowledge[i].length == 2
1 <= keyi.length, valuei.length <= 10
s 只包含小写英文字母和圆括号 '(' 和 ')' 。
s 中每一个左圆括号 '(' 都有对应的右圆括号 ')' 。
s 中每对括号内的键都不会为空。
s 中不会有嵌套括号对。
keyi 和 valuei 只包含小写英文字母。
knowledge 中的 keyi 不会重复。

HashMap + 遍历
 */