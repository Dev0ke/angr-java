public class Solution1927 {
    public boolean sumGame(String num) {
        // case1: '?' 个数为奇数，Alice 胜
        // case2: '?' 个数为 0，左半部分等于右半部分，Bob 胜
        // case3: '?' 个数为 2 且出现在不同侧，左半部分等于右半部分，Bob 胜
        // case4: '?' 个数为 2 且出现在相同侧，包含 '?' 的一半比另一半小 9，Bob 胜
        // case5: 左半部分数字和 s0，'?' 个数 q0；右部分半数字和 s1，'?' 个数 q1；
        // q0+q1 为偶数，当 s0-s1 = 9/2 (q1-q0) 时，Bob 胜
        int n = num.length() / 2;
        int s0 = 0;
        int s1 = 0;
        int q0 = 0;
        int q1 = 0;
        for (int i = 0; i < n; i++) {
            if (num.charAt(i) == '?') {
                q0++;
            } else {
                s0 += num.charAt(i) - '0';
            }

            if (num.charAt(i + n) == '?') {
                q1++;
            } else {
                s1 += num.charAt(i + n) - '0';
            }
        }

        if ((q0 + q1) % 2 == 1) {
            return true;
        }
        if (q0 + q1 == 0 && s0 == s1) {
            return false;
        }
        if (q0 == 1 && q1 == 1 && s0 == s1) {
            return false;
        }
        if ((q0 == 2 && q1 == 0 && s1 - s0 == 9) || (q0 == 0 && q1 == 2 && s0 - s1 == 9)) {
            return false;
        }
        if (s0 - s1 == (q1 - q0) * 9 / 2) {
            return false;
        }
        return true;
    }
}
/*
1927. 求和游戏
https://leetcode.cn/problems/sum-game/

第 56 场双周赛 T3。

Alice 和 Bob 玩一个游戏，两人轮流行动，Alice 先手 。
给你一个 偶数长度 的字符串 num ，每一个字符为数字字符或者 '?' 。每一次操作中，如果 num 中至少有一个 '?' ，那么玩家可以执行以下操作：
1. 选择一个下标 i 满足 num[i] == '?' 。
2. 将 num[i] 用 '0' 到 '9' 之间的一个数字字符替代。
当 num 中没有 '?' 时，游戏结束。
Bob 获胜的条件是 num 中前一半数字的和 等于 后一半数字的和。Alice 获胜的条件是前一半的和与后一半的和 不相等 。
- 比方说，游戏结束时 num = "243801" ，那么 Bob 获胜，因为 2+4+3 = 8+0+1 。如果游戏结束时 num = "243803" ，那么 Alice 获胜，因为 2+4+3 != 8+0+3 。
在 Alice 和 Bob 都采取 最优 策略的前提下，如果 Alice 获胜，请返回 true ，如果 Bob 获胜，请返回 false 。
提示：
2 <= num.length <= 10^5
num.length 是 偶数 。
num 只包含数字字符和 '?' 。

分类讨论 + 数学归纳法验证
时间复杂度 O(n)
空间复杂度 O(n)
 */