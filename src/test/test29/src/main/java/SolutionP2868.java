public class SolutionP2868 {
    public boolean canAliceWin(String[] a, String[] b) {
        int n = a.length, m = b.length;
        int i = 0, j = 0;
        String lastWord = a[i++];
        while (true) {
            while (j < m && isTightlyGreater(b[j], lastWord)) j++;
            if (j == m) return true;
            lastWord = b[j++];
            while (i < n && isTightlyGreater(a[i], lastWord)) i++;
            if (i == n) return false;
            lastWord = a[i++];
        }
    }

    private boolean isTightlyGreater(String w, String z) {
        if (w.compareTo(z) <= 0) return true;
        return w.charAt(0) != z.charAt(0) && w.charAt(0) != z.charAt(0) + 1;
    }
}
/*
$2868. 单词游戏
https://leetcode.cn/problems/the-wording-game/description/

Alice 和 Bob 分别拥有一个 按字典序排序 的字符串数组，分别命名为 a 和 b。
他们正在玩一个单词游戏，遵循以下规则：
- 每一轮，当前玩家应该从他的列表中选择一个单词，并且选择的单词比上一个单词 紧邻大；然后轮到另一名玩家。
- 如果一名玩家在自己的回合中无法选择单词，则输掉比赛。
Alice 通过选择在 字典序最小 的单词开始游戏。
给定 a 和 b，已知两名玩家都按最佳策略玩游戏，如果 Alice 可以获胜，则返回 true ，否则返回 false。
如果满足以下条件，则称一个单词 w 比另一个单词 z 紧邻大：
- w 在 字典序上大于 z。
- 如果 w1 是 w 的第一个字母，z1 是 z 的第一个字母，那么 w1 应该 等于 z1 或者是字母表中 z1 后面相邻 的字母。
- 例如，单词 "care" 比 "book" 和 "car" 紧邻大，但不比 "ant" 或 "cook" 紧邻大。
如果在 s 和 t 不同的第一个位置处，字符串 s 的字母比字符串 t 的字母在字母表中的顺序更靠后，则称为字符串 s 在 字典序上大于 字符串 t。如果前 min(s.length, t.length) 个字符没有区别，那么较长的字符串是在字典序上较大的那一个。
约束条件：
1 <= a.length, b.length <= 10^5
a[i] 和 b[i] 仅包含小写英文字母。
a 和 b 按 字典序排序。
a 和 b 中所有的单词都是 不同的。
a 和 b 中所有单词的长度之和不超过 10^6。

双指针 + 贪心。
https://leetcode.cn/problems/the-wording-game/solutions/2890568/di-yi-ci-xie-duo-duo-bao-han-by-elegant-rsc35/
使用双指针分别遍历 Alice 和 Bob 的字符串数组。
每次轮到当前玩家时，寻找符合条件的紧邻大单词。
如果当前玩家无法找到合适的单词，则另一方获胜。
 */