public class Solution1732 {
    public int largestAltitude(int[] gain) {
        int h = 0;
        int max = 0;
        for (int x : gain) {
            h += x;
            max = Math.max(max, h);
        }
        return max;
    }
}
/*
1732. 找到最高海拔
https://leetcode.cn/problems/find-the-highest-altitude/

有一个自行车手打算进行一场公路骑行，这条路线总共由 n + 1 个不同海拔的点组成。自行车手从海拔为 0 的点 0 开始骑行。
给你一个长度为 n 的整数数组 gain ，其中 gain[i] 是点 i 和点 i + 1 的 净海拔高度差（0 <= i < n）。请你返回 最高点的海拔 。
提示：
n == gain.length
1 <= n <= 100
-100 <= gain[i] <= 100

贪心
时间复杂度 O(n)
空间复杂度 O(1)
 */