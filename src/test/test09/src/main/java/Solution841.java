import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // BFS
        int n = rooms.size();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        BitSet bitSet = new BitSet(n);
        bitSet.set(0, true);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.remove();
                List<Integer> keys = rooms.get(cur);

                for (int key : keys) {
                    if (!bitSet.get(key)) {
                        bitSet.set(key, true);
                        queue.add(key);
                    }
                }
            }
        }
        return bitSet.cardinality() == n;
    }
}
/*
841. 钥匙和房间
https://leetcode.cn/problems/keys-and-rooms/

第 86 场周赛 T2。

有 n 个房间，房间按从 0 到 n - 1 编号。最初，除 0 号房间外的其余所有房间都被锁住。你的目标是进入所有的房间。然而，你不能在没有获得钥匙的时候进入锁住的房间。
当你进入一个房间，你可能会在里面找到一套不同的钥匙，每把钥匙上都有对应的房间号，即表示钥匙可以打开的房间。你可以拿上所有钥匙去解锁其他房间。
给你一个数组 rooms 其中 rooms[i] 是你进入 i 号房间可以获得的钥匙集合。如果能进入 所有 房间返回 true，否则返回 false。
提示：
n == rooms.length
2 <= n <= 1000
0 <= rooms[i].length <= 1000
1 <= sum(rooms[i].length) <= 3000
0 <= rooms[i][j] < n
所有 rooms[i] 的值 互不相同

BFS。
 */