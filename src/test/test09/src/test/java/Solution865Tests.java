import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution865Tests {
    private final Solution865 solution865 = new Solution865();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[3,5,1,6,2,0,8,null,null,7,4]");
        TreeNode expected = TreeNode.buildTreeNode("[2,7,4]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution865.subtreeWithAllDeepest(root)));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1]");
        TreeNode expected = TreeNode.buildTreeNode("[1]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution865.subtreeWithAllDeepest(root)));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[0,1,3,null,2]");
        TreeNode expected = TreeNode.buildTreeNode("[2]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution865.subtreeWithAllDeepest(root)));
    }
}
