import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution543Tests {
    private final Solution543 solution543 = new Solution543();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,4,5]");
        int expected = 3;
        Assertions.assertEquals(expected, solution543.diameterOfBinaryTree(root));
    }
}
