import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionP428 {
    static class Codec {
        // Encodes a tree to a single string.
        public String serialize(Node root) {
            if (root == null) {
                return "[]";
            }
            List<String> list = new ArrayList<>();
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            queue.add(null);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Node cur = queue.remove();

                    if (cur == null) {
                        list.add("null");
                    } else {
                        list.add(String.valueOf(cur.val));
                        if (cur.children != null && cur.children.size() > 0) {
                            queue.addAll(cur.children);
                        }
                        queue.add(null);
                    }
                }
            }
            // 找到最后一个不为null的字符串.
            int end = list.size() - 1;
            while (end >= 0) {
                if (!list.get(end).equals("null")) {
                    break;
                }
                end--;
            }
            StringBuilder stringBuilder = new StringBuilder("[");
            for (int i = 0; i <= end; i++) {
                if (i > 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(list.get(i));
            }
            return stringBuilder.append("]").toString();
        }

        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            if (data.equals("[]")) {
                return null;
            }
            String[] texts = data.substring(1, data.length() - 1).split(",");
            int idx = 0;
            Node root = new Node(Integer.parseInt(texts[idx]), new ArrayList<>());
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            idx = 2;
            while (!queue.isEmpty() && idx < texts.length) {
                Node cur = queue.remove();

                while (idx < texts.length && !texts[idx].equals("null")) {
                    Node child = new Node(Integer.parseInt(texts[idx]), new ArrayList<>());
                    cur.children.add(child);
                    queue.add(child);
                    idx++;
                }
                idx++;
            }
            return root;
        }
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
/*
$428. 序列化和反序列化 N 叉树
https://leetcode.cn/problems/serialize-and-deserialize-n-ary-tree/

序列化是指将一个数据结构转化为位序列的过程，因此可以将其存储在文件中或内存缓冲区中，以便稍后在相同或不同的计算机环境中恢复结构。
设计一个序列化和反序列化 N 叉树的算法。一个 N 叉树是指每个节点都有不超过 N 个孩子节点的有根树。序列化 / 反序列化算法的算法实现没有限制。
你只需要保证 N 叉树可以被序列化为一个字符串并且该字符串可以被反序列化成原树结构即可。
例如，你需要序列化下面的 3-叉 树。
为 [1 [3[5 6] 2 4]]。你不需要以这种形式完成，你可以自己创造和实现不同的方法。
或者，您可以遵循 LeetCode 的层序遍历序列化格式，其中每组孩子节点由空值分隔。
例如，上面的树可以序列化为 [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
你不一定要遵循以上建议的格式，有很多不同的格式，所以请发挥创造力，想出不同的方法来完成本题。
提示：
树中节点数目的范围是 [0, 10^4].
0 <= Node.val <= 104
N 叉树的高度小于等于 1000
不要使用类成员 / 全局变量 / 静态变量来存储状态。你的序列化和反序列化算法应是无状态的。

相似題目: 449. 序列化和反序列化二叉搜索树
https://leetcode.cn/problems/serialize-and-deserialize-bst/
 */