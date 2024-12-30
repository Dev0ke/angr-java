import java.util.ArrayDeque;
import java.util.Queue;

public class Solution2059 {
    public int minimumOperations(int[] nums, int start, int goal) {
        boolean[] vis = new boolean[1001];
        vis[start] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        int step = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int v = q.remove();
                for (int num : nums) {
                    for (int x : new int[]{v + num, v - num, v ^ num}) {
                        if (x == goal) {
                            return step;
                        }
                        if (0 <= x && x <= 1000 && !vis[x]) {
                            vis[x] = true;
                            q.add(x);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
/*
2059. 转化数字的最小运算数
https://leetcode.cn/problems/minimum-operations-to-convert-number/

第 265 场周赛 T3。

给你一个下标从 0 开始的整数数组 nums ，该数组由 互不相同 的数字组成。另给你两个整数 start 和 goal 。
整数 x 的值最开始设为 start ，你打算执行一些运算使 x 转化为 goal 。你可以对数字 x 重复执行下述运算：
如果 0 <= x <= 1000 ，那么，对于数组中的任一下标 i（0 <= i < nums.length），可以将 x 设为下述任一值：
x + nums[i]
x - nums[i]
x ^ nums[i]（按位异或 XOR）
注意，你可以按任意顺序使用每个 nums[i] 任意次。使 x 越过 0 <= x <= 1000 范围的运算同样可以生效，但该该运算执行后将不能执行其他运算。
返回将 x = start 转化为 goal 的最小操作数；如果无法完成转化，则返回 -1 。
提示：
1 <= nums.length <= 1000
-10^9 <= nums[i], goal <= 10^9
0 <= start <= 1000
start != goal
nums 中的所有整数互不相同

BFS。
时间复杂度 O(mn)。其中 m = max(x)。
 */