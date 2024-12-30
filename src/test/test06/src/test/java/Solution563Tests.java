import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution563Tests {
    private final Solution563 solution563 = new Solution563();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3]");
        int expected = 1;
        Assertions.assertEquals(expected, solution563.findTilt(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[4,2,9,3,5,null,7]");
        int expected = 15;
        Assertions.assertEquals(expected, solution563.findTilt(root));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[21,7,14,1,1,2,2,3,3]");
        int expected = 9;
        Assertions.assertEquals(expected, solution563.findTilt(root));
    }
}
