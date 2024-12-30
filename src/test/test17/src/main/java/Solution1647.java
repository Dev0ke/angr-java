import java.util.Arrays;

public class Solution1647 {
    public int minDeletions(String s) {
        final int C = 26;
        int[] cnt = new int[C];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        Arrays.sort(cnt);

        int ans = 0;
        int pre = cnt[C - 1];
        for (int i = 1; i < C && cnt[C - 1 - i] > 0; i++) {
            if (pre <= cnt[C - 1 - i]) {
                pre = Math.max(pre - 1, 0);
                ans += (cnt[C - 1 - i] - pre);
            } else {
                pre = cnt[C - 1 - i];
            }
        }
        return ans;
    }
}
/*
1647. 字符频次唯一的最小删除次数
https://leetcode.cn/problems/minimum-deletions-to-make-character-frequencies-unique/description/

如果字符串 s 中 不存在 两个不同字符 频次 相同的情况，就称 s 是 优质字符串 。
给你一个字符串 s，返回使 s 成为 优质字符串 需要删除的 最小 字符数。
字符串中字符的 频次 是该字符在字符串中的出现次数。例如，在字符串 "aab" 中，'a' 的频次是 2，而 'b' 的频次是 1 。
提示：
1 <= s.length <= 10^5
s 仅含小写英文字母

贪心。统计字符频次。然后大到小枚举（因为只能删不能增）。
时间复杂度 O(n + ClogC)。
 */