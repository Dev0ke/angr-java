import java.util.Map;
import java.util.TreeMap;

public class SolutionP1902 {
    public int maxDepthBST(int[] order) {
        // 元素 -> 高度
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        tm.put(0, 0);
        tm.put(Integer.MAX_VALUE, 0); // 哨兵
        // 首元素
        tm.put(order[0], 1);
        int ans = 1;
        for (int i = 1; i < order.length; i++) {
            int val = order[i];
            Map.Entry<Integer, Integer> lower = tm.lowerEntry(val);
            Map.Entry<Integer, Integer> higher = tm.higherEntry(val);
            int depth = Math.max(lower.getValue(), higher.getValue()) + 1;
            tm.put(val, depth);
            ans = Math.max(ans, depth);
        }
        return ans;
    }
}
/*
$1902. 给定二叉搜索树的插入顺序求深度
https://leetcode.cn/problems/depth-of-bst-given-insertion-order/description/

给定一个从 0 开始索引的整数类型数组 order ，其长度为 n，是从 1 到 n 的所有整数的一个排列，表示插入到一棵二叉搜索树的顺序。
二叉搜索树的定义如下：
- 一个节点的左子树只包含键值小于该节点键值的节点。
- 一个节点的右子树只包含键值大于该节点键值的节点。
- 左子树和右子树须均为二叉搜索树。
该二叉搜索树的构造方式如下：
- order[0] 将成为该二叉搜索树的根。
- 所有后续的元素均在维持二叉搜索树性质的前提下作为任何已存在节点的子节点插入。
返回该二叉搜索树的深度。
一棵二叉树的深度是从根节点到最远叶节点的最长路径所经节点的个数。
提示：
n == order.length
1 <= n <= 10^5
order 是从 1 到 n 的整数的一个排列。

在BST中，二分查找当前元素最接近的两个元素，取深度的较大值。
https://leetcode.cn/problems/depth-of-bst-given-insertion-order/solutions/834618/zai-bstzhong-er-fen-cha-zhao-dang-qian-y-1528/
平衡树从 O(n^2) 优化至 O(nlogn)。
 */