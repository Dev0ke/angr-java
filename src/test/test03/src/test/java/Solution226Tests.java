import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution226Tests {
    private final Solution226 solution226 = new Solution226();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[4,2,7,1,3,6,9]");
        TreeNode expected = TreeNode.buildTreeNode("[4,7,2,9,6,3,1]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution226.invertTree(root)));
    }
}
