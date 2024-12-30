public class Solution1323 {
    public int maximum69Number(int num) {
        char[] a = String.valueOf(num).toCharArray();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '6') {
                a[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(a));
    }
}
/*
1323. 6 和 9 组成的最大数字
https://leetcode.cn/problems/maximum-69-number/description/

给你一个仅由数字 6 和 9 组成的正整数 num。
你最多只能翻转一位数字，将 6 变成 9，或者把 9 变成 6 。
请返回你可以得到的最大数字。
提示：
1 <= num <= 10^4
num 每一位上的数字都是 6 或者 9 。

将第一个 6 变 9。
时间复杂度 O(n)。
 */