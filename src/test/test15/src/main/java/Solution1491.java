public class Solution1491 {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int sal : salary) {
            min = Math.min(min, sal);
            max = Math.max(max, sal);
            sum += sal;
        }
        return (sum - max - min) / (double) (salary.length - 2);
    }
}
/*
1491. 去掉最低工资和最高工资后的工资平均值
https://leetcode.cn/problems/average-salary-excluding-the-minimum-and-maximum-salary/

给你一个整数数组 salary ，数组里每个数都是 唯一 的，其中 salary[i] 是第 i 个员工的工资。
请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。
提示：
3 <= salary.length <= 100
10^3 <= salary[i] <= 10^6
salary[i] 是唯一的。
与真实值误差在 10^-5 以内的结果都将视为正确答案。

模拟。
 */