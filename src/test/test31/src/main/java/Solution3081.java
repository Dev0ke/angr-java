import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3081 {
    public String minimizeStringValue(String s) {
        int n = s.length();
        char[] ans = s.toCharArray();
        int[] cnt = new int[26];
        for (char c : ans) {
            if (c != '?') {
                cnt[c - 'a']++;
            }
        }

        int tot = n - Arrays.stream(cnt).sum();
        List<Character> charList = new ArrayList<>();
        for (int L = 1; L <= n && tot > 0; L++) {
            for (int i = 0; i < 26; i++) {
                if (cnt[i] < L) {
                    cnt[i]++;
                    char c = (char) (i + 'a');
                    charList.add(c);
                    tot--;
                    if (tot == 0) break;
                }
            }
        }
        charList.sort(null);

        int j = 0;
        for (int i = 0; i < n; i++) {
            if (ans[i] == '?') {
                ans[i] = charList.get(j++);
            }
        }
        return new String(ans);
    }
}
/*
3081. 替换字符串中的问号使分数最小
https://leetcode.cn/problems/replace-question-marks-in-string-to-minimize-its-value/description/

第 126 场双周赛 T3。

给你一个字符串 s 。s[i] 要么是小写英文字母，要么是问号 '?' 。
对于长度为 m 且 只 含有小写英文字母的字符串 t ，我们定义函数 cost(i) 为下标 i 之前（也就是范围 [0, i - 1] 中）出现过与 t[i] 相同 字符出现的次数。
字符串 t 的 分数 为所有下标 i 的 cost(i) 之 和 。
比方说，字符串 t = "aab" ：
- cost(0) = 0
- cost(1) = 1
- cost(2) = 0
- 所以，字符串 "aab" 的分数为 0 + 1 + 0 = 1 。
你的任务是用小写英文字母 替换 s 中 所有 问号，使 s 的 分数最小 。
请你返回替换所有问号 '?' 之后且分数最小的字符串。如果有多个字符串的 分数最小 ，那么返回字典序最小的一个。
提示：
1 <= s.length <= 10^5
s[i] 要么是小写英文字母，要么是 '?' 。

贪心。
时间复杂度 O(nlogn)
 */