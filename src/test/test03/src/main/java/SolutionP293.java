import java.util.ArrayList;
import java.util.List;

public class SolutionP293 {
    public List<String> generatePossibleNextMoves(String currentState) {
        int n = currentState.length();
        char[] s = currentState.toCharArray();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i + 1 < n; i++) {
            if (s[i] == '+' && s[i + 1] == '+') {
                s[i] = '-';
                s[i + 1] = '-';
                ans.add(new String(s));
                s[i] = '+';
                s[i + 1] = '+';
            }
        }
        return ans;
    }
}
/*
$293. 翻转游戏
https://leetcode.cn/problems/flip-game/description/

你和朋友玩一个叫做「翻转游戏」的游戏。游戏规则如下：
给你一个字符串 currentState ，其中只含 '+' 和 '-' 。你和朋友轮流将 连续 的两个 "++" 反转成 "--" 。当一方无法进行有效的翻转时便意味着游戏结束，则另一方获胜。
计算并返回 一次有效操作 后，字符串 currentState 所有的可能状态，返回结果可以按 任意顺序 排列。如果不存在可能的有效操作，请返回一个空列表 [] 。
提示：
1 <= currentState.length <= 500
currentState[i] 不是 '+' 就是 '-'

模拟。
时间复杂度 O(n^2)。
 */