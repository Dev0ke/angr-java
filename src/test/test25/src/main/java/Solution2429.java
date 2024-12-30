public class Solution2429 {
    public int minimizeXor(int num1, int num2) {
        // 整数的 置位数 是其二进制表示中 1 的数目。
        int bitCount1 = Integer.bitCount(num1);
        int bitCount2 = Integer.bitCount(num2);

        // x XOR num1 的值 最小
        if (bitCount1 == bitCount2) {
            return num1;
        }

        if (bitCount1 > bitCount2) {
            // 抹去 num1 高位 bitCount2 个 1
            StringBuilder stringBuilder = new StringBuilder();
            String binaryString = Integer.toBinaryString(num1);
            int i = 0;
            for (; i < 31 && bitCount2 > 0; i++) {
                if (binaryString.charAt(i) == '1') {
                    bitCount2--;
                }
                stringBuilder.append("0");
            }
            stringBuilder.append(binaryString.substring(i));
            int res = Integer.parseInt(stringBuilder.toString(), 2);
            return num1 ^ res;
        } else {
            // 将 num1 低位 diff 个 0 置 1
            int diff = bitCount2 - bitCount1;
            int x = num1;
            for (int k = 0; k < 31 && diff > 0; k++) {
                if (((num1 >> k) & 1) == 0) {
                    x = x | (1 << k);
                    diff--;
                }
            }
            return x;
        }
    }
}
/*
2429. 最小 XOR
https://leetcode.cn/problems/minimize-xor/

第 313 场周赛 T3。

给你两个正整数 num1 和 num2 ，找出满足下述条件的整数 x ：
- x 的置位数和 num2 相同，且
- x XOR num1 的值 最小
注意 XOR 是按位异或运算。
返回整数 x 。题目保证，对于生成的测试用例， x 是 唯一确定 的。
整数的 置位数 是其二进制表示中 1 的数目。
提示：
1 <= num1, num2 <= 10^9

贪心。想要结果尽可能小，则需要尽可能抹去高位的 1。
 */