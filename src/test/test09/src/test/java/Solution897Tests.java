import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution897Tests {
    private final Solution897 solution897 = new Solution897();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[5,3,6,2,4,null,8,1,null,null,null,7,9]");
        TreeNode expected = TreeNode.buildTreeNode("[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution897.increasingBST(root)));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[5,1,7]");
        TreeNode expected = TreeNode.buildTreeNode("[1,null,5,null,7]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution897.increasingBST(root)));
    }
}
