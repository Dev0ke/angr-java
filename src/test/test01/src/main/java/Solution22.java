import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> resList = new ArrayList<>();
        helper(n, n, "", resList);
        return resList;
    }

    private void helper(int left, int right, String parenthesis, List<String> resList) {
        if (left == 0 && right == 0) {
            resList.add(parenthesis);
            return;
        }
        if (left > 0) {
            helper(left - 1, right, parenthesis + "(", resList);
        }
        if (left < right) {
            helper(left, right - 1, parenthesis + ")", resList);
        }
    }
}
/*
22. 括号生成
https://leetcode.cn/problems/generate-parentheses/

数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
提示：
1 <= n <= 8

回溯法。
 */