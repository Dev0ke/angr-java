public class Solution2351 {
    public char repeatedCharacter(String s) {
        boolean[] visited = new boolean[26];
        for (char ch : s.toCharArray()) {
            if (!visited[ch - 'a']) {
                visited[ch - 'a'] = true;
            } else {
                return ch;
            }
        }
        return 'a';
    }
}
/*
2351. 第一个出现两次的字母
https://leetcode.cn/problems/first-letter-to-appear-twice/

第 303 场周赛 T1。

给你一个由小写英文字母组成的字符串 s ，请你找出并返回第一个出现 两次 的字母。
注意：
- 如果 a 的 第二次 出现比 b 的 第二次 出现在字符串中的位置更靠前，则认为字母 a 在字母 b 之前出现两次。
- s 包含至少一个出现两次的字母。
提示：
2 <= s.length <= 100
s 由小写英文字母组成
s 包含至少一个重复字母

模拟。
 */