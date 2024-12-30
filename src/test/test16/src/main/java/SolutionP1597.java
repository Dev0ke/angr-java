import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionP1597 {
    public Node expTree(String s) {
        // 存储数字及表达式
        Deque<Node> numStack = new ArrayDeque<>();
        // 存储符号
        Deque<Node> opsStack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                opsStack.push(new Node(ch));
            } else if (ch == ')') {
                // 出栈所有操作符
                while (!opsStack.isEmpty() && opsStack.peek().val != '(') {
                    evaluate(numStack, opsStack);
                }
                // 出栈开括号
                opsStack.pop();
            } else if (ch == '+' || ch == '-') {
                while (!opsStack.isEmpty() && opsStack.peek().val != '(') {
                    evaluate(numStack, opsStack);
                }
                // 入栈符号
                opsStack.push(new Node(ch));
            } else if (ch == '*' || ch == '/') {
                while (!opsStack.isEmpty() && (opsStack.peek().val == '*' || opsStack.peek().val == '/')) {
                    evaluate(numStack, opsStack);
                }
                // 入栈符号
                opsStack.push(new Node(ch));
            } else {
                numStack.push(new Node(ch));
            }
        }
        while (!opsStack.isEmpty()) {
            evaluate(numStack, opsStack);
        }
        return numStack.pop();
    }

    private void evaluate(Deque<Node> numStack, Deque<Node> opsStack) {
        Node pop = opsStack.pop();
        pop.right = numStack.pop();
        pop.left = numStack.pop();
        numStack.push(pop);
    }

    static class Node {
        char val;
        Node left;
        Node right;

        Node() {
            this.val = ' ';
        }

        Node(char val) {
            this.val = val;
        }

        Node(char val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        // fastjson
        public char getVal() {
            return val;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
    }
}
/*
$1597. 根据中缀表达式构造二叉表达式树
https://leetcode.cn/problems/build-binary-expression-tree-from-infix-expression/

二叉表达式树 是一种表达算术表达式的二叉树。二叉表达式树中的每一个节点都有零个或两个子节点。
叶节点（有 0 个子节点的节点）表示操作数，非叶节点（有 2 个子节点的节点）表示运算符： '+' （加）、 '-' （减）、 '*' （乘）和 '/' （除）。
对于每一个运算符为 o 的非叶节点，对应的 中缀表达式 为 (A o B)，其中 A 是左子树所表达的表达式， B 是右子树所表达的表达式。
给定一个 中缀表达式 字符串 s，其中包含操作数、上面提到的运算符，以及括号 '(' 与 ')' 。
返回一个有效的 二叉表达式树，其 中序遍历 序列对应表达式 s 消除括号后的序列（详情参见下面的示例）。
注意，表达式的一般解析顺序适用于 s，即优先解析括号内的表达式，然后解析乘除法，最后解析加减法。
同时，操作数在 s 和树的中序遍历中 出现顺序相同 。
提示:
1 <= s.length <= 100
s 中包含数字和字符 '+'、 '-'、 '*'、 '/' 。
s 中的操作数 恰好 是一位数字。
题目数据保证 s 是一个有效的表达式。

栈
 */