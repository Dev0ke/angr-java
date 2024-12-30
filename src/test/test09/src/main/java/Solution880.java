public class Solution880 {
    public String decodeAtIndex(String s, int k) {
        int n = s.length();
        char[] cs = s.toCharArray();

        long sz = 0L;
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(cs[i])) {
                sz *= cs[i] - '0';
            } else {
                sz++;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            k %= sz;
            if (k == 0 && Character.isLetter(cs[i])) {
                return String.valueOf(cs[i]);
            }
            if (Character.isDigit(cs[i])) {
                sz /= cs[i] - '0';
            } else {
                sz--;
            }
        }
        return "";
    }
}
/*
880. 索引处的解码字符串
https://leetcode.cn/problems/decoded-string-at-index/

给定一个编码字符串 S。请你找出 解码字符串 并将其写入磁带。解码时，从编码字符串中 每次读取一个字符 ，并采取以下步骤：
- 如果所读的字符是字母，则将该字母写在磁带上。
- 如果所读的字符是数字（例如 d），则整个当前磁带总共会被重复写 d-1 次。
现在，对于给定的编码字符串 S 和索引 K，查找并返回解码字符串中的第 K 个字母。
提示：
2 <= S.length <= 100
S 只包含小写字母与数字 2 到 9 。
S 以字母开头。
1 <= K <= 10^9
题目保证 K 小于或等于解码字符串的长度。
解码后的字符串保证少于 2^63 个字母。

逆向工作法
相似题目: $604. 迭代压缩字符串
https://leetcode.cn/problems/design-compressed-string-iterator/
 */