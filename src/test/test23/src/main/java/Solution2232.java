public class Solution2232 {
    public String minimizeResult(String expression) {
        String[] sp = expression.split("\\+");
        String l = sp[0], r = sp[1];

        int min = Integer.MAX_VALUE;
        String ans = "";
        for (int i = 0; i < l.length(); i++) { // 枚举左括号插入位置
            String strA = l.substring(0, i);
            int a = (i > 0) ? Integer.parseInt(strA) : 1; // 左括号左边的数（不存在时为 1）
            int b = Integer.parseInt(l.substring(i)); // 左括号右边的数

            for (int j = 1; j <= r.length(); j++) { // 枚举右括号插入位置
                int c = Integer.parseInt(r.substring(0, j)); // 右括号左边的数
                String strD = r.substring(j);
                int d = (j < r.length()) ? Integer.parseInt(strD) : 1; // 右括号右边的数（不存在时为 1）

                int res = a * (b + c) * d;
                if (res < min) {
                    min = res;
                    ans = strA + "(" + b + "+" + c + ")" + strD;
                }
            }
        }
        return ans;
    }
}
/*
2232. 向表达式添加括号后的最小结果
https://leetcode.cn/problems/minimize-result-by-adding-parentheses-to-expression/

第 288 场周赛 T2。

给你一个下标从 0 开始的字符串 expression ，格式为 "<num1>+<num2>" ，其中 <num1> 和 <num2> 表示正整数。
请你向 expression 中添加一对括号，使得在添加之后， expression 仍然是一个有效的数学表达式，并且计算后可以得到 最小 可能值。
左括号 必须 添加在 '+' 的左侧，而右括号必须添加在 '+' 的右侧。
返回添加一对括号后形成的表达式 expression ，且满足 expression 计算得到 最小 可能值。如果存在多个答案都能产生相同结果，返回任意一个答案。
生成的输入满足：expression 的原始值和添加满足要求的任一对括号之后 expression 的值，都符合 32-bit 带符号整数范围。
提示：
3 <= expression.length <= 10
expression 仅由数字 '1' 到 '9' 和 '+' 组成
expression 由数字开始和结束
expression 恰好仅含有一个 '+'.
expression 的原始值和添加满足要求的任一对括号之后 expression 的值，都符合 32-bit 带符号整数范围

由于 expression 最大只有 10，可以暴力枚举括号的每个位置。
10 理论最大为 5+1+4 或 4+1+5，最多只有 20 种组合。
 */
