import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution111Tests {
    private final Solution111 solution111 = new Solution111();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[3,9,20,null,null,15,7]");
        int expected = 2;
        Assertions.assertEquals(expected, solution111.minDepth(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[2,null,3,null,4,null,5,null,6]");
        int expected = 5;
        Assertions.assertEquals(expected, solution111.minDepth(root));
    }
}
