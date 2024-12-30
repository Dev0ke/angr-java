import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1325Tests {
    private final Solution1325 solution1325 = new Solution1325();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,2,null,2,4]");
        int target = 2;
        TreeNode expected = TreeNode.buildTreeNode("[1,null,3,null,4]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution1325.removeLeafNodes(root, target)));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,3,3,3,2]");
        int target = 3;
        TreeNode expected = TreeNode.buildTreeNode("[1,3,null,null,2]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution1325.removeLeafNodes(root, target)));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,null,2,null,2]");
        int target = 2;
        TreeNode expected = TreeNode.buildTreeNode("[1]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution1325.removeLeafNodes(root, target)));
    }

    @Test
    public void example4() {
        TreeNode root = TreeNode.buildTreeNode("[1,1,1]");
        int target = 1;
        TreeNode expected = TreeNode.buildTreeNode("[]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution1325.removeLeafNodes(root, target)));
    }

    @Test
    public void example5() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3]");
        int target = 1;
        TreeNode expected = TreeNode.buildTreeNode("[1,2,3]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution1325.removeLeafNodes(root, target)));
    }
}
