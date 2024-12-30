public class Solution297 {
    static class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "null";
            }
            String leftStr = serialize(root.left);
            String rightStr = serialize(root.right);
            return root.val + "," + leftStr + "," + rightStr;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] nodeStrs = data.split(",");
            int[] i = {0};
            return preorder(nodeStrs, i);
        }

        private TreeNode preorder(String[] strs, int[] i) {
            String str = strs[i[0]];
            i[0]++;
            if (str.equals("null")) {
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(str));
            node.left = preorder(strs, i);
            node.right = preorder(strs, i);
            return node;
        }
    }
}
/*
297. 二叉树的序列化与反序列化
https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/

序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，
你也可以采用其他的方法解决这个问题。
提示：
树中结点数在范围 [0, 10^4] 内
-1000 <= Node.val <= 1000

前序遍历。
相似题目: 449. 序列化和反序列化二叉搜索树
https://leetcode.cn/problems/serialize-and-deserialize-bst/
 */