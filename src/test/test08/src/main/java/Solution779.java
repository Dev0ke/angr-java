public class Solution779 {
    public int kthGrammar(int n, int k) {
        return Integer.bitCount(k - 1) & 1;
    }
}
/*
779. 第K个语法符号
https://leetcode.cn/problems/k-th-symbol-in-grammar/description/

我们构建了一个包含 n 行( 索引从 1  开始 )的表。首先在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
- 例如，对于 n = 3 ，第 1 行是 0 ，第 2 行是 01 ，第3行是 0110 。
给定行数 n 和序数 k，返回第 n 行中第 k 个字符。（ k 从索引 1 开始）
提示:
1 <= n <= 30
1 <= k <= 2^{n-1}

找规律 + 位运算。
小朋友你是否有很多问号？
时间复杂度 O(1)。
 */