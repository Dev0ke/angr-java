import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> set = new HashSet<>(wordDict);

        boolean[] f = new boolean[n + 1];
        f[0] = true;
        // 状态转移 f[0,j-1] && f[j,i-1]
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && set.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n];
    }
}
/*
139. 单词拆分
https://leetcode.cn/problems/word-break/

给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
提示：
1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s 和 wordDict[i] 仅有小写英文字母组成
wordDict 中的所有字符串 互不相同

动态规划。
dp[i] 表示字符串 s[0,i-1] 是否可以被空格拆分为一个或多个在字典中出现的单词
时间复杂度 O(n^2)
空间复杂度 O(n)
 */