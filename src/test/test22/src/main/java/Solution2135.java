import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class Solution2135 {
    public int wordCount(String[] startWords, String[] targetWords) {
        // 预处理 startWords
        Set<String> memo = new HashSet<>();
        for (String startWord : startWords) {
            int len = startWord.length();
            char[] oldChars = startWord.toCharArray();
            BitSet bitSet = new BitSet(26);
            for (int i = 0; i < len; i++) {
                bitSet.set(oldChars[i] - 'a');
            }
            for (int i = 0; i < 26; i++) {
                if (!bitSet.get(i)) {
                    String newStartWord = startWord.concat(String.valueOf((char) ('a' + i)));
                    char[] newChars = newStartWord.toCharArray();
                    Arrays.sort(newChars);
                    memo.add(new String(newChars));
                }
            }
        }

        // 统计
        int cnt = 0;
        for (String targetWord : targetWords) {
            char[] chars = targetWord.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (memo.contains(key)) {
                cnt++;
            }
        }
        return cnt;
    }
}
/*
2135. 统计追加字母可以获得的单词数
https://leetcode.cn/problems/count-words-obtained-after-adding-a-letter/

第 275 场周赛 T3。

给你两个下标从 0 开始的字符串数组 startWords 和 targetWords 。每个字符串都仅由 小写英文字母 组成。
对于 targetWords 中的每个字符串，检查是否能够从 startWords 中选出一个字符串，执行一次 转换操作 ，得到的结果与当前 targetWords 字符串相等。
转换操作 如下面两步所述：
1.追加 任何 不存在 于当前字符串的任一小写字母到当前字符串的末尾。
 - 例如，如果字符串为 "abc" ，那么字母 'd'、'e' 或 'y' 都可以加到该字符串末尾，但 'a' 就不行。如果追加的是 'd' ，那么结果字符串为 "abcd" 。
2.重排 新字符串中的字母，可以按 任意 顺序重新排布字母。
 - 例如，"abcd" 可以重排为 "acbd"、"bacd"、"cbda"，以此类推。注意，它也可以重排为 "abcd" 自身。
找出 targetWords 中有多少字符串能够由 startWords 中的 任一 字符串执行上述转换操作获得。返回 targetWords 中这类 字符串的数目 。
注意：你仅能验证 targetWords 中的字符串是否可以由 startWords 中的某个字符串经执行操作获得。startWords  中的字符串在这一过程中 不 发生实际变更。
提示：
1 <= startWords.length, targetWords.length <= 5 * 10^4
1 <= startWords[i].length, targetWords[j].length <= 26
startWords 和 targetWords 中的每个字符串都仅由小写英文字母组成
在 startWords 或 targetWords 的任一字符串中，每个字母至多出现一次

先预处理 startWords 所有可以组合的可能，再逐个判断 targetWords 的字符串是否满足条件（字符串中的字母升序排序后 HashSet 判断）。
数据范围 5 * 10^4 * 26 近似 10^6，因此是可行的方案。
时间复杂度 O(S*26log26 + T*26log26)，其中 S = startWords.length，T = targetWords.length
 */