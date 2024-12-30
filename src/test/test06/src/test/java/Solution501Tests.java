import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution501Tests {
    private final Solution501 solution501 = new Solution501();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,null,2,2]");
        int[] expected = {2};
        Assertions.assertArrayEquals(expected, solution501.findMode(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[0]");
        int[] expected = {0};
        Assertions.assertArrayEquals(expected, solution501.findMode(root));
    }
}
