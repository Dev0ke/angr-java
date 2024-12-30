import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution112Tests {
    private final Solution112 solution112 = new Solution112();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[5,4,8,11,null,13,4,7,2,null,null,null,1]");
        int targetSum = 22;
        Assertions.assertTrue(solution112.hasPathSum(root, targetSum));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3]");
        int targetSum = 5;
        Assertions.assertFalse(solution112.hasPathSum(root, targetSum));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[1,2]");
        int targetSum = 0;
        Assertions.assertFalse(solution112.hasPathSum(root, targetSum));
    }
}
