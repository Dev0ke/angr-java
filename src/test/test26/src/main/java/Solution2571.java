import java.util.LinkedList;
import java.util.Queue;

public class Solution2571 {
    public int minOperations(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int k = 0;

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.remove();
                if (cur == 0) {
                    return step;
                }

                while (true) {
                    if (((cur >> k) & 1) == 1) {
                        queue.add(cur + (1 << k));
                        queue.add(cur - (1 << k));
                        break;
                    }
                    k++;
                }
            }
            step++;
        }
        return step;
    }
}
/*
2571. 将整数减少到零需要的最少操作数
https://leetcode.cn/problems/minimum-operations-to-reduce-an-integer-to-0/

第 333 场周赛 T2。

给你一个正整数 n ，你可以执行下述操作 任意 次：
- n 加上或减去 2 的某个 幂
返回使 n 等于 0 需要执行的 最少 操作数。
如果 x == 2^i 且其中 i >= 0 ，则数字 x 是 2 的幂。
提示：
1 <= n <= 10^5

BFS。从低位开始，消除 1 有两个方案：加上 2^i ；减去 2^i
时间复杂度 O(logn)
 */