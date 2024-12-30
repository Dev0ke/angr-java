public class SolutionP2802 {
    public String kthLuckyNumber(int k) {
        return Integer.toBinaryString(k + 1).substring(1)
                .replace('0', '4')
                .replace('1', '7');
    }
}
/*
$2802. 找出第 K 个幸运数字
https://leetcode.cn/problems/find-the-k-th-lucky-number/description/

我们知道 4 和 7 是 幸运 数字。同时，如果一个数字只包含幸运数字，那么它被称为幸运数字。
给定一个整数 k，返回第 k 个幸运数字，并将其表示为一个 字符串 。
提示：
1 <= k <= 10^9

只有4和7两个数字，0代表4，1代表7，二进制0/1来表示结果。
注意，初始数不是0而是1，最后结果要把第一个1删掉。
 */