import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution669Tests {
    private final Solution669 solution669 = new Solution669();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,0,2]");
        int low = 1;
        int high = 2;
        TreeNode expected = TreeNode.buildTreeNode("[1,null,2]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution669.trimBST(root, low, high)));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[3,0,4,null,2,null,null,1]");
        int low = 1;
        int high = 3;
        TreeNode expected = TreeNode.buildTreeNode("[3,2,null,1]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution669.trimBST(root, low, high)));
    }
}
