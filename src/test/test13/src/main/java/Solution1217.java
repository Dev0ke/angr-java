public class Solution1217 {
    public int minCostToMoveChips(int[] position) {
        int len = position.length;
        // 统计奇偶数个数，返回较少值
        int oddCnt = 0;
        for (int pos : position) {
            if (pos % 2 == 1) {
                oddCnt++;
            }
        }
        return Math.min(oddCnt, len - oddCnt);
    }
}
/*
1217. 玩筹码
https://leetcode.cn/problems/minimum-cost-to-move-chips-to-the-same-position/

第 157 场周赛 T1。

有 n 个筹码。第 i 个筹码的位置是 position[i] 。
我们需要把所有筹码移到同一个位置。在一步中，我们可以将第 i 个筹码的位置从 position[i] 改变为:
- position[i] + 2 或 position[i] - 2 ，此时 cost = 0
- position[i] + 1 或 position[i] - 1 ，此时 cost = 1
返回将所有筹码移动到同一位置上所需要的 最小代价 。
提示：
1 <= position.length <= 100
1 <= position[i] <= 10^9

贪心。由于 向左或者右移动 2 个单位，代价为 0。因此只需考虑 是 奇数向偶数移动 还是 偶数向奇数移动 即可。取二者最小值。
 */