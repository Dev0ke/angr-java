import java.util.Arrays;

public class Solution2405 {
    public int partitionString(String s) {
        int len = s.length();
        int cnt = 1;
        boolean[] visited = new boolean[26];
        for (int i = 0; i < len; i++) {
            int idx = s.charAt(i) - 'a';
            if (!visited[idx]) {
                visited[idx] = true;
            } else {
                cnt++;
                Arrays.fill(visited, false);
                visited[idx] = true;
            }
        }
        return cnt;
    }
}
/*
2405. 子字符串的最优划分
https://leetcode.cn/problems/optimal-partition-of-string/

第 310 场周赛 T2。

给你一个字符串 s ，请你将该字符串划分成一个或多个 子字符串 ，并满足每个子字符串中的字符都是 唯一 的。也就是说，在单个子字符串中，字母的出现次数都不超过 一次 。
满足题目要求的情况下，返回 最少 需要划分多少个子字符串。
注意，划分后，原字符串中的每个字符都应该恰好属于一个子字符串。
提示：
1 <= s.length <= 10^5
s 仅由小写英文字母组成

滑动窗口，每个窗口内，字母的出现次数都不超过 一次。
 */