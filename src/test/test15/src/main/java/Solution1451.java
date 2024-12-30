import java.util.Arrays;
import java.util.Comparator;

public class Solution1451 {
    public String arrangeWords(String text) {
        String[] sp = text.toLowerCase().split(" ");
        Arrays.sort(sp, Comparator.comparingInt(String::length));
        sp[0] = sp[0].substring(0, 1).toUpperCase() + sp[0].substring(1);
        return String.join(" ", sp);
    }
}
/*
1451. 重新排列句子中的单词
https://leetcode.cn/problems/rearrange-words-in-a-sentence/description/

「句子」是一个用空格分隔单词的字符串。给你一个满足下述格式的句子 text :
- 句子的首字母大写
- text 中的每个单词都用单个空格分隔。
请你重新排列 text 中的单词，使所有单词按其长度的升序排列。如果两个单词的长度相同，则保留其在原句子中的相对顺序。
请同样按上述格式返回新的句子。
提示：
text 以大写字母开头，然后包含若干小写字母以及单词间的单个空格。
1 <= text.length <= 10^5

模拟。
java 对于 String[] 时是稳定排序。
时间复杂度 O(nlogn)。
 */