public class Solution335 {
    public boolean isSelfCrossing(int[] distance) {
        // 1 <= distance.length <= 10^5
        int len = distance.length;
        for (int i = 3; i < len; i++) {
            // case1
            if (distance[i] >= distance[i - 2] && distance[i - 1] <= distance[i - 3]) {
                return true;
            }
            // case2
            if (i == 4 && (distance[3] == distance[1] && distance[4] >= distance[2] - distance[0])) {
                return true;
            }
            // case3
            if (i >= 5 && (distance[i - 3] - distance[i - 5] <= distance[i - 1]
                    && distance[i - 1] <= distance[i - 3]
                    && distance[i] >= distance[i - 2] - distance[i - 4]
                    && distance[i - 2] > distance[i - 4])) {
                return true;
            }
        }
        return false;
    }
}
/*
335. 路径交叉
https://leetcode.cn/problems/self-crossing/

给你一个整数数组 distance 。
从 X-Y 平面上的点 (0,0) 开始，先向北移动 distance[0] 米，然后向西移动 distance[1] 米，向南移动 distance[2] 米，
向东移动 distance[3] 米，持续移动。也就是说，每次移动后你的方位会发生逆时针变化。
判断你所经过的路径是否相交。如果相交，返回 true ；否则，返回 false 。
提示：
1 <= distance.length <= 10^5
1 <= distance[i] <= 10^5

分类讨论。
官方题解: https://leetcode.cn/problems/self-crossing/solution/lu-jing-jiao-cha-by-leetcode-solution-dekx/
时间复杂度 O(n)
空间复杂度 O(1)
 */