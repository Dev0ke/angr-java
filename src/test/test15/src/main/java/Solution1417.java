import java.util.ArrayList;
import java.util.List;

public class Solution1417 {
    public String reformat(String s) {
        List<Character> digitList = new ArrayList<>();
        List<Character> noDigitList = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                digitList.add(ch);
            } else {
                noDigitList.add(ch);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        if (digitList.size() == noDigitList.size() + 1 || digitList.size() == noDigitList.size()) {
            for (int i = 0; i < noDigitList.size(); i++) {
                stringBuilder.append(digitList.get(i)).append(noDigitList.get(i));
            }
            if (digitList.size() == noDigitList.size() + 1) {
                return stringBuilder.append(digitList.get(digitList.size() - 1)).toString();
            } else {
                return stringBuilder.toString();
            }
        } else if (digitList.size() + 1 == noDigitList.size()) {
            for (int i = 0; i < digitList.size(); i++) {
                stringBuilder.append(noDigitList.get(i)).append(digitList.get(i));
            }
            return stringBuilder.append(noDigitList.get(noDigitList.size() - 1)).toString();
        }
        return "";
    }
}
/*
1417. 重新格式化字符串
https://leetcode.cn/problems/reformat-the-string/

给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
提示：
1 <= s.length <= 500
s 仅由小写英文字母和/或数字组成。
 */