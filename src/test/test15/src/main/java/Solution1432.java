public class Solution1432 {
    public int maxDiff(int num) {
        int min = num, max = num;
        for (int x = 0; x <= 9; x++) {
            for (int y = 0; y <= 9; y++) {
                String newNum = getNum(num, x, y);
                if (!newNum.startsWith("0")) {
                    Integer v = Integer.parseInt(newNum);
                    min = Math.min(min, v);
                    max = Math.max(max, v);
                }
            }
        }
        return max - min;
    }

    private String getNum(int num, int x, int y) {
        char chx = (char) ('0' + x);
        char chy = (char) ('0' + y);
        return String.valueOf(num).replace(chx, chy);
    }
}
/*
1432. 改变一个整数能得到的最大差值
https://leetcode.cn/problems/max-difference-you-can-get-from-changing-an-integer/description/

给你一个整数 num 。你可以对它进行如下步骤恰好 两次 ：
- 选择一个数字 x (0 <= x <= 9).
- 选择另一个数字 y (0 <= y <= 9) 。数字 y 可以等于 x 。
- 将 num 中所有出现 x 的数位都用 y 替换。
- 得到的新的整数 不能 有前导 0 ，得到的新整数也 不能 是 0 。
- 令两次对 num 的操作得到的结果分别为 a 和 b 。
请你返回 a 和 b 的 最大差值 。
提示：
1 <= num <= 10^8

暴力枚举所有情况
 */