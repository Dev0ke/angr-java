public class Solution1266 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int pre_x = points[0][0], pre_y = points[0][1];
        int ans = 0;
        for (int i = 1; i < points.length; i++) {
            int x = points[i][0], y = points[i][1];
            // 切比雪夫距离
            ans += Math.max(Math.abs(x - pre_x), Math.abs(y - pre_y));
            pre_x = x;
            pre_y = y;
        }
        return ans;
    }
}
/*
1266. 访问所有点的最小时间
https://leetcode.cn/problems/minimum-time-visiting-all-points/description/

平面上有 n 个点，点的位置用整数坐标表示 points[i] = [xi, yi] 。请你计算访问所有这些点需要的 最小时间（以秒为单位）。
你需要按照下面的规则在平面上移动：
- 每一秒内，你可以：
  - 沿水平方向移动一个单位长度，或者
  - 沿竖直方向移动一个单位长度，或者
  - 跨过对角线移动 sqrt(2) 个单位长度（可以看作在一秒内向水平和竖直方向各移动一个单位长度）。
- 必须按照数组中出现的顺序来访问这些点。
- 在访问某个点时，可以经过该点后面出现的点，但经过的那些点不算作有效访问。
提示：
points.length == n
1 <= n <= 100
points[i].length == 2
-1000 <= points[i][0], points[i][1] <= 1000

切比雪夫距离。
时间复杂度 O(n)。
 */