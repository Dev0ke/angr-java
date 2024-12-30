public class SolutionP604 {
    static class StringIterator {
        private final String compressedString;
        private final int N;
        private int iterator;
        private char ch;
        private int cnt;

        public StringIterator(String compressedString) {
            this.compressedString = compressedString;
            N = compressedString.length();
            iterator = 0;
            ch = ' ';
            cnt = 0;
        }

        public char next() {
            if (!hasNext()) {
                return ' ';
            }
            if (cnt == 0) {
                ch = compressedString.charAt(iterator++);
                while (iterator < N && Character.isDigit(compressedString.charAt(iterator))) {
                    cnt = cnt * 10 + compressedString.charAt(iterator) - '0';
                    iterator++;
                }
            }
            cnt--;
            return ch;
        }

        public boolean hasNext() {
            return iterator != N || cnt != 0;
        }
    }
}
/*
$604. 迭代压缩字符串
https://leetcode.cn/problems/design-compressed-string-iterator/

设计并实现一个迭代压缩字符串的数据结构。给定的压缩字符串的形式是，每个字母后面紧跟一个正整数，表示该字母在原始未压缩字符串中出现的次数。
设计一个数据结构，它支持如下两种操作： next 和 hasNext。
- next() - 如果原始字符串中仍有未压缩字符，则返回下一个字符，否则返回空格。
- hasNext() - 如果原始字符串中存在未压缩的的字母，则返回true，否则返回false。
提示：
1 <= compressedString.length <= 1000
compressedString 由小写字母、大写字母和数字组成。
在 compressedString 中，单个字符的重复次数在 [1,10 ^9] 范围内。
next 和 hasNext 的操作数最多为 100 。

按需计算
 */