import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2236Tests {
    private final Solution2236 solution2236 = new Solution2236();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[10,4,6]");
        Assertions.assertTrue(solution2236.checkTree(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[5,3,1]");
        Assertions.assertFalse(solution2236.checkTree(root));
    }
}