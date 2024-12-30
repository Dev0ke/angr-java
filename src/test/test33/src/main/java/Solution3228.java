public class Solution3228 {
    public int maxOperations(String s) {
        s = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int ans = 0;
        int cnt0 = 0;
        int i = 0;
        while (i < n) {
            // 分组循环
            int st = i;
            for (i++; i < n && s.charAt(i) == s.charAt(st); i++) {
            }
            if (s.charAt(st) == '1') {
                ans += (i - st) * cnt0;
            } else {
                cnt0++;
            }
        }
        return ans;
    }
}
/*
3228. 将 1 移动到末尾的最大操作次数
https://leetcode.cn/problems/maximum-number-of-operations-to-move-ones-to-the-end/description/

第 407 场周赛 T3。

给你一个 二进制字符串 s。
你可以对这个字符串执行 任意次 下述操作：
- 选择字符串中的任一下标 i（ i + 1 < s.length ），该下标满足 s[i] == '1' 且 s[i + 1] == '0'。
- 将字符 s[i] 向 右移 直到它到达字符串的末端或另一个 '1'。例如，对于 s = "010010"，如果我们选择 i = 1，结果字符串将会是 s = "000110"。
返回你能执行的 最大 操作次数。
提示：
1 <= s.length <= 10^5
s[i] 为 '0' 或 '1'。

分组循环。要使操作次数最大，靠后的 1 先移动。
时间复杂度 O(n)。
 */