public class Solution1227 {
    public double nthPersonGetsNthSeat(int n) {
        return n == 1 ? 1.0 : 0.5;
    }
}
/*
1227. 飞机座位分配概率
https://leetcode.cn/problems/airplane-seat-assignment-probability/description/

有 n 位乘客即将登机，飞机正好有 n 个座位。第一位乘客的票丢了，他随便选了一个座位坐下。
剩下的乘客将会：
- 如果他们自己的座位还空着，就坐到自己的座位上，
- 当他们自己的座位被占用时，随机选择其他座位
第 n 位乘客坐在自己的座位上的概率是多少？
提示：
1 <= n <= 10^5

数学。
时间复杂度 O(1)。
https://leetcode.cn/problems/airplane-seat-assignment-probability/solutions/664495/fei-ji-zuo-wei-fen-pei-gai-lu-by-leetcod-gyw4/
 */