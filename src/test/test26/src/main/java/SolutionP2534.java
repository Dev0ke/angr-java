import java.util.Arrays;
import java.util.PriorityQueue;

public class SolutionP2534 {
    public int[] timeTaken(int[] arrival, int[] state) {
        int n = arrival.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        int p = 0; // 表示arrival里当前待进队列的位置
        PriorityQueue<Integer>[] wait = new PriorityQueue[2];
        wait[0] = new PriorityQueue<>(); // 第一个队列
        wait[1] = new PriorityQueue<>(); // 第二个队列

        int t = 0; // 表示当前时间
        int lt = -1; // 上一个通过门的人的通过时间
        int l = 1; // 上一个通过门的人的类型，如果lt初值小于-1，l的初值设成什么都可以

        while (p < n || !wait[0].isEmpty() || !wait[1].isEmpty()) {
            // 先把已经来到门前等待通过的人都放进优先队列
            while (p < n && arrival[p] <= t) {
                wait[state[p]].add(p);
                p++;
            }

            int typ = (t - lt == 1) ? l : 1; // 如果上一秒有人通过，就和上一秒类型相同的优先，否则出门的优先

            // 只要有一个队列不为空，这一秒就有人要通过门
            if (!wait[typ].isEmpty() || !wait[typ ^ 1].isEmpty()) {
                int chosenType = typ;
                if (wait[typ].isEmpty()) {
                    chosenType = typ ^ 1;
                }
                int idx = wait[chosenType].poll();
                res[idx] = t;
                lt = t;
                t++;
                l = chosenType;
            } else {
                // 没人等待，但在这个问题中，我们可以简单地将时间加1，因为我们要模拟的是时间的连续变化
                t++;
            }
        }
        return res;
    }
}
/*
$2534. 通过门的时间
https://leetcode.cn/problems/time-taken-to-cross-the-door/description/

n 个人，按从 0 到 n - 1 编号。现在有一扇门，每个人只能通过门进入或离开一次，耗时一秒。
给你一个 非递减顺序 排列的整数数组 arrival ，数组长度为 n ，其中 arrival[i] 是第 i 个人到达门前的时间。另给你一个长度为 n 的数组 state ，其中 state[i] 是 0 则表示第 i 个人希望进入这扇门，是 1 则表示 TA 想要离开这扇门。
如果 同时 有两个或更多人想要使用这扇门，则必须遵循以下规则：
- 如果前一秒 没有 使用门，那么想要 离开 的人会先离开。
- 如果前一秒使用门 进入 ，那么想要 进入 的人会先进入。
- 如果前一秒使用门 离开 ，那么想要 离开 的人会先离开。
- 如果多个人都想朝同一方向走（都进入或都离开），编号最小的人会先通过门。
返回一个长度为 n 的数组 answer ，其中 answer[i] 是第 i 个人通过门的时刻（秒）。
注意：
- 每秒只有一个人可以通过门。
- 为遵循上述规则，一个人可以在到达门附近后等待，而不通过门进入或离开。
提示：
n == arrival.length == state.length
1 <= n <= 10^5
0 <= arrival[i] <= n
arrival 按 非递减顺序 排列
state[i] 为 0 或 1

https://leetcode.cn/problems/time-taken-to-cross-the-door/solutions/2064086/bi-jiao-jian-dan-de-you-xian-dui-lie-mo-9s17a/
相似题目: 2532. 过桥的时间
https://leetcode.cn/problems/time-to-cross-a-bridge/
 */