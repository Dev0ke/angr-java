public class Solution3223 {
    public int minimumLength(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        int ans = 0;
        for (int c : cnt) {
            if (c == 0) continue;
            ans += c % 2 == 0 ? 2 : 1;
        }
        return ans;
    }
}
/*
3223. 操作后字符串的最短长度
https://leetcode.cn/problems/minimum-length-of-string-after-operations/description/

第 135 场双周赛 T2。

给你一个字符串 s 。
你需要对 s 执行以下操作 任意 次：
- 选择一个下标 i ，满足 s[i] 左边和右边都 至少 有一个字符与它相同。
- 删除 s[i] 左边 离它 最近 且相同的字符。
- 删除 s[i] 右边 离它 最近 且相同的字符。
请你返回执行完所有操作后， s 的 最短 长度。
提示：
1 <= s.length <= 2 * 10^5
s 只包含小写英文字母。

贪心。统计字符频次，对于每种字符，如果有偶数个，最后会剩下 2 个，否则剩下 1 个。
时间复杂度 O(n)。
 */