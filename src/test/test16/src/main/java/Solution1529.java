public class Solution1529 {
    public int minFlips(String target) {
        char[] s = target.toCharArray();
        char pre = '0';
        int ans = 0;
        for (char ch : s) {
            if (ch != pre) {
                ans++;
                pre = ch;
            }
        }
        return ans;
    }
}
/*
1529. 最少的后缀翻转次数
https://leetcode.cn/problems/minimum-suffix-flips/description/

给你一个长度为 n 、下标从 0 开始的二进制字符串 target 。你自己有另一个长度为 n 的二进制字符串 s ，最初每一位上都是 0 。你想要让 s 和 target 相等。
在一步操作，你可以选择下标 i（0 <= i < n）并翻转在 闭区间 [i, n - 1] 内的所有位。翻转意味着 '0' 变为 '1' ，而 '1' 变为 '0' 。
返回使 s 与 target 相等需要的最少翻转次数。
提示：
n == target.length
1 <= n <= 10^5
target[i] 为 '0' 或 '1'

贪心。如果一个字符被翻转，则一定是选择了该字符的下标或者该字符前面的某个下标，然后进行了翻转操作。
时间复杂度 O(n)。
 */