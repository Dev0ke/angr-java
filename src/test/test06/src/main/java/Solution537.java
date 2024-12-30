public class Solution537 {
    public String complexNumberMultiply(String num1, String num2) {
        String[] complex1 = num1.split("[+i]");
        String[] complex2 = num2.split("[+i]");
        int real1 = Integer.parseInt(complex1[0]);
        int imaginary1 = Integer.parseInt(complex1[1]);
        int real2 = Integer.parseInt(complex2[0]);
        int imaginary2 = Integer.parseInt(complex2[1]);

        int real = real1 * real2 - imaginary1 * imaginary2;
        int imaginary = real1 * imaginary2 + imaginary1 * real2;
        return String.format("%d+%di", real, imaginary);
    }
}
/*
537. 复数乘法
https://leetcode.cn/problems/complex-number-multiplication/

复数 可以用字符串表示，遵循 "实部+虚部i" 的形式，并满足下述条件：
- 实部 是一个整数，取值范围是 [-100, 100]
- 虚部 也是一个整数，取值范围是 [-100, 100]
- i2 == -1
给你两个字符串表示的复数 num1 和 num2 ，请你遵循复数表示形式，返回表示它们乘积的字符串。
提示：
num1 和 num2 都是有效的复数表示。

模拟。
时间复杂度 O(1)。
 */