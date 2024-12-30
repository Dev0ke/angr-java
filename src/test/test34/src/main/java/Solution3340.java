public class Solution3340 {
    public boolean isBalanced(String num) {
        int n = num.length();
        int[] sum = new int[2];
        for (int i = 0; i < n; i++) {
            sum[i & 1] += num.charAt(i) - '0';
        }
        return sum[0] == sum[1];
    }
}
/*
3340. 检查平衡字符串
https://leetcode.cn/problems/check-balanced-string/description/

第 422 场周赛 T1。

给你一个仅由数字 0 - 9 组成的字符串 num。如果偶数下标处的数字之和等于奇数下标处的数字之和，则认为该数字字符串是一个 平衡字符串。
如果 num 是一个 平衡字符串，则返回 true；否则，返回 false。
提示：
2 <= num.length <= 100
num 仅由数字 0 - 9 组成。

模拟。
 */