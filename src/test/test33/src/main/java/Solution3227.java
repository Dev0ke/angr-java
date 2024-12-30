public class Solution3227 {
    public boolean doesAliceWin(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (isVowel(c)) cnt++;
        }
        return cnt > 0;
    }

    private boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) >= 0;
    }
}
/*
3227. 字符串元音游戏
https://leetcode.cn/problems/vowels-game-in-a-string/description/

第 407 场周赛 T2。

小红和小明在玩一个字符串元音游戏。
给你一个字符串 s，小红和小明将轮流参与游戏，小红 先 开始：
- 在小红的回合，她必须移除 s 中包含 奇数 个元音的任意 非空 子字符串。
- 在小明的回合，他必须移除 s 中包含 偶数 个元音的任意 非空 子字符串。
第一个无法在其回合内进行移除操作的玩家输掉游戏。假设小红和小明都采取 最优策略 。
如果小红赢得游戏，返回 true，否则返回 false。
英文元音字母包括：a, e, i, o, 和 u。
提示：
1 <= s.length <= 10^5
s 仅由小写英文字母组成。

诈骗题 / 贪心。
如果是奇数，小红 就一次拿完。
如果是偶数，小红 就先拿一次奇数，再拿一次奇数。
时间复杂度 O(n)。
 */