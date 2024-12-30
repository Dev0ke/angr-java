public class Solution2443 {
    public boolean sumOfNumberAndReverse(int num) {
        if (num == 0) {
            return true;
        }
        for (int i = 1; i < num; i++) {
            int reverse = Integer.parseInt(new StringBuilder(String.valueOf(i)).reverse().toString());
            if (i + reverse == num) {
                return true;
            }
        }
        return false;
    }
}
/*
2443. 反转之后的数字和
https://leetcode.cn/problems/sum-of-number-and-its-reverse/

第 315 场周赛 T3。

给你一个 非负 整数 num 。如果存在某个 非负 整数 k 满足 k + reverse(k) = num  ，则返回 true ；否则，返回 false 。
reverse(k) 表示 k 反转每个数位后得到的数字。
提示：
0 <= num <= 10^5

模拟。注意特判 0。
 */