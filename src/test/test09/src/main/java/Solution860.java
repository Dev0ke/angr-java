public class Solution860 {
    public boolean lemonadeChange(int[] bills) {
        // 5 10 20
        int[] money = new int[3];
        for (int bill : bills) {
            if (bill == 5) {
                money[0]++;
            } else if (bill == 10) {
                if (money[0] > 0) {
                    money[1]++;
                    money[0]--;
                } else {
                    return false;
                }
            }
            // 20
            else {
                // 10 + 5
                if (money[1] > 0 && money[0] > 0) {
                    money[0]--;
                    money[1]--;
                }
                // 5 + 5 + 5
                else if (money[1] == 0 && money[0] >= 3) {
                    money[0] -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
/*
860. 柠檬水找零
https://leetcode.cn/problems/lemonade-change/

第 91 场周赛 T1。

在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
注意，一开始你手头没有任何零钱。
给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
提示：
1 <= bills.length <= 10^5
bills[i] 不是 5 就是 10 或是 20

有限状态，可以直接模拟：
5 块钱，收下
10 块钱，找零 5 块钱
20 块钱，要么找零 10 + 5 块钱，要么找零 5 + 5 + 5 块钱
 */