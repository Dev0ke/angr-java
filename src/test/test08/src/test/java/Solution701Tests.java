import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution701Tests {
    private final Solution701 solution701 = new Solution701();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[4,2,7,1,3]");
        int val = 5;
        TreeNode expected = TreeNode.buildTreeNode("[4,2,7,1,3,5]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution701.insertIntoBST(root, val)));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[40,20,60,10,30,50,70]");
        int val = 25;
        TreeNode expected = TreeNode.buildTreeNode("[40,20,60,10,30,50,70,null,null,25]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution701.insertIntoBST(root, val)));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[4,2,7,1,3,null,null,null,null,null,null]");
        int val = 5;
        TreeNode expected = TreeNode.buildTreeNode("[4,2,7,1,3,5]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution701.insertIntoBST(root, val)));
    }
}
