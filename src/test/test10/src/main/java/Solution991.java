public class Solution991 {
    public int brokenCalc(int startValue, int target) {
        int ans = 0;
        while (target > startValue) {
            ans++;
            if (target % 2 == 1) {
                target++;
            } else {
                target /= 2;
            }
        }
        return ans + (startValue - target);
    }
}
/*
991. 坏了的计算器
https://leetcode.cn/problems/broken-calculator/description/

在显示着数字 startValue 的坏计算器上，我们可以执行以下两种操作：
- 双倍（Double）：将显示屏上的数字乘 2；
- 递减（Decrement）：将显示屏上的数字减 1 。
给定两个整数 startValue 和 target 。返回显示数字 target 所需的最小操作数。
提示：
1 <= startValue, target <= 10^9

逆向 考虑从 t -> s
时间复杂度 O(logY)
 */