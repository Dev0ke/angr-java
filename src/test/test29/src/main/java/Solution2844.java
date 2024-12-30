public class Solution2844 {
    private int n;
    private char[] s;

    public int minimumOperations(String num) {
        n = num.length();
        s = num.toCharArray();

        int ans = num.contains("0") ? n - 1 : n;
        ans = Math.min(ans, getAns('0', '0'));
        ans = Math.min(ans, getAns('2', '5'));
        ans = Math.min(ans, getAns('5', '0'));
        ans = Math.min(ans, getAns('7', '5'));
        return ans;
    }

    // 50 a:5 b:0
    private int getAns(char a, char b) {
        // 00 50
        int lastb = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s[i] == b) {
                lastb = i;
                break;
            }
        }
        int lastba = -1;
        for (int i = lastb - 1; i >= 0; i--) {
            if (s[i] == a) {
                lastba = i;
                break;
            }
        }
        if (lastba != -1) {
            return n - lastba - 2;
        }
        return n;
    }
}
/*
2844. 生成特殊数字的最少操作
https://leetcode.cn/problems/minimum-operations-to-make-a-special-number/

第 361 场周赛 T2。

给你一个下标从 0 开始的字符串 num ，表示一个非负整数。
在一次操作中，您可以选择 num 的任意一位数字并将其删除。请注意，如果你删除 num 中的所有数字，则 num 变为 0。
返回最少需要多少次操作可以使 num 变成特殊数字。
如果整数 x 能被 25 整除，则该整数 x 被认为是特殊数字。
提示
1 <= num.length <= 100
num 仅由数字 '0' 到 '9' 组成
num 不含任何前导零

分类讨论，一共只有 5 种情况：0，25结尾，50结尾，75结尾，00结尾
 */