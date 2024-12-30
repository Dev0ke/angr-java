import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution106Tests {
    private final Solution106 solution106 = new Solution106();

    @Test
    public void example1() {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode expected = TreeNode.buildTreeNode("[3,9,20,null,null,15,7]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution106.buildTree(inorder, postorder)));
    }

    @Test
    public void example2() {
        int[] inorder = {-1};
        int[] postorder = {-1};
        TreeNode expected = TreeNode.buildTreeNode("[-1]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution106.buildTree(inorder, postorder)));
    }
}
