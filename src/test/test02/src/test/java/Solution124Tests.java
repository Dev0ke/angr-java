import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution124Tests {
    private final Solution124 solution124 = new Solution124();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3]");
        int expected = 6;
        Assertions.assertEquals(expected, solution124.maxPathSum(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[-10,9,20,null,null,15,7]");
        int expected = 42;
        Assertions.assertEquals(expected, solution124.maxPathSum(root));
    }
}
