public class Solution754 {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int sum = 0, x = 0;
        while (sum < target || (sum - target) % 2 == 1) { // 没有到达（越过）终点，或者相距奇数
            sum += ++x;
        }
        return x;
    }
}
/*
754. 到达终点数字
https://leetcode.cn/problems/reach-a-number/description/

在一根无限长的数轴上，你站在0的位置。终点在target的位置。
你可以做一些数量的移动 numMoves :
- 每次你可以选择向左或向右移动。
- 第 i 次移动（从  i == 1 开始，到 i == numMoves ），在选择的方向上走 i 步。
给定整数 target ，返回 到达目标所需的 最小 移动次数(即最小 numMoves ) 。
提示:
-10^9 <= target <= 10^9
target != 0

分类讨论。
情况一：恰好到达，例如 10 = 1+2+3+4
情况二：越过终点相距偶数，例如 8 = -1+2+3+4
情况三：越过终点相距奇数，（多走一步，如果相距变为偶数，则情况二）例如 7 = 1+2+3-4+5
情况四：越过终点相距奇数，（多走两步，相距必然变为偶数，则情况二）例如 5 = 1+2+3+4-5
https://leetcode.cn/problems/reach-a-number/solutions/1947254/fen-lei-tao-lun-xiang-xi-zheng-ming-jian-sqj2/
时间复杂度 O(sqrt|target|)。
可用一元二次方程求根公式 优化至 O(1)。
 */