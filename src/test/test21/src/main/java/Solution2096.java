public class Solution2096 {
    private String path;

    public String getDirections(TreeNode root, int startValue, int destValue) {
        dfs(root, startValue, new StringBuilder());
        String path1 = path;
        dfs(root, destValue, new StringBuilder());
        String path2 = path;
        // 移除相同前缀
        int idx = 0;
        while (idx < path1.length() && idx < path2.length()) {
            if (path1.charAt(idx) == path2.charAt(idx)) {
                idx++;
            } else {
                break;
            }
        }
        return "U".repeat(path1.length() - idx) + path2.substring(idx);
    }

    private void dfs(TreeNode root, int target, StringBuilder stringBuilder) {
        if (root.val == target) {
            path = stringBuilder.toString();
            return;
        }
        if (root.left != null) {
            stringBuilder.append("L");
            dfs(root.left, target, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (root.right != null) {
            stringBuilder.append("R");
            dfs(root.right, target, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
/*
2096. 从二叉树一个节点到另一个节点每一步的方向
https://leetcode.cn/problems/step-by-step-directions-from-a-binary-tree-node-to-another/

第 270 场周赛 T3。

给你一棵 二叉树 的根节点 root ，这棵二叉树总共有 n 个节点。每个节点的值为 1 到 n 中的一个整数，且互不相同。给你一个整数 startValue ，
表示起点节点 s 的值，和另一个不同的整数 destValue ，表示终点节点 t 的值。
请找到从节点 s 到节点 t 的 最短路径 ，并以字符串的形式返回每一步的方向。每一步用 大写 字母 'L' ，'R' 和 'U' 分别表示一种方向：
- 'L' 表示从一个节点前往它的 左孩子 节点。
- 'R' 表示从一个节点前往它的 右孩子 节点。
- 'U' 表示从一个节点前往它的 父 节点。
请你返回从 s 到 t 最短路径 每一步的方向。

DFS 分别找 root 到 startValue、destValue 的路径，移除掉相同的前缀，然后将 root 到 startValue 的字符替换为 U 即可。
 */