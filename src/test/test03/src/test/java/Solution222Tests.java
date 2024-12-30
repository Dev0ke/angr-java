import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution222Tests {
    private final Solution222 solution222 = new Solution222();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,4,5,6]");
        int expected = 6;
        Assertions.assertEquals(expected, solution222.countNodes(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[]");
        int expected = 0;
        Assertions.assertEquals(expected, solution222.countNodes(root));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[1]");
        int expected = 1;
        Assertions.assertEquals(expected, solution222.countNodes(root));
    }
}
