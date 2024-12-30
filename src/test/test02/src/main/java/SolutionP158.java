public class SolutionP158 {
    static class Solution extends Reader4 {
        private int size = 0;
        private int i = 0;
        private final char[] tmp = new char[4];

        /**
         * @param buf Destination buffer
         * @param n   Number of characters to read
         * @return The number of actual characters read
         */
        public int read(char[] buf, int n) {
            int idx = 0;
            while (idx < n) {
                if (size == 0) {
                    size = read4(tmp);
                    if (size == 0) {
                        break;
                    }
                }
                while (idx < n && i < size) {
                    buf[idx++] = tmp[i++];
                }
                if (i == size) {
                    // 说明临时字符数组中的内容已经读完, size置零以便执行下一次read4操作
                    i = 0;
                    size = 0;
                }
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
$158. 用 Read4 读取 N 个字符 II
https://leetcode.cn/problems/read-n-characters-given-read4-ii-call-multiple-times/

给你一个文件 file ，并且该文件只能通过给定的 read4 方法来读取，请实现一个方法使其能够使 read 读取 n 个字符。注意：你的 read 方法可能会被调用多次。
read4 的定义：
read4 API 从文件中读取 4 个连续的字符，然后将这些字符写入缓冲区数组 buf4 。
返回值是读取的实际字符数。
请注意，read4() 有其自己的文件指针，类似于 C 中的 FILE * fp 。
    参数类型: char[] buf4
    返回类型: int
注意: buf4[] 是目标缓存区不是源缓存区，read4 的返回结果将会复制到 buf4[] 当中。
下列是一些使用 read4 的例子：
File file("abcde"); // 文件名为 "abcde"， 初始文件指针 (fp) 指向 'a'
char[] buf4 = new char[4]; // 创建一个缓存区使其能容纳足够的字符
read4(buf4); // read4 返回 4。现在 buf4 = "abcd"，fp 指向 'e'
read4(buf4); // read4 返回 1。现在 buf4 = "e"，fp 指向文件末尾
read4(buf4); // read4 返回 0。现在 buf4 = ""，fp 指向文件末尾
read 方法：
通过使用 read4 方法，实现 read 方法。该方法可以从文件中读取 n 个字符并将其存储到缓存数组 buf 中。您 不能 直接操作 file 。
返回值为实际读取的字符。
read 的定义：
    参数类型:  char[] buf, int n
    返回类型:  int
注意: buf[] 是目标缓存区不是源缓存区，你需要将结果写入 buf[] 中。
注意：
你 不能 直接操作该文件，文件只能通过 read4 获取而 不能 通过 read。
read  函数可以被调用 多次。
请记得 重置 在 Solution 中声明的类变量（静态变量），因为类变量会 在多个测试用例中保持不变，影响判题准确。请 查阅 这里。
你可以假定目标缓存数组 buf 保证有足够的空间存下 n 个字符。 
保证在一个给定测试用例中，read 函数使用的是同一个 buf。
提示：
1 <= file.length <= 500
file 由英语字母和数字组成
1 <= queries.length <= 10
1 <= queries[i] <= 500

模拟。UT 写法比较复杂
相似題目: $157. 用 Read4 读取 N 个字符
https://leetcode.cn/problems/read-n-characters-given-read4/
 */