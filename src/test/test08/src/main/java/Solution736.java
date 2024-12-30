import java.util.HashMap;
import java.util.Map;

public class Solution736 {
    private String expression;
    private char[] s;

    public int evaluate(String expression) {
        int n = expression.length();
        this.expression = expression;
        s = expression.toCharArray();
        return dfs(0, n - 1, new HashMap<>());
    }

    private int dfs(int l, int r, Map<String, Integer> mp) {
        if (s[l] == '(') {
            int idx = l;
            while (s[idx] != ' ') idx++;
            String op = expression.substring(l + 1, idx);
            r--;
            if (op.equals("let")) {
                for (int i = idx + 1; i <= r; ) {
                    int j = getRight(i, r);
                    String key = expression.substring(i, j);
                    if (j >= r) return dfs(i, j - 1, new HashMap<>(mp));
                    j++;
                    i = j;
                    j = getRight(i, r);
                    int value = dfs(i, j - 1, new HashMap<>(mp));
                    mp.put(key, value);
                    i = j + 1;
                }
                return -1; // never
            } else {
                int j = getRight(idx + 1, r);
                int a = dfs(idx + 1, j - 1, new HashMap<>(mp)), b = dfs(j + 1, r, new HashMap<>(mp));
                return op.equals("add") ? a + b : a * b;
            }
        } else {
            String cur = expression.substring(l, r + 1);
            if (mp.containsKey(cur)) return mp.get(cur);
            return Integer.parseInt(cur);
        }
    }

    private int getRight(int left, int end) {
        int right = left, score = 0;
        while (right <= end) {
            if (s[right] == '(') {
                score++;
                right++;
            } else if (s[right] == ')') {
                score--;
                right++;
            } else if (s[right] == ' ') {
                if (score == 0) break;
                right++;
            } else {
                right++;
            }
        }
        return right;
    }
}
/*
736. Lisp 语法解析
https://leetcode.cn/problems/parse-lisp-expression/description/

给你一个类似 Lisp 语句的字符串表达式 expression，求出其计算结果。
表达式语法如下所示:
- 表达式可以为整数，let 表达式，add 表达式，mult 表达式，或赋值的变量。表达式的结果总是一个整数。
- (整数可以是正整数、负整数、0)
- let 表达式采用 "(let v1 e1 v2 e2 ... vn en expr)" 的形式，其中 let 总是以字符串 "let"来表示，接下来会跟随一对或多对交替的变量和表达式，也就是说，第一个变量 v1被分配为表达式 e1 的值，第二个变量 v2 被分配为表达式 e2 的值，依次类推；最终 let 表达式的值为 expr表达式的值。
- add 表达式表示为 "(add e1 e2)" ，其中 add 总是以字符串 "add" 来表示，该表达式总是包含两个表达式 e1、e2 ，最终结果是 e1 表达式的值与 e2 表达式的值之 和 。
- mult 表达式表示为 "(mult e1 e2)" ，其中 mult 总是以字符串 "mult" 表示，该表达式总是包含两个表达式 e1、e2，最终结果是 e1 表达式的值与 e2 表达式的值之 积 。
- 在该题目中，变量名以小写字符开始，之后跟随 0 个或多个小写字符或数字。为了方便，"add" ，"let" ，"mult" 会被定义为 "关键字" ，不会用作变量名。
- 最后，要说一下作用域的概念。计算变量名所对应的表达式时，在计算上下文中，首先检查最内层作用域（按括号计），然后按顺序依次检查外部作用域。测试用例中每一个表达式都是合法的。有关作用域的更多详细信息，请参阅示例。
提示：
1 <= expression.length <= 2000
exprssion 中不含前导和尾随空格
expressoin 中的不同部分（token）之间用单个空格进行分隔
答案和所有中间计算结果都符合 32-bit 整数范围
测试用例中的表达式均为合法的且最终结果为整数

DFS 模拟
https://leetcode.cn/problems/parse-lisp-expression/solutions/1649652/by-ac_oier-i7w1/
时间复杂度 O(n^2)。
 */