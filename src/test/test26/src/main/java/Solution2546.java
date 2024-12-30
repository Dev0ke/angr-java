public class Solution2546 {
    public boolean makeStringsEqual(String s, String target) {
        if (s.equals(target)) {
            return true;
        }
        int n = s.length();
        int s0 = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                s0++;
            }
        }
        int t0 = 0;
        for (char ch : target.toCharArray()) {
            if (ch == '0') {
                t0++;
            }
        }
        return s0 != n && t0 != n;
    }

    public boolean makeStringsEqual2(String s, String target) {
        return s.contains("1") == target.contains("1");
    }
}
/*
2546. 执行逐位运算使字符串相等
https://leetcode.cn/problems/apply-bitwise-operations-to-make-strings-equal/

第 329 场周赛 T3。

给你两个下标从 0 开始的 二元 字符串 s 和 target ，两个字符串的长度均为 n 。你可以对 s 执行下述操作 任意 次：
- 选择两个 不同 的下标 i 和 j ，其中 0 <= i, j < n 。
- 同时，将 s[i] 替换为 (s[i] OR s[j]) ，s[j] 替换为 (s[i] XOR s[j]) 。
例如，如果 s = "0110" ，你可以选择 i = 0 和 j = 2，然后同时将 s[0] 替换为 (s[0] OR s[2] = 0 OR 1 = 1)，并将 s[2] 替换为 (s[0] XOR s[2] = 0 XOR 1 = 1)，最终得到 s = "1110" 。
如果可以使 s 等于 target ，返回 true ，否则，返回 false 。
提示：
n == s.length == target.length
2 <= n <= 10^5
s 和 target 仅由数字 0 和 1 组成

找规律
i,j -> i|j, i^j
0,0 -> 0,0
0,1 -> 1,1
1,0 -> 1,1
1,1 -> 1,0
可以观察到 1 不能凭空出现，不能突然消失。
如果数组本身没 1，将不可能出现 1；
如果数组本身有 1，不可能全部变成 0；
因此当两数组不相等时，其中任一数组不能为全 0 数组
 */