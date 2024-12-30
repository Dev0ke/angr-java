import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution404Tests {
    private final Solution404 solution404 = new Solution404();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[3,9,20,null,null,15,7]");
        int expected = 24;
        Assertions.assertEquals(expected, solution404.sumOfLeftLeaves(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1]");
        int expected = 0;
        Assertions.assertEquals(expected, solution404.sumOfLeftLeaves(root));
    }
}
