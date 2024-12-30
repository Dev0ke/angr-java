import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution998Tests {
    private final Solution998 solution998 = new Solution998();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[4,1,3,null,null,2]");
        int val = 5;
        TreeNode expected = TreeNode.buildTreeNode("[5,4,null,1,3,null,null,2]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution998.insertIntoMaxTree(root, val)));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[5,2,4,null,1]");
        int val = 3;
        TreeNode expected = TreeNode.buildTreeNode("[5,2,4,null,1,null,3]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution998.insertIntoMaxTree(root, val)));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[5,2,3,null,1]");
        int val = 4;
        TreeNode expected = TreeNode.buildTreeNode("[5,2,4,null,1,3]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution998.insertIntoMaxTree(root, val)));
    }
}
