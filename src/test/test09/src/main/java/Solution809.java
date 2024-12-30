public class Solution809 {
    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        for (String word : words) {
            if (check(s.toCharArray(), word.toCharArray())) {
                ans++;
            }
        }
        return ans;
    }

    private boolean check(char[] s, char[] t) {
        int i = 0, j = 0;
        while (i < s.length && j < t.length) {
            if (s[i] != t[j]) return false;
            // 分组循环
            int stI = i;
            for (i++; i < s.length && s[i] == s[i - 1]; i++) {
            }
            int stJ = j;
            for (j++; j < t.length && t[j] == t[j - 1]; j++) {
            }
            int cntI = i - stI, cntJ = j - stJ;
            if (cntI < cntJ) return false;
            if (cntI != cntJ && cntI < 3) return false;
        }
        return i == s.length && j == t.length;
    }
}
/*
809. 情感丰富的文字
https://leetcode.cn/problems/expressive-words/description/

有时候人们会用重复写一些字母来表示额外的感受，比如 "hello" -> "heeellooo", "hi" -> "hiii"。我们将相邻字母都相同的一串字符定义为相同字母组，例如："h", "eee", "ll", "ooo"。
对于一个给定的字符串 S ，如果另一个单词能够通过将一些字母组扩张从而使其和 S 相同，我们将这个单词定义为可扩张的（stretchy）。
扩张操作定义如下：选择一个字母组（包含字母 c ），然后往其中添加相同的字母 c 使其长度达到 3 或以上。
例如，以 "hello" 为例，我们可以对字母组 "o" 扩张得到 "hellooo"，但是无法以同样的方法得到 "helloo" 因为字母组 "oo" 长度小于 3。此外，我们可以进行另一种扩张 "ll" -> "lllll" 以获得 "helllllooo"。
如果 s = "helllllooo"，那么查询词 "hello" 是可扩张的，因为可以对它执行这两种扩张操作使得 query = "hello" -> "hellooo" -> "helllllooo" = s。
输入一组查询单词，输出其中可扩张的单词数量。
提示：
1 <= s.length, words.length <= 100
1 <= words[i].length <= 100
s 和所有在 words 中的单词都只由小写字母组成。

双指针 + 分组循环。
时间复杂度 O(n|s| + sigma|words[i]|) 其中 n = words.length
 */