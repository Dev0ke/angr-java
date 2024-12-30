public class Solution2520 {
    public int countDigits(int num) {
        int cnt = 0;
        int n = num;
        while (n > 0) {
            int val = n % 10;
            if (num % val == 0) {
                cnt++;
            }
            n /= 10;
        }
        return cnt;
    }
}
/*
2520. 统计能整除数字的位数
https://leetcode.cn/problems/count-the-digits-that-divide-a-number/

第 326 场周赛 T1。

给你一个整数 num ，返回 num 中能整除 num 的数位的数目。
如果满足 nums % val == 0 ，则认为整数 val 可以整除 nums 。
提示：
1 <= num <= 10^9
num 的数位中不含 0

模拟。
时间复杂度 O(n)
 */