public class Solution67 {
    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        // 进位
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int numA;
            if (i >= 0) {
                numA = a.charAt(i) - '0';
                i--;
            } else {
                numA = 0;
            }
            int numB;
            if (j >= 0) {
                numB = b.charAt(j) - '0';
                j--;
            } else {
                numB = 0;
            }
            int sum = numA + numB + carry;
            carry = sum >= 2 ? 1 : 0;
            sum = sum >= 2 ? sum - 2 : sum;
            stringBuilder.append(sum);
        }
        if (carry == 1) {
            stringBuilder.append(1);
        }
        return stringBuilder.reverse().toString();
    }
}
/*
67. 二进制求和
https://leetcode.cn/problems/add-binary/

给你两个二进制字符串，返回它们的和（用二进制表示）。
输入为 非空 字符串且只包含数字 1 和 0。
提示：
每个字符串仅由字符 '0' 或 '1' 组成。
1 <= a.length, b.length <= 10^4
字符串如果不是 "0" ，就都不含前导零。

当二进制字符串比较长时，它表示的整数可能会超出 int 型整数和 long 型整数的范围。
因此转换成十进制整数再相加不可行。
 */