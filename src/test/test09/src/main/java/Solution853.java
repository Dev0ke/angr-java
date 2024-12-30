import java.util.Arrays;
import java.util.Comparator;

public class Solution853 {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        Node[] nodes = new Node[len];
        for (int i = 0; i < len; i++) {
            // 剩余距离
            int remain = target - position[i];
            double cost = (double) remain / speed[i];
            nodes[i] = new Node(remain, cost);
        }
        // 由近到远排序
        Arrays.sort(nodes, Comparator.comparingInt(o -> o.remain));

        int res = 1;
        for (int i = 1; i < len; i++) {
            // 后车速度比前车快
            if (nodes[i].time <= nodes[i - 1].time) {
                nodes[i].time = nodes[i - 1].time;
            } else {
                res++;
            }
        }
        return res;
    }

    private static class Node {
        int remain;
        double time;

        public Node(int remain, double time) {
            this.remain = remain;
            this.time = time;
        }
    }
}
/*
853. 车队
https://leetcode.cn/problems/car-fleet/

在一条单行道上，有 n 辆车开往同一目的地。目的地是几英里以外的 target 。
给定两个整数数组 position 和 speed ，长度都是 n ，其中 position[i] 是第 i 辆车的位置， speed[i] 是第 i 辆车的速度(单位是英里/小时)。
一辆车永远不会超过前面的另一辆车，但它可以追上去，并与前车 以相同的速度 紧接着行驶。此时，我们会忽略这两辆车之间的距离，也就是说，它们被假定处于相同的位置。
车队 是一些由行驶在相同位置、具有相同速度的车组成的非空集合。注意，一辆车也可以是一个车队。
即便一辆车在目的地才赶上了一个车队，它们仍然会被视作是同一个车队。
返回到达目的地的 车队数量 。
提示：
n == position.length == speed.length
1 <= n <= 10^5
0 < target <= 10^6
0 <= position[i] < target
position 中每个值都 不同
0 < speed[i] <= 10^6

模拟。按距终点的剩余距离排序，如果后车所需时间小于前车，说明后车能“超越”前车。根据题意，置为跟前车相同的速度（所需时间），计数即可。
时间复杂度 O(nlogn)
空间复杂度 O(n)
相似题目: 1776. 车队 II
https://leetcode.cn/problems/car-fleet-ii/description/
 */