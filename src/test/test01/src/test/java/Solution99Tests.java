import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution99Tests {
    private final Solution99 solution99 = new Solution99();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,3,null,null,2]");
        TreeNode expected = TreeNode.buildTreeNode("[3,1,null,null,2]");
        solution99.recoverTree(root);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[3,1,4,null,null,2]");
        TreeNode expected = TreeNode.buildTreeNode("[2,1,4,null,null,3]");
        solution99.recoverTree(root);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, root));
    }
}
