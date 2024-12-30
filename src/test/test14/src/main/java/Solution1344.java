public class Solution1344 {
    public double angleClock(int hour, int minutes) {
        double m = minutes / 5.0;
        double h = hour % 12 + minutes / 60.0;
        double angle = 360 * Math.abs(m - h) / 12; // 夹角角度
        return Math.min(angle, 360 - angle);
    }
}
/*
1344. 时钟指针的夹角
https://leetcode.cn/problems/angle-between-hands-of-a-clock/description/

给你两个数 hour 和 minutes 。请你返回在时钟上，由给定时间的时针和分针组成的较小角的角度（60 单位制）。
提示：
1 <= hour <= 12
0 <= minutes <= 59
与标准答案误差在 10^-5 以内的结果都被视为正确结果。

时针 和 分针 转换成 [0,12) 的值
时间复杂度 O(1)。
 */