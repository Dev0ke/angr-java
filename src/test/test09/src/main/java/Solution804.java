import java.util.HashSet;
import java.util.Set;

public class Solution804 {
    private static final String[] MORSE = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> hashSet = new HashSet<>();
        for (String word : words) {
            int len = word.length();
            String[] morse = new String[len];
            for (int i = 0; i < len; i++) {
                morse[i] = MORSE[word.charAt(i) - 'a'];
            }
            String morseString = String.join("", morse);
            hashSet.add(morseString);
        }
        return hashSet.size();
    }
}
/*
804. 唯一摩尔斯密码词
https://leetcode.cn/problems/unique-morse-code-words/

国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如:
- 'a' 对应 ".-" ，
- 'b' 对应 "-..." ，
- 'c' 对应 "-.-." ，以此类推。
为了方便，所有 26 个英文字母的摩尔斯密码表如下：
[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
给你一个字符串数组 words ，每个单词可以写成每个字母对应摩尔斯密码的组合。
- 例如，"cab" 可以写成 "-.-..--..." ，(即 "-.-." + ".-" + "-..." 字符串的结合)。我们将这样一个连接过程称作 单词翻译 。
对 words 中所有单词进行单词翻译，返回不同 单词翻译 的数量。
提示：
1 <= words.length <= 100
1 <= words[i].length <= 12
words[i] 由小写英文字母组成

模拟。
 */