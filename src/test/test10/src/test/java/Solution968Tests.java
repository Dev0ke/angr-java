import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution968Tests {
    private final Solution968 solution968 = new Solution968();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[0,0,null,0,0]");
        int expected = 1;
        Assertions.assertEquals(expected, solution968.minCameraCover(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[0,0,null,0,null,0,null,null,0]");
        int expected = 2;
        Assertions.assertEquals(expected, solution968.minCameraCover(root));
    }
}
