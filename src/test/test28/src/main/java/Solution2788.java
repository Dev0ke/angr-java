import java.util.ArrayList;
import java.util.List;

public class Solution2788 {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            String[] split = word.split(java.util.regex.Pattern.quote(String.valueOf(separator)));
            for (String s : split) {
                if (s.length() > 0) {
                    ans.add(s);
                }
            }
        }
        return ans;
    }
}
/*
2788. 按分隔符拆分字符串
https://leetcode.cn/problems/split-strings-by-separator/

第 355 场周赛 T1。

给你一个字符串数组 words 和一个字符 separator ，请你按 separator 拆分 words 中的每个字符串。
返回一个由拆分后的新字符串组成的字符串数组，不包括空字符串 。
注意
- separator 用于决定拆分发生的位置，但它不包含在结果字符串中。
- 拆分可能形成两个以上的字符串。
- 结果字符串必须保持初始相同的先后顺序。
提示：
1 <= words.length <= 100
1 <= words[i].length <= 20
words[i] 中的字符要么是小写英文字母，要么就是字符串 ".,|$#@" 中的字符（不包括引号）
separator 是字符串 ".,|$#@" 中的某个字符（不包括引号）

库函数
String#split()
Pattern#quote()
 */