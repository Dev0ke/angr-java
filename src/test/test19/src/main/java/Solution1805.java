import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution1805 {
    public int numDifferentIntegers(String word) {
        char[] chars = word.toCharArray();
        Set<String> hashSet = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : chars) {
            if (!Character.isDigit(ch)) {
                if (!stringBuilder.isEmpty()) {
                    hashSet.add(delLeadingZeros(stringBuilder));
                    stringBuilder.delete(0, stringBuilder.length());
                }
            } else {
                stringBuilder.append(ch);
            }
        }
        if (!stringBuilder.isEmpty()) {
            hashSet.add(delLeadingZeros(stringBuilder));
        }
        return hashSet.size();
    }

    private String delLeadingZeros(StringBuilder stringBuilder) {
        while (stringBuilder.length() > 1 && stringBuilder.charAt(0) == '0') {
            stringBuilder.deleteCharAt(0);
        }
        return stringBuilder.toString();
    }

    public int numDifferentIntegers2(String word) {
        return Arrays.stream(word.replaceAll("[^0-9]+", " ").trim().split(" "))
                .filter(o -> !o.isEmpty())
                .map(o -> o.replaceAll("^0+", ""))
                .collect(Collectors.toSet()).size();
    }
}
/*
1805. 字符串中不同整数的数目
https://leetcode.cn/problems/number-of-different-integers-in-a-string/

给你一个字符串 word ，该字符串由数字和小写英文字母组成。
请你用空格替换每个不是数字的字符。例如，"a123bc34d8ef34" 将会变成 " 123  34 8  34" 。注意，剩下的这些整数为（相邻彼此至少有一个空格隔开）："123"、"34"、"8" 和 "34" 。
返回对 word 完成替换后形成的 不同 整数的数目。
只有当两个整数的 不含前导零 的十进制表示不同， 才认为这两个整数也不同。
提示：
1 <= word.length <= 1000
word 由数字和小写英文字母组成

模拟 / 正则替换
 */