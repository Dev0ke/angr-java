public class Solution1342 {
    public int numberOfSteps(int num) {
        int cnt = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num--;
            }
            cnt++;
        }
        return cnt;
    }
}
/*
1342. 将数字变成 0 的操作次数
https://leetcode.cn/problems/number-of-steps-to-reduce-a-number-to-zero/

给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
提示：
0 <= num <= 10^6

直接模拟。
 */