public class Solution856 {
    public int scoreOfParentheses(String s) {
        int res = 0;
        int depth = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                depth++;
            } else {
                depth--;
                if (s.charAt(i - 1) == '(') {
                    res += Math.pow(2, depth);
                }
            }
        }
        return res;
    }
}
/*
856. 括号的分数
https://leetcode.cn/problems/score-of-parentheses/

第 90 场周赛 T2。

给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
- () 得 1 分。
- AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
- (A) 得 2 * A 分，其中 A 是平衡括号字符串。
提示：
S 是平衡括号字符串，且只含有 ( 和 ) 。
2 <= S.length <= 50

官方题解十分巧妙：只有 () 会对字符串 s 贡献实质的分数，其它的括号只会将分数乘二或者将分数累加。
因此，可以找到每一个 () 对应的深度 x，答案就是 2^x 的累加和
时间复杂度 O(n)
空间复杂度 O(1)
 */