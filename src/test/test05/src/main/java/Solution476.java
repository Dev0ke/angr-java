public class Solution476 {
    public int findComplement(int num) {
        String binNum = Integer.toBinaryString(num);
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : binNum.toCharArray()) {
            if (ch == '1') {
                stringBuilder.append('0');
            } else {
                stringBuilder.append("1");
            }
        }
        return Integer.parseInt(stringBuilder.toString(), 2);
    }
}
/*
476. 数字的补数
https://leetcode.cn/problems/number-complement/

对整数的二进制表示取反（0 变 1 ，1 变 0）后，再转换为十进制表示，可以得到这个整数的补数。
- 例如，整数 5 的二进制表示是 "101" ，取反后得到 "010" ，再转回十进制表示得到补数 2 。
给你一个整数 num ，输出它的补数。
提示：
1 <= num < 2^31

库函数
Integer.toBinaryString(int i)
Integer.parseInt(String s, int radix)
同: 1009. 十进制整数的反码
https://leetcode.cn/problems/complement-of-base-10-integer/
 */