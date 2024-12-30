import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution965Tests {
    private final Solution965 solution965 = new Solution965();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,1,1,1,1,null,1]");
        Assertions.assertTrue(solution965.isUnivalTree(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[2,2,2,5,2]");
        Assertions.assertFalse(solution965.isUnivalTree(root));
    }
}
