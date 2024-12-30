public class Solution1881 {
    public String maxValue(String n, int x) {
        // 负数
        if (n.charAt(0) == '-') {
            return "-" + caseNegative(n.substring(1), x);
        }
        // 正数
        return casePositive(n, x);
    }

    private String casePositive(String n, int x) {
        char[] chars = n.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            // 从左往右，如果大于后一个数，就置于其前
            if (x > chars[i] - '0') {
                return n.substring(0, i) + x + n.substring(i);
            }
        }
        // 如果均不符合，置于末位
        return n + x;
    }

    private String caseNegative(String n, int x) {
        char[] chars = n.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            // 从左往右，如果小于后一个数，就置于其前
            if (x < chars[i] - '0') {
                return n.substring(0, i) + x + n.substring(i);
            }
        }
        // 如果均不符合，置于末位
        return n + x;
    }
}
/*
1881. 插入后的最大值
https://leetcode.cn/problems/maximum-value-after-insertion/

第 243 场周赛 T2。

给你一个非常大的整数 n 和一个整数数字 x ，大整数 n 用一个字符串表示。n 中每一位数字和数字 x 都处于闭区间 [1, 9] 中，且 n 可能表示一个 负数 。
你打算通过在 n 的十进制表示的任意位置插入 x 来 最大化 n 的 数值 。但 不能 在负号的左边插入 x 。
- 例如，如果 n = 73 且 x = 6 ，那么最佳方案是将 6 插入 7 和 3 之间，使 n = 763 。
- 如果 n = -55 且 x = 2 ，那么最佳方案是将 2 插在第一个 5 之前，使 n = -255 。
返回插入操作后，用字符串表示的 n 的最大值。
提示：
1 <= n.length <= 10^5
1 <= x <= 9
n 中每一位的数字都在闭区间 [1, 9] 中。
n 代表一个有效的整数。
当 n 表示负数时，将会以字符 '-' 开始。

题目给出一个大整数，问如何通过插入一个数字后达到数值最大化。
对于正数。不难想到：从左往右，如果大于后一个数，就置于其前即可；
负数同理：从左往右，如果小于后一个数，就置于其前即可。
 */
