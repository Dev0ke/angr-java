import java.util.PriorityQueue;

public class Solution2532 {
    public int findCrossingTime(int n, int k, int[][] time) {
        // 大顶堆
        PriorityQueue<Worker> bridge = new PriorityQueue<>((o1, o2) -> {
            if (o1.right == o2.right) {
                int t1 = o1.leftToRight + o1.rightToLeft;
                int t2 = o2.leftToRight + o2.rightToLeft;
                if (t1 == t2) {
                    return o2.i - o1.i;
                }
                return t2 - t1;
            }
            // 如果没有正在过桥的工人，那么在桥右边等待的工人可以先过桥。
            return o2.right - o1.right;
        });

        // 小顶堆
        PriorityQueue<Worker> free = new PriorityQueue<>((o1, o2) -> {
            if (o1.t == o2.t) {
                if (o1.right == o2.right) {
                    int t1 = o1.leftToRight + o1.rightToLeft;
                    int t2 = o2.leftToRight + o2.rightToLeft;
                    if (t1 == t2) {
                        return o2.i - o1.i;
                    }
                    return t2 - t1;
                }
                // 如果没有正在过桥的工人，那么在桥右边等待的工人可以先过桥。
                return o2.right - o1.right;
            }
            return o1.t - o2.t;
        });

        for (int i = 0; i < k; i++) {
            Worker worker = new Worker(i, time[i][0], time[i][1], time[i][2], time[i][3]);
            bridge.add(worker);
        }

        // 当前时间 出堆才算过桥
        int t = 0;
        while (n > 0) {
            while (!free.isEmpty() && free.peek().t <= t) {
                Worker f = free.remove();
                bridge.add(f);
            }
            // 保证桥上有人
            if (bridge.isEmpty()) {
                Worker f = free.remove();
                t = f.t;
                bridge.add(f);
            }

            Worker worker = bridge.remove();
            if (worker.right == 0) {
                // 左到右
                t += worker.leftToRight;
                worker.t = t + worker.pickOld;
                worker.right = 1;
                free.add(worker);
                n--;
            } else {
                // 右到左
                t += worker.rightToLeft;
                worker.t = t + worker.putNew;
                worker.right = 0;
                free.add(worker);
            }
        }

        // 清空 free
        while (!free.isEmpty()) {
            while (!free.isEmpty() && free.peek().t <= t) {
                Worker f = free.remove();
                bridge.add(f);
            }
            // 保证桥上有人
            if (bridge.isEmpty()) {
                Worker f = free.remove();
                t = f.t;
                bridge.add(f);
            }
            Worker worker = bridge.remove();
            if (worker.right == 1) {
                // 右到左
                t += worker.rightToLeft;
            }
        }
        // 清空 bridge
        while (!bridge.isEmpty()) {
            Worker worker = bridge.remove();
            if (worker.right == 1) {
                // 右到左
                t += worker.rightToLeft;
            } else {
                break;
            }
        }
        return t;
    }

    private static class Worker {
        int i;
        int leftToRight, pickOld, rightToLeft, putNew;
        // 可以过桥的最小时刻
        int t;
        // 左边 = 0, 右边 = 1
        int right;

        public Worker(int i, int leftToRight, int pickOld, int rightToLeft, int putNew) {
            this.i = i;
            this.leftToRight = leftToRight;
            this.pickOld = pickOld;
            this.rightToLeft = rightToLeft;
            this.putNew = putNew;
        }
    }
}
/*
2532. 过桥的时间
https://leetcode.cn/problems/time-to-cross-a-bridge/

第 327 场周赛 T4。

共有 k 位工人计划将 n 个箱子从旧仓库移动到新仓库。给你两个整数 n 和 k，以及一个二维整数数组 time ，数组的大小为 k x 4 ，其中 time[i] = [leftToRighti, pickOldi, rightToLefti, putNewi] 。
一条河将两座仓库分隔，只能通过一座桥通行。旧仓库位于河的右岸，新仓库在河的左岸。开始时，所有 k 位工人都在桥的左侧等待。为了移动这些箱子，第 i 位工人（下标从 0 开始）可以：
- 从左岸（新仓库）跨过桥到右岸（旧仓库），用时 leftToRighti 分钟。
- 从旧仓库选择一个箱子，并返回到桥边，用时 pickOldi 分钟。不同工人可以同时搬起所选的箱子。
- 从右岸（旧仓库）跨过桥到左岸（新仓库），用时 rightToLefti 分钟。
- 将箱子放入新仓库，并返回到桥边，用时 putNewi 分钟。不同工人可以同时放下所选的箱子。
如果满足下面任一条件，则认为工人 i 的 效率低于 工人 j ：
- leftToRighti + rightToLefti > leftToRightj + rightToLeftj
- leftToRighti + rightToLefti == leftToRightj + rightToLeftj 且 i > j
工人通过桥时需要遵循以下规则：
- 如果工人 x 到达桥边时，工人 y 正在过桥，那么工人 x 需要在桥边等待。
- 如果没有正在过桥的工人，那么在桥右边等待的工人可以先过桥。如果同时有多个工人在右边等待，那么 效率最低 的工人会先过桥。
- 如果没有正在过桥的工人，且桥右边也没有在等待的工人，同时旧仓库还剩下至少一个箱子需要搬运，此时在桥左边的工人可以过桥。如果同时有多个工人在左边等待，那么 效率最低 的工人会先过桥。
所有 n 个盒子都需要放入新仓库，请你返回最后一个搬运箱子的工人 到达河左岸 的时间。
提示：
1 <= n, k <= 10^4
time.length == k
time[i].length == 4
1 <= leftToRighti, pickOldi, rightToLefti, putNewi <= 1000

四堆模拟
也可以写成双堆模拟。
相似题目: 1834. 单线程 CPU
https://leetcode.cn/problems/single-threaded-cpu/
$2534. 通过门的时间
https://leetcode.cn/problems/time-taken-to-cross-the-door/description/
 */