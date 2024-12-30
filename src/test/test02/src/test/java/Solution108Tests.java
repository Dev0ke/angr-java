import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution108Tests {
    private final Solution108 solution108 = new Solution108();

    @Test
    public void example1() {
        int[] nums = {-10, -3, 0, 5, 9};
        // 输出：[0,-3,9,-10,null,5]
        // 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
        TreeNode expected = TreeNode.buildTreeNode("[0,-10,5,null,-3,null,9]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution108.sortedArrayToBST(nums)));
    }

    @Test
    public void example2() {
        int[] nums = {1, 3};
        // 输出：[3,1]
        // 解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
        TreeNode expected = TreeNode.buildTreeNode("[1,null,3]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution108.sortedArrayToBST(nums)));
    }
}
