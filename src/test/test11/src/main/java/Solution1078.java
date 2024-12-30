import java.util.ArrayList;
import java.util.List;

public class Solution1078 {
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        int len = words.length;
        List<String> resList = new ArrayList<>();
        for (int i = 0; i + 2 < len; i++) {
            if (words[i].equals(first) && words[i + 1].equals(second)) {
                resList.add(words[i + 2]);
            }
        }
        return resList.toArray(String[]::new);
    }
}
/*
1078. Bigram 分词
https://leetcode.cn/problems/occurrences-after-bigram/

第 140 场周赛 T1。

给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，
其中 second 紧随 first 出现，third 紧随 second 出现。
对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。
提示：
1 <= text.length <= 1000
text 由小写英文字母和空格组成
text 中的所有单词之间都由 单个空格字符 分隔
1 <= first.length, second.length <= 10
first 和 second 由小写英文字母组成

模拟。
 */