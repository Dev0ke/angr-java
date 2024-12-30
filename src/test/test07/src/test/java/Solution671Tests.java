import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution671Tests {
    private final Solution671 solution671 = new Solution671();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[2,2,5,null,null,5,7]");
        int expected = 5;
        Assertions.assertEquals(expected, solution671.findSecondMinimumValue(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[2,2,2]");
        int expected = -1;
        Assertions.assertEquals(expected, solution671.findSecondMinimumValue(root));
    }
}
