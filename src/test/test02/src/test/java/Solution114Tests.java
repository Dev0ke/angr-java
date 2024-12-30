import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution114Tests {
    private final Solution114 solution114 = new Solution114();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,5,3,4,null,6]");
        TreeNode expected = TreeNode.buildTreeNode("[1,null,2,null,3,null,4,null,5,null,6]");
        solution114.flatten(root);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[]");
        TreeNode expected = TreeNode.buildTreeNode("[]");
        solution114.flatten(root);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, root));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[0]");
        TreeNode expected = TreeNode.buildTreeNode("[0]");
        solution114.flatten(root);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, root));
    }
}
