import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1372Tests {
    private final Solution1372 solution1372 = new Solution1372();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]");
        int expected = 3;
        Assertions.assertEquals(expected, solution1372.longestZigZag(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,1,1,null,1,null,null,1,1,null,1]");
        int expected = 4;
        Assertions.assertEquals(expected, solution1372.longestZigZag(root));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[1]");
        int expected = 0;
        Assertions.assertEquals(expected, solution1372.longestZigZag(root));
    }
}
