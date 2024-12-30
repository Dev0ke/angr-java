import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution105Tests {
    private final Solution105 solution105 = new Solution105();

    @Test
    public void example1() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode expected = TreeNode.buildTreeNode("[3,9,20,null,null,15,7]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution105.buildTree(preorder, inorder)));
    }

    @Test
    public void example2() {
        int[] preorder = {-1};
        int[] inorder = {-1};
        TreeNode expected = TreeNode.buildTreeNode("[-1]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution105.buildTree(preorder, inorder)));
    }
}
