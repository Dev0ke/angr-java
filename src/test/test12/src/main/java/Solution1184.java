public class Solution1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int len = distance.length;

        int[] preSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + distance[i];
        }

        int min = Math.min(start, destination);
        int max = Math.max(start, destination);

        int res1 = preSum[max] - preSum[min];
        return Math.min(res1, preSum[len] - res1);
    }
}
/*
1184. 公交站间的距离
https://leetcode.cn/problems/distance-between-bus-stops/

环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
环线上的公交车都可以按顺时针和逆时针的方向行驶。
返回乘客从出发点 start 到目的地 destination 之间的最短距离。
提示：
1 <= n <= 10^4
distance.length == n
0 <= start, destination < n
0 <= distance[i] <= 10^4

前缀和，贪心。
 */