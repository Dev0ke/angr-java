import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution129Tests {
    private final Solution129 solution129 = new Solution129();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3]");
        int expected = 25;
        Assertions.assertEquals(expected, solution129.sumNumbers(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[4,9,0,5,1]");
        int expected = 1026;
        Assertions.assertEquals(expected, solution129.sumNumbers(root));
    }
}
