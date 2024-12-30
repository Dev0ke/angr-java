import java.util.Arrays;

public class Solution464 {
    private int maxChoosableInteger;
    private int desiredTotal;
    private int[] memo;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // 特判，sum < desiredTotal 时，两人都无法获胜
        if ((1 + maxChoosableInteger) * (maxChoosableInteger) / 2 < desiredTotal) {
            return false;
        }
        this.maxChoosableInteger = maxChoosableInteger;
        this.desiredTotal = desiredTotal;
        this.memo = new int[1 << maxChoosableInteger];
        Arrays.fill(memo, -1);
        return dfs(0, 0) == 1;
    }

    // f(mask, total) 选择状态为 mask 时，和为 total，先出手的玩家是否能稳赢
    private int dfs(int mask, int total) {
        if (memo[mask] != -1) {
            return memo[mask];
        }
        int res = 0;
        for (int k = 0; k < maxChoosableInteger; k++) {
            if ((mask >> k & 1) == 0) {
                if (k + 1 + total >= desiredTotal) {
                    res = 1;
                    break;
                }
                if (dfs(mask | (1 << k), total + k + 1) == 0) {
                    res = 1;
                    break;
                }
            }
        }
        return memo[mask] = res;
    }
}
/*
464. 我能赢吗
https://leetcode.cn/problems/can-i-win/

在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和 达到或超过  100 的玩家，即为胜者。
如果我们将游戏规则改为 “玩家 不能 重复使用整数” 呢？
例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。
给定两个整数 maxChoosableInteger （整数池中可选择的最大数）和 desiredTotal（累计和），若先出手的玩家是否能稳赢则返回 true ，否则返回 false 。假设两位玩家游戏时都表现 最佳 。
提示:
1 <= maxChoosableInteger <= 20
0 <= desiredTotal <= 300

状态压缩动态规划
时间复杂度 O(n*2^n)
 */