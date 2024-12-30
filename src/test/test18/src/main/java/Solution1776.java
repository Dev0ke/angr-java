import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution1776 {
    public double[] getCollisionTimes(int[][] cars) {
        int n = cars.length;
        double[] ans = new double[n];
        Arrays.fill(ans, -1);
        Deque<Integer> st = new ArrayDeque<>();
        st.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && (cars[st.peek()][1] >= cars[i][1]
                    || (0 < ans[st.peek()] && ans[st.peek()] <= getCollisionTime(cars[i], cars[st.peek()])))) {
                st.pop();
            }
            if (!st.isEmpty()) {
                ans[i] = getCollisionTime(cars[i], cars[st.peek()]);
            }
            st.push(i);
        }
        return ans;
    }

    // 当前车 与 栈顶车 相遇的时间
    private double getCollisionTime(int[] cur, int[] pre) {
        // position, speed, 距离差（栈顶车更远） / 速度差（当前车更快）
        return (pre[0] - cur[0]) / (double) (cur[1] - pre[1]);
    }
}
/*
1776. 车队 II
https://leetcode.cn/problems/car-fleet-ii/description/

在一条单车道上有 n 辆车，它们朝着同样的方向行驶。给你一个长度为 n 的数组 cars ，其中 cars[i] = [positioni, speedi] ，它表示：
- positioni 是第 i 辆车和道路起点之间的距离（单位：米）。题目保证 positioni < positioni+1 。
- speedi 是第 i 辆车的初始速度（单位：米/秒）。
简单起见，所有车子可以视为在数轴上移动的点。当两辆车占据同一个位置时，我们称它们相遇了。一旦两辆车相遇，它们会合并成一个车队，这个车队里的车有着同样的位置和相同的速度，速度为这个车队里 最慢 一辆车的速度。
请你返回一个数组 answer ，其中 answer[i] 是第 i 辆车与下一辆车相遇的时间（单位：秒），如果这辆车不会与下一辆车相遇，则 answer[i] 为 -1 。答案精度误差需在 10^-5 以内。
提示：
1 <= cars.length <= 10^5
1 <= positioni, speedi <= 10^6
positioni < positioni+1

单调栈
相似题目: 853. 车队
https://leetcode.cn/problems/car-fleet/
 */