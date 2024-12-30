import java.util.ArrayList;
import java.util.List;

public class Solution282 {
    private String num;
    private int target;

    public List<String> addOperators(String num, int target) {
        this.num = num;
        this.target = target;
        List<String> resList = new ArrayList<>();
        dfs(0, 0, 0, "", resList);
        return resList;
    }

    private void dfs(int idx, long pre, long cur, String str, List<String> resList) {
        if (idx == num.length()) {
            if (cur == target) {
                resList.add(str);
            }
            return;
        }
        for (int i = idx; i < num.length(); i++) {
            if (i != idx && num.charAt(idx) == '0') {
                break;
            }
            long next = Long.parseLong(num.substring(idx, i + 1));
            if (idx == 0) {
                dfs(i + 1, next, next, "" + next, resList);
            } else {
                dfs(i + 1, next, cur + next, str + "+" + next, resList);
                dfs(i + 1, -next, cur - next, str + "-" + next, resList);
                long x = pre * next;
                dfs(i + 1, x, cur - pre + x, str + "*" + next, resList);
            }
        }
    }
}
/*
282. 给表达式添加运算符
https://leetcode.cn/problems/expression-add-operators/

给定一个仅包含数字 0-9 的字符串 num 和一个目标值整数 target ，在 num 的数字之间添加 二元 运算符（不是一元）+、- 或 * ，返回 所有 能够得到 target 的表达式。
注意，返回表达式中的操作数 不应该 包含前导零。
提示：
1 <= num.length <= 10
num 仅含数字
-2^31 <= target <= 2^31 - 1

dfs
时间复杂度 O(4^n)
空间复杂度 O(4^n)
相似题目: 227. 基本计算器 II
https://leetcode.cn/problems/basic-calculator-ii/
 */