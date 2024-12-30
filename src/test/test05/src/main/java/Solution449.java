import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution449 {
    static class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "[]";
            }
            List<String> list = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode cur = queue.remove();
                if (cur == null) {
                    list.add("null");
                } else {
                    list.add(String.valueOf(cur.val));
                    queue.add(cur.left);
                    queue.add(cur.right);
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
        public TreeNode deserialize(String data) {
            if (data.equals("[]")) {
                return null;
            }
            String[] texts = data.substring(1, data.length() - 1).split(",");
            int idx = 0;
            TreeNode root = new TreeNode(Integer.parseInt(texts[idx++]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode cur = queue.remove();
                if (idx < texts.length && !texts[idx].equals("null")) {
                    cur.left = new TreeNode(Integer.parseInt(texts[idx]));
                    queue.add(cur.left);
                }
                idx++;
                if (idx < texts.length && !texts[idx].equals("null")) {
                    cur.right = new TreeNode(Integer.parseInt(texts[idx]));
                    queue.add(cur.right);
                }
                idx++;
            }
            return root;
        }
    }
}
/*
449. 序列化和反序列化二叉搜索树
https://leetcode.cn/problems/serialize-and-deserialize-bst/

序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，
并且可以将该字符串反序列化为最初的二叉搜索树。
编码的字符串应尽可能紧凑。
提示：
树中节点数范围是 [0, 10^4]
0 <= Node.val <= 10^4
题目数据 保证 输入的树是一棵二叉搜索树。

同: 297. 二叉树的序列化与反序列化
https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
此处使用 LeetCode 序列化二叉树的格式 即 层序遍历。
 */