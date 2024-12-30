import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution450Tests {
    private final Solution450 solution450 = new Solution450();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[5,3,6,2,4,null,7]");
        int key = 3;
        TreeNode expected = TreeNode.buildTreeNode("[5,4,6,2,null,null,7]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution450.deleteNode(root, key)));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[5,3,6,2,4,null,7]");
        int key = 0;
        TreeNode expected = TreeNode.buildTreeNode("[5,3,6,2,4,null,7]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution450.deleteNode(root, key)));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[]");
        int key = 0;
        TreeNode expected = TreeNode.buildTreeNode("[]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution450.deleteNode(root, key)));
    }
}
