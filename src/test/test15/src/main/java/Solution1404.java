public class Solution1404 {
    // 计算最后一个 1 与第一个 1 之间有多少 0
    // 只要存在 0 就会因为从后往前第一个 0 前面的 1 的 +1 操作而变成 1，这样每个 0 都会进行一次 +1 操作
    // 最后再加上第一次的 +1 操作 即 s 的长度 +0 的个数 +1
    public int numSteps(String s) {
        int n = s.length();
        int zero = 0;
        int i = n - 1;
        while (i >= 0 && s.charAt(i) != '1') i--;
        if (i == 0) return n - 1;
        while (i > 0) if (s.charAt(i--) == '0') zero++;
        return zero + n + 1;
    }
}
/*
1404. 将二进制表示减到 1 的步骤数
https://leetcode.cn/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/description/

给你一个以二进制形式表示的数字 s 。请你返回按下述规则将其减少到 1 所需要的步骤数：
如果当前数字为偶数，则将其除以 2 。
如果当前数字为奇数，则将其加上 1 。
题目保证你总是可以按上述规则将测试用例变为 1 。
提示：
1 <= s.length <= 500
s 由字符 '0' 或 '1' 组成。
s[0] == '1'

遍历。二进制性质。
时间复杂度 O(n)。
相似题目: 1558. 得到目标数组的最少函数调用次数
https://leetcode.cn/problems/minimum-numbers-of-function-calls-to-make-target-array/description/
 */