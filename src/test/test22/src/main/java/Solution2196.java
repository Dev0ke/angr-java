import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution2196 {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> nodeSet = new HashSet<>();
        Set<Integer> childSet = new HashSet<>();

        Map<Integer, TreeNode> map = new HashMap<>();
        for (int[] description : descriptions) {
            int parent = description[0];
            int child = description[1];
            int isLeft = description[2];
            TreeNode parentNode = map.getOrDefault(parent, new TreeNode(parent));
            TreeNode childNode = map.getOrDefault(child, new TreeNode(child));
            if (isLeft == 1) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }
            map.put(child, childNode);
            map.put(parent, parentNode);

            // 标记
            nodeSet.add(parent);
            nodeSet.add(child);
            childSet.add(child);
        }

        nodeSet.removeAll(childSet);
        List<Integer> rootList = new ArrayList<>(nodeSet);
        return map.get(rootList.get(0));
    }
}
/*
2196. 根据描述创建二叉树
https://leetcode.cn/problems/create-binary-tree-from-descriptions/

第 283 场周赛 T3。

给你一个二维整数数组 descriptions ，其中 descriptions[i] = [parenti, childi, isLefti] 表示 parenti 是 childi 在 二叉树 中的 父节点，二叉树中各节点的值 互不相同 。此外：
- 如果 isLefti == 1 ，那么 childi 就是 parenti 的左子节点。
- 如果 isLefti == 0 ，那么 childi 就是 parenti 的右子节点。
请你根据 descriptions 的描述来构造二叉树并返回其 根节点 。
测试用例会保证可以构造出 有效 的二叉树。
提示：
1 <= descriptions.length <= 10^4
descriptions[i].length == 3
1 <= parenti, childi <= 10^5
0 <= isLefti <= 1
descriptions 所描述的二叉树是一棵有效二叉树

模拟。使用 HashMap 做记忆化处理。通过计算节点差集获得 root 节点并返回。
 */