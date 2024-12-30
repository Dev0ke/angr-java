public class Solution3270 {
    public int generateKey(int num1, int num2, int num3) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int d1 = num1 % 10;
            int d2 = num2 % 10;
            int d3 = num3 % 10;
            int min = Math.min(d1, Math.min(d2, d3));
            sb.append(min);
            num1 /= 10;
            num2 /= 10;
            num3 /= 10;
        }
        return Integer.parseInt(sb.reverse().toString());
    }
}
/*
3270. 求出数字答案
https://leetcode.cn/problems/find-the-key-of-the-numbers/description/

第 138 场双周赛 T1。

给你三个 正 整数 num1 ，num2 和 num3 。
数字 num1 ，num2 和 num3 的数字答案 key 是一个四位数，定义如下：
- 一开始，如果有数字 少于 四位数，给它补 前导 0 。
- 答案 key 的第 i 个数位（1 <= i <= 4）为 num1 ，num2 和 num3 第 i 个数位中的 最小 值。
请你返回三个数字 没有 前导 0 的数字答案。
提示：
1 <= num1, num2, num3 <= 9999

模拟。
时间复杂度 O(1)。
 */