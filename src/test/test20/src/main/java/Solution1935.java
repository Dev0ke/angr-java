import java.util.HashSet;
import java.util.Set;

public class Solution1935 {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> brokenLettersSet = new HashSet<>();
        for (char ch : brokenLetters.toCharArray()) {
            brokenLettersSet.add(ch);
        }
        String[] strs = text.split(" ");
        int res = 0;
        for (String str : strs) {
            if (isStrContainBrokenLetters(str, brokenLettersSet)) {
                res++;
            }
        }
        return res;
    }

    private boolean isStrContainBrokenLetters(String str, Set<Character> brokenLettersSet) {
        for (char ch : str.toCharArray()) {
            if (brokenLettersSet.contains(ch)) {
                return false;
            }
        }
        return true;
    }
}
/*
1935. 可以输入的最大单词数
https://leetcode.cn/problems/maximum-number-of-words-you-can-type/

第 250 场周赛 T1。

键盘出现了一些故障，有些字母键无法正常工作。而键盘上所有其他键都能够正常工作。
给你一个由若干单词组成的字符串 text ，单词间由单个空格组成（不含前导和尾随空格）；另有一个字符串 brokenLetters ，
由所有已损坏的不同字母键组成，返回你可以使用此键盘完全输入的 text 中单词的数目。
提示：
1 <= text.length <= 10^4
0 <= brokenLetters.length <= 26
text 由若干用单个空格分隔的单词组成，且不含任何前导和尾随空格
每个单词仅由小写英文字母组成
brokenLetters 由 互不相同 的小写英文字母组成

根据题意进行模拟即可
 */