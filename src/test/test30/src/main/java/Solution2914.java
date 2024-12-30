public class Solution2914 {
    public int minChanges(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                ans++;
            }
        }
        return ans;
    }
}
/*
2914. 使二进制字符串变美丽的最少修改次数
https://leetcode.cn/problems/minimum-number-of-changes-to-make-binary-string-beautiful/

第 116 场双周赛 T2。

给你一个长度为偶数下标从 0 开始的二进制字符串 s 。
如果可以将一个字符串分割成一个或者更多满足以下条件的子字符串，那么我们称这个字符串是 美丽的 ：
- 每个子字符串的长度都是 偶数 。
- 每个子字符串都 只 包含 1 或 只 包含 0 。
你可以将 s 中任一字符改成 0 或者 1 。
请你返回让字符串 s 美丽的 最少 字符修改次数。
提示：
2 <= s.length <= 10^5
s 的长度为偶数。
s[i] 要么是 '0' ，要么是 '1' 。

脑筋急转弯
由于 s 的长度为偶数，所以一定有解，贪心的做法的按长度 2 分割子字符串。
时间复杂度 O(n)
 */