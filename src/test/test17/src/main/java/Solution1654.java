import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution1654 {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Queue<int[]> queue = new LinkedList<>();
        // 0:上一次往前 1:上一次往后
        queue.add(new int[]{0, 0});
        // 最大前跳距离
        int maxLen = 6000;

        Set<Integer> forbiddenSet = new HashSet<>();
        for (int i : forbidden) {
            forbiddenSet.add(i);
        }

        int[][] steps = new int[maxLen][2];
        for (int[] step : steps) {
            Arrays.fill(step, Integer.MAX_VALUE);
        }
        steps[0][0] = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                int idx = cur[0];
                int pre = cur[1];
                if (idx == x) {
                    return steps[idx][pre];
                }

                // 往前
                if (idx + a < maxLen && !forbiddenSet.contains(idx + a) && steps[idx][pre] + 1 < steps[idx + a][0]) {
                    steps[idx + a][0] = steps[idx][pre] + 1;
                    queue.add(new int[]{idx + a, 0});
                }
                // 往后
                if (cur[1] == 0) {
                    if (idx - b >= 0 && !forbiddenSet.contains(idx - b) && steps[idx][pre] + 1 < steps[idx - b][1]) {
                        steps[idx - b][1] = steps[idx][pre] + 1;
                        queue.add(new int[]{idx - b, 1});
                    }
                }
            }

        }
        return -1;
    }

    // WA
    public int minimumJumps2(int[] forbidden, int a, int b, int x) {
        Queue<int[]> queue = new LinkedList<>();
        // 0:往前 1:往后
        queue.add(new int[]{0, 0});
        // 最大前跳距离
        int maxLen = 6000;

        boolean[] visited = new boolean[maxLen];
        visited[0] = true;
        for (int i : forbidden) {
            visited[i] = true;
        }

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                int idx = cur[0];
                if (idx == x) {
                    return step;
                }

                // 往前
                if (idx + a < maxLen && !visited[idx + a]) {
                    visited[idx + a] = true;
                    queue.add(new int[]{idx + a, 0});
                }
                // 往后
                if (cur[1] == 0) {
                    if (idx - b >= 0 && !visited[idx - b]) {
                        visited[idx - b] = true;
                        queue.add(new int[]{idx - b, 1});
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
/*
1654. 到家的最少跳跃次数
https://leetcode.cn/problems/minimum-jumps-to-reach-home/

有一只跳蚤的家在数轴上的位置 x 处。请你帮助它从位置 0 出发，到达它的家。
跳蚤跳跃的规则如下：
- 它可以 往前 跳恰好 a 个位置（即往右跳）。
- 它可以 往后 跳恰好 b 个位置（即往左跳）。
- 它不能 连续 往后跳 2 次。
- 它不能跳到任何 forbidden 数组中的位置。
跳蚤可以往前跳 超过 它的家的位置，但是它 不能跳到负整数 的位置。
给你一个整数数组 forbidden ，其中 forbidden[i] 是跳蚤不能跳到的位置，同时给你整数 a， b 和 x ，请你返回跳蚤到家的最少跳跃次数。如果没有恰好到达 x 的可行方案，请你返回 -1 。
提示：
1 <= forbidden.length <= 1000
1 <= a, b, forbidden[i] <= 2000
0 <= x <= 2000
forbidden 中所有位置互不相同。
位置 x 不在 forbidden 中。

BFS。需要求出边界值 maxLen，可以证明不超过 max(f+a+b, x) 其中 f 为 forbidden 最大值，由于取值范围，这里直接定位 6000。
注意对比 WA 答案，同一个点可以多次到达。
 */