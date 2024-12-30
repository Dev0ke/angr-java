import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution814Tests {
    private final Solution814 solution814 = new Solution814();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,null,0,0,1]");
        TreeNode expected = TreeNode.buildTreeNode("[1,null,0,null,1]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution814.pruneTree(root)));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,0,1,0,0,0,1]");
        TreeNode expected = TreeNode.buildTreeNode("[1,null,1,null,1]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution814.pruneTree(root)));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[1,1,0,1,1,0,1,0]");
        TreeNode expected = TreeNode.buildTreeNode("[1,1,0,1,1,null,1]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution814.pruneTree(root)));
    }
}
