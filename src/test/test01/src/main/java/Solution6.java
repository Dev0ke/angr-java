public class Solution6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int len = s.length();

        int M = numRows;
        int N = 1000;
        char[][] board = new char[M][N];
        int row = 0;
        int col = 0;
        int idx = 0;
        while (idx < len) {
            while (idx < len && row < M - 1) {
                board[row][col] = s.charAt(idx);
                row++;
                idx++;
            }
            while (idx < len && row > 0) {
                board[row][col] = s.charAt(idx);
                row--;
                col++;
                idx++;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j <= col; j++) {
                if (board[i][j] != 0) {
                    stringBuilder.append(board[i][j]);
                }
            }
        }
        return stringBuilder.toString();
    }
}
/*
6. Z 字形变换
https://leetcode.cn/problems/zigzag-conversion/

将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
P   A   H   N
A P L S I I G
Y   I   R
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
请你实现这个将字符串进行指定行数变换的函数：
string convert(string s, int numRows);
提示：
1 <= s.length <= 1000
s 由英文字母（小写和大写）、',' 和 '.' 组成
1 <= numRows <= 1000

模拟。
 */