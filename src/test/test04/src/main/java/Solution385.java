import java.util.ArrayDeque;
import java.util.Deque;

public class Solution385 {
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }
        Deque<NestedInteger> stack = new ArrayDeque<>();
        int num = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '-') {
                sign = -1;
            } else if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            } else if (ch == '[') {
                stack.push(new NestedInteger());
            } else if (ch == ',' || ch == ']') {
                if (Character.isDigit(s.charAt(i - 1))) {
                    num *= sign;
                    stack.peek().add(new NestedInteger(num));
                }
                num = 0;
                sign = 1;
                if (ch == ']' && stack.size() > 1) {
                    NestedInteger ni = stack.pop();
                    stack.peek().add(ni);
                }
            }
        }
        return stack.pop();
    }
}
/*
385. 迷你语法分析器
https://leetcode.cn/problems/mini-parser/

给定一个字符串 s 表示一个整数嵌套列表，实现一个解析它的语法分析器并返回解析的结果 NestedInteger 。
列表中的每个元素只可能是整数或整数嵌套列表
提示：
1 <= s.length <= 5 * 10^4
s 由数字、方括号 "[]"、负号 '-' 、逗号 ','组成
用例保证 s 是可解析的 NestedInteger
输入中的所有值的范围是 [-10^6, 10^6]

相似题目: $339. 嵌套列表权重和
https://leetcode.cn/problems/nested-list-weight-sum/
341. 扁平化嵌套列表迭代器
https://leetcode.cn/problems/flatten-nested-list-iterator/
$364. 加权嵌套序列和 II
https://leetcode.cn/problems/nested-list-weight-sum-ii/
 */