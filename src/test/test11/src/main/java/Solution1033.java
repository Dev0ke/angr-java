import java.util.Arrays;

public class Solution1033 {
    public int[] numMovesStones(int a, int b, int c) {
        int[] p = {a, b, c};
        Arrays.sort(p);
        a = p[0];
        b = p[1];
        c = p[2];

        int[] ans = {2, c - a - 2};
        if (c - a == 2) ans[0] = 0;
        else if (b - a <= 2 || c - b <= 2) ans[0] = 1;
        return ans;
    }
}
/*
1033. 移动石子直到连续
https://leetcode.cn/problems/moving-stones-until-consecutive/description/

三枚石子放置在数轴上，位置分别为 a，b，c。
每一回合，你可以从两端之一拿起一枚石子（位置最大或最小），并将其放入两端之间的任一空闲位置。形式上，假设这三枚石子当前分别位于位置 x, y, z 且 x < y < z。那么就可以从位置 x 或者是位置 z 拿起一枚石子，并将该石子移动到某一整数位置 k 处，其中 x < k < z 且 k != y。
当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。
要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：answer = [minimum_moves, maximum_moves]
提示：
1 <= a <= 100
1 <= b <= 100
1 <= c <= 100
a != b, b != c, c != a

分类讨论。
设 a <= b <= c
最大移动次数：a 和 c 向 b 靠拢，每次只移动一个单位长度，答案就是 c−a−2。
最小移动次数：
  - 如果 c−a=2，已经连续，无需移动。
  - 如果 b−a=1 或者 c−b=1，说明有两颗石子已经连续，那么只需移动 1 次另一颗石子。
  - 如果 b−a=2 或者 c−b=2，那么把一颗石子移到另外两颗石子之间，只需移动 1 次移动。
  - 否则，a 移动到 b−1，c 移动到 b+1，一共 2 次移动。
时间复杂度 O(1)
相似题目: 1040. 移动石子直到连续 II
https://leetcode.cn/problems/moving-stones-until-consecutive-ii/description/
 */