import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution337Tests {
    private final Solution337 solution337 = new Solution337();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[3,2,3,null,3,null,1]");
        int expected = 7;
        Assertions.assertEquals(expected, solution337.rob(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[3,4,5,1,3,null,1]");
        int expected = 9;
        Assertions.assertEquals(expected, solution337.rob(root));
    }
}
