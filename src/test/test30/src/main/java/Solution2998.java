import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Solution2998 {
    public int minimumOperationsToMakeEqual(int x, int y) {
        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> vis = new HashSet<>();
        q.add(x);
        vis.add(x);
        int ans = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int v = q.remove();
                if (v == y) {
                    return ans;
                }
                if (v % 11 == 0 && !vis.contains(v / 11)) {
                    vis.add(v / 11);
                    q.add(v / 11);
                }
                if (v % 5 == 0 && !vis.contains(v / 5)) {
                    vis.add(v / 5);
                    q.add(v / 5);
                }
                if (!vis.contains(v - 1)) {
                    vis.add(v - 1);
                    q.add(v - 1);
                }
                if (!vis.contains(v + 1)) {
                    vis.add(v + 1);
                    q.add(v + 1);
                }
            }
            ans++;
        }
        return -1;
    }
}
/*
2998. 使 X 和 Y 相等的最少操作次数
https://leetcode.cn/problems/minimum-number-of-operations-to-make-x-and-y-equal/description/

第 121 场双周赛 T3。

给你两个正整数 x 和 y 。
一次操作中，你可以执行以下四种操作之一：
1.如果 x 是 11 的倍数，将 x 除以 11 。
2.如果 x 是 5 的倍数，将 x 除以 5 。
3.将 x 减 1 。
4.将 x 加 1 。
请你返回让 x 和 y 相等的 最少 操作次数。
提示：
1 <= x, y <= 10^4

BFS
时间复杂度 O(x)
 */