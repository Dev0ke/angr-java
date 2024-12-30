import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution530Tests {
    private final Solution530 solution530 = new Solution530();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[4,2,6,1,3]");
        int expected = 1;
        Assertions.assertEquals(expected, solution530.getMinimumDifference(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,0,48,null,null,12,49]");
        int expected = 1;
        Assertions.assertEquals(expected, solution530.getMinimumDifference(root));
    }
}
