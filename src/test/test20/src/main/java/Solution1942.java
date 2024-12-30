import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;

public class Solution1942 {
    public int smallestChair(int[][] times, int targetFriend) {
        int[] targetFriendTimes = times[targetFriend];
        // 按到达时间升序排序
        Arrays.sort(times, Comparator.comparingInt(o -> o[0]));
        // BitSet 模拟
        int len = times.length;
        BitSet[] bitSet = new BitSet[len];
        for (int i = 0; i < len; i++) {
            bitSet[i] = new BitSet(100000);
            bitSet[i].set(0, len, false);
        }
        for (int[] time : times) {
            int arrival = time[0];
            int leaving = time[1];
            // 编号最小 且未被占据的椅子
            int seat = 0;
            while (bitSet[seat].get(arrival)) {
                seat++;
            }
            // 占据椅子
            bitSet[seat].set(arrival, leaving, true);
            if (arrival == targetFriendTimes[0]) {
                return seat;
            }
        }
        return 0;
    }
}
/*
1942. 最小未被占据椅子的编号
https://leetcode.cn/problems/the-number-of-the-smallest-unoccupied-chair/

第 57 场双周赛 T2。

有 n 个朋友在举办一个派对，这些朋友从 0 到 n - 1 编号。派对里有 无数 张椅子，编号为 0 到 infinity 。当一个朋友到达派对时，他会占据 编号最小 且未被占据的椅子。
- 比方说，当一个朋友到达时，如果椅子 0 ，1 和 5 被占据了，那么他会占据 2 号椅子。
当一个朋友离开派对时，他的椅子会立刻变成未占据状态。如果同一时刻有另一个朋友到达，可以立即占据这张椅子。
给你一个下标从 0 开始的二维整数数组 times ，其中 times[i] = [arrivali, leavingi] 表示第 i 个朋友到达和离开的时刻，
同时给你一个整数 targetFriend 。所有到达时间 互不相同 。
请你返回编号为 targetFriend 的朋友占据的 椅子编号 。
提示：
n == times.length
2 <= n <= 10^4
times[i].length == 2
1 <= arrivali < leavingi <= 10^5
0 <= targetFriend <= n - 1
每个 arrivali 时刻 互不相同 。

1 <= arrivali < leavingi <= 10^5
暴力时间复杂度达 O(n^2) 使用 BitSet 进行模拟可以 AC
 */