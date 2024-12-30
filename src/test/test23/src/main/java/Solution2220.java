public class Solution2220 {
    public int minBitFlips(int start, int goal) {
        String startStr = Integer.toBinaryString(start);
        String goalStr = Integer.toBinaryString(goal);

        // 双指针 从尾到头
        int p1 = startStr.length() - 1;
        int p2 = goalStr.length() - 1;
        int cnt = 0;
        while (p1 >= 0 && p2 >= 0) {
            if (startStr.charAt(p1) != goalStr.charAt(p2)) {
                cnt++;
            }
            p1--;
            p2--;
        }
        while (p1 >= 0) {
            if (startStr.charAt(p1) == '1') {
                cnt++;
            }
            p1--;
        }
        while (p2 >= 0) {
            if (goalStr.charAt(p2) == '1') {
                cnt++;
            }
            p2--;
        }
        return cnt;
    }
}
/*
2220. 转换数字的最少位翻转次数
https://leetcode.cn/problems/minimum-bit-flips-to-convert-number/

第 75 场双周赛 T1。

一次 位翻转 定义为将数字 x 二进制中的一个位进行 翻转 操作，即将 0 变成 1 ，或者将 1 变成 0 。
- 比方说，x = 7 ，二进制表示为 111 ，我们可以选择任意一个位（包含没有显示的前导 0 ）并进行翻转。
比方说我们可以翻转最右边一位得到 110 ，或者翻转右边起第二位得到 101 ，或者翻转右边起第五位（这一位是前导 0 ）得到 10111 等等。
给你两个整数 start 和 goal ，请你返回将 start 转变成 goal 的 最少位翻转 次数。
提示：
0 <= start, goal <= 10^9

双指针模拟。
 */