public class Solution1318 {
    public int minFlips(int a, int b, int c) {
        int cnt = 0;
        // 二进制第 k 位
        for (int k = 0; k < 31; k++) {
            int bitA = (a >> k) & 1;
            int bitB = (b >> k) & 1;
            int bitC = (c >> k) & 1;
            if (bitC == 0) {
                cnt += bitA + bitB;
            } else {
                cnt += (bitA + bitB == 0) ? 1 : 0;
            }
        }
        return cnt;
    }
}
/*
1318. 或运算的最小翻转次数
https://leetcode.cn/problems/minimum-flips-to-make-a-or-b-equal-to-c/

给你三个正整数 a、b 和 c。
你可以对 a 和 b 的二进制表示进行位翻转操作，返回能够使按位或运算   a OR b == c  成立的最小翻转次数。
「位翻转操作」是指将一个数的二进制表示任何单个位上的 1 变成 0 或者 0 变成 1 。
提示：
1 <= a <= 10^9
1 <= b <= 10^9
1 <= c <= 10^9

位运算 + 贪心
如果 bitC 为 0，则 bitA 和 bitB 都需置 0
如果 bitC 为 1，则 bitA 和 bitB 任意 1 个为 1 即可
 */