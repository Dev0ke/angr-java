import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution654Tests {
    private final Solution654 solution654 = new Solution654();

    @Test
    public void example1() {
        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode expected = TreeNode.buildTreeNode("[6,3,5,null,2,0,null,null,1]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution654.constructMaximumBinaryTree(nums)));
    }

    @Test
    public void example2() {
        int[] nums = {3, 2, 1};
        TreeNode expected = TreeNode.buildTreeNode("[3,null,2,null,1]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution654.constructMaximumBinaryTree(nums)));
    }
}
