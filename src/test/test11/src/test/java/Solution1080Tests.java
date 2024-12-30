import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1080Tests {
    private final Solution1080 solution1080 = new Solution1080();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14]");
        int limit = 1;
        TreeNode expected = TreeNode.buildTreeNode("[1,2,3,4,null,null,7,8,9,null,14]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution1080.sufficientSubset(root, limit)));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[5,4,8,11,null,17,4,7,1,null,null,5,3]");
        int limit = 22;
        TreeNode expected = TreeNode.buildTreeNode("[5,4,8,11,null,17,4,7,null,null,null,5]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution1080.sufficientSubset(root, limit)));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,-3,-5,null,4,null]");
        int limit = -1;
        TreeNode expected = TreeNode.buildTreeNode("[1,null,-3,4]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution1080.sufficientSubset(root, limit)));
    }
}