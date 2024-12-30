import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution538Tests {
    private final Solution538 solution538 = new Solution538();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]");
        TreeNode expected = TreeNode.buildTreeNode("[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution538.convertBST(root)));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[0,null,1]");
        TreeNode expected = TreeNode.buildTreeNode("[1,null,1]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution538.convertBST(root)));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[1,0,2]");
        TreeNode expected = TreeNode.buildTreeNode("[3,3,2]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution538.convertBST(root)));
    }

    @Test
    public void example4() {
        TreeNode root = TreeNode.buildTreeNode("[3,2,4,1]");
        TreeNode expected = TreeNode.buildTreeNode("[7,9,4,10]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution538.convertBST(root)));
    }
}
