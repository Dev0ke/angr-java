public class Solution2283 {
    public boolean digitCount(String num) {
        int[] cntArr = new int[10];
        for (char ch : num.toCharArray()) {
            cntArr[ch - '0']++;
        }

        for (int i = 0; i < num.length(); i++) {
            int cnt = num.charAt(i) - '0';
            if (cntArr[i] != cnt) {
                return false;
            }
        }
        return true;
    }
}
/*
2283. 判断一个数的数字计数是否等于数位的值
https://leetcode.cn/problems/check-if-number-has-equal-digit-count-and-digit-value/

第 79 场双周赛 T1。

给你一个下标从 0 开始长度为 n 的字符串 num ，它只包含数字。
如果对于 每个 0 <= i < n 的下标 i ，都满足数位 i 在 num 中出现了 num[i]次，那么请你返回 true ，否则返回 false 。
提示：
n == num.length
1 <= n <= 10
num 只包含数字。

统计频次 + 模拟
 */