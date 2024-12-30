import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution687Tests {
    private final Solution687 solution687 = new Solution687();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[5,4,5,1,1,5]");
        int expected = 2;
        Assertions.assertEquals(expected, solution687.longestUnivaluePath(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,4,5,4,4,5]");
        int expected = 2;
        Assertions.assertEquals(expected, solution687.longestUnivaluePath(root));
    }
}
