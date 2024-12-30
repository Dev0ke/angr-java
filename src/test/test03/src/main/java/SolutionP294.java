import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionP294 {
    public boolean canWin(String currentState) {
        List<Integer> dec = new ArrayList<>();
        currentState = currentState + "s";
        int cnt = 0;
        int dpSize = 0;
        // 分解原状态至多个不可分解的子态
        for (char c : currentState.toCharArray()) {
            if (c == '+') {
                cnt++;
            } else {
                dec.add(cnt);
                dpSize = Math.max(dpSize, cnt);
                cnt = 0;
            }
        }
        if (dpSize <= 1) {
            return false;
        }

        int[] dp = new int[dpSize + 1];

        // 枚举所有不可细分的子状态（0,1 时为 0 已经返回 false，从 2 开始遍历）
        for (int i = 2; i <= dpSize; i++) {
            // 子状态不可以拆分，那么子状态的值等于所有下一个状态的集合外的最小非负整数
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < i / 2; j++) {
                // 每种翻转后，形成的次态可以分解成两种状态
                // 可分解的状态（g值）等于各分解子状态（g值）的异或和
                set.add(dp[j] ^ dp[i - j - 2]);
            }
            // 找到最小的不在集合中的数字，就是本状态的g值
            for (int k = 0; k <= i / 2; k++) {
                if (set.contains(k)) {
                    continue;
                } else {
                    dp[i] = k;
                    break;
                }
            }
        }

        int a = 0;
        for (int b : dec) {
            a ^= dp[b];
        }
        return a != 0;
    }
}
/*
$294. 翻转游戏 II
https://leetcode.cn/problems/flip-game-ii/

你和朋友玩一个叫做「翻转游戏」的游戏。游戏规则如下：
给你一个字符串 currentState ，其中只含 '+' 和 '-' 。你和朋友轮流将 连续 的两个 "++" 反转成 "--" 。当一方无法进行有效的翻转时便意味着游戏结束，则另一方获胜。默认每个人都会采取最优策略。
请你写出一个函数来判定起始玩家 是否存在必胜的方案 ：如果存在，返回 true ；否则，返回 false 。
提示：
1 <= currentState.length <= 60
currentState[i] 不是 '+' 就是 '-'

Sprague-Grundy 定理
https://leetcode.cn/problems/flip-game-ii/solution/c-sprague-grundy-acmbo-yi-lun-xiang-guan-1ddj/
https://zhuanlan.zhihu.com/p/20611132
https://edwiv.com/wp-content/uploads/2019/08/ACM-ICPC_Templates_201805.pdf
https://oi-wiki.org/math/game-theory/impartial-game/
时间复杂度 O(n^2)
 */