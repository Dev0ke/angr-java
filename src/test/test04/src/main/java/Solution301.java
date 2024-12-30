import java.util.ArrayList;
import java.util.List;

public class Solution301 {
    public List<String> removeInvalidParentheses(String s) {
        // 统计需要删除的 左括号 右括号
        int cntLeft = 0;
        int cntRight = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                cntLeft++;
            } else if (ch == ')') {
                if (cntLeft == 0) {
                    cntRight++;
                } else {
                    cntLeft--;
                }
            }
        }
        List<String> resList = new ArrayList<>();
        if (cntLeft == 0 && cntRight == 0) {
            resList.add(s);
            return resList;
        }
        // 回溯
        dfs(s, resList, 0, 0, new StringBuilder(), cntLeft, cntRight, 0);
        return resList;
    }

    private void dfs(String s, List<String> resList, int idx, int diff,
                     StringBuilder sb, int cntLeft, int cntRight, int status) {
        if (idx == s.length()) {
            if (diff == 0 && isValid(sb)) {
                resList.add(sb.toString());
            }
            return;
        }

        char ch = s.charAt(idx);
        if (ch == '(') {
            // 最低位为1说明前面的左括号没要，那这个左括号也不能要
            if ((status & 1) == 0) {
                // 要这个左括号
                sb.append(ch);
                dfs(s, resList, idx + 1, diff + 1, sb, cntLeft, cntRight, 0);
                sb.deleteCharAt(sb.length() - 1);
            }

            // 不要这个左括号
            if (cntLeft > 0) {
                // 不要当前这个左括号，后面的左括号也不能要
                dfs(s, resList, idx + 1, diff, sb, cntLeft - 1, cntRight, status | 1);
            }
        } else if (ch == ')') {
            // 要这个右括号
            // 倒数第二位为1说明前面的右括号没要，那这个右括号也不能要
            if (diff > 0 && (status & 2) == 0) {
                sb.append(ch);
                dfs(s, resList, idx + 1, diff - 1, sb, cntLeft, cntRight, 0);
                sb.deleteCharAt(sb.length() - 1);
            }

            // 不要这个右括号
            if (cntRight > 0) {
                // 不要当前这个右括号，后面的右括号也不能要
                dfs(s, resList, idx + 1, diff, sb, cntLeft, cntRight - 1, status | 2);
            }
        } else {
            sb.append(ch);
            dfs(s, resList, idx + 1, diff, sb, cntLeft, cntRight, 0);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private boolean isValid(StringBuilder stringBuilder) {
        // 判断括号是否合法
        int left = 0;
        for (int i = 0; i < stringBuilder.length(); i++) {
            char ch = stringBuilder.charAt(i);
            if (ch == '(') {
                left++;
            } else if (ch == ')') {
                if (left == 0) {
                    return false;
                } else {
                    left--;
                }
            }
        }
        return left == 0;
    }
}
/*
301. 删除无效的括号
https://leetcode.cn/problems/remove-invalid-parentheses/

给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
返回所有可能的结果。答案可以按 任意顺序 返回。
提示：
1 <= s.length <= 25
s 由小写英文字母以及括号 '(' 和 ')' 组成
s 中至多含 20 个括号

回溯
 */