public class SolutionP157 {
    static class Solution extends Reader4 {
        /**
         * @param buf Destination buffer
         * @param n   Number of characters to read
         * @return The number of actual characters read
         */
        public int read(char[] buf, int n) {
            int idx = 0;
            char[] buf4 = new char[4];
            int size = read4(buf4);
            while (size > 0 && idx < n) {
                for (int i = 0; i < size && idx < n; i++) {
                    buf[idx++] = buf4[i];
                }
                size = read4(buf4);
            }
            return idx;
        }

        // UT
        public Solution(String file) {
            super(file);
        }
    }

    private static class Reader4 {
        private final String file;
        private int fp;

        public Reader4(String file) {
            this.file = file;
            this.fp = 0;
        }

        int read4(char[] buf4) {
            int idx = 0;
            while (idx < 4 && fp < file.length()) {
                buf4[idx++] = file.charAt(fp++);
            }
            return idx;
        }
    }
}
/*
$157. 用 Read4 读取 N 个字符
https://leetcode.cn/problems/read-n-characters-given-read4/

给你一个文件，并且该文件只能通过给定的 read4 方法来读取，请实现一个方法使其能够读取 n 个字符。
read4 方法：
API read4 可以从文件中读取 4 个连续的字符，并且将它们写入缓存数组 buf 中。
返回值为实际读取的字符个数。
注意 read4() 自身拥有文件指针，很类似于 C 语言中的 FILE *fp 。
read4 的定义：
参数类型: char[] buf4
返回类型: int
注意: buf4[] 是目标缓存区不是源缓存区，read4 的返回结果将会复制到 buf4[] 当中。
下列是一些使用 read4 的例子：
File file("abcde"); // 文件名为 "abcde"， 初始文件指针 (fp) 指向 'a'
char[] buf4 = new char[4]; // 创建一个缓存区使其能容纳足够的字符
read4(buf4); // read4 返回 4。现在 buf4 = "abcd"，fp 指向 'e'
read4(buf4); // read4 返回 1。现在 buf4 = "e"，fp 指向文件末尾
read4(buf4); // read4 返回 0。现在 buf = ""，fp 指向文件末尾
read 方法：
通过使用 read4 方法，实现 read 方法。该方法可以从文件中读取 n 个字符并将其存储到缓存数组 buf 中。您 不能 直接操作文件。
返回值为实际读取的字符。
read 的定义：
参数类型:   char[] buf, int n
返回类型:   int
注意: buf[] 是目标缓存区不是源缓存区，你需要将结果写入 buf[] 中。
提示：
你 不能 直接操作该文件，文件只能通过 read4 获取而 不能 通过 read。
read  函数只在每个测试用例调用一次。
你可以假定目标缓存数组 buf 保证有足够的空间存下 n 个字符。

模拟。UT 写法比较复杂
相似題目: $158. 用 Read4 读取 N 个字符 II
https://leetcode.cn/problems/read-n-characters-given-read4-ii-call-multiple-times/
 */