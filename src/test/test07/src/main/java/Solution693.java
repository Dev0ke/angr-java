public class Solution693 {
    public boolean hasAlternatingBits(int n) {
        String bitString = Integer.toBinaryString(n);
        int len = bitString.length();
        for (int i = 1; i < len; i++) {
            if (bitString.charAt(i) == bitString.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
/*
693. 交替位二进制数
https://leetcode.cn/problems/binary-number-with-alternating-bits/

给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
提示：
1 <= n <= 2^31 - 1

库函数 模拟。
 */