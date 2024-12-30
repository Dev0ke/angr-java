import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Solution500 {
    private static final Set<Character> SET1 = Set.of('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p');
    private static final Set<Character> SET2 = Set.of('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l');
    private static final Set<Character> SET3 = Set.of('z', 'x', 'c', 'v', 'b', 'n', 'm');

    public String[] findWords(String[] words) {
        List<String> resList = new ArrayList<>();
        for (String word : words) {
            Set<Character> curSet = getSet(word);
            if (SET1.containsAll(curSet) || SET2.containsAll(curSet) || SET3.containsAll(curSet)) {
                resList.add(word);
            }
        }
        return resList.toArray(String[]::new);
    }

    private Set<Character> getSet(String word) {
        Set<Character> set = new HashSet<>();
        for (char ch : word.toLowerCase(Locale.ENGLISH).toCharArray()) {
            set.add(ch);
        }
        return set;
    }
}
/*
500. 键盘行
https://leetcode.cn/problems/keyboard-row/

给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
美式键盘 中：
- 第一行由字符 "qwertyuiop" 组成。
- 第二行由字符 "asdfghjkl" 组成。
- 第三行由字符 "zxcvbnm" 组成。
提示：
1 <= words.length <= 20
1 <= words[i].length <= 100
words[i] 由英文字母（小写和大写字母）组成

HashSet 集合判断即可。
 */