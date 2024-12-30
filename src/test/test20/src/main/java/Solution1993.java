import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1993 {
    static class LockingTree {
        private final Map<Integer, List<Integer>> g;
        private final int[] who, pa;

        public LockingTree(int[] parent) {
            int n = parent.length;
            g = new HashMap<>();
            for (int w = 1; w < n; w++) {
                int v = parent[w];
                g.computeIfAbsent(v, key -> new ArrayList<>()).add(w);
            }
            who = new int[n];
            pa = parent;
        }

        public boolean lock(int num, int user) {
            if (who[num] > 0) {
                return false;
            }
            who[num] = user;
            return true;
        }

        public boolean unlock(int num, int user) {
            if (who[num] != user) {
                return false;
            }
            who[num] = 0;
            return true;
        }

        public boolean upgrade(int num, int user) {
            // 指定节点当前状态为未上锁。
            // 指定节点没有任何上锁的祖先节点。
            for (int v = num; v >= 0; v = pa[v]) {
                if (who[v] > 0) {
                    return false;
                }
            }
            // 指定节点至少有一个上锁状态的子孙节点（可以是 任意 用户上锁的）。
            if (!hasLock(num)) {
                return false;
            }
            // 指定用户给指定节点 上锁
            who[num] = user;
            unLock(num);
            return true;
        }

        // 判断 v 的子孙是否有锁
        private boolean hasLock(int v) {
            for (Integer w : g.getOrDefault(v, new ArrayList<>())) {
                if (who[w] > 0 || hasLock(w)) {
                    return true;
                }
            }
            return false;
        }

        // 解锁 v 的所有子孙
        private void unLock(int v) {
            for (Integer w : g.getOrDefault(v, new ArrayList<>())) {
                who[w] = 0;
                unLock(w);
            }
        }
    }
}
/*
1993. 树上的操作
https://leetcode.cn/problems/operations-on-tree/

第 60 场双周赛 T3。

给你一棵 n 个节点的树，编号从 0 到 n - 1 ，以父节点数组 parent 的形式给出，其中 parent[i] 是第 i 个节点的父节点。
树的根节点为 0 号节点，所以 parent[0] = -1 ，因为它没有父节点。你想要设计一个数据结构实现树里面对节点的加锁，解锁和升级操作。
数据结构需要支持如下函数：
- Lock：指定用户给指定节点 上锁 ，上锁后其他用户将无法给同一节点上锁。只有当节点处于未上锁的状态下，才能进行上锁操作。
- Unlock：指定用户给指定节点 解锁 ，只有当指定节点当前正被指定用户锁住时，才能执行该解锁操作。
- Upgrade：指定用户给指定节点 上锁 ，并且将该节点的所有子孙节点 解锁 。只有如下 3 个条件 全部 满足时才能执行升级操作：
  - 指定节点当前状态为未上锁。
  - 指定节点至少有一个上锁状态的子孙节点（可以是 任意 用户上锁的）。
  - 指定节点没有任何上锁的祖先节点。
请你实现 LockingTree 类：
- LockingTree(int[] parent) 用父节点数组初始化数据结构。
- lock(int num, int user) 如果 id 为 user 的用户可以给节点 num 上锁，那么返回 true ，否则返回 false 。如果可以执行此操作，节点 num 会被 id 为 user 的用户 上锁 。
- unlock(int num, int user) 如果 id 为 user 的用户可以给节点 num 解锁，那么返回 true ，否则返回 false 。如果可以执行此操作，节点 num 变为 未上锁 状态。
- upgrade(int num, int user) 如果 id 为 user 的用户可以给节点 num 升级，那么返回 true ，否则返回 false 。如果可以执行此操作，节点 num 会被 升级 。
提示：
n == parent.length
2 <= n <= 2000
对于 i != 0 ，满足 0 <= parent[i] <= n - 1
parent[0] == -1
0 <= num <= n - 1
1 <= user <= 10^4
parent 表示一棵合法的树。
lock ，unlock 和 upgrade 的调用 总共 不超过 2000 次。

DFS 模拟
 */