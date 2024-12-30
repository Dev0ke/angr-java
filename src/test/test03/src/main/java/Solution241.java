import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution241 {
    private final Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> resList = new ArrayList<>();
        if (expression == null || expression.length() == 0) {
            return resList;
        }
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                List<Integer> leftList = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rightList = diffWaysToCompute(expression.substring(i + 1));
                for (int left : leftList) {
                    for (int right : rightList) {
                        if (ch == '+') {
                            resList.add(left + right);
                        } else if (ch == '-') {
                            resList.add(left - right);
                        } else {
                            resList.add(left * right);
                        }
                    }
                }
            }
        }
        // 不含 +/-/*
        if (resList.isEmpty()) {
            resList.add(Integer.parseInt(expression));
        }
        memo.put(expression, resList);
        return resList;
    }
}
/*
241. 为运算表达式设计优先级
https://leetcode.cn/problems/different-ways-to-add-parentheses/

给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。
有效的运算符号包含 +, - 以及 * 。
示例 1:
输入: "2-1-1"
输出: [0, 2]
解释: 
((2-1)-1) = 0 
(2-(1-1)) = 2
提示：
1 <= expression.length <= 20
expression 由数字和算符 '+'、'-' 和 '*' 组成。
输入表达式中的所有整数值在范围 [0, 99]

分治法
trick：使用 HashMap 做 cache 可以缩短程序运行时间。（记忆化搜索）
 */