import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution623Tests {
    private final Solution623 solution623 = new Solution623();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[4,2,6,3,1,5]");
        int val = 1;
        int depth = 2;
        TreeNode expected = TreeNode.buildTreeNode("[4,1,1,2,null,null,6,3,1,5]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution623.addOneRow(root, val, depth)));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[4,2,null,3,1]");
        int val = 1;
        int depth = 3;
        TreeNode expected = TreeNode.buildTreeNode("[4,2,null,1,1,3,null,null,1]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution623.addOneRow(root, val, depth)));
    }
}