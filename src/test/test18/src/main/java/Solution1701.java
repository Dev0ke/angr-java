public class Solution1701 {
    public double averageWaitingTime(int[][] customers) {
        int len = customers.length;

        long total = 0;
        int endTime = 0;
        for (int[] customer : customers) {
            endTime = Math.max(endTime, customer[0]) + customer[1];
            total += endTime - customer[0];
        }
        return total / (double) len;
    }
}
/*
1701. 平均等待时间
https://leetcode.cn/problems/average-waiting-time/

有一个餐厅，只有一位厨师。你有一个顾客数组 customers ，其中 customers[i] = [arrivali, timei] ：
- arrivali 是第 i 位顾客到达的时间，到达时间按 非递减 顺序排列。
- timei 是给第 i 位顾客做菜需要的时间。
当一位顾客到达时，他将他的订单给厨师，厨师一旦空闲的时候就开始做这位顾客的菜。每位顾客会一直等待到厨师完成他的订单。厨师同时只能做一个人的订单。厨师会严格按照 订单给他的顺序 做菜。
请你返回所有顾客需要等待的 平均 时间。与标准答案误差在 10^-5 范围以内，都视为正确结果。
提示：
1 <= customers.length <= 10^5
1 <= arrivali, timei <= 10^4
arrivali <= arrivali+1

模拟
时间复杂度 O(n)
 */