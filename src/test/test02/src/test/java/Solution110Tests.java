import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution110Tests {
    private final Solution110 solution110 = new Solution110();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[3,9,20,null,null,15,7]");
        Assertions.assertTrue(solution110.isBalanced(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,2,3,3,null,null,4,4]");
        Assertions.assertFalse(solution110.isBalanced(root));
    }

    @Test
    public void example3() {
        TreeNode root = null;
        Assertions.assertTrue(solution110.isBalanced(root));
    }
}
