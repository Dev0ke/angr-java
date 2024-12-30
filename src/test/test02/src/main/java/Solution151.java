import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution151 {
    public String reverseWords(String s) {
        List<String> list = Arrays.stream(s.trim().split(" "))
                .filter(s1 -> s1.length() != 0)
                .collect(Collectors.toList());
        Collections.reverse(list);
        return String.join(" ", list);
    }
}
/*
151. 翻转字符串里的单词
https://leetcode.cn/problems/reverse-words-in-a-string/

给你一个字符串 s ，颠倒字符串中 单词 的顺序。
单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
提示：
1 <= s.length <= 10^4
s 包含英文大小写字母、数字和空格 ' '
s 中 至少存在一个 单词
进阶：如果字符串在你使用的编程语言中是一种可变数据类型，请尝试使用 O(1) 额外空间复杂度的 原地 解法。

同: 剑指 Offer 58 - I. 翻转单词顺序
https://leetcode.cn/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 */