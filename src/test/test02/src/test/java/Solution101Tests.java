import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution101Tests {
    private final Solution101 solution101 = new Solution101();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,2,3,4,4,3]");
        Assertions.assertTrue(solution101.isSymmetric(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,2,null,3,null,3]");
        Assertions.assertFalse(solution101.isSymmetric(root));
    }
}
