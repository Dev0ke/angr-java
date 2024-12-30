import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionP1628 {
    /**
     * This is the interface for the expression tree Node.
     * You should not remove it, and you can define some classes to implement it.
     */

    static abstract class Node {
        public abstract int evaluate();
        // define your fields here
    }


    /**
     * This is the TreeBuilder class.
     * You can treat it as the driver code that takes the postinfix input
     * and returns the expression tree represnting it as a Node.
     */

    static class TreeBuilder {
        Node buildTree(String[] postfix) {
            Deque<NodeImpl> stack = new ArrayDeque<>();
            for (String post : postfix) {
                NodeImpl node = new NodeImpl(post);
                if ("+-*/".contains(post)) {
                    node.right = stack.pop();
                    node.left = stack.pop();
                }
                stack.push(node);
            }
            return stack.pop();
        }

        static class NodeImpl extends Node {
            String val;
            NodeImpl left;
            NodeImpl right;

            public NodeImpl(String val) {
                this.val = val;
            }

            @Override
            public int evaluate() {
                return switch (val) {
                    case "+" -> left.evaluate() + right.evaluate();
                    case "-" -> left.evaluate() - right.evaluate();
                    case "*" -> left.evaluate() * right.evaluate();
                    case "/" -> left.evaluate() / right.evaluate();
                    default -> Integer.parseInt(val);
                };
            }
        }
    }
}
/*
$1628. 设计带解析函数的表达式树
https://leetcode.cn/problems/design-an-expression-tree-with-evaluate-function/

给定一个算术表达式的后缀表示法的标记（token） postfix ，构造并返回该表达式对应的二叉表达式树。
后缀表示法是一种将操作数写在运算符之前的表示法。例如，表达式 4*(5-(2+7)) 的后缀表示法表示为数组 postfix = ["4","5","7","2","+","-","*"] 。
抽象类 Node 需要用于实现二叉表达式树。我们将通过 evaluate 函数来测试返回的树是否能够解析树中的值。你不可以移除 Node 类，但你可以按需修改此类，也可以定义其他类来实现它。
二叉表达式树是一种表达算术表达式的二叉树。二叉表达式树中的每一个节点都有零个或两个子节点。 叶节点（有 0 个子节点的节点）表示操作数，非叶节点（有 2 个子节点的节点）表示运算符： '+' （加）、 '-' （减）、 '*' （乘）和 '/' （除）。
我们保证任何子树对应值的绝对值不超过 10^9 ，且所有操作都是有效的（即没有除以零的操作）
进阶： 你可以将表达式树设计得更模块化吗？例如，你的设计能够不修改现有的 evaluate 的实现就能支持更多的操作符吗？
提示:
1 <= s.length < 100
s.length 是奇数。
s 包含数字和字符 '+' 、 '-' 、 '*' 以及 '/' 。
如果 s[i] 是数，则对应的整数不超过 10^5 。
s 保证是一个有效的表达式。
结果值和所有过程值的绝对值均不超过 10^9 。
保证表达式不包含除以零的操作。
 */