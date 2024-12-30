public class Solution2266 {
    private static final long MOD = 1000000007;
    private static final int MAX_LEN = 100000;
    private long[] f;
    private long[] g;

    public int countTexts(String pressedKeys) {
        // f(i) = f(i-1) + f(i-2) + f(i-3)
        // g(i) = g(i-1) + g(i-2) + g(i-3) + g(i-4)
        if (f == null) {
            f = new long[MAX_LEN + 1];
            g = new long[MAX_LEN + 1];
            g[0] = f[0] = 1;
            g[1] = f[1] = 1;
            g[2] = f[2] = 2;
            g[3] = f[3] = 4;
            for (int i = 4; i <= MAX_LEN; i++) {
                f[i] = (f[i - 1] + f[i - 2] + f[i - 3]) % MOD;
                g[i] = (g[i - 1] + g[i - 2] + g[i - 3] + g[i - 4]) % MOD;
            }
        }

        int len = pressedKeys.length();
        long ans = 1;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            cnt++;

            char ch = pressedKeys.charAt(i);
            if (i == len - 1 || pressedKeys.charAt(i + 1) != ch) {
                if (ch == '7' || ch == '9') {
                    ans = ans * g[cnt] % MOD;
                } else {
                    ans = ans * f[cnt] % MOD;
                }
                cnt = 0;
            }
        }
        return (int) ans;
    }
}
/*
2266. 统计打字方案数
https://leetcode.cn/problems/count-number-of-texts/

第 292 场周赛 T3。

Alice 在给 Bob 用手机打字。数字到字母的 对应 如下图所示。
为了 打出 一个字母，Alice 需要 按 对应字母 i 次，i 是该字母在这个按键上所处的位置。
- 比方说，为了按出字母 's' ，Alice 需要按 '7' 四次。类似的， Alice 需要按 '5' 两次得到字母  'k' 。
- 注意，数字 '0' 和 '1' 不映射到任何字母，所以 Alice 不 使用它们。
但是，由于传输的错误，Bob 没有收到 Alice 打字的字母信息，反而收到了 按键的字符串信息 。
- 比方说，Alice 发出的信息为 "bob" ，Bob 将收到字符串 "2266622" 。
给你一个字符串 pressedKeys ，表示 Bob 收到的字符串，请你返回 Alice 总共可能发出多少种文字信息 。
由于答案可能很大，将它对 10^9 + 7 取余 后返回。
提示：
1 <= pressedKeys.length <= 10^5
pressedKeys 只包含数字 '2' 到 '9' 。

2 a (1)
22 aa b (2)
222 aaa ab ba c (4)
2222 aaaa aab aba baa ac ca bb (7)
22222 aaaaa aaab aaba abaa baaa aac aca caa abb bab bba bc cb (13)
动态规划。
相似题目: 70. 爬楼梯
https://leetcode.cn/problems/climbing-stairs/
 */
