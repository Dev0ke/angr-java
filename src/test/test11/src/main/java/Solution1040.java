import java.util.Arrays;

public class Solution1040 {
    public int[] numMovesStonesII(int[] stones) {
        int n = stones.length;
        Arrays.sort(stones);

        // 最大移动次数
        // 从 s[0] 到 s[n-2] 之间的空位数
        // 从 s[1] 到 s[n-1] 之间的空位数
        int e1 = stones[n - 2] - stones[0] - n + 2;
        int e2 = stones[n - 1] - stones[1] - n + 2; // 计算空位
        int maxMove = Math.max(e1, e2);
        if (e1 == 0 || e2 == 0) { // 特殊情况：没有空位
            return new int[]{Math.min(2, maxMove), maxMove};
        }

        // 最小移动次数
        int l = 0, r = 0;
        int maxCnt = 0;
        while (r < n) { // 滑动窗口：枚举右端点所在石子
            while (stones[r] - stones[l] + 1 > n) { // 窗口长度大于 n
                l++; // 缩小窗口长度
            }
            maxCnt = Math.max(maxCnt, r - l + 1); // 维护窗口内的最大石子数
            r++;
        }
        return new int[]{n - maxCnt, maxMove};
    }
}
/*
1040. 移动石子直到连续 II
https://leetcode.cn/problems/moving-stones-until-consecutive-ii/description/

在一个长度 无限 的数轴上，第 i 颗石子的位置为 stones[i]。如果一颗石子的位置最小/最大，那么该石子被称作 端点石子 。
每个回合，你可以将一颗端点石子拿起并移动到一个未占用的位置，使得该石子不再是一颗端点石子。
值得注意的是，如果石子像 stones = [1,2,5] 这样，你将 无法 移动位于位置 5 的端点石子，因为无论将它移动到任何位置（例如 0 或 3），该石子都仍然会是端点石子。
当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。
要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：answer = [minimum_moves, maximum_moves] 。
提示：
3 <= stones.length <= 10^4
1 <= stones[i] <= 10^9
stones[i] 的值各不相同。

最大移动次数（数学）
最小移动次数（滑动窗口）
相似题目: 1033. 移动石子直到连续
https://leetcode.cn/problems/moving-stones-until-consecutive/description/
 */